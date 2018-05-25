package Controlador;

import java.sql.Date;
import java.util.Vector;

import javax.swing.JOptionPane;

import Modelo.Usuario;
import Persistencia.MapperUsuario;

public class AdmUsr {
	
	private Vector<Usuario> usuarios;
	private static AdmUsr instancia;	

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
	public void generarUsr (int d, String n, String a, Date fn, String m, char[]p)
	{
		//Verificar que no exista en la BD 
		Usuario u = new Usuario(d,n,a,fn,m, new String(p), true);
		usuarios.addElement(u);
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
