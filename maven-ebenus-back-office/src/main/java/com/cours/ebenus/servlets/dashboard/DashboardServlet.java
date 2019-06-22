package com.cours.ebenus.servlets.dashboard;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.cours.ebenus.entities.ArticleCommande;
import com.cours.ebenus.entities.Utilisateur;
import com.cours.ebenus.service.IServiceFacade;
import com.cours.ebenus.service.ServiceFacade;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author thiva
 */
@WebServlet(name = "DashboardServlet", urlPatterns = {"/DashboardServlet"})
public class DashboardServlet extends HttpServlet {

    private IServiceFacade serviceFacade = null;
    
    @Override
    public void init() throws ServletException {
    	serviceFacade = new ServiceFacade();    
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        if(session.getAttribute("user") != null){
            
            request.setAttribute("user", (Utilisateur) session.getAttribute("user"));
        
            if(serviceFacade.getArticleCommandeDao() != null && serviceFacade.getArticleCommandeDao().findAllArticleCommande() != null){
                List<ArticleCommande> articleCommandeList = serviceFacade.getArticleCommandeDao().findAllArticleCommande();
                request.setAttribute("articleCommandeList", articleCommandeList);
            
            }
      
            this.getServletContext().getRequestDispatcher("/pages/dashboard/dashboard.jsp").forward(request, response);
        
        }else response.sendRedirect(request.getContextPath()  + "/LoginServlet");
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
         this.doGet(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
