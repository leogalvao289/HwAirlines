package com.hwairlines.dao;

public class Avion {
	private int id_avion;
	private String fabricante;
	private int capacidad;
	
	public Avion(int id_avion, String fabricante, int capacidad) {
		super();
		this.id_avion = id_avion;
		this.fabricante = fabricante;
		this.capacidad = capacidad;
	}

	public int getId_avion() {
		return id_avion;
	}

	public void setId_avion(int id_avion) {
		this.id_avion = id_avion;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	
	
	
}
