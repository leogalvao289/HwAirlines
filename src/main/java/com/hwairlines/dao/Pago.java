package com.hwairlines.dao;

import java.sql.Date;

public class Pago {
	private int id_pago;
	private Date fecha;
	private double importe;
	
	public Pago(int id_pago, Date fecha, double importe) {
		super();
		this.id_pago = id_pago;
		this.fecha = fecha;
		this.importe = importe;
	}

	public int getId_pago() {
		return id_pago;
	}

	public void setId_pago(int id_pago) {
		this.id_pago = id_pago;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}


	
	
	
	
}
