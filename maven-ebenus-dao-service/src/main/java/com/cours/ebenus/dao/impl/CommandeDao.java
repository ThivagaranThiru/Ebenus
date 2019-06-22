package com.cours.ebenus.dao.impl;

import com.cours.ebenus.dao.ConnectionHelper;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.cours.ebenus.dao.ICommandeDao;
import com.cours.ebenus.entities.Commande;
import com.cours.ebenus.service.IServiceFacade;
import com.cours.ebenus.service.ServiceFacade;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CommandeDao implements ICommandeDao{
	
	private static final Log log = LogFactory.getLog(CommandeDao.class);
	
	private Connection conn = null;
	
	public CommandeDao(Connection connexion) {
		this.conn = connexion;
	}

	@Override
	public List<Commande> findAllCommandes() {
		// TODO Auto-generated method stub
            
            List<Commande> commande = new ArrayList<Commande>();
            
            PreparedStatement stmt = null;
            ResultSet result = null;
            
            try {
                stmt = this.conn.prepareStatement("SELECT * FROM Commande");
                result = stmt.executeQuery();
                
                if(result != null) {
                    while(result.next()) {				
			commande.add(createCommandeWithSQLObject(result));
                    }
		}
           
            } catch (SQLException ex) {
                Logger.getLogger(CommandeDao.class.getName()).log(Level.SEVERE, null, ex);
            }finally {
	
		ConnectionHelper.closeSqlResources(stmt, result);
            }
          
            return commande;
	}

	@Override
	public Commande findCommandeById(int idCommande) {
		// TODO Auto-generated method stub
            
            PreparedStatement stmt = null;
            ResultSet result = null;
            
            try {
                stmt = this.conn.prepareStatement("SELECT * FROM Commande WHERE idCommande = ?");
                stmt.setInt(1,idCommande);
		result = stmt.executeQuery();
                
                if(result.first() != false) return createCommandeWithSQLObject(result);
            
            } catch (SQLException ex) {
                Logger.getLogger(CommandeDao.class.getName()).log(Level.SEVERE, null, ex);
            }finally {
	
		ConnectionHelper.closeSqlResources(stmt, result);
            }     
            
            return null;
	}

	@Override
	public List<Commande> findCommandesByIdAdresse(int idAdresse) {
		// TODO Auto-generated method stub
            
            List<Commande> commande = new ArrayList<Commande>();
            PreparedStatement stmt = null;
            ResultSet result = null;
            
            try {
                stmt = this.conn.prepareStatement("SELECT * FROM Commande WHERE idAdresse = ? ");
                stmt.setInt(1,idAdresse);
		result = stmt.executeQuery();
                
                if(result != null) {
                    while(result.next()) {				
			commande.add(createCommandeWithSQLObject(result));
                    }
		}
            
            } catch (SQLException ex) {
                Logger.getLogger(CommandeDao.class.getName()).log(Level.SEVERE, null, ex);
            }finally {
	
		ConnectionHelper.closeSqlResources(stmt, result);
            }
            	
            return commande;
	}

	@Override
	public List<Commande> findCommandesByIdUtilisateur(int idUtilisateur) {
		// TODO Auto-generated method stub
            
            List<Commande> commande = new ArrayList<Commande>();
            PreparedStatement stmt = null;
            ResultSet result = null;
            
            try {
                stmt = this.conn.prepareStatement("SELECT * FROM Commande WHERE idUtilisateur = ?");
                stmt.setInt(1,idUtilisateur);
		result = stmt.executeQuery();
                
                if(result != null) {
                    while(result.next()) {				
			commande.add(createCommandeWithSQLObject(result));
                    }
		}
                
            } catch (SQLException ex) {
                Logger.getLogger(CommandeDao.class.getName()).log(Level.SEVERE, null, ex);
            }finally {
	
		ConnectionHelper.closeSqlResources(stmt, result);
            }
		
            return commande;
	}

	@Override
	public Commande createCommande(Commande commande) {
		// TODO Auto-generated method stub
            
            PreparedStatement stmt = null;
            ResultSet result = null;
            
            try {
                stmt = this.conn.prepareStatement("INSERT INTO Commande(totalCommande, idUtilisateur, idAdresse, statut, dateCommande, dateModification) VALUES(?,?,?,?,?,?)");
                
                stmt.setDouble(1, commande.getTotalCommande());
                stmt.setInt(2, commande.getUtilisateur().getIdUtilisateur());
                stmt.setInt(3, commande.getAdresse().getIdAdresse());
                stmt.setString(4, commande.getStatut());
                stmt.setDate(5,new Date(System.currentTimeMillis()));
		stmt.setDate(6,new Date(System.currentTimeMillis()));
                stmt.executeUpdate();
                
                stmt = this.conn.prepareStatement("SELECT MAX(idCommande) FROM Commande");
                result = stmt.executeQuery();
                
                if(result.first() != false) commande = findCommandeById(result.getInt("MAX(idCommande)"));
                    
            } catch (SQLException ex) {
                Logger.getLogger(CommandeDao.class.getName()).log(Level.SEVERE, null, ex);
            }finally {

                ConnectionHelper.closeSqlResources(stmt, result);
            }
		
            return commande;
	}

	@Override
	public Commande updateCommande(Commande commande) {
		// TODO Auto-generated method stub
            
            PreparedStatement stmt = null;
            ResultSet result = null;
	
            if(commande.getIdCommande() > 0 && findCommandeById(commande.getIdCommande()) == null ) return commande;
            
            try {
                if(commande.getTotalCommande() != null && commande.getUtilisateur().getIdUtilisateur() != null && commande.getAdresse().getIdAdresse() != null
                        && commande.getStatut() != null && commande.getDateCommande() != null && commande.getVersion() != null){
                
                    stmt = this.conn.prepareStatement("UPDATE Commande SET totalCommande = ?, idUtilisateur = ?, "
                            + "idAdresse = ?, statut = ?, dateCommande = ?, dateModification = ?, version = ? WHERE idCommande = ?");
                
                    stmt.setDouble(1, commande.getTotalCommande());
                    stmt.setInt(2, commande.getUtilisateur().getIdUtilisateur());
                    stmt.setInt(3, commande.getAdresse().getIdAdresse());
                    stmt.setString(4, commande.getStatut());
                    Date sqlDate = new Date(commande.getDateCommande().getTime());
                    stmt.setDate(5,sqlDate);
                    stmt.setDate(6,new Date(System.currentTimeMillis()));
                    stmt.setInt(7, commande.getVersion());
                    stmt.setInt(8, commande.getIdCommande());
                    stmt.executeUpdate();
            }
            
            } catch (SQLException ex) {
                Logger.getLogger(CommandeDao.class.getName()).log(Level.SEVERE, null, ex);
            }finally {

                ConnectionHelper.closeSqlResources(stmt, result);
            }
            
            return commande;
	}

	@Override
	public boolean deleteCommande(Commande commande) {
		// TODO Auto-generated method stub
		
            PreparedStatement stmt = null;
            ResultSet result = null;
            
            if(commande.getIdCommande() > 0 && findCommandeById(commande.getIdCommande()) == null ) return false;
            
            try {
               
                if(commande.getIdCommande() != null) {
                    stmt = this.conn.prepareStatement("DELETE FROM Commande WHERE idCommande = ?");
                    stmt.setInt(1, commande.getIdCommande());
                    stmt.executeUpdate();
                }
            
            } catch (SQLException ex) {
                Logger.getLogger(CommandeDao.class.getName()).log(Level.SEVERE, null, ex);
            }finally {

                ConnectionHelper.closeSqlResources(stmt, result);
            }
            
            return true;
	}
	
	public Commande createCommandeWithSQLObject(ResultSet rset) {
            
            IServiceFacade serviceFacade = null;
            
            try {
                
                if(rset.getInt("idCommande") > 0 && rset.getDouble("totalCommande") > 0 && rset.getInt("idUtilisateur") > 0
                        && rset.getInt("idAdresse") > 0  && rset.getString("statut") != null && rset.getDate("dateCommande") != null
                        && rset.getDate("dateModification") != null && rset.getInt("version") >= 0) {
                    
                            serviceFacade = new ServiceFacade();
                    
                            return new Commande(
					rset.getInt("idCommande"),
					rset.getDouble("totalCommande"),
					rset.getString("statut"),
					rset.getDate("dateCommande"),								
					rset.getDate("dateModification"),
					serviceFacade.getAdresseDao().findAdresseById(rset.getInt("idAdresse")),
					serviceFacade.getUtilisateurDao().findUtilisateurById(rset.getInt("idUtilisateur"))
                                    );   
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(CommandeDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            return null;
	}
}
