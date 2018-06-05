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
	public int generarUsr (int d, String n, String a, Date fn, String m, String p)
	{
		//Verificar que no exista en la BD
		Usuario u = MapperUsuario.getInstancia().buscarUsuario(d);
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

	public Usuario buscarUsrXmail (String mail) {
		Usuario u = buscarMail(mail);
		if ( u == null) {
			u = MapperUsuario.getInstancia().buscarUsuarioXmail(mail);	
		}
		return u;	
	}
	
	public Usuario buscarMail (String m) {
		for(Usuario u : usuarios) {
            if (u.getMail().equals(m)) {
            	return u;
            };
        }
		return null;
	}
}
