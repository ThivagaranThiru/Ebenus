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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.storm.shade.org.apache.commons.fileupload.FileItem;
import org.apache.storm.shade.org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.storm.shade.org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author thiva
 */
@WebServlet(name = "AllProduitsServlet", urlPatterns = {"/AllProduitsServlet"})
public class AllProduitsServlet extends HttpServlet {
    
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
        List<Produit> produitList = null;
        
        if(session.getAttribute("user") != null){
            
            request.setAttribute("user", (Utilisateur) session.getAttribute("user"));
            
            if(request.getParameter("idProduit") != null && serviceFacade.getProduitDao() != null){
                Produit produit = serviceFacade.getProduitDao().findProduitById(Integer.parseInt(request.getParameter("idProduit")));
                serviceFacade.getProduitDao().deleteProduit(produit);
            }
        
            if(request.getParameter("q") != null && serviceFacade.getProduitDao() != null){

               if(serviceFacade.getProduitDao().findProduitsByNom(request.getParameter("q")).size() > 0){

                    produitList = serviceFacade.getProduitDao().findProduitsByNom(request.getParameter("q"));

                }else if(serviceFacade.getProduitDao().findProduitByReference(request.getParameter("q")).size() > 0){

                    produitList = serviceFacade.getProduitDao().findProduitByReference(request.getParameter("q"));

                }else if(isInteger(request.getParameter("q"))){

                    Integer idProduit = Integer.parseInt(request.getParameter("q"));

                    if(serviceFacade.getProduitDao().findProduitById(idProduit) != null){
                        produitList = new ArrayList<Produit>();
                        produitList.add(serviceFacade.getProduitDao().findProduitById(idProduit));
                    }    
                } 
            }

            if(produitList == null && serviceFacade.getProduitDao() != null && serviceFacade.getProduitDao().findAllProduits() != null) produitList = serviceFacade.getProduitDao().findAllProduits();

            request.setAttribute("produitList", produitList);

            this.getServletContext().getRequestDispatcher("/pages/produit/allProduits.jsp").forward(request, response);
   
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
        
        
        if(ServletFileUpload.isMultipartContent(request)){
            try {
                List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
               
                for(FileItem item : multiparts){
                    if(!item.isFormField() &&  item.getInputStream() != null) importCsv(item.getInputStream());
                }
                
                request.setAttribute("message", "Le fichier CSV a ete importe");
                
            } catch (Exception e) {
               request.setAttribute("message", "Le fichier n'a pas été importe à cause de " + e);
            }          
        }
        
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
    }// </editor-fold>ù
    
    public static boolean isInteger(String s) {
        try { 
            Integer.parseInt(s); 
        } catch(NumberFormatException e) { 
            return false; 
        } catch(NullPointerException e) {
            return false;
        }
        return true;
    }
    
    public void importCsv(InputStream file) {
    	BufferedReader buffer = null;
    	String [] parts = null;
    	String line = null;
    	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        
    	try {
            if(file != null) {
		buffer = new BufferedReader(new InputStreamReader(file));
                buffer.readLine();
				
		while((line = buffer.readLine()) != null) {
                    parts = line.split(";");
                    if(parts != null && parts[0] != null && parts[1] != null && parts[2] != null && parts[3] != null && 
                        parts[4] != null && parts[5] != null && serviceFacade.getProduitDao() != null ) {
                        
                        Produit produit = new Produit(parts[0],Double.parseDouble(parts[1]),parts[2],parts[3],Integer.parseInt(parts[4]), Integer.parseInt(parts[5]) == 1 ? true : false);
                        
                        if(serviceFacade.getProduitDao().createProduit(produit).getIdProduit() == null && produit.getReference() != null
                                && serviceFacade.getProduitDao().findProduitByReference(produit.getReference()).get(0) != null){
                            
                            Produit produitCsv = serviceFacade.getProduitDao().findProduitByReference(produit.getReference()).get(0);
                            produitCsv.setReference(produit.getReference());
                            produitCsv.setPrix(produit.getPrix());
                            produitCsv.setNom(produit.getNom());
                            produitCsv.setDescription(produit.getDescription());
                            produitCsv.setStock(produit.getStock());
                            produitCsv.setActif(produit.getActif());
                            
                            serviceFacade.getProduitDao().updateProduit(produitCsv);
                        }
                    }
		}
            }	
	} catch (Exception e) {
            // TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
            try {
                if (buffer != null) {
                    buffer.close();
                }
            } catch (Exception e) {
            // TODO Auto-generated catch block
		e.printStackTrace();
            }
	}
    } 
}
