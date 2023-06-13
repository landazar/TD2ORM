package com.inti.model;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

//@Entity
//@DiscriminatorValue("2")
@Entity
@Table
@PrimaryKeyJoinColumn( name = "idPaiement" )
public class CB extends Paiement{

	private long numeroCarte;
	private LocalDate dateExpiration;
	public CB() {
		super();
	}
	public CB(double montant, LocalDate date, long numeroCarte, LocalDate dateExpiration) {
		super(montant, date);
		this.numeroCarte = numeroCarte;
		this.dateExpiration = dateExpiration;
	}
	public CB(int idPaiement, double montant, LocalDate date, long numeroCarte, LocalDate dateExpiration) {
		super(idPaiement, montant, date);
		this.numeroCarte = numeroCarte;
		this.dateExpiration = dateExpiration;
	}
	public long getNumeroCarte() {
		return numeroCarte;
	}
	public void setNumeroCarte(long numeroCarte) {
		this.numeroCarte = numeroCarte;
	}
	public LocalDate getDateExpiration() {
		return dateExpiration;
	}
	public void setDateExpiration(LocalDate dateExpiration) {
		this.dateExpiration = dateExpiration;
	}
	@Override
	public String toString() {
		return "CB [numeroCarte=" + numeroCarte + ", dateExpiration=" + dateExpiration + ", idPaiement=" + idPaiement
				+ ", montant=" + montant + ", date=" + date + "]";
	}
	
	
	
	
}
