package com.cours.ebenus.maven.ebenus.front.office.web.model;

import java.util.List;

import com.cours.ebenus.entities.Adresse;
import com.cours.ebenus.entities.Utilisateur;
import com.cours.ebenus.service.ServiceFacade;

public class ModelUserData {
public Utilisateur user;
public List<Adresse> adresseLivraison;
public Adresse principalAdresse;
public Adresse adresseFacturation;
private ServiceFacade serviceFacade;
public Utilisateur getUser() {
	return user;
}
public List<Adresse> getAdresseLivraison() {
	return adresseLivraison;
}
public void setAdresseLivraison(List<Adresse> adresseLivraison) {
	this.adresseLivraison = adresseLivraison;
}
public Adresse getAdresseFacturation() {
	return adresseFacturation;
}
public void setAdresseFacturation(Adresse adresseFacturation) {
	this.adresseFacturation = adresseFacturation;
}
public void setUser(Utilisateur user) {
	this.user = user;
}

public Adresse getPrincipalAdresse(int idUtilisateur) {
	return serviceFacade.getAdresseDao().findAdressesLPByIdUtilisateur(idUtilisateur);
}

public Adresse getAdresseFacturation(int idUtilisateur) {
	return serviceFacade.getAdresseDao().findAdressesFByIdUtilisateur(idUtilisateur);
}
public Adresse getPrincipalAdresse() {
	return principalAdresse;
}
public List<Adresse> getAdresseLivraison(int idUtilisateur) {
	return serviceFacade.getAdresseDao().findAdressesLByIdUtilisateur(idUtilisateur);
}
public void setPrincipalAdresse(Adresse principalAdresse) {
	this.principalAdresse = principalAdresse;
}

}
