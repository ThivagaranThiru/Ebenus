package com.cours.ebenus.maven.ebenus.front.office.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cours.ebenus.service.ServiceFacade;

/**
 * Servlet implementation class DeleteController
 */
@WebServlet("/DeleteController")
public class DeleteController extends HttpServlet {
	private ServiceFacade serviceFacade;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteController() {
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
		int idArticle = Integer.parseInt(request.getParameter("id"));
		if (idArticle > 0) {
			if (serviceFacade.getArticleCommandeDao().findArticleCommandeById(idArticle) != null) {
				serviceFacade.getArticleCommandeDao().deleteArticleCommande(serviceFacade.getArticleCommandeDao().findArticleCommandeById(idArticle));
				this.getServletContext().getRequestDispatcher("/PanierContent").forward(request, response);
			}
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
