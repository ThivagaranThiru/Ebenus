package com.cours.ebenus.dao.impl;

import com.cours.ebenus.dao.ConnectionHelper;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.cours.ebenus.dao.IArticleCommandeDao;
import com.cours.ebenus.entities.ArticleCommande;
import com.cours.ebenus.service.IServiceFacade;
import com.cours.ebenus.service.ServiceFacade;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ArticleCommandeDao implements IArticleCommandeDao {
	
	private static final Log log = LogFactory.getLog(ArticleCommandeDao.class);
	
	private Connection conn = null;
	
	public ArticleCommandeDao(Connection connexion){
		this.conn = connexion;
	}
	
	@Override
	public List<ArticleCommande> findAllArticleCommande() {
		// TODO Auto-generated method stub
            
            List<ArticleCommande> articleCommande = new ArrayList<ArticleCommande>();
            PreparedStatement stmt = null;
            ResultSet result = null;
            
            try {
                
                stmt = this.conn.prepareStatement("SELECT * FROM ArticleCommande");
                result = stmt.executeQuery();
                
                if(result != null) {
                    while(result.next()) {				
			articleCommande.add(createArticleCommandeWithSQLObject(result));
                    }
		}
            
            } catch (SQLException ex) {
                Logger.getLogger(ArticleCommandeDao.class.getName()).log(Level.SEVERE, null, ex);
            }finally {
	
		ConnectionHelper.closeSqlResources(stmt, result);
            }
            
            return articleCommande;
	}

	@Override
	public ArticleCommande findArticleCommandeById(int idArticleCommande) {
		// TODO Auto-generated method stub
            
            PreparedStatement stmt = null;
            ResultSet result = null;
            
            try {
                
                stmt = this.conn.prepareStatement("SELECT * FROM ArticleCommande WHERE idArticleCommande = ? ");
                stmt.setInt(1,idArticleCommande);
		result = stmt.executeQuery();
            
                if(result.first() != false) return createArticleCommandeWithSQLObject(result);
            
            } catch (SQLException ex) {
                Logger.getLogger(ArticleCommandeDao.class.getName()).log(Level.SEVERE, null, ex);
            }finally {
	
		ConnectionHelper.closeSqlResources(stmt, result);
            }
            	
            return null;
	}

	@Override
	public ArticleCommande findArticleCommandeByReferenceArticleCommande(String referenceArticleCommande) {
		// TODO Auto-generated method stub
            
            PreparedStatement stmt = null;
            ResultSet result = null;
            
            try {
                
                stmt = this.conn.prepareStatement("SELECT * FROM ArticleCommande WHERE reference like ? ");
                stmt.setString(1,referenceArticleCommande);
                result = stmt.executeQuery();
					
		if(result.first() != false) return createArticleCommandeWithSQLObject(result);
           
            } catch (SQLException ex) {
                Logger.getLogger(ArticleCommandeDao.class.getName()).log(Level.SEVERE, null, ex);
            }finally {
			
		ConnectionHelper.closeSqlResources(stmt, result);
            }
            
            return null;
	}

	@Override
	public List<ArticleCommande> findArticleCommandeByIdCommande(int idCommande) {
		// TODO Auto-generated method stub
                
            List<ArticleCommande> articleCommande = new ArrayList<ArticleCommande>();
            
            PreparedStatement stmt = null;
            ResultSet result = null;
            
            try {
                stmt = this.conn.prepareStatement("SELECT * FROM ArticleCommande WHERE idCommande = ? ");
                stmt.setInt(1,idCommande);
		result = stmt.executeQuery();
                
                if(result != null) {
		    while(result.next()) {
		    	articleCommande.add(createArticleCommandeWithSQLObject(result));
		    }
		}
            
            } catch (SQLException ex) {
                Logger.getLogger(ArticleCommandeDao.class.getName()).log(Level.SEVERE, null, ex);
            }finally {
			
		ConnectionHelper.closeSqlResources(stmt, result);
            }
            
            return articleCommande;
	}

	@Override
	public List<ArticleCommande> findArticleCommandeByIdUtilisateur(int idUtilisateur) {
		// TODO Auto-generated method stub
            List<ArticleCommande> articleCommande = new ArrayList<ArticleCommande>();
            
            PreparedStatement stmt = null;
            ResultSet result = null;
            
            try {
                stmt = this.conn.prepareStatement("SELECT * FROM ArticleCommande WHERE idUtilisateur = ? ");
                stmt.setInt(1,idUtilisateur);
		result = stmt.executeQuery();
                
                if(result != null) {
                    while(result.next()) {
    			articleCommande.add(createArticleCommandeWithSQLObject(result));
                    }
    		}
                
            } catch (SQLException ex) {
                Logger.getLogger(ArticleCommandeDao.class.getName()).log(Level.SEVERE, null, ex);
            }finally {
	
		ConnectionHelper.closeSqlResources(stmt, result);
            }
            
            return articleCommande;
	}

	@Override
	public List<ArticleCommande> findArticleCommandeByIdAdresse(int idAdresse) {
		// TODO Auto-generated method stub
            List<ArticleCommande> articleCommande = new ArrayList<ArticleCommande>();
            
            PreparedStatement stmt = null;
            ResultSet result = null;
            
            try {
                stmt = this.conn.prepareStatement("SELECT * FROM ArticleCommande WHERE idAdresse = ? ");
                stmt.setInt(1,idAdresse);
		result = stmt.executeQuery();
                
                if(result != null) {
		    while(result.next()) {
		    	articleCommande.add(createArticleCommandeWithSQLObject(result));
		    }
		}
            
            } catch (SQLException ex) {
                Logger.getLogger(ArticleCommandeDao.class.getName()).log(Level.SEVERE, null, ex);
            }finally {
			
		ConnectionHelper.closeSqlResources(stmt, result);
            }
            
            return articleCommande;
	}

	@Override
	public List<ArticleCommande> findArticleCommandeByIdProduit(int idProduit) {
		// TODO Auto-generated method stub
            
            List<ArticleCommande> articleCommande = new ArrayList<ArticleCommande>();
            
            PreparedStatement stmt = null;
            ResultSet result = null;
            
            try {
                stmt = this.conn.prepareStatement("SELECT * FROM ArticleCommande WHERE idProduit = ? ");
                stmt.setInt(1,idProduit);
		result = stmt.executeQuery();
            
                if(result != null) {
                    while(result.next()) {
    			articleCommande.add(createArticleCommandeWithSQLObject(result));
                    }
    		}
            
            } catch (SQLException ex) {
                Logger.getLogger(ArticleCommandeDao.class.getName()).log(Level.SEVERE, null, ex);
            }finally {
	
		ConnectionHelper.closeSqlResources(stmt, result);
            }
            
            return articleCommande;
	}
        
        @Override
        public List<ArticleCommande> findArticleCommandeTByIdUtilisateur(int idUtilisateur) {
            List<ArticleCommande> articleCommande = new ArrayList<ArticleCommande>();
            
            PreparedStatement stmt = null;
            ResultSet result = null;
                      
            try {
                stmt = this.conn.prepareStatement("SELECT * FROM ArticleCommande WHERE idUtilisateur = ? AND statut like 'T'");
                stmt.setInt(1,idUtilisateur);
		result = stmt.executeQuery();
                
                if(result != null) {
                    while(result.next()) {
    			articleCommande.add(createArticleCommandeWithSQLObject(result));
                    }
    		}
            
            } catch (SQLException ex) {
                Logger.getLogger(ArticleCommandeDao.class.getName()).log(Level.SEVERE, null, ex);
            }finally {
	
		ConnectionHelper.closeSqlResources(stmt, result);
            }
            
            return articleCommande;
        }

        @Override
        public List<ArticleCommande> findArticleCommandeVByIdUtilisateur(int idUtilisateur) {
            
            List<ArticleCommande> articleCommande = new ArrayList<ArticleCommande>();
            
            PreparedStatement stmt = null;
            ResultSet result = null;
            
            try {
                stmt = this.conn.prepareStatement("SELECT * FROM ArticleCommande WHERE idUtilisateur = ? AND statut like 'V'");
                stmt.setInt(1,idUtilisateur);
		result = stmt.executeQuery();
                
                if(result != null) {
                    while(result.next()) {
    			articleCommande.add(createArticleCommandeWithSQLObject(result));
                    }
    		}

            
            } catch (SQLException ex) {
                Logger.getLogger(ArticleCommandeDao.class.getName()).log(Level.SEVERE, null, ex);
            }finally {
	
		ConnectionHelper.closeSqlResources(stmt, result);
            }
            
            return articleCommande;
        }

	@Override
	public ArticleCommande createArticleCommande(ArticleCommande articleCommande) {
		// TODO Auto-generated method stub
            
            PreparedStatement stmt = null;
            ResultSet result = null;
            
            try {
                stmt = this.conn.prepareStatement("INSERT INTO ArticleCommande(idCommande,idUtilisateur,idAdresse,idProduit,totalArticleCommande,reference,quantite,statut,dateModification) VALUES(?,?,?,?,?,?,?,?,?)");
                
                stmt.setInt(1, articleCommande.getCommande().getIdCommande());
    		stmt.setInt(2, articleCommande.getUtilisateur().getIdUtilisateur());
    		stmt.setInt(3, articleCommande.getAdresse().getIdAdresse());
    		stmt.setInt(4, articleCommande.getProduit().getIdProduit());
    		stmt.setDouble(5, articleCommande.getTotalArticleCommande());
    		stmt.setString(6, articleCommande.getReference());
    		stmt.setInt(7, articleCommande.getQuantite());
    		stmt.setString(8, articleCommande.getStatut());
                Date sqlDate = new Date(articleCommande.getDateModification().getTime());
                stmt.setDate(9, sqlDate);
   
    		stmt.executeUpdate();
                
                stmt = this.conn.prepareStatement("SELECT MAX(idArticleCommande) FROM ArticleCommande");
                result = stmt.executeQuery();
                
                if(result.first() != false) articleCommande = findArticleCommandeById(result.getInt("MAX(idArticleCommande)"));
            
            } catch (SQLException ex) {
                Logger.getLogger(ArticleCommandeDao.class.getName()).log(Level.SEVERE, null, ex);
            }finally {

                ConnectionHelper.closeSqlResources(stmt, result);
            }
           	
            return articleCommande;
	}

	@Override
	public ArticleCommande updateArticleCommande(ArticleCommande articleCommande) {
		// TODO Auto-generated method stub
            
            PreparedStatement stmt = null;
            ResultSet result = null;
            
            if(articleCommande.getIdArticleCommande() > 0 && findArticleCommandeById(articleCommande.getIdArticleCommande()) == null) return articleCommande;
               
            try {
                if(articleCommande.getIdArticleCommande() != null && articleCommande.getTotalArticleCommande() != null
                        && articleCommande.getReference() != null && articleCommande.getQuantite() != null
                        && articleCommande.getStatut() != null  && articleCommande.getDateModification() != null
                        && articleCommande.getVersion() != null && articleCommande.getCommande().getIdCommande() != null
                        && articleCommande.getUtilisateur().getIdUtilisateur() != null && articleCommande.getAdresse().getIdAdresse() != null
                        && articleCommande.getProduit().getIdProduit() != null) 
                
                    stmt = this.conn.prepareStatement("UPDATE ArticleCommande SET idCommande = ?, idUtilisateur = ?, idAdresse = ?, idProduit = ?, "
                            + "totalArticleCommande = ?, reference = ?, quantite = ?, statut = ?, dateModification = ?, version = ? WHERE idArticleCommande = ?");
                
                    stmt.setInt(1, articleCommande.getCommande().getIdCommande());
                    stmt.setInt(2, articleCommande.getUtilisateur().getIdUtilisateur());
                    stmt.setInt(3, articleCommande.getAdresse().getIdAdresse());
                    stmt.setInt(4, articleCommande.getProduit().getIdProduit());
                    stmt.setDouble(5, articleCommande.getTotalArticleCommande());
                    stmt.setString(6, articleCommande.getReference());
                    stmt.setInt(7, articleCommande.getQuantite());
                    stmt.setString(8, articleCommande.getStatut());
                    Date sqlDate = new Date(articleCommande.getDateModification().getTime());
                    stmt.setDate(9, sqlDate);
                    stmt.setInt(10, articleCommande.getVersion());
                    stmt.setInt(11, articleCommande.getIdArticleCommande());
                    stmt.executeUpdate();
            
            
            } catch (SQLException ex) {
                Logger.getLogger(ArticleCommandeDao.class.getName()).log(Level.SEVERE, null, ex);
            }finally {
	
		ConnectionHelper.closeSqlResources(stmt, result);
            }  
          
            return articleCommande;
	}

	@Override
	public boolean deleteArticleCommande(ArticleCommande articleCommande) {
		// TODO Auto-generated method stub
		
            
            PreparedStatement stmt = null;
            ResultSet result = null;
            
            if(articleCommande.getIdArticleCommande() > 0  && findArticleCommandeById(articleCommande.getIdArticleCommande()) == null) return false;
            
            try {
                
                if(articleCommande.getIdArticleCommande() != null) {
                    stmt = this.conn.prepareStatement("DELETE FROM ArticleCommande WHERE idArticleCommande = ?");
                    stmt.setInt(1, articleCommande.getIdArticleCommande());
                    stmt.executeUpdate();
                
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(ArticleCommandeDao.class.getName()).log(Level.SEVERE, null, ex);
            }finally {
			
		ConnectionHelper.closeSqlResources(stmt, result);
            }
            
            return true;
	}
	
        
        public ArticleCommande createArticleCommandeWithSQLObject(ResultSet rset) {
            
            IServiceFacade serviceFacade = null;
            
            try {
			
		if(rset.getInt("idArticleCommande") > 0 && rset.getInt("idCommande") > 0 && rset.getInt("idUtilisateur") > 0
                    && rset.getInt("idAdresse") > 0  && rset.getInt("idProduit") > 0 && rset.getDouble("totalArticleCommande") > 0
                    && rset.getString("reference") != null && rset.getInt("quantite") > 0 && rset.getString("statut") != null 
                    && rset.getDate("dateModification") != null
                    && rset.getInt("version") >= 0 ) {
			
                        serviceFacade = new ServiceFacade();
                        
                        return new ArticleCommande(
                                    rset.getInt("idArticleCommande"),
                                    rset.getDouble("totalArticleCommande"),
                                    rset.getString("reference"),
                                    rset.getInt("quantite"),
                                    rset.getString("statut"),								
                                    rset.getDate("dateModification"),
                                    rset.getInt("version"),
                                    serviceFacade.getCommandeDao().findCommandeById(rset.getInt("idCommande")),
                                    serviceFacade.getUtilisateurDao().findUtilisateurById(rset.getInt("idUtilisateur")),
                                    serviceFacade.getAdresseDao().findAdresseById(rset.getInt("idAdresse")),
                                    serviceFacade.getProduitDao().findProduitById(rset.getInt("idProduit"))
				);
                }
					
            } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
            }
		
            return null;
	}
        
       @Override
	public List<ArticleCommande> findArticleCommandeFavoris() {
            
            List<ArticleCommande> articleCommande = new ArrayList<ArticleCommande>();
            
            ServiceFacade serviceFacade = new ServiceFacade();
            PreparedStatement stmt = null;
            ResultSet result = null;
            
            try {
                
                stmt = this.conn.prepareStatement("SELECT idProduit, COUNT(*) as nb FROM `ArticleCommande` group by idProduit ORDER BY nb ASC");
                result = stmt.executeQuery();
                
                if(result != null) {
                    while(result.next()) {	
			ArticleCommande article = new ArticleCommande();
                        article.setProduit(serviceFacade.getProduitDao().findProduitById(result.getInt("idProduit")));
			articleCommande.add(article);
                    }
		}
            
            } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
            }finally {
	
		ConnectionHelper.closeSqlResources(stmt, result);
            }
            
            return articleCommande;
        }
}
