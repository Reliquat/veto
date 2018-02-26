package fr.eni.clinique.bo;

import java.util.Date;

public class Agenda {
	private Date dateRdv;
	private Animal animal;
	
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
}
