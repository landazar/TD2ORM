package com.inti.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table
public class Utilisateur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUtilisateur;
	private String login;
	private String mdp;
	
	
	@OneToOne (cascade = CascadeType.ALL)
	@JoinColumn(name = "idUD")
	private UtilisateurDetails utilisateurDetails;
	
	@OneToMany(mappedBy = "utilisateur")
	private List<Commande> listeCommande;
	
	
	@ManyToMany
	@JoinTable(name = "utilisateur_role",
				joinColumns = @JoinColumn(name = "idUtilisateur"),
				inverseJoinColumns = @JoinColumn(name = "IdRole"))
	private List<Role> listeRole;
	
	public Utilisateur() {
		super();
	}

	public Utilisateur(String login, String mdp) {
		super();
		this.login = login;
		this.mdp = mdp;
	}

	public Utilisateur(int idUtilisateur, String login, String mdp) {
		super();
		this.idUtilisateur = idUtilisateur;
		this.login = login;
		this.mdp = mdp;
	}

	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public UtilisateurDetails getUtilisateurDetails() {
		return utilisateurDetails;
	}

	public void setUtilisateurDetails(UtilisateurDetails utilisateurDetails) {
		this.utilisateurDetails = utilisateurDetails;
	}

	public List<Commande> getListeCommande() {
		return listeCommande;
	}

	public void setListeCommande(List<Commande> listeCommande) {
		this.listeCommande = listeCommande;
	}

	public List<Role> getListeRole() {
		return listeRole;
	}

	public void setListeRole(List<Role> listeRole) {
		this.listeRole = listeRole;
	}

	@Override
	public String toString() {
		return "Utilisateur [idUtilisateur=" + idUtilisateur + ", login=" + login + ", mdp=" + mdp + "]";
	}
	
	
}
