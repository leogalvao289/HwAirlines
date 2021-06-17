package com.hwairlines.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VueloDAO {
	private Connection con;

	public VueloDAO() {
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hw_airlines", "root", "");
            System.out.println("Conexi�n establecida");
 
        } catch (Exception ex) {
            System.out.println(ex);
        }
	}

	/* CRUD DE VUELOS ---------------------------------------------------------------------------------------------------------------*/
	
	public Vuelo getVuelo(int id) {
		AeropuertoDAO aeropuerto=new AeropuertoDAO();
		try {
			String sql="select * from hw_airlines.vuelo where id_vuelo=?";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1,id);
			ResultSet rs=stmt.executeQuery();
			if(rs.next()) {
				Vuelo vuelo=new Vuelo(rs.getInt("id_vuelo"),rs.getDate("fecha"),rs.getTime("hora_salida"),rs.getTime("hora_llegada"),rs.getString("codigo_vuelo"),rs.getDouble("precio"),rs.getInt("id_avion"),rs.getInt("id_aeropuerto_origen"),rs.getInt("id_aeropuerto_destino"));
				vuelo.setAeropuertoOrigen(aeropuerto.getAeropuerto(rs.getInt("id_aeropuerto_origen")));
				vuelo.setAeropuertoDestino(aeropuerto.getAeropuerto(rs.getInt("id_aeropuerto_destino")));
				return vuelo;
			} else {
				return null;
			}
		} catch(Exception ex) {
			System.out.println(ex);
			return null;
		}
	}
	
	public List<Vuelo> getVuelos(){
		try {
			String sql="select * from hw_airlines.vuelo";
			PreparedStatement stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			List<Vuelo> vuelos=new ArrayList<Vuelo>();
			while(rs.next()) {
				Vuelo vuelo= new Vuelo(rs.getInt("id_vuelo"),rs.getDate("fecha"),rs.getTime("hora_salida"),rs.getTime("hora_llegada"),rs.getString("codigo_vuelo"),rs.getDouble("precio"),rs.getInt("id_avion"),rs.getInt("id_aeropuerto_origen"),rs.getInt("id_aeropuerto_destino"));
				vuelos.add(vuelo);
			}
			return vuelos;
			
		}catch(Exception ex) {
			System.out.println(ex);
			return null;
		}
	}
	
	
	public int addVuelo(Vuelo vuelo) {
		try {
			String sql="insert into hw_airlines.vuelo (fecha, hora_salida, hora_llegada, codigo_vuelo, precio, id_avion, id_aeropuerto_origen,id_aeropuerto_destino) values (?,?,?,?,?,?,?,?)";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setDate(1, vuelo.getFecha());
			stmt.setTime(2, vuelo.getHora_salida());
			stmt.setTime(3, vuelo.getHora_llegada());
			stmt.setString(4, vuelo.getCodigo_vuelo());
			stmt.setDouble(5, vuelo.getPrecio());
			stmt.setInt(6, vuelo.getId_avion());
			stmt.setInt(7, vuelo.getId_aeropuerto_origen());
			stmt.setInt(8, vuelo.getId_aeropuerto_destino());
			int res=stmt.executeUpdate();
			return res;
		} catch (Exception ex) {
			System.out.println(ex);
			return -1;
		}
	}
	
	public int deleteVuelo(int id) {
		try {
			String sql="delete from hw_airlines.vuelo where id_vuelo=?";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1, id);
			int res=stmt.executeUpdate();
			return res;
		} catch(Exception ex) {
			System.out.println(ex);
			return -1;
		}
	}
	
	public int updateVuelo(Vuelo vuelo) {
		try {
			String sql="update hw_airlines.vuelo set fecha=?, hora_salida=?, hora_llegada=?, codigo_vuelo=?, precio=?,id_avion=?, id_aeropuerto_origen=?, id_aeropuerto_destino=? where id_vuelo=?";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setDate(1, vuelo.getFecha());
			stmt.setTime(2, vuelo.getHora_salida());
			stmt.setTime(3, vuelo.getHora_llegada());
			stmt.setString(4, vuelo.getCodigo_vuelo());
			stmt.setDouble(5, vuelo.getPrecio());
			stmt.setInt(6, vuelo.getId_avion());
			stmt.setInt(7, vuelo.getId_aeropuerto_origen());
			stmt.setInt(8, vuelo.getId_aeropuerto_destino());
			int res=stmt.executeUpdate();
			return res;
					
		} catch(Exception ex) {
			System.out.println(ex);
			return -1; 
		}
	}
	
	/* OTRAS FUNCIONES ---------------------------------------------------------------------------------------------------------------*/
	
	public int sumVuelos() {
		try {
			String sql="select * from hw_airlines.vuelo";
			PreparedStatement stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			int cont=0;
			while(rs.next()) {
				cont++;
			}
			return cont;
		}catch (Exception ex) {
			System.out.println(ex);
			return -1;
		}		
	}
	
	
	
	/* FUNCI�N QUE NOS BUSQUE LOS VUELOS ---------------------------------------------------------------------------------------------------------------*/
	
	public List<Vuelo> buscarVuelos(int origen, int destino, Date fecha){
		AeropuertoDAO aeropuerto=new AeropuertoDAO();
		try {
			String sql="select * from hw_airlines.vuelo where id_aeropuerto_origen=? and id_aeropuerto_destino=? and fecha=?";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1,origen);
			stmt.setInt(2, destino);
			stmt.setDate(3, fecha);
			ResultSet rs=stmt.executeQuery();
			List<Vuelo> vuelos=new ArrayList<Vuelo>();
			while(rs.next()) {
				Vuelo vuelo= new Vuelo(rs.getInt("id_vuelo"),rs.getDate("fecha"),rs.getTime("hora_salida"),rs.getTime("hora_llegada"),rs.getString("codigo_vuelo"),rs.getDouble("precio"),rs.getInt("id_avion"),rs.getInt("id_aeropuerto_origen"),rs.getInt("id_aeropuerto_destino"));
				vuelo.setAeropuertoOrigen(aeropuerto.getAeropuerto(rs.getInt("id_aeropuerto_origen")));
				vuelo.setAeropuertoDestino(aeropuerto.getAeropuerto(rs.getInt("id_aeropuerto_destino")));
				vuelos.add(vuelo);
			}
			return vuelos;
		}catch(Exception ex) {
			System.out.println(ex);
			return null;
		}
	}
	
	
}
