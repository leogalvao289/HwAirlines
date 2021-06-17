package com.hwairlines.controllers;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hwairlines.dao.Usuario;
import com.hwairlines.dao.UsuarioDAO;

/**
 * Servlet implementation class RegistroServlet
 */
@WebServlet("/registro")
public class RegistroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistroServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String nombre=request.getParameter("nombre");
			String apellido=request.getParameter("apellido");
			String dni=request.getParameter("dni");
			String email=request.getParameter("email");
			String contrasenya=request.getParameter("contrasenya");
			String contrasenya2=request.getParameter("contrasenya2");
			java.sql.Date nacimiento=java.sql.Date.valueOf(request.getParameter("nacimiento"));
			UsuarioDAO usuarios = new UsuarioDAO();;
			if(nombre.isEmpty()||apellido.isEmpty()||dni.isEmpty()||email.isEmpty()||contrasenya.isEmpty()||contrasenya2.isEmpty()) {
				request.setAttribute("error", "Hay campos vacios. Por favor, rellene todos los campos.");
				RequestDispatcher dispatcher = request.getRequestDispatcher("registro.jsp");
		        dispatcher.forward(request, response);
			} else if(usuarios.isEmailRegistred(email)) {
				request.setAttribute("error", "El email indicado ya está registrado.");
				RequestDispatcher dispatcher = request.getRequestDispatcher("registro.jsp");
		        dispatcher.forward(request, response);
			} else if(!contrasenya.equals(contrasenya2)) {
				request.setAttribute("error", "Las contraseñas no son iguales.");
				RequestDispatcher dispatcher = request.getRequestDispatcher("registro.jsp");
		        dispatcher.forward(request, response);
			} else {
				Usuario usuario= new Usuario(1,nombre, apellido, nacimiento, dni, email, contrasenya, Date.valueOf("2021-05-07"));
				usuarios.addUsuario(usuario);			
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				dispatcher.forward(request, response);	
			}
				
		}catch(Exception ex) {
			System.out.println(ex);
		}		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
