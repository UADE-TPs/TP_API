package Persistencia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Vector;

import Modelo.Usuario;


public class MapperUsuario {
	
	private static MapperUsuario instancia;
	
	private MapperUsuario()
	{
		
	}
	
	public static MapperUsuario getInstancia()
	{
		if (instancia == null)
			instancia = new MapperUsuario();
		return instancia;
	}

	public Vector<Usuario> selectAll()
	{
		try
		{
			Vector<Usuario> usuarios = new Vector<Usuario>();
			
			return usuarios;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	

	public void insert (Usuario u)
	{
		try
		{
			Connection con = PoolConnection.getPoolConnection().getConnection();
			
			PreparedStatement s = con.prepareStatement("insert into API.dbo.Usuarios values (?,?,?,?,?,?,?)");
			s.setInt(1,u.getDni());
			s.setString(2, u.getNombre());
			s.setString(3,u.getApellido());
			s.setDate(4, u.getFechaNacimiento());
			s.setString(5,u.getMail());
			s.setString(6,u.getPassword());
		    s.setBoolean(7, u.getEstado());;
			s.execute();
		
			PoolConnection.getPoolConnection().realeaseConnection(con);
			
		}
		catch (Exception e)
		{
			System.out.println("Error en MapperUsusario - insert");
			e.printStackTrace();
		}
	}
	
	public Usuario buscarUsuario (int dni)
	{
		try
		{
			Usuario u = null;
			Connection con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s = con.prepareStatement("select * from API.dbo.Usuarios where dni = ?");
			s.setLong(1,dni);
			ResultSet result = s.executeQuery();
			while (result.next())
			{
				String nom = result.getString(2);
				String ape = result.getString(3);
				Date fn = result.getDate(4);
				String mail = result.getString(5);
				String pass = result.getString(6);
				Boolean est = result.getBoolean(7);
				u = new Usuario(dni, nom, ape, fn,  mail, pass, est);
			}
			
			PoolConnection.getPoolConnection().realeaseConnection(con);
			return u;
		}
		catch (Exception e)
		{
			System.out.println("Error en MapperUsusario - BuscarUsusario");
			e.printStackTrace();
		}
		return null;
	}
	
	public Usuario verificarUsrPass (int dni, String pass)
	{
		try
		{
			Usuario u = null;
			Connection con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s = con.prepareStatement("select * from API.dbo.Usuarios where dni = ? and pass =? and estado = 1");
			s.setLong(1,dni);
			s.setString(2, pass);
			ResultSet result = s.executeQuery();
			while (result.next())
			{
				String nom = result.getString(2);
				String ape = result.getString(3);
				Date fn = result.getDate(4);
				String mail = result.getString(5);
				Boolean est = result.getBoolean(7);
				u = new Usuario(dni, nom, ape, fn,  mail, pass, est);
			}
			
			PoolConnection.getPoolConnection().realeaseConnection(con);
			return u;
		}
		catch (Exception e)
		{
			System.out.println("Error en MapperUsusario - VerificarUsrPass");
		}
		return null;
	}
	
	public int bajaUsr (int dni) {
		try
		{
			Connection con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s = con.prepareStatement("update API.dbo.Usuarios set estado = 0 where dni = ?");
			s.setLong(1,dni);
			PoolConnection.getPoolConnection().realeaseConnection(con);
			return 1;
		}
		catch (Exception e)
		{
			System.out.println("Error en MapperUsusario - BajaUsr");
		}
		return 0;
	}
}
