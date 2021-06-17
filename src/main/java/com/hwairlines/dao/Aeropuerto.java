package com.hwairlines.dao;

public class Aeropuerto {
	private int id_aeropuerto;
	private String nombre;
	private String codigo_aeropuerto;
	private int id_ciudad;
	
	public Aeropuerto(int id_aeropuerto, String nombre, String codigo_aeropuerto,
			int id_ciudad) {
		super();
		this.id_aeropuerto = id_aeropuerto;
		this.nombre = nombre;
		this.codigo_aeropuerto = codigo_aeropuerto;
		this.id_ciudad = id_ciudad;
	}

	public int getId_aeropuerto() {
		return id_aeropuerto;
	}

	public void setId_aeropuerto(int id_aeropuerto) {
		this.id_aeropuerto = id_aeropuerto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo_aeropuerto() {
		return codigo_aeropuerto;
	}

	public void setCodigo_aeropuerto(String codigo_aeropuerto) {
		this.codigo_aeropuerto = codigo_aeropuerto;
	}

	public int getId_ciudad() {
		return id_ciudad;
	}

	public void setId_ciudad(int id_ciudad) {
		this.id_ciudad = id_ciudad;
	}

	@Override
	public String toString() {
		return "Aeropuerto [id_aeropuerto=" + id_aeropuerto + ", nombre=" + nombre + ", codigo_aeropuerto="
				+ codigo_aeropuerto + ", id_ciudad=" + id_ciudad + "]";
	}
	
	
	
	
}
