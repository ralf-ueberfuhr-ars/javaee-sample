package de.ars.demo.control;

import java.util.Collection;
import java.util.LinkedList;

import javax.enterprise.context.ApplicationScoped;

import de.ars.demo.entity.Fahrzeug;

@ApplicationScoped
public class Fahrzeugbestand {

	private final Collection<Fahrzeug> fahrzeuge = new LinkedList<>();

	// nur 1 Bestand in der Anwendung -> Singleton

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
