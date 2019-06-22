/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.ebenus.dao.test;

import com.cours.ebenus.service.ServiceFacade;

import org.junit.BeforeClass;


/**
 *
 * @author thiva
 */
public class JUnitAdresseDao extends JUnitEbenus{
    
     @BeforeClass
     public static void init() throws Exception {
 	
 	serviceFacade = new ServiceFacade();
 	
 	if(serviceFacade.getRoleDao() != null && serviceFacade.getRoleDao() != null) {
            roles = serviceFacade.getRoleDao().findAllRoles();
            utilisateurs = serviceFacade.getUtilisateurDao().findAllUtilisateurs();
            produits = serviceFacade.getProduitDao().findAllProduits();
            adresses = serviceFacade.getAdresseDao().findAllAdresses();
            articleCommandes = serviceFacade.getArticleCommandeDao().findAllArticleCommande();
            commandes = serviceFacade.getCommandeDao().findAllCommandes();
        }
    }
}
