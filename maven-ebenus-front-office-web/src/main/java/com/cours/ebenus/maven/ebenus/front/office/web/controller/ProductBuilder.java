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
import javax.ws.rs.core.Request;

import com.cours.ebenus.entities.Produit;
import com.cours.ebenus.entities.Utilisateur;
import com.cours.ebenus.maven.ebenus.front.office.web.model.ModelUser;
import com.cours.ebenus.maven.ebenus.front.office.web.model.modelProduct;
import com.cours.ebenus.service.IServiceFacade;
import com.cours.ebenus.service.ServiceFacade;



/**
 * Servlet implementation class ProductBuilder
 */
@WebServlet("/product")
public class ProductBuilder extends HttpServlet {
	
   private IServiceFacade serviceFacade;
   private modelProduct model;
   private ModelUser modelUser;
   @Override
   public void init() throws ServletException {
	model = new modelProduct();
	modelUser = new ModelUser();
   	serviceFacade = new ServiceFacade();
   }
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductBuilder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
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
		List<Produit> produits = serviceFacade.getProduitDao().findAllProduits();
	   	model.setProduits(produits);
	   	request.setAttribute("model", model);
	   	this.getServletContext().getRequestDispatcher("/products.jsp").forward(request, response);
		}else {
		   	this.getServletContext().getRequestDispatcher("/LoginController").forward(request, response);
		}
	}



}
