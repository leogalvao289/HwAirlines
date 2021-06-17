package com.hwairlines.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class UsuarioDAO {
	private Connection con;

	public UsuarioDAO() {
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hw_airlines", "root", "");
            System.out.println("Conexi�n establecida");
 
        } catch (Exception ex) {
            System.out.println(ex);
        }
	}
	
	/* CRUD DE USUARIO */	
	
	public Usuario getUsuario(int id) {
		try {
			String sql="select * from hw_airlines.usuario where id_usuario=?";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1,id);
			ResultSet rs=stmt.executeQuery();
			if(rs.next()) {
				Usuario usuario=new Usuario(rs.getInt("id_usuario"),rs.getString("nombre"),rs.getString("apellidos"),rs.getDate("fecha_nacimiento"),rs.getString("dni"),rs.getString("correo"),rs.getString("contrasenya"),rs.getDate("fecha_registro"));
				return usuario;
			} else {
				return null;
			}
		} catch(Exception ex) {
			System.out.println(ex);
			return null;
		}
	}
	
	public List<Usuario> getUsuarios(){
		try {
			String sql="select * from hw_airlines.usuario";
			PreparedStatement stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			List<Usuario> usuarios=new ArrayList<Usuario>();
			while(rs.next()) {
				Usuario usuario= new Usuario(rs.getInt("id_usuario"),rs.getString("nombre"),rs.getString("apellidos"),rs.getDate("fecha_nacimiento"),rs.getString("dni"),rs.getString("correo"),rs.getString("contrasenya"),rs.getDate("fecha_registro"));
				usuarios.add(usuario);
			}
			return usuarios;
			
		}catch(Exception ex) {
			System.out.println(ex);
			return null;
		}
	}
	
	public int addUsuario(Usuario usuario) {
		try {
			String sql="insert into hw_airlines.usuario (nombre, apellidos, fecha_nacimiento, dni, correo, contrasenya) values (?,?,?,?,?,?)";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setString(1, usuario.getNombre());
			stmt.setString(2, usuario.getApellidos());
			stmt.setDate(3, usuario.getFecha_nacimiento());	
			stmt.setString(4, usuario.getDni());
			stmt.setString(5, usuario.getCorreo());
			stmt.setString(6, usuario.getContrasenya());
			int res=stmt.executeUpdate();
			return res;
		} catch (Exception ex) {
			System.out.println(ex);
			return -1;
		}
	}
	
	public int deleteUsuario(int id) {
		try {
			String sql="delete from hw_airlines.usuario where id_usuario=?";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1, id);
			int res=stmt.executeUpdate();
			return res;
		} catch(Exception ex) {
			System.out.println(ex);
			return -1;
		}
	}
	
	public int updateUsuario(Usuario usuario) {
		try {
			String sql="update hw_airlines.usuario set nombre=?, apellidos=?, fecha_nacimiento=?, dni=?, correo=?, contrasenya=? where id_usuario=?";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setString(1, usuario.getNombre());
			stmt.setString(2, usuario.getApellidos());
			stmt.setDate(3, usuario.getFecha_nacimiento());	
			stmt.setString(4, usuario.getDni());
			stmt.setString(5, usuario.getCorreo());
			stmt.setString(6, usuario.getContrasenya());
			stmt.setInt(7, usuario.getId_usuario());
			int res=stmt.executeUpdate();
			return res;
					
		} catch(Exception ex) {
			System.out.println(ex);
			return -1; 
		}
	}
	
	public int sumUsuarios() {
		try {
			String sql="select * from hw_airlines.usuario";
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

    /* ------------------------------Funci�n para consultar si el usuario ya est� registrado en la BBDD---------------------------------------------------*/
	public boolean isEmailRegistred(String email) {
		try {
			String sql="select * from hw_airlines.usuario where correo=?";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setString(1, email);
			ResultSet rs=stmt.executeQuery();
			boolean r=false;
			while(rs.next()) {
				r=true;
			}
			return r;
		}catch (Exception ex) {
			System.out.println(ex);
			return false;
		}		
	}
	 /* ------------------------------Funci�n para consultar si la cuenta existe---------------------------------------------------*/
	public boolean isAcountExist(String email, String pwd) {
		try {
			String sql = "select * from hw_airlines.usuario where correo =? and contrasenya = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, email);
			stmt.setString(2, pwd);
			ResultSet rs = stmt.executeQuery();
			boolean r = false;
			while (rs.next()) {
				r = true;
			}
			return r;
		} catch (Exception ex) {
			System.out.println(ex);
			return false;
		}
	}
	/* ------------------------------Funci�n para consultar si la cuenta existe---------------------------------------------------*/
	public Usuario getUsuario(String email) {
		try {
			String sql = "select * from hw_airlines.usuario where correo=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				Usuario usuario = new Usuario(rs.getInt("id_usuario"), rs.getString("nombre"),
						rs.getString("apellidos"), rs.getDate("fecha_nacimiento"), rs.getString("dni"),
						rs.getString("correo"), rs.getString("contrasenya"), rs.getDate("fecha_registro"));
				return usuario;
			} else {
				return null;
			}
		} catch (Exception ex) {
			System.out.println(ex);
			return null;
		}
	}
}