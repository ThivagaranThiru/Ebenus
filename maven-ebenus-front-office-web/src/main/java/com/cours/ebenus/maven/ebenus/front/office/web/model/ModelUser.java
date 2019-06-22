package com.cours.ebenus.maven.ebenus.front.office.web.model;

import java.util.ArrayList;
import java.util.List;

import com.cours.ebenus.entities.Utilisateur;

public class ModelUser {
public Utilisateur user;
public List<String> monCompte = new ArrayList<String>();
public Utilisateur getUser() {
	return user;
}
public void setUser(Utilisateur user) {
	this.user = user;
}
public List<String> getMonCompte() {
	return monCompte;
}
public void setMonCompte(List<String> monCompte) {
	this.monCompte = monCompte;
}
}
