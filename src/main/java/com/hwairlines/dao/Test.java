package com.hwairlines.dao;

import java.sql.Date;

public class Test {

	public static void main(String[] args) {
	
		//AeropuertoDAO foo= new AeropuertoDAO();
		//System.out.println(foo.getAeropuerto(1));
		//System.out.println(foo.getAeropuertos());
		
		
		
		//VueloDAO foo=new VueloDAO();
		//Vuelo vuelo=foo.getVuelo(20);
		//System.out.println(vuelo);
		//System.out.println(vuelo.getAeropuertoOrigen().getNombre());
		
		//System.out.println(foo.getVuelos());
		VueloDAO foo= new VueloDAO();
		//Usuario usere= new Usuario(1,"Laura", "Pi Olivo", Date.valueOf("1970-05-12"), "46789302A", "laura@gmail.com", "98765", Date.valueOf("2021-05-07"));
		System.out.println(foo.buscarVuelos(27, 16, Date.valueOf("2021-05-07")));
		
		
	}

}
