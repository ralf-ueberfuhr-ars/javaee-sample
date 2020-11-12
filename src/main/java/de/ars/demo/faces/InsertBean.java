package de.ars.demo.faces;

import java.util.Comparator;
import java.util.Optional;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import de.ars.demo.control.Fahrzeugbestand;
import de.ars.demo.entity.Fahrzeug;

@SuppressWarnings("deprecation")
@RequestScoped
@ManagedBean(name = "insertBean")
public class InsertBean {

	@ManagedProperty("#{eingabeFahrzeug}")
	private	Fahrzeug fahrzeug;
	@ManagedProperty("#{bestand}")
	private	Fahrzeugbestand bestand;

	public String insert() {
		// ID setzen
		Optional<Integer> max = bestand.getFahrzeuge().stream().map(Fahrzeug::getId).max(Comparator.naturalOrder());
		fahrzeug.setId(max.orElse(0) + 1);
		bestand.add(fahrzeug);
		return "anzeige";
	}

	// Setter notwendig für Injection durch JSF
	
	public void setFahrzeug(Fahrzeug fahrzeug) {
		this.fahrzeug = fahrzeug;
	}

	public void setBestand(Fahrzeugbestand bestand) {
		this.bestand = bestand;
	}

}
