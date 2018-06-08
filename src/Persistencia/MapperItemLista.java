package Persistencia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JOptionPane;

import Controlador.AdmLista;
import Controlador.AdmUsr;
import Modelo.ItemLista;
import Modelo.Lista;
import Modelo.Pago;
import Modelo.Usuario;
import Vista.PantallaAgregaParticipanteLista;

public class MapperItemLista {
	
	private static MapperItemLista instancia;

	private MapperItemLista()
	{
		
	}
	
	public static MapperItemLista getInstancia()
	{
		if (instancia == null)
			instancia = new MapperItemLista();
		return instancia;
	}
	
	public void insert (ItemLista i)
	{
		try
		{
			Connection con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement sl = con.prepareStatement("insert into API.dbo.ItemsLista values (?,?,?)");
			sl.setInt(1,i.getcodLista());
			sl.setInt(2,i.getParticiante().getDni());
			sl.setNull(3, java.sql.Types.INTEGER);
			sl.execute();
			PoolConnection.getPoolConnection().realeaseConnection(con);
				
			//System.out.println("MapperItemLista - insert ItemLista OK!!!");
			
		}
		catch (Exception e)
		{
			System.out.println("Error en MapperItemLista - insert ItemLista");
			e.printStackTrace();
		}
	}

	public Vector<Integer> buscarItemsPar (int dniPar)
	{
		try
		{

			Vector<Integer> codigosLista = new Vector<Integer>();
			Connection con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s = con.prepareStatement("select codLista from API.dbo.ItemsLista where dniParticipante = ?");
			s.setLong(1, dniPar);
			ResultSet result = s.executeQuery();
			while (result.next())
			{
				codigosLista.addElement(result.getInt(1)); 
			}
			PoolConnection.getPoolConnection().realeaseConnection(con);
			return codigosLista;
		}
		catch (Exception e)
		{
			System.out.println("Error en MapperItemLista - buscarItemsPar");
			e.printStackTrace();
		}
		return null;
	}
}
