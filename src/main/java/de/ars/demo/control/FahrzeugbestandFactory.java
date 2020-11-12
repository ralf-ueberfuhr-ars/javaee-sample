package de.ars.demo.control;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.New;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import de.ars.demo.entity.Fahrzeug;

@ApplicationScoped
public class FahrzeugbestandFactory {

	@Produces
	@ApplicationScoped
	@Named("bestand") // in Facelet verwendbar wird
	public Fahrzeugbestand createSamples(@New Fahrzeugbestand bestand) {
		bestand.add(new Fahrzeug(1, "Ford", 2010));
		bestand.add(new Fahrzeug(2, "Opel", 2018));
		bestand.add(new Fahrzeug(3, "VW", 2015));
		bestand.add(new Fahrzeug(4, "Renault", 1999));
		return bestand;
	}

}
