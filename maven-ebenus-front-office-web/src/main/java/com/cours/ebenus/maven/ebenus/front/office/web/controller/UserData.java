package com.cours.ebenus.maven.ebenus.front.office.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cours.ebenus.entities.Utilisateur;
import com.cours.ebenus.maven.ebenus.front.office.web.model.ModelUserData;
import com.cours.ebenus.service.ServiceFacade;

/**
 * Servlet implementation class UserData
 */
@WebServlet("/UserData")
public class UserData extends HttpServlet {
	private ServiceFacade serviceFacade ;
	public ModelUserData modelUserData;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserData() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() throws ServletException{
    	serviceFacade = new ServiceFacade();
    	modelUserData = new ModelUserData();
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Utilisateur user = null;
		if (session.getAttribute("user") != null) {
			user = (Utilisateur) session.getAttribute("user");
			modelUserData.setUser(user);
			modelUserData.setPrincipalAdresse(serviceFacade.getAdresseDao().findAdressesLPByIdUtilisateur(user.getIdUtilisateur()));
			modelUserData.setAdresseFacturation(serviceFacade.getAdresseDao().findAdressesFByIdUtilisateur(user.getIdUtilisateur()));
			request.setAttribute("modelUserData", modelUserData);
			this.getServletContext().getRequestDispatcher("/informations-personnelle.jsp").forward(request, response);
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
