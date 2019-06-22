package com.cours.ebenus.dao;

import java.util.List;

import com.cours.ebenus.entities.Adresse;

public interface IAdresseDao {
	
    public List<Adresse> findAllAdresses();
	
    public Adresse findAdresseById(int idAdresse);
	
    public List<Adresse> findAdressesByVille(String ville);
	
    public List<Adresse> findAdressesByPays(String pays);
	
    public List<Adresse> findAdressesByIdUtilisateur(int idUtilisateur);
	
    public List<Adresse> findAdressesByIdentifiantUtilisateur(String identifiantUtilisateur);
        
    public Adresse findAdressesFByIdUtilisateur(int idUtilisateur);
	
    public List<Adresse> findAdressesLByIdUtilisateur(int idUtilisateur);
    
    public Adresse findAdressesLPByIdUtilisateur(int idUtilisateur);
	
    public Adresse createAdresse(Adresse adresse);
	
    public Adresse updateAdresse(Adresse adresse);
	
    public boolean deleteAdresse(Adresse adresse);
}
