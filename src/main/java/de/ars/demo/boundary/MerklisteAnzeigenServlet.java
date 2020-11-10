package de.ars.demo.boundary;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import de.ars.demo.entity.Fahrzeug;

@WebServlet("/merkliste")
public class MerklisteAnzeigenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Logik, z.B. DB-Zugriff o.Ä.

		Collection<Fahrzeug> merkliste = null;

		HttpSession session = request.getSession(false); // nicht anlegen, falls nicht vorhanden
		if (null != session) {
			merkliste = (Collection<Fahrzeug>) session.getAttribute("merkliste");
		}

		request.setAttribute("fz", merkliste); // null ist okay
		request.setAttribute("pageTitle", "Merkliste");
		request.setAttribute("merkenFormDisabled", true);
		request.getRequestDispatcher("/displayFahrzeuge.jsp").forward(request, response);

	}

}
