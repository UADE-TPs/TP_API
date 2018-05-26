package Modelo;


import java.sql.Date;

import Persistencia.MapperUsuario;

public class Usuario {
	
	private int dni;
	private String nombre;
	private String apellido;
	private Date fechaNacimiento;
	private String mail;
	private String password;
	private boolean estado; // True=activo / False=dado de baja
	
	
	public Usuario (int dni, String nombre, String apellido, Date fechaNacimiento, String mail, String password) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.mail = mail;
		this.password = password;
		this.estado = true;
		
		MapperUsuario.getInstancia().insert(this);
	}

	public Usuario (int dni, String nombre, String apellido, Date fechaNacimiento, String mail, String password, boolean estado) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.mail = mail;
		this.password = password;
		this.estado = estado;
		
	}
	public int bajaUsr() {
		this.setEstado(false);
		return MapperUsuario.getInstancia().bajaUsr(this.dni);
	}

	
	
	public int getDni() {
		return dni;
	}


	public void setDni(int dni) {
		this.dni = dni;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public boolean getEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}

}
