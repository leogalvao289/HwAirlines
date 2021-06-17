package com.hwairlines.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hwairlines.dao.UsuarioDAO;
import com.hwairlines.dao.VueloDAO;

/**
 * Servlet implementation class CarritoServlet
 */
@WebServlet("/carrito")
public class CarritoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarritoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			String email = (String) session.getAttribute("email");
			UsuarioDAO usuario = new UsuarioDAO();			
			request.setAttribute("usuario", usuario.getUsuario(email));
			if(session.getAttribute("id") != null) {
				int id = (int) session.getAttribute("id");
				VueloDAO vuelo=new VueloDAO();
				request.setAttribute("vueloReserva", vuelo.getVuelo(id));
				
			}				
			RequestDispatcher dispatcher = request.getRequestDispatcher("carrito.jsp");
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
