package com.cours.ebenus.maven.ebenus.front.office.web.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.cours.ebenus.entities.ArticleCommande;
import com.cours.ebenus.entities.Produit;

public class ModelPanier {
public  List<ArticleCommande> articleCommande = new ArrayList<ArticleCommande>();
public 	double total;

public  List<ArticleCommande> getArticleCommande() {
	return articleCommande;
}

public  void setArticleCommande(List<ArticleCommande> articleCommande) {
	this.articleCommande = articleCommande;
}

public double calculTotal() {
	Iterator<ArticleCommande> parser = articleCommande.iterator();
	double t = 0 ;
	while(parser.hasNext()) {
		ArticleCommande ac = parser.next();
		t = t + ac.getTotalArticleCommande();
	}
	return t;
}

public double getTotal() {
	return total;
}

public void setTotal(double total) {
	this.total = total;
}

}
