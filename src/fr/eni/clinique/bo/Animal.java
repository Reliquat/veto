package fr.eni.clinique.bo;

public class Animal {
	private int codeAnimal;
	private String nomAnimal;
	private String sexe;
	private String couleur;
	private Race race;
	private String tatouage;
	private String antecedents;
	private boolean archive;
	
	public Animal() {
		super();
	}
	public Animal(int codeAnimal, String nomAnimal, String sexe, String couleur, Race race, String espece,
			String tatouage, String antecedents, boolean archive) {
		super();
		this.codeAnimal = codeAnimal;
		this.nomAnimal = nomAnimal;
		this.sexe = sexe;
		this.couleur = couleur;
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
		return "Animal [codeAnimal=" + codeAnimal + ", nomAnimal=" + nomAnimal + ", sexe=" + sexe + ", couleur="
				+ couleur + ", race=" + race + ", tatouage=" + tatouage + ", antecedents=" + antecedents + ", archive="
				+ archive + "]";
	}
}
