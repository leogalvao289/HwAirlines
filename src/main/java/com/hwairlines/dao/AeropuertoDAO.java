package com.hwairlines.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AeropuertoDAO {
	private Connection con;
	
	public AeropuertoDAO() {
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hw_airlines", "root", "");
            System.out.println("Conexi�n establecida");
 
        } catch (Exception ex) {
            System.out.println(ex);
        }
	}
	
	/* CRUD DE AEROPUERTO DESTINO */	
	
	public Aeropuerto getAeropuerto(int id) {
		try {
			String sql="select * from hw_airlines.aeropuerto where id_aeropuerto=?";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1,id);
			ResultSet rs=stmt.executeQuery();
			if(rs.next()) {
				Aeropuerto aeropuerto=new Aeropuerto(rs.getInt("id_aeropuerto"),rs.getString("nombre"),rs.getString("codigo_aeropuerto"),rs.getInt("id_ciudad"));
				return aeropuerto;
			} else {
				return null;
			}
		} catch(Exception ex) {
			System.out.println(ex);
			return null;
		}
	}
	
	public List<Aeropuerto> getAeropuertos(){
		try {
			String sql="select * from hw_airlines.aeropuerto";
			PreparedStatement stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			List<Aeropuerto> aeropuertos=new ArrayList<Aeropuerto>();
			while(rs.next()) {
				Aeropuerto aeropuerto= new Aeropuerto(rs.getInt("id_aeropuerto"),rs.getString("nombre"),rs.getString("codigo_aeropuerto"),rs.getInt("id_ciudad"));
				aeropuertos.add(aeropuerto);
			}
			return aeropuertos;
			
		}catch(Exception ex) {
			System.out.println(ex);
			return null;
		}
	}
	
	public int addAeropuerto(Aeropuerto aeropuerto) {
		try {
			String sql="insert into hw_airlines.aeropuerto(nombre, codigo_aeropuerto, id_ciudad) values (?,?,?)";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setString(1, aeropuerto.getNombre());
			stmt.setString(2, aeropuerto.getCodigo_aeropuerto());
			stmt.setInt(3, aeropuerto.getId_ciudad());
			int res=stmt.executeUpdate();
			return res;
		} catch (Exception ex) {
			System.out.println(ex);
			return -1;
		}
	}
	
	public int deleteAeropuerto(int id) {
		try {
			String sql="delete from hw_airlines.aeropuerto where id_aeropuerto=?";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1, id);
			int res=stmt.executeUpdate();
			return res;
		} catch(Exception ex) {
			System.out.println(ex);
			return -1;
		}
	}
	
	public int updateAeropuerto(Aeropuerto aeropuerto) {
		try {
			String sql="update hw_airlines.aeropuerto set set nombre=?, codigo_aeropuerto=?, id_ciudad=? where id_aeropuerto=?";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setString(1, aeropuerto.getNombre());
			stmt.setString(2, aeropuerto.getCodigo_aeropuerto());
			stmt.setInt(3, aeropuerto.getId_ciudad());
			stmt.setInt(4, aeropuerto.getId_aeropuerto());
			int res=stmt.executeUpdate();
			return res;
					
		} catch(Exception ex) {
			System.out.println(ex);
			return -1; 
		}
	}
	
	public int sumAeropuertos() {
		try {
			String sql="select * from hw_airlines.aeropuerto";
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
	
	public List<String> getNombreAeropuertos(){
		try {
			String sql="select nombre from hw_airlines.aeropuerto";
			PreparedStatement stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			List<String> aeropuertos=new ArrayList<String>();
			while(rs.next()) {	
				aeropuertos.add(rs.getString("nombre"));
			}
			return aeropuertos;
			
		}catch(Exception ex) {
			System.out.println(ex);
			return null;
		}
	}
	
	
}
