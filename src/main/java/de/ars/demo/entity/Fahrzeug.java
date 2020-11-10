package de.ars.demo.entity;

public class Fahrzeug {

	private int id;
	private String hersteller;
	private int baujahr;
	
	public Fahrzeug() {
		super();
	}

	public Fahrzeug(int id, String hersteller, int baujahr) {
		super();
		this.id = id;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
