package de.ars.demo.entity;

public class Fahrzeug {

	private String hersteller;
	private int baujahr;
	
	public Fahrzeug() {
		super();
	}

	public Fahrzeug(String hersteller, int baujahr) {
		super();
		this.hersteller = hersteller;
		this.baujahr = baujahr;
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
	
}
