package de.ars.demo.entity;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@RequestScoped
@Named("eingabeFahrzeug")
public class Fahrzeug implements Serializable {

	/*
	 * Reihenfolge der Injections
	 *  1. Hersteller (C)
	 *  2. Motor (F)
	 *  3. Reifen (M)
	 */
	
	private static final long serialVersionUID = 1L;

	@Min(1)
	private int id;
	@Size(min = 2)
	@NotNull
	@Pattern(regexp = "[A-Z].*")
	private String hersteller;
	@Min(1900)
	private int baujahr;
	//private Motor motor; // Field Injection
	
	public Fahrzeug() {
		
	}
	
	public Fahrzeug(int id, String hersteller, int baujahr) { // Constructor Injection
		super();
		this.id = id;
		this.hersteller = hersteller;
		this.baujahr = baujahr;
	}
	
	public void fahre(Reifen reifen) { // Method Injection
		
	}
	
	public String getHersteller() {
		return hersteller;
	}
	public void setHersteller(String hersteller) {
		this.hersteller = hersteller;
	}
	public int getBaujahr() {
		return baujahr;
	}
	public void setBaujahr(int baujahr) {
		this.baujahr = baujahr;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
