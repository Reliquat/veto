package fr.eni.clinique.bo;

import java.sql.Timestamp;
import java.sql.Date;

public class Agenda {
	private Timestamp dateRdv;
	private Animal animal;
	
	public Agenda() {
		super();
	}

	public Agenda(Timestamp dateRdv, Animal animal) {
		super();
		this.dateRdv = dateRdv;
		Date.valueOf(dateRdv);
		Timestamp.
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
