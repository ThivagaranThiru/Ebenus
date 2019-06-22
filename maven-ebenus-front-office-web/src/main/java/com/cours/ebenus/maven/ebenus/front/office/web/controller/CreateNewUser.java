package com.cours.ebenus.maven.ebenus.front.office.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cours.ebenus.entities.Utilisateur;
import com.cours.ebenus.service.ServiceFacade;

/**
 * Servlet implementation class CreateNewUser
 */
@WebServlet("/Create")
public class CreateNewUser extends HttpServlet {
	private ServiceFacade serviceFacade ; 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	@Override
	public void init() throws ServletException{
		serviceFacade = new ServiceFacade();
	}
    public CreateNewUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = null ;
		Utilisateur newUser = null;
		//HttpSession session = request.getSession();
		if (request.getAttribute("newUser") == null) {
			if (!request.getParameter("email").isEmpty()) {
				email = request.getParameter("email");			
				newUser = new Utilisateur();
				newUser.setIdentifiant(email);
			//	session.setAttribute("newUser", newUser);
				request.setAttribute("newUser", newUser);
				this.getServletContext().getRequestDispatcher("/creer-compte-client.jsp").forward(request, response);;
				//session.setMaxInactiveInterval(10);
				System.out.println("mail");
				
			}
		}else {
			newUser = (Utilisateur) request.getAttribute("newUser");
			request.removeAttribute("newUser");
			this.getServletContext().getRequestDispatcher("/creer-compte-client.jsp").forward(request, response);
			System.out.println("s enregistrer");
		//	Utilisateur u = (Utilisateur)session.getAttribute("newUser");
		//	System.out.println(u.getIdentifiant());
		}
	}

}
