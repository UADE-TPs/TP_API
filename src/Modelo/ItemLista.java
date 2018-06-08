package Modelo;

import Persistencia.MapperLista;
import Persistencia.PoolConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import Persistencia.MapperItemLista;

public class ItemLista {
	
	private int codLista;
	private Usuario particiante;
	private Pago pago;
	
	public ItemLista(int cod, Usuario parti) {
		super();
		this.codLista=cod;
		this.particiante=parti;
		MapperItemLista.getInstancia().insert(this);
	}
	
	public ItemLista(int cod,Usuario parti, Pago pago) {
		super();
		this.codLista=cod;
		this.particiante=parti;
		this.pago = pago;
	}

	public Usuario getParticiante() {
		return particiante;
	}
	public void setParticiante(Usuario p) {
		this.particiante=p;
	}

	public Pago getPago() {
		return pago;
	}

	public void setPago(Pago pag) {
		this.pago = pag;
	}

	public void setCodLista(int cod) {
		this.codLista = cod;
	}

	public int getcodLista() {
		return this.codLista;
	}


}
