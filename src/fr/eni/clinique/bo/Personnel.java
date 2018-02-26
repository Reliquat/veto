package fr.eni.clinique.bo;

import java.util.ArrayList;

public class Personnel {
	private int codePers;
	private String nom;
	private String motPasse;
	private String role;
	private boolean archive;
	private ArrayList<Agenda> rdv;
	
	public int getCodePers() {
		return codePers;
	}
	public void setCodePers(int codePers) {
		this.codePers = codePers;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getMotPasse() {
		return motPasse;
	}
	public void setMotPasse(String motPasse) {
		this.motPasse = motPasse;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isArchive() {
		return archive;
	}
	public void setArchive(boolean archive) {
		this.archive = archive;
	}
	public ArrayList<Agenda> getRdv() {
		return rdv;
	}
	public void setAgenda(ArrayList<Agenda> agenda) {
		this.rdv = agenda;
	}
}
