package com.hwairlines.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AvionDAO {
	private Connection con;
	
	public AvionDAO() {
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hw_airlines", "root", "");
            System.out.println("Conexión establecida");
 
        } catch (Exception ex) {
            System.out.println(ex);
        }
	}
	
	/* CRUD DE AVIÓN */
	
	public Avion getAvion(int id) {
		try {
			String sql="select * from hw_airlines.avion where id_avion=?";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1,id);
			ResultSet rs=stmt.executeQuery();
			if(rs.next()) {
				Avion avion=new Avion(rs.getInt("id_avion"),rs.getString("fabricante"),rs.getInt("capacidad"));
				return avion;
			} else {
				return null;
			}
		} catch(Exception ex) {
			System.out.println(ex);
			return null;
		}
	}
	
	public List<Avion> getAviones(){
		try {
			String sql="select * from hw_airlines.avion";
			PreparedStatement stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			List<Avion> aviones=new ArrayList<Avion>();
			while(rs.next()) {
				Avion avion= new Avion(rs.getInt("id_avion"),rs.getString("fabricante"),rs.getInt("capacidad"));
				aviones.add(avion);
			}
			return aviones;
			
		}catch(Exception ex) {
			System.out.println(ex);
			return null;
		}
	}
	
	public int addAvion(Avion avion) {
		try {
			String sql="insert into hw_airlines.avion (fabricante, capacidad) values (?,?)";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setString(1, avion.getFabricante());
			stmt.setInt(2, avion.getCapacidad());
			int res=stmt.executeUpdate();
			return res;
		} catch (Exception ex) {
			System.out.println(ex);
			return -1;
		}
	}
	
	public int deleteAvion(int id) {
		try {
			String sql="delete from hw_airlines.avion where id_avion=?";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1, id);
			int res=stmt.executeUpdate();
			return res;
		} catch(Exception ex) {
			System.out.println(ex);
			return -1;
		}
	}
	
	public int updateAvion(Avion avion) {
		try {
			String sql="update hw_airlines.avion set fabricante=?, capacidad=? where id_avion=?";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setString(1, avion.getFabricante());
			stmt.setInt(2, avion.getCapacidad());
			stmt.setInt(3, avion.getId_avion());
			int res=stmt.executeUpdate();
			return res;
					
		} catch(Exception ex) {
			System.out.println(ex);
			return -1; 
		}
	}
	
	public int sumAviones() {
		try {
			String sql="select * from hw_airlines.avion";
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
