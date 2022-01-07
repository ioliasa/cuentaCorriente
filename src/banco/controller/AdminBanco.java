package banco.controller;
import java.io.IOException;
import java.sql.SQLException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import banco.Cuenta;



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
		try {
			switch (action) {
			case "empezar":
				empezar(request, response);
				break;
			case "ingresar":
				ingresar(request, response);
				break;		
			case "realizarIngreso":
				realizarIngreso(request, response);
				break;
			case "reintegrar":
				reintegrar(request, response);
				break;	
			case "realizarReintegro":
				realizarReintegro(request, response);
			case "saldo":
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
