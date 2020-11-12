package de.ars.demo.boundary;

import java.io.IOException;
import java.util.Collection;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.ars.demo.control.Fahrzeugbestand;
import de.ars.demo.entity.Fahrzeug;

@WebServlet("/fahrzeuge")
public class FahrzeugdatenAnzeigeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Inject
	private Fahrzeugbestand bestand;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Logik, z.B. DB-Zugriff o.Ä.
		
		Collection<Fahrzeug> fahrzeuge = bestand.getFahrzeuge();
		
		// Antwort generieren in JSP, kein PrintWriter!
		request.setAttribute("fz", fahrzeuge);
		request.setAttribute("pageTitle", "Anzeige aller Fahrzeuge");
		request.getRequestDispatcher("/WEB-INF/jsp/displayFahrzeuge.jsp")
			.forward(request, response);
		
	}

}
