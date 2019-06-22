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
import com.cours.ebenus.entities.Utilisateur;
import com.cours.ebenus.maven.ebenus.front.office.web.model.ModelPanier;
import com.cours.ebenus.maven.ebenus.front.office.web.model.ModelUser;
import com.cours.ebenus.service.ServiceFacade;

/**
 * Servlet implementation class PanierContent
 */
@WebServlet("/PanierContent")
public class PanierContent extends HttpServlet {
	private ServiceFacade serviceFacade;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PanierContent() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init() throws ServletException{
    	serviceFacade = new ServiceFacade();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		HttpSession session = request.getSession();
		Utilisateur user = null;
		ModelPanier modelPanier = new ModelPanier();
		ModelUser modelUser = new ModelUser();
		if (session.getAttribute("user") != null){
			List<String> monCompte = new ArrayList<String>();
			user = (Utilisateur) session.getAttribute("user");
			monCompte.add("Mon Compte");
			monCompte.add("Deconnexion");
			monCompte.add(user.getNom());
			monCompte.add("panier");
			modelUser.setMonCompte(monCompte);
			request.setAttribute("userModel", modelUser);
			session.setMaxInactiveInterval(1000);
			
			List<ArticleCommande> articleCommande = new ArrayList<ArticleCommande>();
			articleCommande = serviceFacade.getArticleCommandeDao().findArticleCommandeTByIdUtilisateur(user.getIdUtilisateur());
			modelPanier.setArticleCommande(articleCommande);
			modelPanier.setTotal(modelPanier.calculTotal());
			request.setAttribute("modelPanier", modelPanier);
			this.getServletContext().getRequestDispatcher("/panier.jsp").forward(request, response);
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
