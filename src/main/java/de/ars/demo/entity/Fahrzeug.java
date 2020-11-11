package de.ars.demo.entity;

import java.io.Serializable;

public class Fahrzeug implements Serializable {

	/*
	 * Reihenfolge der Injections
	 *  1. Hersteller (C)
	 *  2. Motor (F)
	 *  3. Reifen (M)
	 */
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String hersteller;
	private int baujahr;
	//private Motor motor; // Field Injection
	
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
