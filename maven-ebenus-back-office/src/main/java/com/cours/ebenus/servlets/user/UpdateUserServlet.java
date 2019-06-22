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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
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
@WebServlet(name = "UpdateUserServlet", urlPatterns = {"/UpdateUserServlet"})
public class UpdateUserServlet extends HttpServlet {
    
    private IServiceFacade serviceFacade = null;
    private Adresse adresseUpdate = null;
    private Utilisateur utilisateurUpdate = null;
    
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
            
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Iterator<Adresse> iterator = null;
            request.setAttribute("user", (Utilisateur) session.getAttribute("user"));
            
            request.setAttribute("checkMale","checked=checked");
            
            if(serviceFacade.getRoleDao() != null){
                List<Role> roleList = serviceFacade.getRoleDao().findAllRoles();
                request.setAttribute("roleList", roleList);
            }
        
            if(request.getParameter("idAdresse") != null && serviceFacade.getAdresseDao() != null){
                String idAdresse = request.getParameter("idAdresse");
                Adresse adresseDelete = serviceFacade.getAdresseDao().findAdresseById(Integer.parseInt(idAdresse));
                serviceFacade.getAdresseDao().deleteAdresse(adresseDelete);
            }
        
            if(request.getParameter("idUser") != null && serviceFacade.getUtilisateurDao() != null){
                String idUser = request.getParameter("idUser");
                utilisateurUpdate = serviceFacade.getUtilisateurDao().findUtilisateurById(Integer.parseInt(idUser));
             
                iterator = utilisateurUpdate.getAdresse().iterator();
                
                while(iterator.hasNext()){
                    Adresse adresse = iterator.next();
                    if(adresse.getTypeAdresse().equals("F")){
                        request.setAttribute("adresse", adresse);
                        adresseUpdate = adresse;
                    }
                }
            
                if(utilisateurUpdate.getActif()) request.setAttribute("checked","checked");
                if(utilisateurUpdate.getCivilite().endsWith("Mme")) request.setAttribute("checkFemale","checked=checked");
                if(utilisateurUpdate.getDateNaissance() != null) request.setAttribute("dateNai", dateFormat.format(utilisateurUpdate.getDateNaissance()));
                request.setAttribute("updateUser", utilisateurUpdate);
            } 
        
            this.getServletContext().getRequestDispatcher("/pages/user/updateUser.jsp").forward(request, response);
       
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
        
        String sex = null;
        Boolean active = false;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String message = null;
        
        if(request.getParameter("checkboxes") != null) active = true;
        
         if(request.getParameter("firstName") != null && request.getParameter("secondName") != null
            && request.getParameter("select-rol") != null && request.getParameter("userSex") != null 
            && request.getParameter("adressEmail") != null && request.getParameter("dteNaiss") != null 
            && request.getParameter("passUser") != null && request.getParameter("passUserBis") != null
            && serviceFacade.getUtilisateurDao() != null && serviceFacade.getRoleDao() != null){
             
                if(request.getParameter("passUser").equals(request.getParameter("passUserBis"))){
                        
                    if("male".equals(request.getParameter("userSex"))){
                        sex = "Mr";
                    }else if("female".equals(request.getParameter("userSex"))) sex = "Mme";
                    
                    if(utilisateurUpdate != null){
                        
                        try {
                            utilisateurUpdate.setCivilite(sex);
                            utilisateurUpdate.setPrenom(request.getParameter("firstName"));
                            utilisateurUpdate.setNom(request.getParameter("secondName"));
                            utilisateurUpdate.setIdentifiant(request.getParameter("adressEmail"));
                            utilisateurUpdate.setDateNaissance(simpleDateFormat.parse(request.getParameter("dteNaiss")));
                            utilisateurUpdate.setActif(active);
                            utilisateurUpdate.setMotPasse(request.getParameter("passUser"));
                            utilisateurUpdate.setRole(serviceFacade.getRoleDao().findRoleByIdentifiant(request.getParameter("select-rol")).get(0));
                           
                            serviceFacade.getUtilisateurDao().updateUtilisateur(utilisateurUpdate);
                            
                            if(adresseUpdate == null) adresseUpdate = new Adresse();
                            
                            if(request.getParameter("street-Bill") != null && request.getParameter("postalcodeBill") != null
                                && request.getParameter("cityBill") != null && request.getParameter("countryBill") != null
                                && serviceFacade.getAdresseDao() != null){
                                
                                adresseUpdate.setRue(request.getParameter("street-Bill"));
                                adresseUpdate.setCodePostal(request.getParameter("postalcodeBill"));
                                adresseUpdate.setVille(request.getParameter("cityBill"));
                                adresseUpdate.setPays(request.getParameter("countryBill"));
                                
                                if(adresseUpdate.getIdAdresse() == null) {
                                    adresseUpdate.setTypeAdresse("F");
                                    adresseUpdate.setPrincipale(true);
                                    adresseUpdate.setIdUtilisateur(utilisateurUpdate.getIdUtilisateur());
                                    serviceFacade.getAdresseDao().createAdresse(adresseUpdate);
                                }else serviceFacade.getAdresseDao().updateAdresse(adresseUpdate);
                            }
                            
                            message = "votre Uilisateur a été mise à jour";
                        } catch (ParseException ex) {
                            Logger.getLogger(UpdateUserServlet.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                    }else message = "Votre Utilisateur n'existe pas";
                    
                    response.sendRedirect(request.getContextPath() + "/AllUsersServlet?message="+message);
                    
                }else{
                    message = "votre mot ne ressemble pas";
                    request.setAttribute("message", message);
                    request.getRequestDispatcher("/pages/user/updateUser.jsp").forward(request, response);
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
