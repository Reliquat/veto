package fr.eni.clinique.bo;

public class Animal {
	private int codeAnimal;
	private Client client;
	private String nomAnimal;
	private String sexe;
	private String couleur;
	private String espece;
	private String race;
	private String tatouage;
	private String antecedents;
	private boolean archive;
	
	public Animal() {
		super();
	}
	public Animal(int codeAnimal, Client client, String nomAnimal, String sexe, String couleur, String espece, String race,
			String tatouage, String antecedents, boolean archive) {
		super();
		this.codeAnimal = codeAnimal;
		this.client = client;
		this.nomAnimal = nomAnimal;
		this.sexe = sexe;
		this.couleur = couleur;
		this.espece = espece;
		this.race = race;
		this.tatouage = tatouage;
		this.antecedents = antecedents;
		this.archive = archive;
	}
	public int getCodeAnimal() {
		return codeAnimal;
	}
	public void setCodeAnimal(int codeAnimal) {
		this.codeAnimal = codeAnimal;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public String getNomAnimal() {
		return nomAnimal;
	}
	public void setNomAnimal(String nomAnimal) {
		this.nomAnimal = nomAnimal;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	public String getEspece() {
		return espece;
	}
	public void setEspece(String espece) {
		this.espece = espece;
	}
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public String getTatouage() {
		return tatouage;
	}
	public void setTatouage(String tatouage) {
		this.tatouage = tatouage;
	}
	public String getAntecedents() {
		return antecedents;
	}
	public void setAntecedents(String antecedents) {
		this.antecedents = antecedents;
	}
	public boolean isArchive() {
		return archive;
	}
	public void setArchive(boolean archive) {
		this.archive = archive;
	}
	
	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("Animal [codeAnimal=")
		       .append(codeAnimal)
		       .append(", client=")
		   	   .append(client)
			   .append(", nomAnimal=")
			   .append(nomAnimal)
			   .append(", sexe=")
			   .append(sexe)
			   .append(", couleur=")
			   .append(couleur)
			   .append(", espece=")
			   .append(espece)
			   .append(", race=")
			   .append(race)
			   .append(", tatouage=")
			   .append(tatouage)
			   .append(", antecedents=")
			   .append(antecedents)
			   .append(", archive=")
			   .append(archive)
			   .append("]");
		
		return builder.toString();
	}
}
