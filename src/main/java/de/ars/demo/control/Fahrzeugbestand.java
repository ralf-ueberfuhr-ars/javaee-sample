package de.ars.demo.control;

import java.util.Collection;
import java.util.LinkedList;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

import de.ars.demo.entity.Fahrzeug;

@ApplicationScoped
public class Fahrzeugbestand {

	private final Collection<Fahrzeug> fahrzeuge = new LinkedList<>();

	// nur 1 Bestand in der Anwendung -> Singleton
	
	@PostConstruct
	public void init() {
		fahrzeuge.add(new Fahrzeug(1, "Ford", 2010));
		fahrzeuge.add(new Fahrzeug(2, "Opel", 2018));
		fahrzeuge.add(new Fahrzeug(3, "VW", 2015));
		fahrzeuge.add(new Fahrzeug(4, "Renault", 1999));
	}

	public Collection<Fahrzeug> getFahrzeuge() {
		return fahrzeuge;
	}

	public boolean add(Fahrzeug e) {
		return fahrzeuge.add(e);
	}

	public boolean remove(Fahrzeug o) {
		return fahrzeuge.remove(o);
	}

}
