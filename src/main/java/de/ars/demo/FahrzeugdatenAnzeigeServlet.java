package de.ars.demo;

import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/fahrzeuge")
public class FahrzeugdatenAnzeigeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Logik, z.B. DB-Zugriff o.Ä.
		
		Collection<Fahrzeug> fahrzeuge = new LinkedList<>();
		fahrzeuge.add(new Fahrzeug("Ford", 2010));
		fahrzeuge.add(new Fahrzeug("Opel", 2018));
		
		// Antwort generieren in JSP, kein PrintWriter!
		request.setAttribute("fz", fahrzeuge);
		request.getRequestDispatcher("/displayFahrzeuge.jsp")
			.forward(request, response);
		
	}

}
