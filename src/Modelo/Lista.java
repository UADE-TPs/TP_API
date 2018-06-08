package Modelo;

import java.util.Vector;

import Controlador.AdmUsr;
import Persistencia.MapperLista;
import Persistencia.MapperUsuario;

import java.sql.Date;

public class Lista {
	
	private int codLista;
	private String nomLista;
	private Usuario admin;
	private float montoARecaudar;
	private Date fechaInicio;
	private Date fechaFin;
	private Date fechaAgasajo;
	private String nombreAgasajado;
	private String mailAgasajado;
	private String estadoLista; // A=activo / C=cerrada / B= dada de baja
	private Vector<ItemLista> itemsLista;
	
	public Lista (
			String nomLista,
			Usuario admin,
			float montoARecaudar,
			Date fechaInicio,
			Date fechaFin,
			Date fechaAgasajo, 
			String nombreAgasajado,
			String mailAgasajado) {
		super();
		this.nomLista=nomLista;
		this.admin=admin;
		this.montoARecaudar=montoARecaudar;
		this.fechaInicio=fechaInicio;
		this.fechaFin=fechaFin;
		this.fechaAgasajo=fechaAgasajo;
		this.nombreAgasajado=nombreAgasajado;
		this.mailAgasajado=mailAgasajado;
		this.estadoLista=String.valueOf('A'); //Lista activa
		this.itemsLista= new Vector<ItemLista> ();
		this.codLista=MapperLista.getInstancia().insert(this);
	}	
	
	public Lista (int codLista, 
			String nomLista,
			Usuario admin,
			float montoARecaudar,
			Date fechaInicio,
			Date fechaFin,
			Date fechaAgasajo, 
			String nombreAgasajado,
			String mailAgasajado,
			String estadoLista) {
		super();
		this.codLista = codLista;
		this.nomLista=nomLista;
		this.admin=admin;
		this.montoARecaudar=montoARecaudar;
		this.fechaInicio=fechaInicio;
		this.fechaFin=fechaFin;
		this.fechaAgasajo=fechaAgasajo;
		this.nombreAgasajado=nombreAgasajado;
		this.mailAgasajado=mailAgasajado;
		this.estadoLista=estadoLista;
		this.itemsLista= new Vector<ItemLista> ();
	}	
	
	public void bajaLista() {
		this.estadoLista=String.valueOf('B');
		//return MapperLista.getInstancia().bajaLista(this.codLista);
	}
	
	public void insertarItem (ItemLista il) {
		System.out.println("insertarItem");
		this.itemsLista.addElement(il);
	}
	
	//Getters/Setters
	public int getCodigo() {
		return codLista;
	}
	
	public Usuario getAdmin() {
		return admin;
	}

	public float getMonto() {
		return montoARecaudar;
	}
	public void setMonto(float m) {
		this.montoARecaudar=m;
	}

	public Date getfechaInicio() {
		return fechaInicio;
	}
	public void setfechaInicio(Date fi) {
		this.fechaInicio=fi;
	}

	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date ff) {
		this.fechaFin=ff;
	}

	public Date getFechaAgasajo() {
		return fechaAgasajo;
	}
	public void setFechaAgasajo(Date fa)
	{
		this.fechaAgasajo=fa;
	}

	public String getNombreAgasajado() {
		return nombreAgasajado;
	}
	public void setNombreAgasajado(String n) {
		this.nombreAgasajado=n;
	}
	
	public String getNombreLista() {
		return nomLista;
	}
	
	public void setNombreLista(String nl) {
		this.nomLista=nl;
	}
	
	public String getMailAgasajado() {
		return mailAgasajado;
	}
	
	public void setMailAgasajado(String m) {
		this.mailAgasajado=m;
	}

	public String getEstadoLista() {
		return this.estadoLista;
	}
	
	public void setEstadoLista(String estado) {
		this.estadoLista=estado;
	}

	public ItemLista getItemLista() {
		return null;
			
	}
}