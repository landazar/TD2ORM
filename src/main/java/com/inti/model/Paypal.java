package com.inti.model;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

//@Entity
//@DiscriminatorValue("1")
@Entity
@Table
@PrimaryKeyJoinColumn( name = "idPaiement" )
public class Paypal extends Paiement {
	
	private int numeroCompte;

	public Paypal() {
		super();
	}

	public Paypal(double montant, LocalDate date, int numeroCompte) {
		super(montant, date);
		this.numeroCompte = numeroCompte;
	}

	public Paypal(int idPaiement, double montant, LocalDate date, int numeroCompte) {
		super(idPaiement, montant, date);
		this.numeroCompte = numeroCompte;
	}

	public int getNumeroCompte() {
		return numeroCompte;
	}

	public void setNumeroCompte(int numeroCompte) {
		this.numeroCompte = numeroCompte;
	}

	@Override
	public String toString() {
		return "Paypal [numeroCompte=" + numeroCompte + ", idPaiement=" + idPaiement + ", montant=" + montant
				+ ", date=" + date + "]";
	}

	
	
	

}
