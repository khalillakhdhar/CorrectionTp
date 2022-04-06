package com.th.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
@Entity
public class Participant implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
private String nom,prenom;
@Column(unique = true)
@Email 
private String email;
private String telephone;
private int age;

@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
@JoinColumn(name = "id_sortie", referencedColumnName = "id")
Sortie sortie;

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}

public String getPrenom() {
	return prenom;
}

public void setPrenom(String prenom) {
	this.prenom = prenom;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getTelephone() {
	return telephone;
}

public void setTelephone(String telephone) {
	this.telephone = telephone;
}

public int getAge() {
	return age;
}

public void setAge(int age) {
	this.age = age;
}

public Sortie getSortie() {
	return sortie;
}

public void setSortie(Sortie sortie) {
	this.sortie = sortie;
}

public Participant(String nom, String prenom, @Email String email, String telephone, int age, Sortie sortie) {
	super();
	this.nom = nom;
	this.prenom = prenom;
	this.email = email;
	this.telephone = telephone;
	this.age = age;
	this.sortie = sortie;
}

public Participant() {
	super();
}










}
