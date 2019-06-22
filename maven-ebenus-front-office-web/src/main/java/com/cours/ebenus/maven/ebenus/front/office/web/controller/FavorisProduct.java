package com.cours.ebenus.maven.ebenus.front.office.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cours.ebenus.entities.ArticleCommande;
import com.cours.ebenus.entities.Produit;
import com.cours.ebenus.entities.Utilisateur;
import com.cours.ebenus.maven.ebenus.front.office.web.model.ModelFavoris;
import com.cours.ebenus.maven.ebenus.front.office.web.model.ModelUser;
import com.cours.ebenus.service.IServiceFacade;
import com.cours.ebenus.service.ServiceFacade;

/**
 * Servlet implementation class FavorisProduct
 */
@WebServlet("/Favoris")
public class FavorisProduct extends HttpServlet {
	private IServiceFacade serviceFacade;
	   private ModelFavoris model;
	   private ModelUser modelUser;
	   @Override
	   public void init() throws ServletException {
		model = new ModelFavoris();
		modelUser = new ModelUser();
	   	serviceFacade = new ServiceFacade();
	   }
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FavorisProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Utilisateur user = (Utilisateur) session.getAttribute("user");
		if (user != null) {
			List<String> monCompte = new ArrayList<String>();
			monCompte.add("Mon Compte");
			monCompte.add("Deconnexion");
			monCompte.add(user.getNom());
			monCompte.add("panier");
			modelUser.setMonCompte(monCompte);
			request.setAttribute("userModel", modelUser);
		List<ArticleCommande> articlecleCommande = serviceFacade.getArticleCommandeDao().findArticleCommandeFavoris();
	   	List<Produit> produitsCarrousel = new ArrayList<Produit>();
	   	List<Produit> produitsFav = new ArrayList<Produit>();
		model.setArticleCommande(articlecleCommande);
	   	Iterator<ArticleCommande> parser = articlecleCommande.iterator();
	   	int i = 0;
	   	while(parser.hasNext() && i < 15) {
	   		ArticleCommande article = parser.next();
	   		
	   		if (i < 5) {
	   			produitsCarrousel.add(serviceFacade.getProduitDao().findProduitById(article.getProduit().getIdProduit()));
	   		}else {
	   			produitsFav.add(serviceFacade.getProduitDao().findProduitById(article.getProduit().getIdProduit()));
	   		}
	   		i = i + 1 ;
	   	}
	   	model.setProduitsCaroussel(produitsCarrousel);
	   	model.setProduitsFav(produitsFav);
	   	request.setAttribute("model", model);
	   	this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		}else {
		   	this.getServletContext().getRequestDispatcher("/LoginController").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
