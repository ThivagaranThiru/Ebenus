package com.cours.ebenus.maven.ebenus.front.office.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cours.ebenus.entities.Produit;
import com.cours.ebenus.maven.ebenus.front.office.web.model.modelProduct;
import com.cours.ebenus.service.IServiceFacade;
import com.cours.ebenus.service.ServiceFacade;

/**
 * Servlet implementation class ProductDetail
 */
@WebServlet("/ProductDetail")
public class ProductDetail extends HttpServlet {
	  private IServiceFacade serviceFacade;
	   private modelProduct model;
	   @Override
	   public void init() throws ServletException {
		model = new modelProduct();
	   	serviceFacade = new ServiceFacade();
	   	
	   }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		modelProduct model = new modelProduct();
		int id;
		Produit produit = null;
		try {
		id = Integer.parseInt((String) request.getParameter("id"));
		if (id >= 0) {
			produit = serviceFacade.getProduitDao().findProduitById(id);
			if (produit != null) {
				model.setProduit(produit);
				request.setAttribute("model", model);
				this.getServletContext().getRequestDispatcher("/detail-produit.jsp").forward(request, response);
			}else {
				this.getServletContext().getRequestDispatcher("/404.jsp").forward(request, response);
			}
		}else {
			this.getServletContext().getRequestDispatcher("/404.jsp").forward(request, response);
		}
		}catch(Exception e) {
			this.getServletContext().getRequestDispatcher("/404.jsp").forward(request, response);
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
