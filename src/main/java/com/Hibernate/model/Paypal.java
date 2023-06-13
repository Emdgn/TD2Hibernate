package com.Hibernate.model;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table
//@DiscriminatorValue("1")
@PrimaryKeyJoinColumn(name = "idPaiement")

public class Paypal extends Paiement {
	
	private int numeroCompte;
	

	public Paypal() {
		super();
	}


	public Paypal(int numeroCompte) {
		super();
		this.numeroCompte = numeroCompte;
	}


	public Paypal(double d, LocalDate date, int numeroCompte) {
		super(d, date);
		this.numeroCompte = numeroCompte;
	}
	
	


	public Paypal(int idPaiement, float montant, LocalDate date, int numeroCompte) {
		super(idPaiement, montant, date);
		this.numeroCompte = numeroCompte;
	}


	public int getNumeroCompte() {
		return numeroCompte;
	}


	public void setNumeroCompte(int numeroCompte) {
		this.numeroCompte = numeroCompte;
	}
	
	
	

}
