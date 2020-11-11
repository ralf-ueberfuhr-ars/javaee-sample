package de.ars.demo.control;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import de.ars.demo.entity.Fahrzeug;

@WebListener
public class FahrzeugbestandInitializer implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {

		// Application Scope
		ServletContext sc = sce.getServletContext();
		Fahrzeugbestand bestand = new Fahrzeugbestand();
		// Beispieldaten
		bestand.add(new Fahrzeug(1, "Ford", 2010));
		bestand.add(new Fahrzeug(2, "Opel", 2018));
		bestand.add(new Fahrzeug(3, "VW", 2015));

		sc.setAttribute("fahrzeuge", bestand);
				
		System.out.println("Fahrzeugbestand initialisiert");
	}

}
