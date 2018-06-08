package Modelo;

import java.sql.Date;

public class Pago {
	
	private int idPago;
	private Date fechaPago;
	private int monto;
	
	public Pago (int id, Date fchPago, int monto) {
		this.idPago = id;
		this.fechaPago = fchPago;
		this.monto = monto;
	}

	public Pago () {
		this.idPago = 0;
		this.monto = 0;

	}
	
	public Date getFechaPago() {
		return fechaPago;
	}
	public int getMonto() {
		return monto;
	}
	public int getIdPago() {
		return idPago;
	}
	
	
	
}
