package com.Hibernate.model;

import java.time.LocalDate;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table
@Inheritance(strategy = InheritanceType.JOINED) //Seulement sur la classe mère pour indiquer l'héritage
//@DiscriminatorColumn(name = "discriminator", discriminatorType = DiscriminatorType.INTEGER)
//@DiscriminatorValue("0")

public class Paiement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int idPaiement;
	protected double montant;
	protected LocalDate date;
	
	
	public Paiement() {
		super();
	}


	public Paiement(double d, LocalDate date) {
		super();
		this.montant = d;
		this.date = date;
	}


	public Paiement(int idPaiement, float montant, LocalDate date) {
		super();
		this.idPaiement = idPaiement;
		this.montant = montant;
		this.date = date;
	}


	public int getIdPaiement() {
		return idPaiement;
	}


	public void setIdPaiement(int idPaiement) {
		this.idPaiement = idPaiement;
	}


	public double getMontant() {
		return montant;
	}


	public void setMontant(float montant) {
		this.montant = montant;
	}


	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	@Override
	public String toString() {
		return "Paiement [idPaiement=" + idPaiement + ", montant=" + montant + ", date=" + date + "]";
	}
	
	
	
}
