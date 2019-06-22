package com.cours.ebenus.maven.ebenus.front.office.web.model;

import java.util.ArrayList;
import java.util.List;

import com.cours.ebenus.entities.Produit;

public class modelProduct {
public List<Produit> produits = new ArrayList<Produit>();
public Produit produit;


public Produit getProduit() {
	return produit;
}

public void setProduit(Produit produit) {
	this.produit = produit;
}

public List<Produit> getProduits() {
	return produits;
}

public void setProduits(List<Produit> produits) {
	this.produits = produits;
}

}
