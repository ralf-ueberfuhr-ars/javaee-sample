package de.ars.demo.boundary;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	/*
	 * Hollywood-Prinzip: Don't call us, we call u.
	 *  - doGet WIRD aufgerufen (passiv) -> wann? welche parameter? welcher rückgabewert?
	 *  -> Objekt WIRD erzeugt: wann? wieviele? -> max. 1
	 *  -> Instanzvariablen im Servlet nur einmalig initialisieren, ansonsten nur lesen
	 */

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		try(PrintWriter out = response.getWriter()) {
			out.println("Hello " + (name != null ? name : "World") + "!");
		};
	}



}
