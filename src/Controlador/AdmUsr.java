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
		usuarios = new Vector<Usuario>();
	}
	
	public static AdmUsr getInstancia()
	{
		if (instancia == null)
			instancia = new AdmUsr();
		return instancia;
	}
	
	//Alta del usuario: recibe dni, nombre, apellido, fecha nacimiento, mail y password
	public int generarUsr (int d, String n, String a, Date fn, String m, String p)
	{
		//Verificar que no exista en la BD
		Usuario u = buscarUsrxDoc(d);
		if (u == null) {
			u = new Usuario(d,n,a,fn,m, p);
			usuarios.addElement(u);
			return 1;
		}
		return 0;
	}
	
	public int logIn (int d, String p) {
		
		loggedUsr = MapperUsuario.getInstancia().verificarUsrPass(d, p);
		if (loggedUsr != null) {
			return 1;
		}
		return 0;
	}
	
	public int  bajaUsr ()
	{
		//Cerrar todas listas que administra s
		//Sacar de todas las listas que participa
		return loggedUsr.bajaUsr();
	}
	
	public Usuario loggedUsr ()
	{
		return loggedUsr;
	}
	
	public int modificarDatosUsr (String nomb, String ape, Date fchNac, String mail, String pass )
	{
		loggedUsr.setNombre(nomb);
		loggedUsr.setApellido(ape);
		loggedUsr.setFechaNacimiento(fchNac);
		loggedUsr.setMail(mail);
		loggedUsr.setPassword(pass);
		return MapperUsuario.getInstancia().modificarDatosUsr(loggedUsr);
	}

	public Usuario buscarUsrxDoc (int doc) {
		Usuario u = buscarDoc(doc);
		if ( u == null) {
			u = MapperUsuario.getInstancia().buscarUsuario(doc);
			usuarios.add(u);
		}
		return u;	
	}
	
	public Usuario buscarDoc (int d) {
		if (!usuarios.isEmpty()) {
			for(Usuario u : usuarios) {
	            if (u.getDni() == d) {
	            	return u;
	            };
	        }
		}
		return null;
	}
	
	public Usuario buscarUsrXmail (String mail) {
		System.out.println("llama buscarMail 777");
		Usuario u = null; //buscarMail(mail);
		System.out.println("verifica si encontro buscarMail");
		if ( u == null) {
			System.out.println("llama mapper");
			u = MapperUsuario.getInstancia().buscarUsuarioXmail(mail);
			if ( u != null) {
				usuarios.add(u);
				System.out.println("usr" + u.getMail());
			}
		}
		return u;	
	}
	
	public Usuario buscarMail (String m) {
		if (!usuarios.isEmpty()) {
			for(Usuario u : usuarios) {
				System.out.println("for " + u.getMail());
	            if (u.getMail().equals(m)) {
	            	System.out.println("igualllll");
	            	return u;
	            }
			}
		}
		System.out.println("fuera if");
		return null;
	}
}
