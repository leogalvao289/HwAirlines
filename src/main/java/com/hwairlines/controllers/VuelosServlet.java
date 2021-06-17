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

import com.hwairlines.dao.AeropuertoDAO;
import com.hwairlines.dao.VueloDAO;

/**
 * Servlet implementation class VuelosServlet
 */
@WebServlet("/vuelos")
public class VuelosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VuelosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion=request.getParameter("accion");
		if(accion == null) {
			accion="";
		}		
		switch (accion) {
		case "buscar":
			 try {
				 	int origen = Integer.parseInt(request.getParameter("origen"));
				 	int destino = Integer.parseInt(request.getParameter("destino"));	  
					Date fecha=Date.valueOf(request.getParameter("fecha"));
					VueloDAO vuelos= new VueloDAO();
					request.setAttribute("vuelosBusqueda", vuelos.buscarVuelos(origen, destino, fecha));
					AeropuertoDAO ae=new AeropuertoDAO();
					request.setAttribute("vuelos", ae.getAeropuertos());
					RequestDispatcher dispatcher = request.getRequestDispatcher("vuelos.jsp");
					dispatcher.forward(request, response);
					
		        } catch(Exception ex) {
		        	System.out.println(ex);
		        }
			 break;
		case "reservar":
				HttpSession session = request.getSession();
			try {
				String email = (String) session.getAttribute("email");
				if( email==null) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
					dispatcher.forward(request, response);
					
				} else {
					int id=Integer.parseInt(request.getParameter("id"));
					session.setAttribute("id", id);
					System.out.println("Reserva añadida correctamente");
					RequestDispatcher dispatcher = request.getRequestDispatcher("./carrito");
					dispatcher.forward(request, response);
				}
						
			} catch(Exception ex) {
				System.out.println(ex);
				
			}		
			break;
			
		default:
		AeropuertoDAO ae=new AeropuertoDAO();
		request.setAttribute("vuelos", ae.getAeropuertos());
		RequestDispatcher dispatcher = request.getRequestDispatcher("vuelos.jsp");
		dispatcher.forward(request, response);
		break;
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
