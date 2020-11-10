package de.ars.demo.control;

import java.util.Collection;
import java.util.LinkedList;

import de.ars.demo.entity.Fahrzeug;

public class Fahrzeugbestand {

	private static final Fahrzeugbestand theInstance = new Fahrzeugbestand();

	private final Collection<Fahrzeug> fahrzeuge = new LinkedList<>();

	// nur 1 Bestand in der Anwendung -> Singleton

	private Fahrzeugbestand() {
		fahrzeuge.add(new Fahrzeug("Ford<b>test</b>", 2010));
		fahrzeuge.add(new Fahrzeug("Opel", 2018));
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

	public static Fahrzeugbestand getInstance() {
		return theInstance;
	}

}
