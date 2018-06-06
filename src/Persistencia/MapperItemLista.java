package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Modelo.ItemLista;

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
	
	public void insert (int CodLista, ItemLista i)
	{
		try
		{
			Connection con = PoolConnection.getPoolConnection().getConnection();
			
			PreparedStatement s = con.prepareStatement("insert into API.dbo.ItemsLista values (?,?,?)");


			s.execute();
		
			PoolConnection.getPoolConnection().realeaseConnection(con);
			
		}
		catch (Exception e)
		{
			System.out.println("Error en MapperUsusario - insert");
			e.printStackTrace();
		}
	}
	
}
