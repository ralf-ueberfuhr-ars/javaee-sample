package de.ars.demo.boundary;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import de.ars.demo.control.Fahrzeugbestand;
import de.ars.demo.entity.Fahrzeug;

@WebServlet("/merken")
public class MerkenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String[] ids = request.getParameterValues("id");
		if(null != ids && ids.length>0) {
			
			HttpSession session = request.getSession();
			Collection<Fahrzeug> merkliste;
			synchronized (session) { // parallele Zugriffe auf dieselbe Session -> Thread Safety
				merkliste = (Collection<Fahrzeug>) session.getAttribute("merkliste");
				if(null == merkliste) {
					merkliste = new TreeSet<>(Comparator.comparing(Fahrzeug::getId)); // keine Duplikate, Sortierung nach ID
					session.setAttribute("merkliste", merkliste);
				}
			}
			// ID-Parameter als Integer
			Set<Integer> idSet = Arrays.stream(ids).map(Integer::valueOf).collect(Collectors.toSet());
			Fahrzeugbestand bestand = (Fahrzeugbestand) getServletContext().getAttribute("bestand");
			// alles aus bestand, dessen ID in idSet (=Parameter) zu finden ist, wird in die Merkliste gepackt.
			bestand.getFahrzeuge().stream().filter(f -> idSet.contains(f.getId())).forEach(merkliste::add);
		}
		
		// Anzeige der Merkliste
		response.sendRedirect("merkliste");
		
	}

}
