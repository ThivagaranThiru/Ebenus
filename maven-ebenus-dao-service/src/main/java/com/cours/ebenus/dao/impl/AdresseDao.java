package com.cours.ebenus.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.cours.ebenus.dao.ConnectionHelper;
import com.cours.ebenus.dao.IAdresseDao;
import com.cours.ebenus.entities.Adresse;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdresseDao implements IAdresseDao{
	
	private static final Log log = LogFactory.getLog(AdresseDao.class);
	
	private Connection conn = null;
	
	public AdresseDao(Connection connexion) {
		this.conn = connexion;
	}

	@Override
	public List<Adresse> findAllAdresses() {
		// TODO Auto-generated method stub
		
            List<Adresse> adresse = new ArrayList<Adresse>();
		
            PreparedStatement stmt = null;
            ResultSet result = null;
		
            try {
			
                stmt = this.conn.prepareStatement("SELECT * FROM Adresse");
		result = stmt.executeQuery();
			
		if(result != null) {
                    while(result.next()) {
			adresse.add(createAdresseWithSQLObject(result));
                    }
		}
			
            } catch (SQLException e) {
			// TODO Auto-generated catch block
		e.printStackTrace();
            }finally {
	
		ConnectionHelper.closeSqlResources(stmt, result);
            }
		
            return adresse;
	}

	@Override
	public Adresse findAdresseById(int idAdresse) {
		// TODO Auto-generated method stub
		
            PreparedStatement stmt = null;
            ResultSet result = null;
    	
            try {
			
                stmt = this.conn.prepareStatement("SELECT * FROM Adresse WHERE Adresse.idAdresse = ?");
			stmt.setInt(1,idAdresse);
			result = stmt.executeQuery();
			
			if(result.first() != false) return createAdresseWithSQLObject(result);
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
	
			ConnectionHelper.closeSqlResources(stmt, result);
		}
		
		return null;
	}

	@Override
	public List<Adresse> findAdressesByVille(String ville) {
		// TODO Auto-generated method stub
		
            List<Adresse> adresse = new ArrayList<Adresse>();
		
            PreparedStatement stmt = null;
            ResultSet result = null;
    	
            try {
    		
		stmt = this.conn.prepareStatement("SELECT * FROM Adresse WHERE Adresse.ville = ?");
		stmt.setString(1,ville);
		result = stmt.executeQuery();
			
		if(result != null) {
                    while(result.next()) {
    			adresse.add(createAdresseWithSQLObject(result));
                    }
    		}
			
            } catch (SQLException e) {
                // TODO Auto-generated catch block
		e.printStackTrace();
            }finally {
	
		ConnectionHelper.closeSqlResources(stmt, result);
            }
    	
            return adresse;
	}

	@Override
	public List<Adresse> findAdressesByPays(String pays) {
		// TODO Auto-generated method stub
		
            List<Adresse> adresse = new ArrayList<Adresse>();
		
            PreparedStatement stmt = null;
            ResultSet result = null;
    	
            try {
    		
		stmt = this.conn.prepareStatement("SELECT * FROM Adresse WHERE Adresse.pays = ?");
		stmt.setString(1,pays);
		result = stmt.executeQuery();
			
		if(result != null) {
                    while(result.next()) {
    			adresse.add(createAdresseWithSQLObject(result));
                    }
    		}
			
            } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
            }finally {
	
		ConnectionHelper.closeSqlResources(stmt, result);
            }
    	
            return adresse;
	}

	@Override
	public List<Adresse> findAdressesByIdUtilisateur(int idUtilisateur) {
		// TODO Auto-generated method stub
		
            List<Adresse> adresse = new ArrayList<Adresse>();
		
            PreparedStatement stmt = null;
            ResultSet result = null;
    	
            try {
    		
		stmt = this.conn.prepareStatement("SELECT * FROM Adresse INNER JOIN Utilisateur WHERE Adresse.idUtilisateur = Utilisateur.idUtilisateur AND Utilisateur.idUtilisateur = ?");
		stmt.setInt(1,idUtilisateur);
		result = stmt.executeQuery();
			
		if(result != null) {
                    while(result.next()) {
    			adresse.add(createAdresseWithSQLObject(result));
                    }
    		}
			
            } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
            }finally {
	
		ConnectionHelper.closeSqlResources(stmt, result);
            }
    	
            return adresse;
	}

	@Override
	public List<Adresse> findAdressesByIdentifiantUtilisateur(String identifiantUtilisateur) {
		// TODO Auto-generated method stub
		
            List<Adresse> adresse = new ArrayList<Adresse>();
		
            PreparedStatement stmt = null;
            ResultSet result = null;
    	
            try {
    		
		stmt = this.conn.prepareStatement("SELECT * FROM Adresse INNER JOIN Utilisateur WHERE Adresse.idUtilisateur = Utilisateur.idUtilisateur AND Utilisateur.identifiant = ?");
		stmt.setString(1,identifiantUtilisateur);
		result = stmt.executeQuery();
			
		if(result != null) {
                    while(result.next()) {
    			adresse.add(createAdresseWithSQLObject(result));
                    }
    		}
			
            } catch (SQLException e) {
                // TODO Auto-generated catch block
		e.printStackTrace();
            }finally {
	
		ConnectionHelper.closeSqlResources(stmt, result);
            }
    	
            return adresse;
	}
        
        @Override
        public Adresse findAdressesFByIdUtilisateur(int idUtilisateur) {
    
            PreparedStatement stmt = null;
            ResultSet result = null;
        
            try {
                
                stmt = this.conn.prepareStatement("SELECT * FROM Adresse INNER JOIN Utilisateur WHERE Adresse.idUtilisateur = Utilisateur.idUtilisateur AND Utilisateur.idUtilisateur = ? AND Adresse.typeAdresse like 'F'");
                stmt.setInt(1,idUtilisateur);
                result = stmt.executeQuery();
                
                if(result.first() != false) return createAdresseWithSQLObject(result);
                
            } catch (SQLException ex) {
                Logger.getLogger(AdresseDao.class.getName()).log(Level.SEVERE, null, ex);
            }finally {
			
		ConnectionHelper.closeSqlResources(stmt, result);
            }
            
            return null;
        }

        @Override
        public List<Adresse> findAdressesLByIdUtilisateur(int idUtilisateur) {
        
            PreparedStatement stmt = null;
            ResultSet result = null;
            List<Adresse> adresse = new ArrayList<Adresse>();
        
            try {
                
                stmt = this.conn.prepareStatement("SELECT * FROM Adresse INNER JOIN Utilisateur WHERE Adresse.idUtilisateur = Utilisateur.idUtilisateur AND Utilisateur.idUtilisateur = ? AND Adresse.typeAdresse like 'L'");
                stmt.setInt(1,idUtilisateur);
                result = stmt.executeQuery();
                
                if(result != null) {
                    while(result.next()) {
                        adresse.add(createAdresseWithSQLObject(result));
                    }
                }
                                        
            } catch (SQLException ex) {
               
                Logger.getLogger(AdresseDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
            return adresse;
        }
        
        @Override
	public Adresse findAdressesLPByIdUtilisateur(int idUtilisateur) {
            
            PreparedStatement stmt = null;
            ResultSet result = null;
            
            try {
                
                stmt = this.conn.prepareStatement("SELECT * FROM Adresse INNER JOIN Utilisateur WHERE Adresse.idUtilisateur = Utilisateur.idUtilisateur AND Utilisateur.idUtilisateur = ? AND Adresse.typeAdresse like 'L' AND principale = 1");
                stmt.setInt(1,idUtilisateur);
		result = stmt.executeQuery();
					
		if(result.first() != false) return createAdresseWithSQLObject(result);
            
            }catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
            }finally {
			
		ConnectionHelper.closeSqlResources(stmt, result);
            }
            
            return null;
        }
        

	@Override
	public Adresse createAdresse(Adresse adresse) {
		// TODO Auto-generated method stub

            PreparedStatement stmt = null;
            ResultSet result = null;

            try {

                if(adresse.getIdUtilisateur() > 0 && adresse.getRue() != null && adresse.getCodePostal() != null
                    && adresse.getVille() != null && adresse.getPays() != null && adresse.getTypeAdresse() != null
                        && adresse.getPrincipale() != null) {

                    stmt = this.conn.prepareStatement("INSERT INTO Adresse(idUtilisateur, rue, codePostal, ville, pays, typeAdresse, principale) VALUES (?,?,?,?,?,?,?)");
                    stmt.setInt(1,adresse.getIdUtilisateur());
                    stmt.setString(2,adresse.getRue());
                    stmt.setString(3,adresse.getCodePostal());
                    stmt.setString(4,adresse.getVille());
                    stmt.setString(5,adresse.getPays());
                    stmt.setString(6,adresse.getTypeAdresse());
                    stmt.setInt(7,adresse.getPrincipale() ? 1 : 0);
                    stmt.executeUpdate();
                    
                    stmt = this.conn.prepareStatement("SELECT MAX(idAdresse) FROM Adresse");
                    result = stmt.executeQuery();
                
                    if(result.first() != false) adresse = findAdresseById(result.getInt("MAX(idAdresse)"));
                  
                    }

            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }finally {

                ConnectionHelper.closeSqlResources(stmt, result);
            }

            return adresse;
	}

	@Override
	public Adresse updateAdresse(Adresse adresse) {
		// TODO Auto-generated method stub
		
		PreparedStatement stmt = null;
                ResultSet result = null;
		
		if(adresse.getIdAdresse() == null && adresse.getIdAdresse() > 0 && findAdresseById(adresse.getIdAdresse()) == null) return adresse;
		
		try {
			
			if(adresse.getIdAdresse() > 0 && adresse.getIdUtilisateur() > 0 && adresse.getRue() != null && adresse.getCodePostal() != null
	    			&& adresse.getVille() != null && adresse.getPays() != null && adresse.getStatut() != null && adresse.getTypeAdresse() != null 
	    			&& adresse.getPrincipale() != null && adresse.getVersion() >= 0) {
				
				stmt = this.conn.prepareStatement("UPDATE Adresse SET idUtilisateur = ?, rue = ?, codePostal = ?, "
						+ "ville = ?, pays = ?, statut = ?, typeAdresse = ?, principale = ?, version = ? WHERE idAdresse = ?");
   
				stmt.setInt(1,adresse.getIdUtilisateur());
				stmt.setString(2,adresse.getRue());
				stmt.setString(3,adresse.getCodePostal());
				stmt.setString(4,adresse.getVille());
				stmt.setString(5,adresse.getPays());
				stmt.setString(6,adresse.getStatut());
				stmt.setString(7,adresse.getTypeAdresse());
				stmt.setInt(8,adresse.getPrincipale() ? 1 : 0);
				stmt.setInt(9,adresse.getVersion());
				stmt.setInt(10,adresse.getIdAdresse());
				stmt.executeUpdate();
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
	
			ConnectionHelper.closeSqlResources(stmt, result);
		}
    	
		return adresse;
	}

	@Override
	public boolean deleteAdresse(Adresse adresse) {
		// TODO Auto-generated method stub
		
		PreparedStatement stmt = null;
    	ResultSet result = null;
    	
    	if(findAdresseById(adresse.getIdAdresse()) == null) return false;
    	
    	try {
			
    		if(adresse.getIdAdresse() != null) {
    			
    			stmt = this.conn.prepareStatement("DELETE FROM Adresse WHERE idAdresse = ?");
    			stmt.setInt(1,adresse.getIdAdresse());
    			stmt.executeUpdate();
    		} 		
		
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			ConnectionHelper.closeSqlResources(stmt, result);
		}
		
		return true;
	}
	
	public Adresse createAdresseWithSQLObject(ResultSet rset) {
		
		try {
			
			if(rset.getInt("Adresse.idAdresse") > 0 && rset.getString("Adresse.rue") != null && rset.getString("Adresse.codePostal")  != null && rset.getString("Adresse.ville") != null 
					 && rset.getString("Adresse.pays") != null  && rset.getString("Adresse.statut") != null && rset.getString("Adresse.typeAdresse") != null && rset.getInt("Adresse.principale") >=0 
					&& rset.getInt("Adresse.version") >= 0 && rset.getInt("Adresse.idUtilisateur") > 0) {
				
				return new Adresse(rset.getInt("Adresse.idAdresse"),rset.getString("Adresse.rue"), rset.getString("Adresse.codePostal"), rset.getString("Adresse.ville"), rset.getString("Adresse.pays"), 
						rset.getString("Adresse.statut"), rset.getString("Adresse.typeAdresse"), rset.getInt("Adresse.principale") == 1 ? true : false, rset.getInt("Adresse.version"), rset.getInt("Adresse.idUtilisateur"));	
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
