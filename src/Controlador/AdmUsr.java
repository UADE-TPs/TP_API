package Controlador;

import java.sql.Date;
import java.util.Vector;

import javax.swing.JOptionPane;

import Modelo.Usuario;
import Persistencia.MapperUsuario;

public class AdmUsr {
	
	private Vector<Usuario> usuarios;
	private static AdmUsr instancia;	
	private  Usuario loggedUsr;

	private AdmUsr()
	{
		usuarios = MapperUsuario.getInstancia().selectAll();
	}
	
	public static AdmUsr getInstancia()
	{
		if (instancia == null)
			instancia = new AdmUsr();
		return instancia;
	}
	
	//Alta del usuario: recibe dni, nombre, apellido, fecha nacimiento, mail y password
	public int generarUsr (int d, String n, String a, Date fn, String m, char[]p)
	{
		//Verificar que no exista en la BD
		Usuario u = null;
		u = MapperUsuario.getInstancia().buscarUsuario(d);
		if (u == null) {
			u = new Usuario(d,n,a,fn,m, new String(p), true);
			usuarios.addElement(u);
			return 1;
		}
		return 0;
	}
	
	public void  bajaUsr (Usuario u)
	{
		
	}
	
	public Usuario obtenerUsr (int d)
	{
		return usuarios.elementAt(0);
	}
	
	public void modificarNombre (Usuario u, String n)
	{
		
	}
	
	public void modificarApellido (Usuario u, String a)
	{
		
	}
	
	public void modificarFechaNacimiento (Usuario u, Date f)
	{
		
	}
	
	public void modificarMail (Usuario u, String m)
	{
		
	}
	
	public void modificarPassword (Usuario u, String p)
	{
		
	}

	
}
