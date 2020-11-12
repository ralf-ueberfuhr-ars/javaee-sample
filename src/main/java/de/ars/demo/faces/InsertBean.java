package de.ars.demo.faces;

import java.util.Comparator;
import java.util.Optional;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import de.ars.demo.control.Fahrzeugbestand;
import de.ars.demo.entity.Fahrzeug;

@RequestScoped
@Named("insertBean")
public class InsertBean {

	@Inject
	Fahrzeug fahrzeug;
	@Inject
	Fahrzeugbestand bestand;
	
	public String insert() { // Bean Validation automatisch
		// ID setzen
		Optional<Integer> max = bestand.getFahrzeuge().stream().map(Fahrzeug::getId).max(Comparator.naturalOrder());
		// Kopie erstellen, da CDI Managed Bean Proxy -> bei Validierung in Interceptor gibt es Probleme
		Fahrzeug newF = new Fahrzeug(max.orElse(0) + 1, fahrzeug.getHersteller(), fahrzeug.getBaujahr());
		bestand.add(newF);
		return "anzeige";
	}
	
	
}
