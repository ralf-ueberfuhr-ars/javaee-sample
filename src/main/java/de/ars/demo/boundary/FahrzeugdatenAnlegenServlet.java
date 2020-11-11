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
		// Konvertierung / Validierung
		int baujahr = Integer.valueOf(baujahrParam);

		Fahrzeugbestand bestand = (Fahrzeugbestand) getServletContext().getAttribute("fahrzeuge");
		// neue ID finden
		Optional<Integer> max = bestand.getFahrzeuge().stream().map(Fahrzeug::getId).max(Comparator.naturalOrder());
		// Fahrzeug einfügen
		bestand.add(new Fahrzeug(max.orElse(0) + 1, hersteller, baujahr));
		
		// Anzeige der Fahrzeugdaten
		response.sendRedirect("fahrzeuge");

	}

}
