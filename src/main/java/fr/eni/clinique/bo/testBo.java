package fr.eni.clinique.bo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class testBo {

	public static void main(String[] args) {
		
		Animal animal = new Animal();
		animal.setCodeAnimal(50);
		animal.setNomAnimal("Squiky");
		animal.setSexe("M");
		animal.setRace("oiseau");
		animal.setEspece("pinšon");
		animal.setCouleur("Fushia");
		animal.setTatouage("123A456");
		animal.setAntecedents("Chiant");
		animal.setArchive(false);
		
		Agenda rdv = new Agenda(new Timestamp(Calendar.LONG), animal);
		ArrayList<Agenda> agenda = new ArrayList<Agenda>();
		agenda.add(rdv);
		
		ArrayList<Animal> nanimaux = new ArrayList<>();
		nanimaux.add(animal);
		
		Personnel personnel = new Personnel();
		personnel.setCodePers(28);
		personnel.setNom("Jean Eude");
		personnel.setMotPasse("J'ai un nom de merde");
		personnel.setRole("Sous-fifre");
		personnel.setArchive(false);
		personnel.setAgenda(agenda);
		
		Client client = new Client();
		
		client.setCodeClient(666);
		client.setNomClient("test");
		client.setAdresse1("Lituanie");
		client.setAdresse1("Europe");
		client.setCodePostal("24589");
		client.setVille("Kaunas");
		client.setAssurance("toutatÚriskes");
		client.setEmail("cliente@test.li");
		client.setRemarque("remarque de test");
		client.setArchive(false);
		client.setAnimaux(nanimaux);
		
		nanimaux.get(0).setClient(client);
		
		System.out.println(client);
		System.out.println(nanimaux);
		System.out.println(rdv);
		System.out.println(personnel);
	}

}
