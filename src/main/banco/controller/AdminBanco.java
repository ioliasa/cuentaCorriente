package main.banco.controller;

import java.io.IOException;
import java.sql.SQLException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.banco.*;



@WebServlet("/adminBanco")
public class AdminBanco extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Cuenta cuenta;

	public void init(String ncc, double saldo) {
		cuenta = new Cuenta(ncc, saldo);
	}
	
	// El constructor llama a la clase de la que hereda
	public AdminBanco() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Esta es la función que se llama desde JSP y que gestiona el flujo
	// del programa. Cuando recive una palabra o token llama a un método
	// que realiza la ación.
	// En request se le pasa lo que llega del formulario
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		int opc=0;
		if (action.equals("empezar"))
			opc = 1;
		else if (action.equals("ingresar"))
			opc =2;
		else if (action.equals("realizarIngreso"))
			opc = 3;
		else if (action.equals("reintegrar"))
			opc = 4;
		else if (action.equals("realizarReintegro"))
			opc = 5;
		else if (action.equals("saldo"))
			opc = 6;
		try {
			switch (opc) {
			case 1:
				empezar(request, response);
				break;
			case 2:
				ingresar(request, response);
				break;		
			case 3:
				realizarIngreso(request, response);
				break;
			case 4:
				reintegrar(request, response);
				break;	
			case 5:
				realizarReintegro(request, response);
			case 6:
				saldo(request, response);
				break;
			default:
				break;
			}			
		} catch (SQLException e) {
			e.getStackTrace();
		}
	}	
	
	// Llama a la clase padre.
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Hola Servlet..");
		doGet(request, response);
	}
	
	
	private void ingresar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("ingresar.jsp");
		dispatcher.forward(request, response);
	}
	
	private void reintegrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("reintegrar.jsp");
		dispatcher.forward(request, response);
	}
	
	private void saldo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("menu.jsp");
		request.setAttribute("saldo",cuenta.getSaldo()); 
		
		dispatcher.forward(request, response);
	}

	
	private void empezar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		// creo la máquina para empezar. El valor del monedero se pasa por parámetro
		cuenta = new Cuenta(request.getParameter("ncc"), Double.parseDouble(request.getParameter("saldo")));
				
		RequestDispatcher dispatcher = request.getRequestDispatcher("menu.jsp");
		
		dispatcher.forward(request, response);
	}
	
	private void realizarIngreso(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		// creo la máquina para empezar. El valor del monedero se pasa por parámetro
		cuenta.ingresar( Double.parseDouble(request.getParameter("dinero")));
				
		RequestDispatcher dispatcher = request.getRequestDispatcher("menu.jsp");
		
		dispatcher.forward(request, response);
	}
	
	private void realizarReintegro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		// creo la máquina para empezar. El valor del monedero se pasa por parámetro
		cuenta.reintegrar( Double.parseDouble(request.getParameter("dinero")));
				
		RequestDispatcher dispatcher = request.getRequestDispatcher("menu.jsp");
		
		dispatcher.forward(request, response);
	}	

}
