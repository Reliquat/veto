package fr.eni.clinique.bo;

import java.util.ArrayList;
import java.util.List;

public class Personnel {
	private int codePers;
	private String nom;
	private String motPasse;
	private String role;
	private boolean archive;
	private List<Agenda> rdv;
	
	public Personnel() {
		super();
	}
	public Personnel(int codePers, String nom, String motPasse, String role, boolean archive, ArrayList<Agenda> rdv) {
		super();
		this.codePers = codePers;
		this.nom = nom;
		this.motPasse = motPasse;
		this.role = role;
		this.archive = archive;
		this.rdv = rdv;
	}
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
	public List<Agenda> getRdv() {
		return rdv;
	}
	public void setAgenda(List<Agenda> list) {
		this.rdv = list;
	}
	@Override
	public String toString() {
		return "Personnel [codePers=" + codePers + ", nom=" + nom + ", motPasse=" + motPasse + ", role=" + role
				+ ", archive=" + archive + ", rdv=" + rdv + "]";
	}
}
