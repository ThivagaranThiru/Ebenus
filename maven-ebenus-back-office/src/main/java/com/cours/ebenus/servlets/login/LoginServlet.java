/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.ebenus.servlets.login;

import com.cours.ebenus.entities.Utilisateur;
import com.cours.ebenus.service.IServiceFacade;
import com.cours.ebenus.service.ServiceFacade;
import java.io.IOException;
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
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    
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
        
	if (session.getAttribute("user") != null) session.removeAttribute("user");
	
        this.getServletContext().getRequestDispatcher("/pages/login/login.jsp").forward(request, response);
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
        
        Utilisateur user = null;
        
        if(serviceFacade.getUtilisateurDao() != null) user = serviceFacade.getUtilisateurDao().authenticate(request.getParameter("textinput"),request.getParameter("passdinput"));
        
        if(user != null && user.getRole() != null && user.getRole().getIdentifiant() != null && 
                (user.getRole().getIdentifiant().equals("Administrateur") || user.getRole().getIdentifiant().equals("Directeur") 
                || user.getRole().getIdentifiant().equals("Vendeur"))){
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            response.sendRedirect(request.getContextPath()  + "/DashboardServlet");
        }else {
            String message = "Votre login ou mdp sont incorrect ou vous êtes pas habilité";
            request.setAttribute("message", message);
            request.getRequestDispatcher("/pages/login/login.jsp").forward(request,response);
        }
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
