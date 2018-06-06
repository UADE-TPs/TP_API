package Modelo;

import java.sql.Date;

public class Pago {
	
	private int idPago;
	private Date fechaPago;
	private float monto;
	
	public Pago (int id, Date fchPago, float monto) {
		this.idPago = id;
		this.fechaPago = fchPago;
		this.monto = monto;
	}
	
	public Date getFechaPago() {
		return fechaPago;
	}
	public float getMonto() {
		return monto;
	}
	public int getIdPago() {
		return idPago;
	}
	
	

	
	
}
