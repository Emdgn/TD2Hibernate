package com.Hibernate.model;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
/**
 * Classe pour le paiement en CB
 * @author ME
 *
 */

@Entity
//@DiscriminatorValue("2")
@Table
@PrimaryKeyJoinColumn(name = "idPaiement")


public class CB extends Paiement {
	
	private long numeroCarte;
	private LocalDate dateExpiration;
	
	
	public CB() {
		super();
	}


	public CB(long numeroCarte, LocalDate dateExpiration) {
		super();
		this.numeroCarte = numeroCarte;
		this.dateExpiration = dateExpiration;
	}
	


	public CB(double d, LocalDate date, long numeroCarte, LocalDate dateExpiration) {
		super(d, date);
		this.numeroCarte = numeroCarte;
		this.dateExpiration = dateExpiration;
	}

	

	public CB(int idPaiement, float montant, LocalDate date, long numeroCarte, LocalDate dateExpiration) {
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
	
	

}
