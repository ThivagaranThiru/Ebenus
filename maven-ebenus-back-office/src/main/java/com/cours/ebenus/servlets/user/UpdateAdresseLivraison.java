/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.ebenus.servlets.user;

import com.cours.ebenus.entities.Adresse;
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
@WebServlet(name = "UpdateAdresseLivraison", urlPatterns = {"/UpdateAdresseLivraison"})
public class UpdateAdresseLivraison extends HttpServlet {
    
    private IServiceFacade serviceFacade = null;
    private Adresse adresseUpdate = null;
    
    @Override
    public void init() throws ServletException {
    	serviceFacade = new ServiceFacade();
        
    }
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */


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
            
            if(request.getParameter("idAdresse") != null && serviceFacade.getAdresseDao() != null){
                adresseUpdate = serviceFacade.getAdresseDao().findAdresseById(Integer.parseInt(request.getParameter("idAdresse")));
                request.setAttribute("adresse",adresseUpdate);
            }

            this.getServletContext().getRequestDispatcher("/pages/user/updateAdresseLivraison.jsp").forward(request, response);
      
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
        
        String message = null;
        Adresse adresse = null;
        
        if(request.getParameter("street-ship") != null && request.getParameter("postalcodeShip") != null 
                && request.getParameter("cityShip") != null && request.getParameter("countryShip") != null){
            
            adresseUpdate.setRue(request.getParameter("street-ship"));
            adresseUpdate.setCodePostal(request.getParameter("postalcodeShip"));
            adresseUpdate.setVille(request.getParameter("cityShip"));
            adresseUpdate.setPays(request.getParameter("countryShip"));
            
            adresse = serviceFacade.getAdresseDao().updateAdresse(adresseUpdate);
            
            if(adresse.getIdAdresse() != null){
                response.sendRedirect(request.getContextPath() + "/UpdateUserServlet?idUser="+adresseUpdate.getIdUtilisateur());
            }else{
                message = "Votre adresse n'exite pas";
                request.setAttribute("message", message);
                request.getRequestDispatcher("/pages/user/updateAdresseLivraison.jsp").forward(request, response);
            }
            
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
