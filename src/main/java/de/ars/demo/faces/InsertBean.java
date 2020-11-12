package de.ars.demo.faces;

import java.util.Comparator;
import java.util.Optional;

import javax.faces.annotation.ManagedProperty;

import de.ars.demo.control.Fahrzeugbestand;
import de.ars.demo.entity.Fahrzeug;

public class InsertBean {

	@ManagedProperty("#{eingabeFahrzeug}")
	Fahrzeug fahrzeug;
	@ManagedProperty("#{fahrzeuge}")
	Fahrzeugbestand bestand;
	
	public String insert() {
		// ID setzen
		Optional<Integer> max = bestand.getFahrzeuge().stream().map(Fahrzeug::getId).max(Comparator.naturalOrder());
		fahrzeug.setId(max.orElse(0) + 1);
		bestand.add(fahrzeug);
		return "anzeige";
	}
	
	
}
