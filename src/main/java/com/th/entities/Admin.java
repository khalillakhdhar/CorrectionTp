package com.th.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;

@Entity
public class Admin implements Serializable {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Email
@Id
private String email;
private String password;
private String nomcomplet;
private int active;
private String adresse;
private String telephone;
@ManyToMany(fetch = FetchType.EAGER)
private Collection<Role> roles= new ArrayList<Role>();


public Admin() {
	super();
	// TODO Auto-generated constructor stub
}
public Admin(@Email String email, String password, String nomcomplet, int active, String adresse,
		String telephone, Collection<Role> roles) {
	super();
	this.email = email;
	this.password = password;
	this.nomcomplet = nomcomplet;
	this.active = active;
	this.adresse = adresse;
	this.telephone = telephone;
	this.roles = roles;
}
public String getNomcomplet() {
	return nomcomplet;
}
public void setNomcomplet(String nomcomplet) {
	this.nomcomplet = nomcomplet;
}

public String getAdresse() {
	return adresse;
}
public void setAdresse(String adresse) {
	this.adresse = adresse;
}
public String getTelephone() {
	return telephone;
}
public void setTelephone(String telephone) {
	this.telephone = telephone;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

public int getActive() {
	return active;
}
public void setActive(int active) {
	this.active = active;
}
public Collection<Role> getRoles() {
	return roles;
}
public void setRoles(Collection<Role> roles) {
	this.roles = roles;
}
@Override
public String toString() {
	return "Admin [email=" + email + ", password=" + password + ", nomcomplet=" + nomcomplet + ", active=" + active
			+ ", adresse=" + adresse + ", telephone=" + telephone + ", roles=" + roles + "]";
}


	




	
}
