package fr.eni.clinique.bo;

import java.util.Date;

public class Agenda {
	private Date dateRdv;
	private Animal animal;
	
	public Agenda() {
		super();
	}

	public Agenda(Date dateRdv, Animal animal) {
		super();
		this.dateRdv = dateRdv;
		this.animal = animal;
	}
	
	public Date getDateRdv() {
		return dateRdv;
	}
	public void setDateRdv(Date dateRdv) {
		this.dateRdv = dateRdv;
	}
	public Animal getCodeAnimal() {
		return animal;
	}
	public void setCodeAnimal(Animal animal) {
		this.animal = animal;
	}

	@Override
	public String toString() {
		return "Agenda [dateRdv=" + dateRdv + ", animal=" + animal + "]";
	}
}
