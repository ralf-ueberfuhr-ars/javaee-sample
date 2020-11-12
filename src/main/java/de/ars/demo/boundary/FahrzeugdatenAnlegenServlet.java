package de.ars.demo.boundary;

import java.io.IOException;
import java.util.Comparator;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.ars.demo.control.Fahrzeugbestand;
import de.ars.demo.entity.Fahrzeug;

@WebServlet("/fahrzeugAnlegen")
public class FahrzeugdatenAnlegenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String hersteller = request.getParameter("hersteller");
		String baujahrParam = request.getParameter("baujahr");
		
		if(null == hersteller || null == baujahrParam || hersteller.isEmpty() || baujahrParam.isEmpty() ) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		
		// Konvertierung / Validierung
		int baujahr;
		try {
			baujahr = Integer.valueOf(baujahrParam);
		} catch (NumberFormatException e) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		
		if(baujahr<1900) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Baujahr must be gte 1900.");
			return;
		}

		Fahrzeugbestand bestand = (Fahrzeugbestand) getServletContext().getAttribute("fahrzeuge");
		// neue ID finden
		Optional<Integer> max = bestand.getFahrzeuge().stream().map(Fahrzeug::getId).max(Comparator.naturalOrder());
		// Fahrzeug einfügen
		bestand.add(new Fahrzeug(max.orElse(0) + 1, hersteller, baujahr));
		
		// Anzeige der Fahrzeugdaten
		response.sendRedirect("fahrzeuge");

	}

}
