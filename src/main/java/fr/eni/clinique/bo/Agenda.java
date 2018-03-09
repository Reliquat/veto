package fr.eni.clinique.bo;

import java.sql.Timestamp;
<<<<<<< HEAD
import java.sql.Date;
=======
import java.util.Date;
>>>>>>> branch 'master' of https://github.com/Reliquat/veto.git

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
	
	public Timestamp getDateRdv() {
		return dateRdv;
	}
	public void setDateRdv(Timestamp dateRdv) {
		this.dateRdv = dateRdv;
	}
	public Animal getAnimal() {
		return animal;
	}
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	@Override
	public String toString() {
		return "Agenda [dateRdv=" + dateRdv + ", animal=" + animal + "]";
	}
}
