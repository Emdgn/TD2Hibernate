package com.Hibernate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table //On demande à générer la table 

public class UtilisateurDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String adresse;
	private String ville;
	private int cp;
	private long tel;
	private String email;
	
	@OneToOne(mappedBy = "utilisateurDetails")
	@JoinColumn(name = "idUtilisateur") //Si on précise pas un nom nous même, il en génèrera un lui même
	private Utilisateur utilisateur;
	
	
	public UtilisateurDetails() {
		super();
	}


	public UtilisateurDetails(String adresse, String ville, int cp, long tel, String email) {
		super();
		this.adresse = adresse;
		this.ville = ville;
		this.cp = cp;
		this.tel = tel;
		this.email = email;
	}


	public UtilisateurDetails(int id, String adresse, String ville, int cp, long tel, String email) {
		super();
		this.id = id;
		this.adresse = adresse;
		this.ville = ville;
		this.cp = cp;
		this.tel = tel;
		this.email = email;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getVille() {
		return ville;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}


	public int getCp() {
		return cp;
	}


	public void setCp(int cp) {
		this.cp = cp;
	}


	public long getTel() {
		return tel;
	}


	public void setTel(long tel) {
		this.tel = tel;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Utilisateur getUtilisateur() {
		return utilisateur;
	}


	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}


	@Override
	public String toString() {
		return "UtilisateurDetails [id=" + id + ", adresse=" + adresse + ", ville=" + ville + ", cp=" + cp + ", tel="
				+ tel + ", email=" + email + "]";
	}
	
	
	
	
	
	

}
