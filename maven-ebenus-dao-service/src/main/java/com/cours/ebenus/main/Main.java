package com.cours.ebenus.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.cours.ebenus.entities.Adresse;
import com.cours.ebenus.entities.Produit;
import com.cours.ebenus.entities.Role;
import com.cours.ebenus.entities.Utilisateur;
import com.cours.ebenus.service.IServiceFacade;
import com.cours.ebenus.service.ServiceFacade;

public class Main {
	
    private static final Log log = LogFactory.getLog(Main.class);
	
    public static void main(String[] args) {

    	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    	IServiceFacade serviceFacade = null;
       	serviceFacade = new ServiceFacade();
       	
    	if(serviceFacade.getRoleDao() != null && serviceFacade.getUtilisateurDao() != null && serviceFacade.getProduitDao() != null
    			&& serviceFacade.getAdresseDao() != null) {
    		
    		parcourList(serviceFacade.getRoleDao().findAllRoles());
       		System.out.println(serviceFacade.getRoleDao().findRoleById(1));
        	parcourList(serviceFacade.getRoleDao().findRoleByIdentifiant("Directeur"));
        	System.out.println(serviceFacade.getRoleDao().createRole(new Role("Client","Le role Client")));
       		Role role = serviceFacade.getRoleDao().findRoleById(6);
       		role.setIdentifiant("SAV");
        	System.out.println(serviceFacade.getRoleDao().updateRole(role));
        	if(serviceFacade.getRoleDao().deleteRole(new Role(6)) == true) System.out.println("Supprimer");
        	
        	System.out.println();
    		
    		parcourList(serviceFacade.getUtilisateurDao().findAllUtilisateurs());
       		System.out.println(serviceFacade.getUtilisateurDao().findUtilisateurById(1));
        	parcourList(serviceFacade.getUtilisateurDao().findUtilisateursByPrenom("Nicolas"));
        	parcourList(serviceFacade.getUtilisateurDao().findUtilisateursByNom("Cantin"));
        	parcourList(serviceFacade.getUtilisateurDao().findUtilisateursByIdentifiant("dimitry.gozin@gmail.com"));
        	parcourList(serviceFacade.getUtilisateurDao().findUtilisateursByIdRole(5));
        	parcourList(serviceFacade.getUtilisateurDao().findUtilisateursByIdentifiantRole("Standard"));
    		
       		try {
       			System.out.println(serviceFacade.getUtilisateurDao().createUtilisateur(new Utilisateur("Mr.","Thiva","Thiruchelvam","thiruc_t@etna_alternace.net","passw0rd", simpleDateFormat.parse("18/06/1994"),true, new Role(1,"Administrateur","Le role Administrateur"))).toString());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
       		Utilisateur user = serviceFacade.getUtilisateurDao().authenticate("thiruc_t@etna_alternace.net","passw0rd");
       		System.out.println(user.toString());
    		
       		user.setPrenom("Thivagaran");
       		System.out.println(serviceFacade.getUtilisateurDao().updateUtilisateur(user));
       		
       		if(serviceFacade.getUtilisateurDao().deleteUtilisateur(user) != false) System.out.println("Supprimer");
    		
    		System.out.println();
    		
    		parcourList(serviceFacade.getProduitDao().findAllProduits());
    		System.out.println(serviceFacade.getProduitDao().findProduitById(1));
    		System.out.println(serviceFacade.getProduitDao().findProduitByReference("REF-IPHONE-4"));
    		System.out.println(serviceFacade.getProduitDao().findProduitsByNom("Iphone 5"));
    		System.out.println(serviceFacade.getProduitDao().findProduitsByPrix(300.0));
    		Produit produit = new Produit(36,"RF-AUDI-Q3",180.0,"AUDI-Q3","Voiture-très-puissante",5,true);
    		System.out.println(serviceFacade.getProduitDao().createProduit(produit));
    		Produit produitUpdate = serviceFacade.getProduitDao().findProduitByReference("RF-AUDI-Q3").get(0);
    		produitUpdate.setDescription("Voiture très puissante et magnifique");
    		System.out.println(serviceFacade.getProduitDao().updateProduit(produitUpdate));
    		if(serviceFacade.getProduitDao().deleteProduit(produitUpdate) != false) System.out.println("Supprimer");
    		
    		System.out.println();
    		
    		parcourList(serviceFacade.getAdresseDao().findAllAdresses());
    		System.out.println(serviceFacade.getAdresseDao().findAdresseById(1));
    		System.out.println(serviceFacade.getAdresseDao().findAdressesByVille("Paris"));
    		System.out.println(serviceFacade.getAdresseDao().findAdressesByPays("France"));
    		System.out.println(serviceFacade.getAdresseDao().findAdressesByIdUtilisateur(1));
    		System.out.println(serviceFacade.getAdresseDao().findAdressesByIdentifiantUtilisateur("directecteur@gmail.com"));
    		Adresse adresse = new Adresse("11 rue Lamartine", "94800", "Villejuif", "France","P",true,1);
    		serviceFacade.getAdresseDao().createAdresse(adresse);
    		Adresse adresseUpdate = serviceFacade.getAdresseDao().findAdressesByVille("Villejuif").get(0);
    		adresseUpdate.setVille("villefeuj");
    		serviceFacade.getAdresseDao().updateAdresse(adresseUpdate);
    		if(serviceFacade.getAdresseDao().deleteAdresse(adresseUpdate) != false) System.out.println("Supprimer");
    	}
    }
	 
    public static <T> void parcourList (List<T> list) {
		
	Iterator<T> it = null;
	it = list.iterator();
	        
	while(it.hasNext()) {
	    T util = it.next();
	    System.out.println(util.toString());
	}
    }
}
