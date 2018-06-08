package Persistencia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JOptionPane;

import Controlador.AdmUsr;
import Modelo.Lista;
import Modelo.Usuario;
import Controlador.AdmUsr;

public class MapperLista {
	private static MapperLista instancia;	
		
		private MapperLista()
		{
			
		}
		
		public static MapperLista getInstancia()
		{
			if (instancia == null)
				instancia = new MapperLista();
			return instancia;
		}
		
		public Vector<Lista> selectListasAdm(int dniAdm)
		{
			try
			{
				System.out.println("selectListasAdm " + dniAdm);
				Vector<Lista> listas = new Vector<Lista>();
				Connection con = PoolConnection.getPoolConnection().getConnection();
				PreparedStatement s = con.prepareStatement("select * from API.dbo.Listas where dniAdmin = ? and estado = 'A'");
				s.setLong(1, dniAdm);
				ResultSet result = s.executeQuery();
				while (result.next())
				{
					int codLista = result.getInt(1);
					String nomLista = result.getString(2);
					float montoARecaudar = result.getFloat(4);
					Date fechaInicio = result.getDate(5);
					Date fechaFin = result.getDate(6);
					Date fechaAgasajo = result.getDate(7);
					String nombreAgasajado = result.getString(8); 
					String mailAgasajado = result.getString(9); 
					String estadoLista = result.getString(10);
					Lista l = new Lista(codLista, nomLista, AdmUsr.getInstancia().loggedUsr(), montoARecaudar, fechaInicio,  fechaFin, fechaAgasajo, nombreAgasajado, mailAgasajado, estadoLista );
					System.out.println("lista " + l.getNombreLista());
					listas.addElement(l);
				}
				PoolConnection.getPoolConnection().realeaseConnection(con);
				return listas;
			}
			catch (Exception e)
			{
				System.out.println("Error en MapperLista - selectListasAdm");
				e.printStackTrace();
			}
			return null;
		}
		
		public Vector<Lista> selectListasPar(int dniPar)
		{
			try
			{
				Vector<Integer> codigosLista = MapperItemLista.getInstancia().buscarItemsPar(dniPar);
				Vector<Lista> listas = new Vector<Lista>();
				Connection con = PoolConnection.getPoolConnection().getConnection();
				for(int cl : codigosLista) {
					PreparedStatement s = con.prepareStatement("select * from API.dbo.Listas where codLista = ? and dniAdmin <> ? and estado = 'A'");
					s.setLong(1, cl);
					s.setLong(2, dniPar);
					ResultSet result = s.executeQuery();
					while (result.next())
					{
						int codLista = result.getInt(1);
						String nomLista = result.getString(2);
						float montoARecaudar = result.getFloat(4);
						Date fechaInicio = result.getDate(5);
						Date fechaFin = result.getDate(6);
						Date fechaAgasajo = result.getDate(7);
						String nombreAgasajado = result.getString(8); 
						String mailAgasajado = result.getString(9); 
						String estadoLista = result.getString(10);
						Lista l = new Lista(codLista, nomLista, AdmUsr.getInstancia().loggedUsr(), montoARecaudar, fechaInicio,  fechaFin, fechaAgasajo, nombreAgasajado, mailAgasajado, estadoLista );
						System.out.println("lista " + l.getNombreLista());
						listas.addElement(l);
					}
				
				}
				PoolConnection.getPoolConnection().realeaseConnection(con);
				return listas;
			}
			catch (Exception e)
			{
				System.out.println("Error en MapperLista - selectListasPar");
				e.printStackTrace();
			}
			return null;
		}

		
		public int insert (Lista l) {
			int codLista=0;
			try
			{
				Connection con = PoolConnection.getPoolConnection().getConnection();
				PreparedStatement sl = con.prepareStatement("insert into API.dbo.Listas values (?,?,?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
				//sl.setInt(1,l.getCodigo());
				sl.setString(1, l.getNombreLista());
				sl.setInt(2,l.getAdmin().getDni());
				sl.setFloat(3,l.getMonto());
				sl.setDate(4,l.getfechaInicio());
				sl.setDate(5,l.getFechaFin());
			    sl.setDate(6, l.getFechaAgasajo());
				sl.setString(7,l.getNombreAgasajado());
			    sl.setString(8, l.getMailAgasajado());
			    sl.setNString(9, l.getEstadoLista());
				sl.execute();
				ResultSet rs = sl.getGeneratedKeys();
				if (rs!= null && rs.next()) {
					codLista = rs.getInt(1); // devuelve codigo de lista autogenerado
				}
				
				
				PoolConnection.getPoolConnection().realeaseConnection(con);
			}
			catch (Exception e)
			{
				System.out.println("Error en MapperLista - InsertLista");
				e.printStackTrace();
			}
			return codLista;
		}

			public int bajaLista (int codigo) {
				try
				{
					Connection con = PoolConnection.getPoolConnection().getConnection();
					PreparedStatement s = con.prepareStatement("update API.dbo.Listas set estado = 'B' where codLista = ?");
					s.setLong(1,codigo);
					s.execute();			
					PoolConnection.getPoolConnection().realeaseConnection(con);
					return 1;
				}
				catch (Exception e)
				{
					System.out.println("Error en MapperLista - BajaLista");
					e.printStackTrace();
				}
				return 0;
			}
	

			public int modificarDatosLista (Lista l) {
				try
				{
					Connection con = PoolConnection.getPoolConnection().getConnection();
					PreparedStatement s = con.prepareStatement("update API.dbo.Listas set fechaFin = ?, fechaAgasajo = ?, nombreAgasajado = ?, emailAgasajado = ? where codLista = ?");
					s.setDate(1,l.getFechaFin());
					s.setDate(2,l.getFechaAgasajo());
					s.setString(3,l.getNombreAgasajado());
					s.setString(4,l.getMailAgasajado());
					s.setInt(5, l.getCodigo());
					s.execute();			
					PoolConnection.getPoolConnection().realeaseConnection(con);
					return 1;
				}
				catch (Exception e)
				{
					System.out.println("Error en MapperLista - modificarDatosLista");
					e.printStackTrace();
				}
				return 0;
			}
			
						
			public Lista buscarLista (int codigoLista)
			{
				try
				{
					Lista l = null;
					Connection con = PoolConnection.getPoolConnection().getConnection();
					PreparedStatement s = con.prepareStatement("select * from API.dbo.Listas where codigo = ?");
					s.setLong(1,codigoLista);
					ResultSet result = s.executeQuery();
					while (result.next())
					{
						String nom = result.getString(2); //Nombre Lista
						int  dni = result.getInt(3); // dni Admin
						Date fini = result.getDate(4); //fecha inicio
						Date ffin = result.getDate(5); // fecha fin
						int idAg = result.getInt(6);
						float mont = result.getFloat(7);
						Boolean est = result.getBoolean(8);
						//l = new Lista(dni, nom, ape, fn,  mail, pass, est);
						
					}
					
					PoolConnection.getPoolConnection().realeaseConnection(con);
					return l;
				}
				catch (Exception e)
				{
					System.out.println("Error en Mapper - BuscarUsusario");
					e.printStackTrace();
				}
				return null;
			}

}				

			

