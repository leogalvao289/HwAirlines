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
 * Servlet implementation class MiCuentaServlet
 */
@WebServlet("/micuenta")
public class MiCuentaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UsuarioDAO modelo;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MiCuentaServlet() {
        super();
        modelo = new UsuarioDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			HttpSession session = request.getSession();
			String email = (String) session.getAttribute("email");

			UsuarioDAO usuario = new UsuarioDAO();
			
			request.setAttribute("usuario", usuario.getUsuario(email));
			RequestDispatcher dispatcher = request.getRequestDispatcher("micuenta.jsp");
			dispatcher.forward(request, response);
			
						
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