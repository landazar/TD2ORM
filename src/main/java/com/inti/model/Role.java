package com.inti.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRole;
	private String nomRole;
	
	@ManyToMany
	@JoinTable(name = "utilisateur_role",
				joinColumns = @JoinColumn(name = "idRole"),
				inverseJoinColumns = @JoinColumn(name = "IdUtilisateur"))
	private List<Utilisateur> listeUtilisateur;
	
	public Role() {
		super();
	}

	public Role(String nomRole) {
		super();
		this.nomRole = nomRole;
	}

	public Role(int idRole, String nomRole) {
		super();
		this.idRole = idRole;
		this.nomRole = nomRole;
	}

	public int getIdRole() {
		return idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	public String getNomRole() {
		return nomRole;
	}

	public void setNomRole(String nomRole) {
		this.nomRole = nomRole;
	}

	public List<Utilisateur> getListeUtilisateur() {
		return listeUtilisateur;
	}

	public void setListeUtilisateur(List<Utilisateur> listeUtilisateur) {
		this.listeUtilisateur = listeUtilisateur;
	}

	@Override
	public String toString() {
		return "Role [idRole=" + idRole + ", nomRole=" + nomRole + "]";
	}
	
	

}
