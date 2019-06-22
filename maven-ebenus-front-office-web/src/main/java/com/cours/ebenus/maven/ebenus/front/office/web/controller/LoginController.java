package com.cours.ebenus.maven.ebenus.front.office.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cours.ebenus.entities.Utilisateur;
import com.cours.ebenus.maven.ebenus.front.office.web.model.ModelUser;
import com.cours.ebenus.service.ServiceFacade;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private ServiceFacade serviceFacade;
	private ModelUser model ;
    /**
     * @see HttpServlet#HttpServlet()
     */
	@Override
	public void init() throws ServletException{
		serviceFacade = new ServiceFacade();
		model = new ModelUser();
	}
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if (session.getAttribute("user") != null) {
			Utilisateur user = (Utilisateur) session.getAttribute("user");
			List<String> monCompte = new ArrayList<String>();
			monCompte.add("Mon Compte");
			monCompte.add("Deconnexion");
			monCompte.add(user.getNom());
			monCompte.add("panier");
			model.setMonCompte(monCompte);
			request.setAttribute("userModel", model);
			this.getServletContext().getRequestDispatcher("/Favoris").forward(request, response);
			
		}else
		{
			this.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = null ;
		String password = null;
		Utilisateur user = null;
		if (!request.getParameter("__email").isEmpty()) {
			email = request.getParameter("__email");
			if (!request.getParameter("password").isEmpty()) {
				password = request.getParameter("password");
				user = serviceFacade.getUtilisateurDao().authenticate(email, password);
			}
		}
		
		
		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			session.setMaxInactiveInterval(1000);
			List<String> monCompte = new ArrayList<String>();
			monCompte.add("Mon Compte");
			monCompte.add("Deconnexion");
			monCompte.add(user.getNom());
			monCompte.add("panier");
			model.setMonCompte(monCompte);
			request.setAttribute("userModel", model);
			response.sendRedirect(request.getContextPath() + "/Favoris");
		}else {
			this.getServletContext().getRequestDispatcher("/404.jsp").forward(request, response);
		}
	}

}
