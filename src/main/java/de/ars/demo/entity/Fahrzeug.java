package de.ars.demo.entity;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@SuppressWarnings("deprecation")
@RequestScoped
@ManagedBean(name = "eingabeFahrzeug")
public class Fahrzeug {

	@Min(1)
	private int id;
	@Size(min = 2)
	@NotNull
	@Pattern(regexp = "[A-Z].*")
	private String hersteller;
	@Min(1900)
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
