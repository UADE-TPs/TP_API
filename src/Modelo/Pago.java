package Modelo;

import java.sql.Date;

public class Pago {
	
	private Date fechaPago;
	private float monto;
	
	public Pago (Date fchPago, float monto) {
		this.fechaPago = fchPago;
		this.monto = monto;
	}
	
	public Date getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}
	public float getMonto() {
		return monto;
	}
	public void setMonto(float monto) {
		this.monto = monto;
	}
	
	

	
	
}
