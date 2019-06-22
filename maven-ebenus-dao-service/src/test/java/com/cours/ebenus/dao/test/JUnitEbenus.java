/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.ebenus.dao.test;

import com.cours.ebenus.dao.DriverManagerSingleton;
import com.cours.ebenus.entities.Adresse;
import com.cours.ebenus.entities.ArticleCommande;
import com.cours.ebenus.entities.Commande;
import com.cours.ebenus.entities.Produit;
import com.cours.ebenus.entities.Role;
import com.cours.ebenus.entities.Utilisateur;
import com.cours.ebenus.exception.CustomException;
import com.cours.ebenus.service.IServiceFacade;
import com.cours.ebenus.utils.Constants;
import com.ibatis.common.jdbc.ScriptRunner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author thiva
 */
public class JUnitEbenus {
    
    private static final Log log = LogFactory.getLog(JUnitEbenus.class);
    protected static IServiceFacade serviceFacade = null;
    
    private static final int NB_UTILISATEURS_LIST = 22;
    private static final int NB_ROLES_LIST = 6;
    private static final int NB_PRODUITS_LIST = 35;
    private static final int NB_ADRESSES_LIST = 40;
    private static final int NB_COMMANDES_LIST = 621;
    private static final int NB_ARTICLES_COMMANDES_LIST = 1647;
    
    protected static List<Utilisateur> utilisateurs = null;
    protected static List<Role> roles = null;
    protected static List<Produit> produits = null;
    protected static List<Adresse> adresses = null;
    protected static List<ArticleCommande> articleCommandes = null;
    protected static List<Commande> commandes = null;
    
    @BeforeClass
    public static void initDataBase() throws FileNotFoundException, IOException, SQLException {
        // Initialiser les données de la base de données
        
    	String scriptSqlPath = Constants.SQL_JUNIT_PATH_FILE;
    	Connection conn = null;
    	
        if(DriverManagerSingleton.getInstance() != null 
            && DriverManagerSingleton.getInstance().getConnectionInstance() != null) {
			
            conn = DriverManagerSingleton.getInstance().getConnectionInstance();
        }
    	
        ScriptRunner runner = null;
    	runner = new ScriptRunner(conn, false, false);
        runner.setLogWriter(null);
        runner.setErrorLogWriter(null);
        runner.runScript(new InputStreamReader(new FileInputStream(scriptSqlPath)));
    }
    
    public void verifyUserDatas(Utilisateur user) {
        log.debug("Entree de la methode");
        if (user != null) {
            log.debug("idUtilisateur : " + user.getIdUtilisateur());
            Assert.assertNotNull(user.getIdUtilisateur());
            Assert.assertNotNull(user.getCivilite());
            Assert.assertNotNull(user.getPrenom());
            Assert.assertNotNull(user.getNom());
            Assert.assertNotNull(user.getIdentifiant());
            Assert.assertNotNull(user.getMotPasse());
            Assert.assertNotNull(user.getDateNaissance());
            Assert.assertNotNull(user.getDateCreation());
            Assert.assertNotNull(user.getDateModification());
            Assert.assertNotNull(user.getMarquerEffacer());
            Assert.assertNotNull(user.getActif());
            Assert.assertNotNull(user.getVersion());
            Assert.assertNotNull(user.getRole());
            Assert.assertNotNull(user.getRole().getIdRole());
            Assert.assertNotNull(user.getRole().getIdentifiant());
            Assert.assertNotNull(user.getRole().getDescription());
        } else if (user == null) {
            Assert.fail("Utilisateur null");
        }
        log.debug("Sortie de la methode");
    }
    
    public void verifyUsersDatas(List<Utilisateur> utilisateurs) {
        log.debug("Entree de la methode");
        if (utilisateurs != null) {
            log.debug("utilisateurs.size(): " + utilisateurs.size());
            for (Utilisateur user : utilisateurs) {
                verifyUserDatas(user);
            }
        } else if (utilisateurs == null || utilisateurs.isEmpty()) {
            Assert.fail("Aucun utilisateur n'a ete trouves dans votre liste");
        }
        log.debug("Sortie de la methode");
    }
    
    public void verifyRoleData(Role role) {
        log.debug("Entree de la methode");
        if (role != null) {
            log.debug("idRole : " + role.getIdRole());
            Assert.assertNotNull(role.getIdRole());
            Assert.assertNotNull(role.getIdentifiant());
            Assert.assertNotNull(role.getDescription());
            Assert.assertNotNull(role.getMarquerEffacer());
            Assert.assertNotNull(role.getVersion());
        } else if (role == null) {
            Assert.fail("Role null");
        }
        log.debug("Sortie de la methode");
    }
    
    public void verifyProduitData(Produit produit){
       log.debug("Entree de la methode");
       if(produit != null){
           log.debug("idProduit : " + produit.getIdProduit());
           Assert.assertNotNull(produit.getIdProduit());
           Assert.assertNotNull(produit.getNom());
           Assert.assertNotNull(produit.getReference());
           Assert.assertNotNull(produit.getPrix());
           Assert.assertNotNull(produit.getDescription());
           Assert.assertNotNull(produit.getActif());
           Assert.assertNotNull(produit.getStock());
           Assert.assertNotNull(produit.getMarquerEffacer());
           Assert.assertNotNull(produit.getVersion());           
       }else if(produit == null){
           Assert.fail("Produit null");
       }
       log.debug("Sortie de la methode");
    }
    
    public void verifyAdresseData(Adresse adresse){
       log.debug("Entree de la methode");
       if(adresse != null){
           log.debug("idAdresse : " + adresse.getIdAdresse());
           Assert.assertNotNull(adresse.getIdUtilisateur());
           Assert.assertNotNull(adresse.getRue());
           Assert.assertNotNull(adresse.getVille());
           Assert.assertNotNull(adresse.getCodePostal());
           Assert.assertNotNull(adresse.getPays());
           Assert.assertNotNull(adresse.getTypeAdresse());
           Assert.assertNotNull(adresse.getPrincipale());
           Assert.assertNotNull(adresse.getStatut());
           Assert.assertNotNull(adresse.getVersion());           
       }else if(adresse == null){
           Assert.fail("Adresse null");
       }
       log.debug("Sortie de la methode");
    }
    
    public void verifyCommandeData(Commande commande){
       log.debug("Entree de la methode");
       if(commande != null){
           log.debug("idCommande : " + commande.getIdCommande());
           Assert.assertNotNull(commande.getUtilisateur());
           Assert.assertNotNull(commande.getTotalCommande());
           Assert.assertNotNull(commande.getAdresse());
           Assert.assertNotNull(commande.getDateCommande());
           Assert.assertNotNull(commande.getDateModification());
           Assert.assertNotNull(commande.getStatut());
           Assert.assertNotNull(commande.getVersion());          
       }else if(commande == null){
           Assert.fail("Commande null");
       }
       log.debug("Sortie de la methode");
    }
    
    public void verifyArticleCommandeData(ArticleCommande articleCommande){
       log.debug("Entree de la methode");
       if(articleCommande != null){
           log.debug("idarticleCommande : " + articleCommande.getIdArticleCommande());
           Assert.assertNotNull(articleCommande.getReference());
           Assert.assertNotNull(articleCommande.getTotalArticleCommande());
           Assert.assertNotNull(articleCommande.getQuantite());
           Assert.assertNotNull(articleCommande.getStatut());
           Assert.assertNotNull(articleCommande.getDateModification());
           Assert.assertNotNull(articleCommande.getVersion());
           Assert.assertNotNull(articleCommande.getCommande());
           Assert.assertNotNull(articleCommande.getUtilisateur());
           Assert.assertNotNull(articleCommande.getAdresse()); 
           Assert.assertNotNull(articleCommande.getProduit()); 
       }else if(articleCommande == null){
           Assert.fail("ArticleCommande null");
       }
       log.debug("Sortie de la methode");
    }

   @Test
    public void testFindAllUtilisateurs() {
        log.debug("Entree de la methode");
        if (utilisateurs != null) {
            log.debug("NB_UTILISATEURS_LIST: " + NB_UTILISATEURS_LIST + " , utilisateurs.size(): " + utilisateurs.size());
            Assert.assertEquals(NB_UTILISATEURS_LIST, utilisateurs.size());
            verifyUsersDatas(utilisateurs);
        } else {
            Assert.fail("Aucun utilisateur n'a ete trouves dans votre base de données");
        }
        log.debug("Sortie de la methode");
    }
    
    @Test
    public void testFindAllRoles() {
        log.debug("Entree de la methode");
        if (roles != null) {
            log.debug("NB_ROLES_LIST: " + NB_ROLES_LIST + " , roles.size(): " + roles.size());
            Assert.assertEquals(NB_ROLES_LIST, roles.size());
        } else {
            Assert.fail("Aucun Role n'a ete trouves dans votre base de données");
        }
        log.debug("Sortie de la methode");
    }
    
    @Test
    public void testFindAllProduits(){
        log.debug("Entree de la methode");
        if(produits != null){
            log.debug("NB_PRODUITS_LIST: " + NB_PRODUITS_LIST + " , produits.size(): " + produits.size());
            Assert.assertEquals(NB_PRODUITS_LIST, produits.size());
        }else{
            Assert.fail("Aucun Produit n'a ete trouves dans votre base de données");
        }
        log.debug("Sortie de la methode");
    }
    
        @Test
    public void testFindAllAdresses(){
        log.debug("Entree de la methode");
        if(adresses != null){
            log.debug("NB_ADRESSES_LIST: " + NB_ADRESSES_LIST + " , adresses.size(): " + adresses.size());
            Assert.assertEquals(NB_ADRESSES_LIST, adresses.size());
        }else{
            Assert.fail("Aucun Adresse n'a ete trouves dans votre base de données");
        }
        log.debug("Sortie de la methode");
    }
   
    @Test
    public void testFindAllCommandes(){
        log.debug("Entree de la methode");
        if(commandes != null){
            log.debug("NB_COMMANDES_LIST: " + NB_COMMANDES_LIST + " , commande.size(): " + commandes.size());
            Assert.assertEquals(NB_COMMANDES_LIST, commandes.size());
        }else{
            Assert.fail("Aucun Commande n'a ete trouves dans votre base de données");
        }
        log.debug("Sortie de la methode");
    }
    
    @Test
    public void testFindAllArticleCommande(){
        log.debug("Entree de la methode");
        if(articleCommandes != null){
            log.debug("NB_ARTICLE_COMMANDES_LIST: " + NB_ARTICLES_COMMANDES_LIST + " , articleCommandes.size(): " + articleCommandes.size());
            Assert.assertEquals(NB_ARTICLES_COMMANDES_LIST, articleCommandes.size());
        }else{
            Assert.fail("Aucun ArtcileCommandes n'a ete trouves dans votre base de données");
        }
        log.debug("Sortie de la methode");
    }
    
    @Test
    public void testCreateUpdateDeleteUtilisateur() {
        log.debug("Entree de la methode");
        Role roleCRUD = new Role("Superviseur", "Le rôle superviseur");
        roleCRUD = serviceFacade.getRoleDao().createRole(roleCRUD);
        verifyRoleData(roleCRUD);
        log.debug("Created roleCRUD : " + roleCRUD);
        log.debug("Created roleCRUD.getIdRole : " + roleCRUD.getIdRole());
        roleCRUD = serviceFacade.getRoleDao().findRoleById(roleCRUD.getIdRole());
        Assert.assertNotNull(roleCRUD);
        Utilisateur userCRUD = new Utilisateur("Mme", "Nicole", "Valentine", "nicole.valentine@gmail.com", "passw0rd", new Date(System.currentTimeMillis()),true, roleCRUD);
        userCRUD = serviceFacade.getUtilisateurDao().createUtilisateur(userCRUD);
        verifyUserDatas(userCRUD);
        log.debug("Created userCRUD : " + userCRUD);
        userCRUD = serviceFacade.getUtilisateurDao().findUtilisateurById(userCRUD.getIdUtilisateur());
        Assert.assertNotNull(userCRUD);
        userCRUD.setPrenom("Nicole Bis");
        userCRUD.setNom("Valentine Bis");
        userCRUD = serviceFacade.getUtilisateurDao().updateUtilisateur(userCRUD);
        Assert.assertNotNull(userCRUD);
        userCRUD = serviceFacade.getUtilisateurDao().findUtilisateurById(userCRUD.getIdUtilisateur());
        log.debug("Updated userCRUD : " + userCRUD);
        Assert.assertEquals("Nicole Bis", userCRUD.getPrenom());
        Assert.assertEquals("Valentine Bis", userCRUD.getNom());
        Assert.assertTrue(serviceFacade.getUtilisateurDao().deleteUtilisateur(userCRUD));
        userCRUD = serviceFacade.getUtilisateurDao().findUtilisateurById(userCRUD.getIdUtilisateur());
        Assert.assertNull(userCRUD);
        Assert.assertTrue(serviceFacade.getRoleDao().deleteRole(roleCRUD));
        roleCRUD = serviceFacade.getRoleDao().findRoleById(roleCRUD.getIdRole());
        Assert.assertNull(roleCRUD);
        // Cas des gestions des doublons d'identifiant (mail).
        userCRUD = new Utilisateur("Mr", "Admin", "Admin", "admin@gmail.com", "passw0rd", new Date(System.currentTimeMillis()));
        try {
            userCRUD = serviceFacade.getUtilisateurDao().createUtilisateur(userCRUD);
            log.debug("Duplicate userCRUD : " + userCRUD.getIdentifiant());
        } catch (CustomException e) {
            log.debug("Bravo la gestion des doublons d'identifiant marche parfaitement");
            Assert.assertEquals(Constants.EXCEPTION_CODE_USER_ALREADY_EXIST, e.getCode());
        }
        List<Utilisateur> utilisateursFinal = serviceFacade.getUtilisateurDao().findAllUtilisateurs();
        if (utilisateursFinal != null) {
            Assert.assertEquals(NB_UTILISATEURS_LIST, utilisateursFinal.size());
            log.debug("utilisateursFinal.size() : " + utilisateursFinal.size() + " , NB_UTILISATEURS_LIST: " + NB_UTILISATEURS_LIST);
        }
        log.debug("Sortie de la methode");
    }
    
        @Test
    public void testCreateUpdateDeleteRole() {
        log.debug("Entree de la methode");
        Role roleCRUD = new Role("Superviseur", "Le rôle superviseur");
        roleCRUD = serviceFacade.getRoleDao().createRole(roleCRUD);
        verifyRoleData(roleCRUD);
        log.debug("Created roleCRUD : " + roleCRUD);
        log.debug("Created roleCRUD.getIdRole : " + roleCRUD.getIdRole());
        roleCRUD = serviceFacade.getRoleDao().findRoleById(roleCRUD.getIdRole());
        Assert.assertNotNull(roleCRUD);
        roleCRUD.setIdentifiant("Superviseur Bis");
        roleCRUD.setDescription("Le rôle superviseur Bis");
        roleCRUD = serviceFacade.getRoleDao().updateRole(roleCRUD);
        Assert.assertNotNull(roleCRUD);
        roleCRUD = serviceFacade.getRoleDao().findRoleById(roleCRUD.getIdRole());
        log.debug("Updated roleCRUD : " + roleCRUD);
        Assert.assertEquals("Superviseur Bis", roleCRUD.getIdentifiant());
        Assert.assertEquals("Le rôle superviseur Bis", roleCRUD.getDescription());
        Assert.assertTrue(serviceFacade.getRoleDao().deleteRole(roleCRUD));
        roleCRUD = serviceFacade.getRoleDao().findRoleById(roleCRUD.getIdRole());
        Assert.assertNull(roleCRUD);
        List<Role> rolesFinal = serviceFacade.getRoleDao().findAllRoles();
        if (rolesFinal != null) {
            Assert.assertEquals(NB_ROLES_LIST, rolesFinal.size());
            log.debug("rolesFinal.size() : " + rolesFinal.size() + " , NB_ROLES_LIST: " + NB_ROLES_LIST);
        }
        log.debug("Sortie de la methode");
    }
    
    @Test
    public void testCreateUpdateDeleteProduit(){
        log.debug("Entree de la methode");
        Produit produitCRUD = new Produit("REF-PLAY-STATION-4",699.0,"PLAYSTATION4","CONSOLE DE JEU PERFORMANT",300,true);
        produitCRUD = serviceFacade.getProduitDao().createProduit(produitCRUD);
        verifyProduitData(produitCRUD);
        log.debug("Created produitCRUD : " + produitCRUD);
        log.debug("Created produitCRUD.getIdProduit : " + produitCRUD.getIdProduit());
        produitCRUD = serviceFacade.getProduitDao().findProduitById(produitCRUD.getIdProduit());
        Assert.assertNotNull(produitCRUD);
        produitCRUD.setNom("PLAY 4");
        produitCRUD.setDescription("CONSOLE DE JEUX 4k 500GO");
        produitCRUD = serviceFacade.getProduitDao().updateProduit(produitCRUD);
        Assert.assertNotNull(produitCRUD);
        produitCRUD = serviceFacade.getProduitDao().findProduitById(produitCRUD.getIdProduit());
        log.debug("Updated produitCRUD : " + produitCRUD);
        Assert.assertEquals("PLAY 4", produitCRUD.getNom());
        Assert.assertEquals("CONSOLE DE JEUX 4k 500GO", produitCRUD.getDescription());
        Assert.assertTrue(serviceFacade.getProduitDao().deleteProduit(produitCRUD));
        produitCRUD = serviceFacade.getProduitDao().findProduitById(produitCRUD.getIdProduit());
        Assert.assertNull(produitCRUD);
        produitCRUD = new Produit("REF-IPHONE-3GS",0.0,"3g","telephone",300,true);
        try {
            produitCRUD = serviceFacade.getProduitDao().createProduit(produitCRUD);
            log.debug("Duplicate produitCRUD : " + produitCRUD.getReference());
        } catch (CustomException e) {
            log.debug("Bravo la gestion des doublons de réference marche parfaitement");
            Assert.assertEquals(Constants.EXCEPTION_CODE_USER_ALREADY_EXIST, e.getCode());
        }
        List<Produit> produitsFinal = serviceFacade.getProduitDao().findAllProduits();
        if(produitsFinal != null){
            Assert.assertEquals(NB_PRODUITS_LIST, produitsFinal.size());
            log.debug("produitsFinal.size() : " + produitsFinal.size() + " , NB_PRODUITS_LIST: " + NB_PRODUITS_LIST);
        }
        log.debug("Sortie de la methode");
    }
    
        @Test
    public void testCreateUpdateDeleteAdresse(){
        log.debug("Entree de la methode");
        Adresse adresseCRUD = new Adresse("8 rue ETNA","9400","IVRY-SUR-SEINE","FRANCE","F",true,1);
        adresseCRUD = serviceFacade.getAdresseDao().createAdresse(adresseCRUD);
        verifyAdresseData(adresseCRUD);
        log.debug("Created adresseCRUD : " + adresseCRUD);
        log.debug("Created adresseCRUD.getIdAdresse : " + adresseCRUD.getIdAdresse());
        adresseCRUD = serviceFacade.getAdresseDao().findAdresseById(adresseCRUD.getIdAdresse());
        Assert.assertNotNull(adresseCRUD);
        adresseCRUD.setRue("22 rue Faubourg");
        adresseCRUD.setVille("PARIS");
        adresseCRUD = serviceFacade.getAdresseDao().updateAdresse(adresseCRUD);
        Assert.assertNotNull(adresseCRUD);
        adresseCRUD = serviceFacade.getAdresseDao().findAdresseById(adresseCRUD.getIdAdresse());
        log.debug("Updated adresseCRUD : " + adresseCRUD);
        Assert.assertEquals("22 rue Faubourg", adresseCRUD.getRue());
        Assert.assertEquals("PARIS", adresseCRUD.getVille());
        Assert.assertTrue(serviceFacade.getAdresseDao().deleteAdresse(adresseCRUD));
        adresseCRUD = serviceFacade.getAdresseDao().findAdresseById(adresseCRUD.getIdAdresse());
        Assert.assertNull(adresseCRUD);
        List<Adresse> adressesFinal = serviceFacade.getAdresseDao().findAllAdresses();
        if(adressesFinal != null){
            Assert.assertEquals(NB_ADRESSES_LIST, adressesFinal.size());
            log.debug("adressesFinal.size() : " + adressesFinal.size() + " , NB_ADRESSES_LIST: " + NB_ADRESSES_LIST);
        }
        log.debug("Sortie de la methode");
    }
    
        
    @Test
    public void testCreateUpdateDeleteCommande(){
        log.debug("Entree de la methode"); 
        Utilisateur user = serviceFacade.getUtilisateurDao().findUtilisateurById(6);
        Adresse adres = serviceFacade.getAdresseDao().findAdressesByIdUtilisateur(1).get(0);
        Commande commandeCRUD = new Commande(900.0,"V",new Date(System.currentTimeMillis()),new Date(System.currentTimeMillis()),adres,user);
        commandeCRUD = serviceFacade.getCommandeDao().createCommande(commandeCRUD);
        verifyCommandeData(commandeCRUD);
        log.debug("Created commandeCRUD : " + commandeCRUD);
        log.debug("Created commandeCRUD.getIdCommande : " + commandeCRUD.getIdCommande());
        commandeCRUD = serviceFacade.getCommandeDao().findCommandeById(commandeCRUD.getIdCommande());
        Assert.assertNotNull(commandeCRUD);
        commandeCRUD.setStatut("T");
        commandeCRUD.setTotalCommande(200.0);
        commandeCRUD = serviceFacade.getCommandeDao().updateCommande(commandeCRUD);
        Assert.assertNotNull(commandeCRUD);
        commandeCRUD = serviceFacade.getCommandeDao().findCommandeById(commandeCRUD.getIdCommande());
        log.debug("Updated commandeCRUD" + commandeCRUD);
        Assert.assertEquals("T", commandeCRUD.getStatut());
        Assert.assertEquals("200.0", commandeCRUD.getTotalCommande().toString());
        Assert.assertTrue(serviceFacade.getCommandeDao().deleteCommande(commandeCRUD));
        commandeCRUD = serviceFacade.getCommandeDao().findCommandeById(commandeCRUD.getIdCommande());
        Assert.assertNull(commandeCRUD);
        List<Commande> commandeFinal = serviceFacade.getCommandeDao().findAllCommandes();
        if(commandeFinal != null){
            Assert.assertEquals(NB_COMMANDES_LIST, commandeFinal.size());
            log.debug("commandeFinal.size() : " + commandeFinal.size() + " , NB_COMMANDES_LIST: " + NB_COMMANDES_LIST);
        }
        log.debug("Sortie de la methode");
    }
    
        @Test
    public void testCreateUpdateDeleteArticleCommande(){
        log.debug("Entree de la methode"); 
        Utilisateur user = serviceFacade.getUtilisateurDao().findUtilisateurById(1);
        Adresse adres = serviceFacade.getAdresseDao().findAdressesByIdUtilisateur(1).get(0);
        Produit product = serviceFacade.getProduitDao().findProduitById(1);
        Commande comman = serviceFacade.getCommandeDao().findCommandeById(1);
        ArticleCommande articleCommandeCRUD = new ArticleCommande(900.0,"REF-TEST",400,"V",new Date(System.currentTimeMillis()),comman,user,adres,product);
        articleCommandeCRUD = serviceFacade.getArticleCommandeDao().createArticleCommande(articleCommandeCRUD);
        verifyArticleCommandeData(articleCommandeCRUD);
        log.debug("Created articleCommandeCRUD : " + articleCommandeCRUD);
        log.debug("Created articleCommandeCRUD.getIdArticleCommande : " + articleCommandeCRUD.getIdArticleCommande());
        articleCommandeCRUD = serviceFacade.getArticleCommandeDao().findArticleCommandeById(articleCommandeCRUD.getIdArticleCommande());
        Assert.assertNotNull(articleCommandeCRUD);
        articleCommandeCRUD.setStatut("T");
        articleCommandeCRUD.setReference("REF-TEST-JUNIT");
        articleCommandeCRUD = serviceFacade.getArticleCommandeDao().updateArticleCommande(articleCommandeCRUD);
        Assert.assertNotNull(articleCommandeCRUD);
        articleCommandeCRUD = serviceFacade.getArticleCommandeDao().findArticleCommandeById(articleCommandeCRUD.getIdArticleCommande());
        log.debug("Updated articleCommandeCRUD" + articleCommandeCRUD);
        Assert.assertEquals("T", articleCommandeCRUD.getStatut());
        Assert.assertEquals("REF-TEST-JUNIT", articleCommandeCRUD.getReference());
        Assert.assertTrue(serviceFacade.getArticleCommandeDao().deleteArticleCommande(articleCommandeCRUD));
        articleCommandeCRUD = serviceFacade.getArticleCommandeDao().findArticleCommandeById(articleCommandeCRUD.getIdArticleCommande());
        Assert.assertNull(articleCommandeCRUD);
        List<ArticleCommande> aricleCommandeFinal = serviceFacade.getArticleCommandeDao().findAllArticleCommande();
        if(aricleCommandeFinal != null){
            Assert.assertEquals(NB_ARTICLES_COMMANDES_LIST, aricleCommandeFinal.size());
            log.debug("commandeFinal.size() : " + aricleCommandeFinal.size() + " , NB_ARTICLES_COMMANDES_LIST: " + NB_ARTICLES_COMMANDES_LIST);
        }
        log.debug("Sortie de la methode");
    }
    
   @AfterClass
    public static void terminate() throws Exception {
        log.debug("Entree de la methode");
        serviceFacade = null;
        utilisateurs = null;
        roles = null;
        produits = null;
        commandes = null;
        articleCommandes = null;
        adresses = null;
        log.debug("Sortie de la methode");
    }
}
