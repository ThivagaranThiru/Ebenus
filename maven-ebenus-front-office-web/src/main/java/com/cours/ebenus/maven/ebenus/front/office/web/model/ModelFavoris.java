package com.cours.ebenus.maven.ebenus.front.office.web.model;

import java.util.ArrayList;
import java.util.List;

import com.cours.ebenus.entities.ArticleCommande;
import com.cours.ebenus.entities.Produit;

public class ModelFavoris {
	public List<ArticleCommande> articleCommande = new ArrayList<ArticleCommande>();
	public List<Produit> produitsCaroussel = new ArrayList<Produit>();
	public List<Produit> produitsFav = new ArrayList<Produit>();
	public ArticleCommande produit;
	public List<ArticleCommande> getArticleCommande() {
		return articleCommande;
	}
	public void setArticleCommande(List<ArticleCommande> articleCommande) {
		this.articleCommande = articleCommande;
	}

	public List<Produit> getProduitsCaroussel() {
		return produitsCaroussel;
	}
	public void setProduitsCaroussel(List<Produit> produitsCaroussel) {
		this.produitsCaroussel = produitsCaroussel;
	}
	public List<Produit> getProduitsFav() {
		return produitsFav;
	}
	public void setProduitsFav(List<Produit> produitsFav) {
		this.produitsFav = produitsFav;
	}
	public ArticleCommande getProduit() {
		return produit;
	}
	public void setProduit(ArticleCommande produit) {
		this.produit = produit;
	}
	


	
}
