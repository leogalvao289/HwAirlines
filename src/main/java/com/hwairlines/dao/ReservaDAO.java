package com.hwairlines.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReservaDAO {
	private Connection con;
	
	public ReservaDAO() {
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hw_airlines", "root", "");
            System.out.println("Conexión establecida");
 
        } catch (Exception ex) {
            System.out.println(ex);
        }
	}

	/* CRUD DE RESERVAS ---------------------------------------------------------------------------------------------------------------*/
	
	public Reserva getReserva(int id) {
		try {
			String sql="select * from hw_airlines.reserva where id_reserva=?";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1,id);
			ResultSet rs=stmt.executeQuery();
			if(rs.next()) {
				Reserva reserva=new Reserva(rs.getInt("id_reserva"),rs.getDate("fecha"),rs.getDouble("coste"),rs.getInt("id_usuario"),rs.getInt("id_pago"),rs.getInt("id_vuelo"));
				return reserva;
			} else {
				return null;
			}
		} catch(Exception ex) {
			System.out.println(ex);
			return null;
		}
	}
	
	public List<Reserva> getReservas(){
		try {
			String sql="select * from hw_airlines.reserva";
			PreparedStatement stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			List<Reserva> reservas=new ArrayList<Reserva>();
			while(rs.next()) {
				Reserva reserva= new Reserva(rs.getInt("id_reserva"),rs.getDate("fecha"),rs.getDouble("coste"),rs.getInt("id_usuario"),rs.getInt("id_pago"),rs.getInt("id_vuelo"));
				reservas.add(reserva);
			}
			return reservas;
			
		}catch(Exception ex) {
			System.out.println(ex);
			return null;
		}
	}
	
	public int addReserva(Reserva reserva) {
		try {
			String sql="insert into hw_airlines.reserva (fecha, coste, id_usuario, id_pago, id_vuelo) values (?,?,?,?,?)";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setDate(1, reserva.getFecha());
			stmt.setDouble(2, reserva.getCoste());
			stmt.setInt(3, reserva.getId_usuario());
			stmt.setInt(4, reserva.getId_pago());
			stmt.setInt(5, reserva.getId_vuelo());
			int res=stmt.executeUpdate();
			return res;
		} catch (Exception ex) {
			System.out.println(ex);
			return -1;
		}
	}
	
	public int deleteReserva(int id) {
		try {
			String sql="delete from hw_airlines.reserva where id_reserva=?";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1, id);
			int res=stmt.executeUpdate();
			return res;
		} catch(Exception ex) {
			System.out.println(ex);
			return -1;
		}
	}
	
	public int updateReserva(Reserva reserva) {
		try {
			String sql="update hw_airlines.reserva set fecha=?, coste=?, id_usuario=?, id_pago=?, id_vuelo=? where id_reserva=?";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setDate(1, reserva.getFecha());
			stmt.setDouble(2, reserva.getCoste());
			stmt.setInt(3, reserva.getId_usuario());
			stmt.setInt(3, reserva.getId_pago());
			stmt.setInt(3, reserva.getId_vuelo());
			int res=stmt.executeUpdate();
			return res;
					
		} catch(Exception ex) {
			System.out.println(ex);
			return -1; 
		}
	}
	
	/* OTRAS FUNCIONES ---------------------------------------------------------------------------------------------------------------*/
	
	public int sumReservas() {
		try {
			String sql="select * from hw_airlines.reservas";
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
