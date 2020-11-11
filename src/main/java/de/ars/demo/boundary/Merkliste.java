package de.ars.demo.boundary;

import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.TreeSet;

import javax.enterprise.context.SessionScoped;

import de.ars.demo.entity.Fahrzeug;

@SessionScoped
public class Merkliste implements Serializable {

	private static final long serialVersionUID = 1L;

	private final Collection<Fahrzeug> fahrzeuge = new TreeSet<>(Comparator.comparing(Fahrzeug::getId));

	public Collection<Fahrzeug> getFahrzeuge() {
		return fahrzeuge;
	}
	
}
