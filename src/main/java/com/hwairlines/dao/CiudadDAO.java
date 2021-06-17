package com.hwairlines.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CiudadDAO {
	private Connection con;
	
	public CiudadDAO() {
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hw_airlines", "root", "");
            System.out.println("Conexión establecida");
 
        } catch (Exception ex) {
            System.out.println(ex);
        }
	}
	
	/* CRUD DE CIUDAD */	

	public Ciudad getCiudad(int id) {
		try {
			String sql="select * from hw_airlines.ciudad where id_ciudad=?";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1,id);
			ResultSet rs=stmt.executeQuery();
			if(rs.next()) {
				Ciudad ciudad=new Ciudad(rs.getInt("id_ciudad"),rs.getString("nombre"));
				return ciudad;
			} else {
				return null;
			}
		} catch(Exception ex) {
			System.out.println(ex);
			return null;
		}
	}
	
	public List<Ciudad> getCiudades(){
		try {
			String sql="select * from hw_airlines.ciudad";
			PreparedStatement stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			List<Ciudad> ciudades=new ArrayList<Ciudad>();
			while(rs.next()) {
				Ciudad ciudad= new Ciudad(rs.getInt("id_ciudad"),rs.getString("nombre"));
				ciudades.add(ciudad);
			}
			return ciudades;
			
		}catch(Exception ex) {
			System.out.println(ex);
			return null;
		}
	}
	
	public int addCiudad(Ciudad ciudad) {
		try {
			String sql="insert into hw_airlines.ciudad (nombre) values (?)";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setString(1, ciudad.getNombre());
			int res=stmt.executeUpdate();
			return res;
		} catch (Exception ex) {
			System.out.println(ex);
			return -1;
		}
	}
	
	public int deleteCiudad(int id) {
		try {
			String sql="delete from hw_airlines.ciudad where id_ciudad=?";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1, id);
			int res=stmt.executeUpdate();
			return res;
		} catch(Exception ex) {
			System.out.println(ex);
			return -1;
		}
	}
	
	public int updateCiudad(Ciudad ciudad) {
		try {
			String sql="update hw_airlines.ciudad set nombre=? where id_ciudad=?";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setString(1, ciudad.getNombre());
			stmt.setInt(2, ciudad.getId_ciudad());
			int res=stmt.executeUpdate();
			return res;
					
		} catch(Exception ex) {
			System.out.println(ex);
			return -1; 
		}
	}
	
	public int sumCiudades() {
		try {
			String sql="select * from hw_airlines.ciudad";
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
}
