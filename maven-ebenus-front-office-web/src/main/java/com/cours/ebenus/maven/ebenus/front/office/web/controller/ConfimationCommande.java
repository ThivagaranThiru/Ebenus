package com.cours.ebenus.maven.ebenus.front.office.web.controller;

import java.io.IOException;
import java.util.ArrayList;
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
import com.cours.ebenus.maven.ebenus.front.office.web.model.ModelPanier;
import com.cours.ebenus.maven.ebenus.front.office.web.model.ModelUser;
import com.cours.ebenus.maven.ebenus.front.office.web.model.ModelUserData;
import com.cours.ebenus.maven.ebenus.front.office.web.model.modelProduct;
import com.cours.ebenus.service.IServiceFacade;
import com.cours.ebenus.service.ServiceFacade;

/**
 * Servlet implementation class ConfimationCommande
 */
@WebServlet("/ConfimationCommande")
public class ConfimationCommande extends HttpServlet {
	 private IServiceFacade serviceFacade;
	   private modelProduct model;
	   private ModelUser modelUser;
	   ModelUserData modelUserData;
	   @Override
	   public void init() throws ServletException {
		model = new modelProduct();
		//modelUser = new ModelUser();
	   	serviceFacade = new ServiceFacade();
	   	 modelUserData = new ModelUserData();
	   	 modelUser = new ModelUser();
	   }
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfimationCommande() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Utilisateur user = null;
		ModelPanier modelPanier = new ModelPanier();
	//	ModelUser modelUser = new ModelUser();
		
		if (session.getAttribute("user") != null){
			List<String> monCompte = new ArrayList<String>();
			user = (Utilisateur) session.getAttribute("user");
			modelUserData.setUser(user);
			modelUserData.setAdresseFacturation(serviceFacade.getAdresseDao().findAdressesFByIdUtilisateur(user.getIdUtilisateur()));
			modelUserData.setPrincipalAdresse(serviceFacade.getAdresseDao().findAdressesLPByIdUtilisateur(user.getIdUtilisateur()));
			modelUserData.setAdresseLivraison(serviceFacade.getAdresseDao().findAdressesLByIdUtilisateur(user.getIdUtilisateur()));
			monCompte.add("Mon Compte");
			monCompte.add("Deconnexion");
			monCompte.add(user.getNom());
			monCompte.add("panier");
			modelUser.setMonCompte(monCompte);
			
			session.setMaxInactiveInterval(1000);
			
			List<ArticleCommande> articleCommande = new ArrayList<ArticleCommande>();
			articleCommande = serviceFacade.getArticleCommandeDao().findArticleCommandeTByIdUtilisateur(user.getIdUtilisateur());
			modelPanier.setArticleCommande(articleCommande);
			modelPanier.setTotal(modelPanier.calculTotal());
			request.setAttribute("modelPanier", modelPanier);
			request.setAttribute("userModel", modelUser);
			request.setAttribute("modelUserData", modelUserData);
			this.getServletContext().getRequestDispatcher("/confirmation.jsp").forward(request, response);
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
