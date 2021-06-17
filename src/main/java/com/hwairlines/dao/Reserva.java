package com.hwairlines.dao;

import java.sql.Date;

public class Reserva {
	private int id_reserva;
	private Date fecha;
	private double coste;
	private int id_usuario;
	private int id_pago;
	private int id_vuelo;
	
	public Reserva(int id_reserva, Date fecha, double coste, int id_usuario, int id_pago, int id_vuelo) {
		super();
		this.id_reserva = id_reserva;
		this.fecha = fecha;
		this.coste = coste;
		this.id_usuario = id_usuario;
		this.id_pago = id_pago;
		this.id_vuelo = id_vuelo;
	}

	public int getId_reserva() {
		return id_reserva;
	}

	public void setId_reserva(int id_reserva) {
		this.id_reserva = id_reserva;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public double getCoste() {
		return coste;
	}

	public void setCoste(double coste) {
		this.coste = coste;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public int getId_pago() {
		return id_pago;
	}

	public void setId_pago(int id_pago) {
		this.id_pago = id_pago;
	}

	public int getId_vuelo() {
		return id_vuelo;
	}

	public void setId_vuelo(int id_vuelo) {
		this.id_vuelo = id_vuelo;
	}

	
	
	
}
