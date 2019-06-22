package com.cours.ebenus.maven.ebenus.front.office.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cours.ebenus.entities.ArticleCommande;
import com.cours.ebenus.entities.Commande;
import com.cours.ebenus.entities.Produit;
import com.cours.ebenus.entities.Utilisateur;
import com.cours.ebenus.service.ServiceFacade;
import java.util.Date;

/**
 * Servlet implementation class CartController
 */
@WebServlet("/CartController")
public class CartController extends HttpServlet {
	private ServiceFacade serviceFacade;
	
	@Override
	public void init() throws ServletException{
		serviceFacade = new ServiceFacade();
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		int idProduit = Integer.parseInt(request.getParameter("idProduit"));
		int quantite = Integer.parseInt(request.getParameter("qty"));
		Produit produit = serviceFacade.getProduitDao().findProduitById(idProduit);
		if (session.getAttribute("user") != null) {
			Utilisateur user = (Utilisateur) session.getAttribute("user");
			//request.setAttribute("modelPanier", ModelPanier.paniers);
			Commande commande = new Commande();
			commande.setTotalCommande(produit.getPrix() * quantite);
			commande.setUtilisateur(user);
			commande.setAdresse(serviceFacade.getAdresseDao().findAdressesFByIdUtilisateur(user.getIdUtilisateur()));
			commande.setStatut("T");
			commande.setVersion(1);
			serviceFacade.getCommandeDao().createCommande(commande);
			ArticleCommande articleCommande = new ArticleCommande();
			articleCommande.setCommande(serviceFacade.getCommandeDao().findCommandesByIdUtilisateur(user.getIdUtilisateur()).get(0));
			articleCommande.setUtilisateur(user);
			articleCommande.setAdresse(serviceFacade.getAdresseDao().findAdressesLByIdUtilisateur(user.getIdUtilisateur()).get(0));
			articleCommande.setProduit(produit);
			articleCommande.setTotalArticleCommande(produit.getPrix() * quantite);
			articleCommande.setReference(produit.getReference());
			articleCommande.setQuantite(quantite);
			articleCommande.setStatut("T");
			articleCommande.setDateModification(new Date(System.currentTimeMillis()));
			serviceFacade.getArticleCommandeDao().createArticleCommande(articleCommande);
			this.getServletContext().getRequestDispatcher("/PanierContent").forward(request, response);
		}else {
			this.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

}
