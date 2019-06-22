/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.ebenus.servlets.role;

import com.cours.ebenus.entities.Role;
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
@WebServlet(name = "UpdateRoleServle", urlPatterns = {"/UpdateRoleServle"})
public class UpdateRoleServlet extends HttpServlet {
   
    private IServiceFacade serviceFacade = null;
    private Role roleUpdate= null;
    
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
            
            if(request.getParameter("idRole") != null && serviceFacade.getRoleDao() != null){
                String idRole = request.getParameter("idRole");
                roleUpdate = serviceFacade.getRoleDao().findRoleById(Integer.parseInt(idRole));
                request.setAttribute("roleUpdate", roleUpdate);
            }

            this.getServletContext().getRequestDispatcher("/pages/role/updateRole.jsp").forward(request, response);
        
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
        
        if(request.getParameter("idRole") != null && request.getParameter("desRole") != null
                && serviceFacade.getRoleDao() != null){
            
            roleUpdate.setIdentifiant(request.getParameter("idRole"));
            roleUpdate.setDescription(request.getParameter("desRole"));
            
            Role roleu = serviceFacade.getRoleDao().updateRole(roleUpdate);
            
            if(roleu.getIdRole() != null){
                 response.sendRedirect(request.getContextPath() + "/AllRolesServlet?message=Votre role update");
            }else{
                message = "Votre role n'existe pas";
                request.setAttribute("message", message);
                request.getRequestDispatcher("/pages/role/updateRole.jsp").forward(request, response);
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
