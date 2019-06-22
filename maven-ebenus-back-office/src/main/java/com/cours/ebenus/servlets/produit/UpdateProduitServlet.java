/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.ebenus.servlets.produit;

import com.cours.ebenus.entities.Produit;
import com.cours.ebenus.entities.Utilisateur;
import com.cours.ebenus.service.IServiceFacade;
import com.cours.ebenus.service.ServiceFacade;
import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet(name = "UpdateProduitServlet", urlPatterns = {"/UpdateProduitServlet"})
public class UpdateProduitServlet extends HttpServlet {
    
    private IServiceFacade serviceFacade = null;
    private Produit updateProduit = null;
    
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
        
            if(request.getParameter("idProduit") != null && serviceFacade.getProduitDao() != null){
                updateProduit = serviceFacade.getProduitDao().findProduitById(Integer.parseInt(request.getParameter("idProduit")));
                if(updateProduit.getActif()) request.setAttribute("checked","checked");
                request.setAttribute("updateProduit",updateProduit);
            }

            this.getServletContext().getRequestDispatcher("/pages/produit/updateProduit.jsp").forward(request, response);
        
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
        
        Produit produit = null;
        Boolean active = false;
        String message = null;
        
        if(request.getParameter("checkboxes") != null) active = true;
        
          if(request.getParameter("reference") != null && request.getParameter("nomProduit") != null
                && request.getParameter("prix") != null && request.getParameter("stock") != null
                && request.getParameter("description") != null && updateProduit != null && serviceFacade.getProduitDao() != null){
              
                updateProduit.setReference(request.getParameter("reference"));
                updateProduit.setNom(request.getParameter("nomProduit"));
                updateProduit.setPrix(Double.parseDouble(request.getParameter("prix")));
                updateProduit.setStock(Integer.parseInt(request.getParameter("stock")));
                updateProduit.setActif(active);
                updateProduit.setDescription(request.getParameter("description"));
              
                produit = serviceFacade.getProduitDao().updateProduit(updateProduit);
              
                if(produit.getIdProduit() != null){
                    message = "Votre produit a ete mise a jour";
                }else message = "Votre produit n'existe pas";
              
                response.sendRedirect(request.getContextPath() + "/AllProduitsServlet?message="+message);
              
        }else this.doGet(request, response);
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
