package com.hwairlines.controllers;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hwairlines.dao.Pago;
import com.hwairlines.dao.PagoDAO;
import com.hwairlines.dao.Reserva;
import com.hwairlines.dao.ReservaDAO;
import com.hwairlines.dao.UsuarioDAO;
import com.hwairlines.dao.VueloDAO;

/**
 * Servlet implementation class PagoServlet
 */
@WebServlet("/pago")
public class PagoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PagoServlet() {
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
		switch(accion) {
		case "pagar":
			try {
			HttpSession session = request.getSession();
			String email = (String) session.getAttribute("email");
			UsuarioDAO usuario = new UsuarioDAO();
			request.setAttribute("idUsuario", usuario.getUsuario(email).getId_usuario());
			int id = (int) session.getAttribute("id");
			VueloDAO vuelo=new VueloDAO();
			PagoDAO pago= new PagoDAO();
			Pago foo=new Pago(1, Date.valueOf(LocalDate.now()),vuelo.getVuelo(id).getPrecio());
			pago.addPago(foo);
			ReservaDAO reserva=new ReservaDAO(); 
			Reserva reser=new Reserva(1,Date.valueOf(LocalDate.now()),vuelo.getVuelo(id).getPrecio(),usuario.getUsuario(email).getId_usuario(),foo.getId_pago(),id);
			reserva.addReserva(reser);
			System.out.println("Pago realizado con exito");
			session.removeAttribute("id");
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
			}catch(Exception ex) {
				System.out.println(ex);
			}
			break;
			
		default:
			try {
				HttpSession session = request.getSession();
				if(session.getAttribute("id") != null) {
				int id = (int) session.getAttribute("id");
				VueloDAO vuelo=new VueloDAO();
				request.setAttribute("vueloReserva", vuelo.getVuelo(id));
					
				}				
				RequestDispatcher dispatcher = request.getRequestDispatcher("pago.jsp");
				dispatcher.forward(request, response);
				
							
			}catch(Exception ex) {
				System.out.println(ex);
			}	
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
