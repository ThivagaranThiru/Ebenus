package com.cours.ebenus.dao;

import java.util.List;

import com.cours.ebenus.entities.Produit;

public interface IProduitDao {
	
    public List<Produit> findAllProduits();
	
    public Produit findProduitById(int idProduit);
	
    public List<Produit> findProduitByReference(String reference);
	
    public List<Produit> findProduitsByPrix(Double prix);
	
    public List<Produit> findProduitsByNom(String nom);
	
    public Produit createProduit(Produit produit);
	
    public Produit updateProduit(Produit produit);
	
    public boolean deleteProduit(Produit produit);

}
