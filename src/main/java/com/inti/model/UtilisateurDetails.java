package com.inti.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table
public class UtilisateurDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String adresse;
	private String ville;
	private int cp;
	private String tel;
	private String email;
	
	@OneToOne(mappedBy = "utilisateurDetails")
	private Utilisateur utilisateur;
	
	public UtilisateurDetails() {
		super();
	}

	

	public UtilisateurDetails(String adresse, String ville, int cp, String tel, String email) {
		super();
		this.adresse = adresse;
		this.ville = ville;
		this.cp = cp;
		this.tel = tel;
		this.email = email;
	}



	public UtilisateurDetails(int id, String adresse, String ville, int cp, String tel, String email) {
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

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
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

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	@Override
	public String toString() {
		return "UtilisateurDetails [id=" + id + ", adresse=" + adresse + ", cp=" + cp + ", tel=" + tel + ", email="
				+ email + "]";
	}
	

}
