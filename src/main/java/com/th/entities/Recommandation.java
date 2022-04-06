package com.th.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Recommandation  implements Serializable{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
private String titre;
private String texte;
private String date;
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getTitre() {
	return titre;
}
public void setTitre(String titre) {
	this.titre = titre;
}
public String getTexte() {
	return texte;
}
public void setTexte(String texte) {
	this.texte = texte;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public Recommandation() {
	super();
	// TODO Auto-generated constructor stub
}
public Recommandation(String titre, String texte, String date) {
	super();
	this.titre = titre;
	this.texte = texte;
	this.date = date;
}

}
