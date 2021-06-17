package com.hwairlines.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PagoDAO {
	private Connection con;
	
	public PagoDAO() {
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hw_airlines", "root", "");
            System.out.println("Conexi�n establecida");
 
        } catch (Exception ex) {
            System.out.println(ex);
        }
	}
	
	/* CRUD DE PAGO */
	
	public Pago getPago(int id) {
		try {
			String sql="select * from hw_airlines.pago where id_pago=?";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1,id);
			ResultSet rs=stmt.executeQuery();
			if(rs.next()) {
				Pago pago=new Pago(rs.getInt("id_pago"),rs.getDate("fecha"),rs.getDouble("importe"));
				return pago;
			} else {
				return null;
			}
		} catch(Exception ex) {
			System.out.println(ex);
			return null;
		}
	}
	
	public List<Pago> getPagos(){
		try {
			String sql="select * from hw_airlines.pago";
			PreparedStatement stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			List<Pago> pagos=new ArrayList<Pago>();
			while(rs.next()) {
				Pago pago= new Pago(rs.getInt("id_pago"),rs.getDate("fecha"),rs.getDouble("importe"));
				pagos.add(pago);
			}
			return pagos;
			
		}catch(Exception ex) {
			System.out.println(ex);
			return null;
		}
	}
	
	public int addPago(Pago pago) {
		try {
			String sql="insert into hw_airlines.pago (fecha, importe) values (?,?)";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setDate(1, pago.getFecha());
			stmt.setDouble(2, pago.getImporte());
			int res=stmt.executeUpdate();
			return res;
		} catch (Exception ex) {
			System.out.println(ex);
			return -1;
		}
	}
	
	public int deletePago(int id) {
		try {
			String sql="delete from hw_airlines.pago where id_pago=?";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1, id);
			int res=stmt.executeUpdate();
			return res;
		} catch(Exception ex) {
			System.out.println(ex);
			return -1;
		}
	}
	
	public int updatePago(Pago pago) {
		try {
			String sql="update hw_airlines.pago set fecha=?, importe=? where id_pago=?";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setDate(1, pago.getFecha());
			stmt.setDouble(2, pago.getImporte());
			stmt.setInt(3, pago.getId_pago());
			int res=stmt.executeUpdate();
			return res;
					
		} catch(Exception ex) {
			System.out.println(ex);
			return -1; 
		}
	}
	
	public int sumPagos() {
		try {
			String sql="select * from hw_airlines.pago";
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
