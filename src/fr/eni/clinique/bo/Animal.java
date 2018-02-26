package fr.eni.clinique.bo;

public class Animal {
	private int codeAnimal;
	private String nomAnimal;
	private String sexe;
	private String couleur;
	private Race race;
	private String espece;
	private String tatouage;
	private String Antecedents;
	private boolean archive;
	
	public int getCodeAnimal() {
		return codeAnimal;
	}
	public void setCodeAnimal(int codeAnimal) {
		this.codeAnimal = codeAnimal;
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
	public Race getRace() {
		return race;
	}
	public void setRace(Race race) {
		this.race = race;
	}
	public String getEspece() {
		return espece;
	}
	public void setEspece(String espece) {
		this.espece = espece;
	}
	public String getTatouage() {
		return tatouage;
	}
	public void setTatouage(String tatouage) {
		this.tatouage = tatouage;
	}
	public String getAntecedents() {
		return Antecedents;
	}
	public void setAntecedents(String antecedents) {
		Antecedents = antecedents;
	}
	public boolean isArchive() {
		return archive;
	}
	public void setArchive(boolean archive) {
		this.archive = archive;
	}
}
