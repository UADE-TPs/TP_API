package Modelo;

import java.util.Vector;

import Persistencia.MapperLista;

import java.sql.Date;

public class Lista {
	
	private int codLista;
	private Usuario admin;
	private Vector<ItemLista> itemsLista;
	private float montoARecaudar;
	private Date fechaInicio;
	private Date fechaFin;
	private String nombreAgasajado;
	private Date fechaAgasajo;
	private String mailAgasajado;
	private boolean estadoLista;
	//			l = new Lista(c,u,m,f1,ff,n,fa,e);
	public Lista (int codlista , Usuario admin, float montoARecaudar,
			Date fechaInicio, Date fechaFin, String nombreAgasajado,
			Date fechaAgasajo, String mailAgasajado) {
		super();
		this.codLista=codlista;
		this.admin=admin;
		this.montoARecaudar=montoARecaudar;
		this.fechaInicio=fechaInicio;
		this.fechaFin=fechaFin;
		this.fechaAgasajo=fechaAgasajo;
		this.nombreAgasajado=nombreAgasajado;
		this.mailAgasajado=mailAgasajado;
		this.estadoLista=true;
		this.itemsLista=null;
		MapperLista.getInstancia().insert(this);
		//this.itemsLista =null;
		
	
	}	
	public void bajaLista() {
		this.estadoLista=false;
		//return MapperLista.getInstancia().bajaLista(this.codLista);
	}
	//Getters/Setters
	public int getCodigo() {
		return codLista;
	}
	public void setCodigo(int cod) {
		this.codLista= cod;
	}
	
	public Usuario getAdmin() {
		return admin;
	}
	public void setAdmin(Usuario u) {
		this.admin= u;
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

	public String getMailAgasajado() {
		return mailAgasajado;
	}
	public void setMailAgasajado(String m) {
		this.mailAgasajado=m;
	}

	public boolean getEstadoLista() {
		return true;
	}
	public void setEstadoLista() {
		this.estadoLista=true;
	}

	public ItemLista getItemLista() {
		return null;
			
	}
	
	/*
 * codLista: int;
 * admin: Usuario;
 * itemsLista: Collection;
 * montoARecaudar: float;
 * fechaInicio: Date;
 * fechaFin: Date;
 * nombreAgasajado: String;
 * fechaAgasajo: Date;
 * mailAgasajado: String;
 * estadoLista: Char;
 * 
 * Metodos
 * agregarParticipante(Usuario p): int
 * agregarPago(Usuario u, Pago p): int
 * obtenerMontoRecaudado(): float
 * 
 * 
 * 
 * 
 */

}