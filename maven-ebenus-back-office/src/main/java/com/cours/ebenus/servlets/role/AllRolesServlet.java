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
import java.util.Iterator;
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
@WebServlet(name = "AllRolesServlet", urlPatterns = {"/AllRolesServlet"})
public class AllRolesServlet extends HttpServlet {
    
    private IServiceFacade serviceFacade = null;
    
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
            Iterator<Utilisateur> iterator = null;
            
            if(request.getParameter("idRole") != null && serviceFacade.getRoleDao() != null
                && serviceFacade.getUtilisateurDao() != null){
                
                String idRole = request.getParameter("idRole");
                Role role = serviceFacade.getRoleDao().findRoleById(Integer.parseInt(idRole));
                iterator = serviceFacade.getUtilisateurDao().findAllUtilisateurs().iterator();
            
                while(iterator.hasNext()){
                    Utilisateur user = iterator.next();
                    if(user.getRole().equals(role)){
                        user.setRole(serviceFacade.getRoleDao().findRoleByIdentifiant("RolePoubelle").get(0));
                        serviceFacade.getUtilisateurDao().updateUtilisateur(user);
                    }
                }
            
                serviceFacade.getRoleDao().deleteRole(role);
            }
        
            if(serviceFacade.getRoleDao() != null && serviceFacade.getRoleDao().findAllRoles() != null){
                List<Role> roleList = serviceFacade.getRoleDao().findAllRoles();
                request.setAttribute("roleList", roleList);
            }
        
            this.getServletContext().getRequestDispatcher("/pages/role/allRoles.jsp").forward(request, response);
       
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
