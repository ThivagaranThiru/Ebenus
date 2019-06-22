/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.ebenus.servlets.commande;

import com.cours.ebenus.entities.Commande;
import com.cours.ebenus.entities.Utilisateur;
import com.cours.ebenus.service.IServiceFacade;
import com.cours.ebenus.service.ServiceFacade;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.apache.storm.shade.org.json.simple.JSONArray;
import org.apache.storm.shade.org.json.simple.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author thiva
 */

@WebServlet(name = "AllCommandesServlet", urlPatterns = {"/AllCommandesServlet"})
public class AllCommandesServlet extends HttpServlet {

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
        List<Commande> commandeList = null;
        
        if(session.getAttribute("user") != null){
            
            request.setAttribute("user", (Utilisateur) session.getAttribute("user"));
        
            if(request.getParameter("idCommande") != null && serviceFacade.getCommandeDao() != null){
                String idCommande = request.getParameter("idCommande");
                Commande commandeDele = serviceFacade.getCommandeDao().findCommandeById(Integer.parseInt(idCommande));
                serviceFacade.getCommandeDao().deleteCommande(commandeDele);
            }

            if(request.getParameter("selectexport") != null){
                File file = null;

                switch(request.getParameter("selectexport")){
                    case "CSV" : file = exportCsv();
                                 break;
                    case "XML" : file = exportXml();
                                 break;   
                    case "JSON" : file = exportJson();
                                  break;
                    default: 
                            break;
                }

                if(file != null) {
                    response.setContentType("application/download");
                    response.setHeader("Content-Disposition", "attachment;filename=\"" + file.getName() + "\""); 
                    if(response.getWriter() != null){
                        PrintWriter out = response.getWriter();

                        FileInputStream fileInputStream = new FileInputStream(file);

                        int i;
                        while ((i = fileInputStream.read()) != -1) {
                            out.write(i);
                        }

                        fileInputStream.close();
                        out.close();
                    }
                }
            }


            if(request.getParameter("q") != null && serviceFacade.getCommandeDao() != null
                     && serviceFacade.getUtilisateurDao() != null){

                 if(serviceFacade.getUtilisateurDao().findUtilisateursByIdentifiant(request.getParameter("q")).size() > 0 
                         && serviceFacade.getUtilisateurDao().findUtilisateursByIdentifiant(request.getParameter("q")).get(0) != null 
                         && serviceFacade.getUtilisateurDao().findUtilisateursByIdentifiant(request.getParameter("q")).get(0).getIdUtilisateur() != null 
                        && serviceFacade.getCommandeDao().findCommandesByIdUtilisateur(serviceFacade.getUtilisateurDao().findUtilisateursByIdentifiant(request.getParameter("q")).get(0).getIdUtilisateur()).size() > 0){

                     commandeList = serviceFacade.getCommandeDao().findCommandesByIdUtilisateur(serviceFacade.getUtilisateurDao().findUtilisateursByIdentifiant(request.getParameter("q")).get(0).getIdUtilisateur());

                 }else if(isInteger(request.getParameter("q"))){

                        Integer idCommande = Integer.parseInt(request.getParameter("q"));

                        if(serviceFacade.getCommandeDao().findCommandeById(idCommande) != null){
                            commandeList = new ArrayList<Commande>();
                            commandeList.add(serviceFacade.getCommandeDao().findCommandeById(idCommande));
                        }
                 }
             }

            if(commandeList == null && serviceFacade.getCommandeDao() != null && serviceFacade.getCommandeDao().findAllCommandes() != null){
                 commandeList = serviceFacade.getCommandeDao().findAllCommandes();
            }

            request.setAttribute("commandeList", commandeList);

            this.getServletContext().getRequestDispatcher("/pages/commande/allCommandes.jsp").forward(request, response);
            
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
   
    public File exportCsv() {
        File fileCSV = null;
    	BufferedWriter buffwrite = null;
        Iterator<Commande> it = null;
        List<Commande> commandeList = null;
        
	try {
            
            fileCSV = new File("ExportCommandeCSV.csv");
            buffwrite = new BufferedWriter(new FileWriter(fileCSV));
            commandeList = serviceFacade.getCommandeDao().findAllCommandes();
	    	
            if(commandeList.iterator() != null) {
		it = commandeList.iterator();		
                while(it.hasNext()){
                    Commande commande = it.next();
                    if(commande != null && commande.getUtilisateur() != null && commande.getUtilisateur().getIdUtilisateur() != null
                            && commande.getUtilisateur().getIdentifiant() != null && commande.getIdCommande() != null
                            && commande.getTotalCommande() != null && commande.getDateCommande() != null) {
						
                        buffwrite.write(commande.getUtilisateur().getIdUtilisateur() + ";");
                        buffwrite.write(commande.getUtilisateur().getIdentifiant()+ ";");
                        buffwrite.write(commande.getIdCommande()+ ";");
                        buffwrite.write(commande.getTotalCommande() + ";");
                        buffwrite.write(commande.getDateCommande()  + ";");
                        buffwrite.write("REF-TELE-SAMSUNG-3D;");
                        buffwrite.write("REF-TELE-SAMSUNG-3D;");
                        buffwrite.newLine();
                    }
                }
            }	
	} catch (IOException e) {
            // TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
            try {
                if (buffwrite != null) {
                    buffwrite.close();
                }
            } catch (Exception e) {
		// TODO Auto-generated catch block
                    e.printStackTrace();
	    }
	}
        
        return fileCSV;
    }
    
        
    public File exportXml() {
            
        List<Commande> commandeList = null;
        Iterator<Commande> it = null;
        File fileXml = null;
            
        try {
			
            fileXml = new File("ExportCommandeXml.xml");
            commandeList = serviceFacade.getCommandeDao().findAllCommandes();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                
            if(commandeList.iterator() != null) {
                it = commandeList.iterator();		
				
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document document = builder.newDocument();
				
                Element commandeNode = document.createElement("Commandes");
                document.appendChild(commandeNode);
				
                while(it.hasNext()){
                    Commande commande = it.next();
                    if(commande != null && commande.getUtilisateur() != null && commande.getUtilisateur().getIdUtilisateur() != null
                            && commande.getUtilisateur().getIdentifiant() != null && commande.getIdCommande() != null
                            && commande.getTotalCommande() != null && commande.getDateCommande() != null) {
						
			Element commandeElement = document.createElement("Commande");
			commandeNode.appendChild(commandeElement);
						
			createElement(document,"IdUtilisateur",commande.getUtilisateur().getIdUtilisateur().toString(),commandeElement);
			createElement(document,"identifiant",commande.getUtilisateur().getIdentifiant(),commandeElement);
			createElement(document,"numeroCommande",commande.getIdCommande().toString(),commandeElement);
			createElement(document,"totalCommande",commande.getTotalCommande().toString(),commandeElement);
			createElement(document,"dateCommande",dateFormat.format(commande.getDateCommande()),commandeElement);
                        Element articleElement = document.createElement("articlesCommande");
                        commandeElement.appendChild(articleElement);
                        createElement(document,"produit","REF-TELE-SAMSUNG-3D",articleElement );
                        createElement(document,"produit","REF-TELE-SAMSUNG-3D",articleElement);
                    }
		}
				
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(document);
		StreamResult result = new StreamResult(fileXml);

		transformer.transform(source, result);
            }
			
	} catch (Exception e) {
            // TODO Auto-generated catch block
		e.printStackTrace();
	}	
        
        return fileXml;
    }
    
    public void createElement(Document document,String valeur,String liste, Element element) {
    	Element newElement = document.createElement(valeur);
        newElement.appendChild(document.createTextNode(liste));
	element.appendChild(newElement);
    }
    
    public File exportJson() {
    	
    	File fileJson = null;
        List<Commande> commandeList = null;
        Iterator<Commande> it = null;
    	FileWriter file = null;
    	JSONArray pers = null;
    	JSONObject json = null;
    	
	try {
	
            fileJson = new File("ExportCommandeJson.json");
            commandeList = serviceFacade.getCommandeDao().findAllCommandes();
            
            if(commandeList.iterator() != null) {
                it = commandeList.iterator();
	    	pers = new JSONArray();
	    		
		while(it.hasNext()){
                    Commande commande = it.next();
                    if(commande != null && commande.getUtilisateur() != null && commande.getUtilisateur().getIdUtilisateur() != null
                            && commande.getUtilisateur().getIdentifiant() != null && commande.getIdCommande() != null
                            && commande.getTotalCommande() != null && commande.getDateCommande() != null) {
						
			json = new JSONObject();
			json.put("IdUtilisateur",commande.getUtilisateur().getIdUtilisateur());
			json.put("numeroCommande",commande.getIdCommande());
			json.put("identifiant",commande.getUtilisateur().getIdentifiant());
			json.put("totalCommande",commande.getTotalCommande());
			json.put("dateCommande",commande.getDateCommande());
			pers.add(json);
                    }
		}
				
		json = new JSONObject();
		json.put("Commandes",pers);
		file = new FileWriter(fileJson);
		file.write(json.toJSONString());
		file.flush();
            }
			
	} catch (Exception e) {
            // TODO Auto-generated catch block
		e.printStackTrace();
        }finally {
            if (file != null) {
		try {
                    file.close();
		} catch (Exception e) {
                    // TODO Auto-generated catch block
			e.printStackTrace();
	        }
            }
	}
        
        return fileJson;
    }
}


