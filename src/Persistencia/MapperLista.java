package Persistencia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import Modelo.Lista;
import Modelo.Usuario;

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
		
		public Vector<Lista> selectAll()
		{
			try
			{
				Vector<Lista> lista = new Vector<Lista>();
				
				return lista;
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			return null;
		}

		
		public void insert (Lista l)
		{
			try
			{
				Connection con = PoolConnection.getPoolConnection().getConnection();
				
				PreparedStatement sl = con.prepareStatement("insert into API.dbo.Lista values (?,?,?,?,?,?,?,?,?,?)");
				sl.setInt(1,l.getCodigo());
				sl.setString(2, l.getAdmin().getMail());
				sl.setFloat(3,l.getMonto());
				sl.setDate(3,l.getfechaInicio());
				sl.setDate(4,l.getFechaFin());
				sl.setString(6,l.getNombreAgasajado());
			    sl.setDate(7, l.getFechaAgasajo());
			    sl.setString(8, l.getMailAgasajado());
			    sl.setBoolean(9, l.getEstadoLista());
			    
			   // sl.setArray(10, l.getItemLista());;
				sl.execute();
			
				PoolConnection.getPoolConnection().realeaseConnection(con);
				
			}
			catch (Exception e)
			{
				System.out.println("Error en MapperLista - insert");
				e.printStackTrace();
			}
		}

			public int bajaLista (int codigo) {
				try
				{
					Connection con = PoolConnection.getPoolConnection().getConnection();
					PreparedStatement s = con.prepareStatement("update API.dbo.Lista set estado = 0 where codigo = ?");
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
			public Lista buscarLista (int codigoLista)
			{
				try
				{
					Lista l = null;
					Connection con = PoolConnection.getPoolConnection().getConnection();
					PreparedStatement s = con.prepareStatement("select * from API.dbo.Lista where codigo = ?");
					s.setLong(1,codigoLista);
					ResultSet result = s.executeQuery();
					while (result.next())
					{
						String nom = result.getString(2);
						String ape = result.getString(3);
						Date fn = result.getDate(4);
						String mail = result.getString(5);
						String pass = result.getString(6);
						Boolean est = result.getBoolean(7);
						//l = new Lista(dni, nom, ape, fn,  mail, pass, est);
						
					}
					
					PoolConnection.getPoolConnection().realeaseConnection(con);
					return l;
				}
				catch (Exception e)
				{
					System.out.println("Error en MapperUsusario - BuscarUsusario");
					e.printStackTrace();
				}
				return null;
			}
}				

			

