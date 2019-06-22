/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.ebenus.servlets.user;

import com.cours.ebenus.entities.Adresse;
import com.cours.ebenus.entities.Role;
import com.cours.ebenus.entities.Utilisateur;
import com.cours.ebenus.service.IServiceFacade;
import com.cours.ebenus.service.ServiceFacade;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "AddUserServlet", urlPatterns = {"/AddUserServlet"})
public class AddUserServlet extends HttpServlet {
    
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

            if(serviceFacade.getRoleDao() != null){
                List<Role> roleList = serviceFacade.getRoleDao().findAllRoles();
                request.setAttribute("roleList", roleList);
            }

            this.getServletContext().getRequestDispatcher("/pages/user/addUser.jsp").forward(request, response);
        
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
        
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Utilisateur user = null;
        Adresse adresse = null;
        Boolean active = false;
        String sex = null;
        String message = null;
        
        if(request.getParameter("checkboxes") != null) active = true;
        
        if(request.getParameter("firstName") != null && request.getParameter("secondName") != null
            && request.getParameter("select-adress") != null && request.getParameter("userSex") != null 
            && request.getParameter("adressEmail") != null && request.getParameter("dteNaiss") != null 
            && request.getParameter("passUser") != null && request.getParameter("passUserBis") != null
            && serviceFacade.getUtilisateurDao() != null && serviceFacade.getRoleDao() != null){
                      
            try {
                    
                if(request.getParameter("passUser").equals(request.getParameter("passUserBis"))){
                        
                    if("male".equals(request.getParameter("userSex"))){
                        sex = "Mr";
                    }else if("female".equals(request.getParameter("userSex"))) sex = "Mme";
                                           
                    user = serviceFacade.getUtilisateurDao().createUtilisateur(new Utilisateur(sex,
                            request.getParameter("firstName"), request.getParameter("secondName"),request.getParameter("adressEmail"),
                            request.getParameter("passUser"),simpleDateFormat.parse(request.getParameter("dteNaiss")),
                            active,serviceFacade.getRoleDao().findRoleByIdentifiant(request.getParameter("select-adress")).get(0)));
                     
                    if(user.getIdUtilisateur() != null && serviceFacade.getAdresseDao() != null){
                        
                        if(request.getParameter("shippingAdress") != null) adresse = newAdresse(request,"street-ship","postalcodeShip","cityShip","countryShip","L",true,user.getIdUtilisateur());
                            
                        if(request.getParameter("billAdress") != null) adresse = newAdresse(request,"streetBill","postalcodeBill","cityBill","countryBill","F",true,user.getIdUtilisateur());
                            
                        if(request.getParameter("BillShip") != null) adresse = newAdresse(request,"street-BillShip","postalcodeBillShip","cityBillShip","countryBillShip","L",false,user.getIdUtilisateur());
                        
                        if(adresse.getIdAdresse() != null){
                            message = "Votre Utilisateur a ete crée";
                        }else message = "Votre Utilisateur a ete crée sans d'Adresse";
                        
                        response.sendRedirect(request.getContextPath() + "/AllUsersServlet?message="+message);
                    
                    }else{
                        message = "Votre utilisateur existe déjà";
                        request.setAttribute("message", message);
                        request.getRequestDispatcher("/pages/user/addUser.jsp").forward(request, response);
                    }           
                        
                }else {
                    message = "votre mot ne ressemble pas";
                    request.setAttribute("message", message);
                    request.getRequestDispatcher("/pages/user/addUser.jsp").forward(request, response);
                }
                    
            } catch (ParseException ex) {
                Logger.getLogger(AddUserServlet.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public Adresse newAdresse(HttpServletRequest request, String rue, String codePostal, String ville, String pays, String typeAdresse, Boolean principale, Integer idUtilisateur){
        
         if(request.getParameter(rue) != null && request.getParameter(codePostal) != null && principale != null
                && request.getParameter(ville) != null && request.getParameter(pays) != null && typeAdresse != null
                && idUtilisateur != null){
                               
                return serviceFacade.getAdresseDao().createAdresse(new Adresse(request.getParameter(rue),request.getParameter(codePostal),
                        request.getParameter(ville),request.getParameter(pays),typeAdresse,principale,idUtilisateur));
         }
        
        return null;
    }
}
