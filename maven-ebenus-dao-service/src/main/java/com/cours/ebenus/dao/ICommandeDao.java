package com.cours.ebenus.dao;

import java.util.List;

import com.cours.ebenus.entities.Commande;

public interface ICommandeDao {
	
    public List<Commande> findAllCommandes();
	
    public Commande findCommandeById(int idCommande);
	
    public List<Commande> findCommandesByIdAdresse(int idAdresse);
	
    public List<Commande> findCommandesByIdUtilisateur(int idUtilisateur);
	
    public Commande createCommande(Commande commande);
	
    public Commande updateCommande(Commande commande);
	
    public boolean deleteCommande(Commande commande);

}
