package com.cours.ebenus.dao;

import java.util.List;

import com.cours.ebenus.entities.ArticleCommande;

public interface IArticleCommandeDao {
	
    public List<ArticleCommande> findAllArticleCommande();
	
    public ArticleCommande findArticleCommandeById(int idArticleCommande);
	
    public ArticleCommande findArticleCommandeByReferenceArticleCommande(String referenceArticleCommande);
	
    public List<ArticleCommande> findArticleCommandeByIdCommande(int idCommande);
	
    public List<ArticleCommande> findArticleCommandeByIdUtilisateur(int idUtilisateur);
	
    public List<ArticleCommande> findArticleCommandeByIdAdresse(int idAdresse);
	
    public List<ArticleCommande> findArticleCommandeByIdProduit(int idProduit);
        
    public List<ArticleCommande> findArticleCommandeTByIdUtilisateur(int idUtilisateur);
	
    public List<ArticleCommande> findArticleCommandeVByIdUtilisateur(int idUtilisateur);
    
    public List<ArticleCommande> findArticleCommandeFavoris();
	
    public ArticleCommande createArticleCommande(ArticleCommande articleCommande);
	
    public ArticleCommande updateArticleCommande(ArticleCommande articleCommande);
	
    public boolean deleteArticleCommande(ArticleCommande articleCommande);
    
    

}
