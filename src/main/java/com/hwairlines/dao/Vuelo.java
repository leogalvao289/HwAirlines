package com.hwairlines.dao;

import java.sql.Date;
import java.sql.Time;

public class Vuelo {
	private int id_vuelo;
	private Date fecha;
	private Time hora_salida;
	private Time hora_llegada;
	private String codigo_vuelo;
	private double precio;
	private int id_avion;
	private int id_aeropuerto_origen;
	private int id_aeropuerto_destino;
	private Aeropuerto aeropuertoOrigen;
	private Aeropuerto aeropuertoDestino;
	
	public Vuelo(int id_vuelo, Date fecha, Time hora_salida, Time hora_llegada, String codigo_vuelo,double precio, int id_avion,
			int id_aeropuerto_origen, int id_aeropuerto_destino) {
		super();
		this.id_vuelo = id_vuelo;
		this.fecha = fecha;
		this.hora_salida = hora_salida;
		this.hora_llegada = hora_llegada;
		this.codigo_vuelo = codigo_vuelo;
		this.precio=precio;
		this.id_avion = id_avion;
		this.id_aeropuerto_origen = id_aeropuerto_origen;
		this.id_aeropuerto_destino = id_aeropuerto_destino;
	}
	
	public int getId_vuelo() {
		return id_vuelo;
	}

	public void setId_vuelo(int id_vuelo) {
		this.id_vuelo = id_vuelo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Time getHora_salida() {
		return hora_salida;
	}

	public void setHora_salida(Time hora_salida) {
		this.hora_salida = hora_salida;
	}

	public Time getHora_llegada() {
		return hora_llegada;
	}

	public void setHora_llegada(Time hora_llegada) {
		this.hora_llegada = hora_llegada;
	}

	public String getCodigo_vuelo() {
		return codigo_vuelo;
	}

	public void setCodigo_vuelo(String codigo_vuelo) {
		this.codigo_vuelo = codigo_vuelo;
	}

	public int getId_avion() {
		return id_avion;
	}

	public void setId_avion(int id_avion) {
		this.id_avion = id_avion;
	}

	public int getId_aeropuerto_origen() {
		return id_aeropuerto_origen;
	}

	public void setId_aeropuerto_origen(int id_aeropuerto_origen) {
		this.id_aeropuerto_origen = id_aeropuerto_origen;
	}

	public int getId_aeropuerto_destino() {
		return id_aeropuerto_destino;
	}

	public void setId_aeropuerto_destino(int id_aeropuerto_destino) {
		this.id_aeropuerto_destino = id_aeropuerto_destino;
	}

	public Aeropuerto getAeropuertoOrigen() {
		return aeropuertoOrigen;
	}

	public void setAeropuertoOrigen(Aeropuerto aeropuertoOrigen) {
		this.aeropuertoOrigen = aeropuertoOrigen;
	}

	public Aeropuerto getAeropuertoDestino() {
		return aeropuertoDestino;
	}

	public void setAeropuertoDestino(Aeropuerto aeropuertoDestino) {
		this.aeropuertoDestino = aeropuertoDestino;
	}

	
	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	

	@Override
	public String toString() {
		return "Vuelo [id_vuelo=" + id_vuelo + ", fecha=" + fecha + ", hora_salida=" + hora_salida + ", hora_llegada="
				+ hora_llegada + ", codigo_vuelo=" + codigo_vuelo + ", id_avion=" + id_avion + ", id_aeropuerto_origen="
				+ id_aeropuerto_origen + ", id_aeropuerto_destino=" + id_aeropuerto_destino + ", aeropuertoOrigen="
				+ aeropuertoOrigen + ", aeropuertoDestino=" + aeropuertoDestino + "]";
	}
		
	
}
