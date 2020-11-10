package de.ars.demo.boundary;

import java.io.IOException;
import java.util.Collection;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.ars.demo.control.Fahrzeugbestand;
import de.ars.demo.entity.Fahrzeug;

@WebServlet("/fahrzeugsuche")
public class FahrzeugdatenSuchenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String suchtext = request.getParameter("suchtext");
		// Validierung?
		if (null == suchtext) {

			// response.sendRedirect("suche.html");
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Parameter suchtext must not be null!");

		} else {

			// Logik, z.B. DB-Zugriff o.Ä.

			Collection<Fahrzeug> fahrzeuge = Fahrzeugbestand.getInstance().getFahrzeuge();
			Collection<Fahrzeug> suchErgebnisse = fahrzeuge.stream()
					.filter(fz -> fz.getHersteller().toLowerCase().contains(suchtext.toLowerCase()))
					.collect(Collectors.toList());

			// Antwort generieren in JSP, kein PrintWriter!
			request.setAttribute("fz", suchErgebnisse);
			request.setAttribute("pageTitle", "Suchergebnisse für '" + suchtext + "'");
			request.getRequestDispatcher("/displayFahrzeuge.jsp").forward(request, response);
		}

	}

}
