package com.cours.ebenus.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.cours.ebenus.dao.ConnectionHelper;
import com.cours.ebenus.dao.IUtilisateurDao;
import com.cours.ebenus.entities.Adresse;
import com.cours.ebenus.entities.Role;
import com.cours.ebenus.entities.Utilisateur;;

public class UtilisateurDao implements IUtilisateurDao{
	
	private static final Log log = LogFactory.getLog(UtilisateurDao.class);
	
	private Connection conn = null;
	
    public UtilisateurDao(Connection connexion) {
    	this.conn = connexion;
    }
	
    @Override
    public List<Utilisateur> findAllUtilisateurs() {
    	
    	List<Utilisateur> user = new ArrayList<Utilisateur>();
    	
    	PreparedStatement stmt = null;
    	ResultSet result = null;
    	
    	try {
    		
            stmt = this.conn.prepareStatement("SELECT * FROM Utilisateur INNER JOIN Role WHERE Utilisateur.idRole = Role.idRole");
            result = stmt.executeQuery();
    		
            if(result != null) {
    		while(result.next()) {

                    user.add(createUtilisateurWithSQLObject(result));
    		}
            }
			
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
	
            ConnectionHelper.closeSqlResources(stmt, result);
	}
    	
        return user;
    }
    
    @Override
    public Utilisateur findUtilisateurById(int idUtilisateur) {
    	
    	PreparedStatement stmt = null;
    	ResultSet result = null;
    	
    	try {
    		
            stmt = this.conn.prepareStatement("SELECT * FROM Utilisateur INNER JOIN Role WHERE Utilisateur.idRole = Role.idRole AND Utilisateur.idUtilisateur = ? ");
            stmt.setInt(1,idUtilisateur);
            result = stmt.executeQuery();
			
            if(result.first() != false) return createUtilisateurWithSQLObject(result);
				
        } catch (SQLException e) {
           // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
	
            ConnectionHelper.closeSqlResources(stmt, result);
        }

        return null;
    }
    
    @Override
    public List<Utilisateur> findUtilisateursByPrenom(String prenom) {
    	
    	List<Utilisateur> user = new ArrayList<Utilisateur>();
    	PreparedStatement stmt = null;
    	ResultSet result = null;
    	
    	try {
    		
            stmt = this.conn.prepareStatement("SELECT * FROM Utilisateur INNER JOIN Role WHERE Utilisateur.idRole = Role.idRole AND Utilisateur.prenom = ?");
            stmt.setString(1,prenom);
            result = stmt.executeQuery();
			
            if(result != null) {
    		while(result.next()) {
                    user.add(createUtilisateurWithSQLObject(result));
                }
            }
				
	} catch (SQLException e) {
            // TODO Auto-generated catch block
		e.printStackTrace();
        }finally {
	
            ConnectionHelper.closeSqlResources(stmt, result);
	}
    	
        return user;
    }
    
    @Override
    public List<Utilisateur> findUtilisateursByNom(String nom) {
    	
    	List<Utilisateur> user = new ArrayList<Utilisateur>(); 
    	PreparedStatement stmt = null;
    	ResultSet result = null;
    	
    	try {
    		
            stmt = this.conn.prepareStatement("SELECT * FROM Utilisateur INNER JOIN Role WHERE Utilisateur.idRole = Role.idRole AND Utilisateur.nom = ? ");
            stmt.setString(1,nom);
            result = stmt.executeQuery();
			
            if(result != null) {
    		while(result.next()) {
                    user.add(createUtilisateurWithSQLObject(result));
    		}
            }
				
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
	}finally {
	
            ConnectionHelper.closeSqlResources(stmt, result);
	}
    	
        return user;
    }
    
    @Override
    public List<Utilisateur> findUtilisateursByIdentifiant(String identifiant) {

    	List<Utilisateur> user = new ArrayList<Utilisateur>();
    	PreparedStatement stmt = null;
    	ResultSet result = null;
    	
    	try {
    		
            stmt = this.conn.prepareStatement("SELECT * FROM Utilisateur INNER JOIN Role WHERE Utilisateur.idRole = Role.idRole AND Utilisateur.identifiant = ? ");
            stmt.setString(1,identifiant);
            result = stmt.executeQuery();
			
            if(result != null) {
    		while(result.next()) {
                    user.add(createUtilisateurWithSQLObject(result));
    		}
            }
				
       } catch (SQLException e) {
            // TODO Auto-generated catch block
		e.printStackTrace();
        }finally {
	
            ConnectionHelper.closeSqlResources(stmt, result);
	}
    	
        return user;
    }
    
    @Override
    public List<Utilisateur> findUtilisateursByIdRole(int idRole) {
    	
    	List<Utilisateur> user = new ArrayList<Utilisateur>();
    	PreparedStatement stmt = null;
    	ResultSet result = null;
    	
    	try {
    		
            stmt = this.conn.prepareStatement("SELECT * FROM Utilisateur INNER JOIN Role WHERE Utilisateur.idRole = Role.idRole AND Utilisateur.idRole = ? ");
            stmt.setInt(1,idRole);
            result = stmt.executeQuery();
			
            if(result != null) {
    		while(result.next()) {
                    user.add(createUtilisateurWithSQLObject(result));
    		}
            }
				
	} catch (SQLException e) {
            // TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
	
            ConnectionHelper.closeSqlResources(stmt, result);
	}
    	
        return user;
    }
    
    @Override
    public List<Utilisateur> findUtilisateursByIdentifiantRole(String identifiantRole) {

    	List<Utilisateur> user = new ArrayList<Utilisateur>();
    	PreparedStatement stmt = null;
    	ResultSet result = null;
    	
    	try {
    		
            stmt = this.conn.prepareStatement("SELECT * FROM Utilisateur INNER JOIN Role WHERE Role.identifiant = ? AND Utilisateur.idRole = Role.idRole ");
            stmt.setString(1,identifiantRole);
            result = stmt.executeQuery();
			
            if(result != null) {
    		while(result.next()) {
                    user.add(createUtilisateurWithSQLObject(result));
    		}
            }
				
            } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
            }finally {
	
		ConnectionHelper.closeSqlResources(stmt, result);
            }
    	
        return user;
    }
    
    @Override
    public Utilisateur createUtilisateur(Utilisateur user) {
    	
    	PreparedStatement stmt = null;
    	ResultSet result = null;
    	
    	
    	if(user.getIdentifiant() != null && findUtilisateursByIdentifiant(user.getIdentifiant()).size() > 0) return user;
    	
    	try {
			
            if(user.getRole() != null && user.getRole().getIdRole() > 0 && user.getCivilite() != null && user.getPrenom() != null
                    && user.getNom() != null && user.getIdentifiant() != null && user.getMotPasse() != null && user.getDateNaissance() != null 
                    &&  user.getActif() != null) {
				
                    stmt = this.conn.prepareStatement("INSERT INTO Utilisateur(idRole, civilite, prenom, nom, identifiant, "
				+ "motPasse, dateNaissance, dateCreation, dateModification, actif) "
				+ "VALUES (?,?,?,?,?,?,?,?,?,?)");
				
                    stmt.setInt(1,user.getRole().getIdRole());
                    stmt.setString(2,user.getCivilite());
                    stmt.setString(3,user.getPrenom());
                    stmt.setString(4,user.getNom());
                    stmt.setString(5,user.getIdentifiant());
                    stmt.setString(6,user.getMotPasse());
                    Date sqlDate = new Date(user.getDateNaissance().getTime());
                    stmt.setDate(7,sqlDate);
                    stmt.setDate(8,new Date(System.currentTimeMillis()));
                    stmt.setDate(9,new Date(System.currentTimeMillis()));
                    stmt.setInt(10,user.getActif() ? 1 : 0);
                    stmt.executeUpdate();
			    
                    user = findUtilisateursByIdentifiant(user.getIdentifiant()).get(0);
                }
		
	} catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
	}finally {
	
            ConnectionHelper.closeSqlResources(stmt, result);
	}
    	
	return user;
    }
    
    @Override
    public Utilisateur updateUtilisateur(Utilisateur user) {
    	
    	PreparedStatement stmt = null;
    	ResultSet result = null;

    	if(user.getIdUtilisateur() > 0 && findUtilisateurById(user.getIdUtilisateur()) == null) return user;
    	
    	try {
			
            if(user.getRole() != null && user.getRole().getIdRole() > 0 && user.getCivilite() != null && user.getPrenom() != null
                    && user.getNom() != null && user.getIdentifiant() != null && user.getMotPasse() != null && user.getDateNaissance() != null 
                    && user.getDateCreation() != null && user.getActif() != null && user.getMarquerEffacer() != null && user.getVersion() >= 0) {
				
                stmt = this.conn.prepareStatement("UPDATE Utilisateur SET idRole = ?, civilite = ?, prenom = ?, nom = ?, identifiant = ?, "
                            + "motPasse = ?, dateNaissance = ?, dateCreation = ?, dateModification = ?, actif = ?, marquerEffacer = ?, version = ? "
                            + "WHERE idUtilisateur = ? ");
				
		stmt.setInt(1,user.getRole().getIdRole());
		stmt.setString(2,user.getCivilite());
		stmt.setString(3,user.getPrenom());
                stmt.setString(4,user.getNom());
		stmt.setString(5,user.getIdentifiant());
		stmt.setString(6,user.getMotPasse());
                Date sqlDateborn = new Date(user.getDateNaissance().getTime());
                stmt.setDate(7,sqlDateborn);
                Date sqlDatecreate = new Date(user.getDateCreation().getTime());
                stmt.setDate(8,sqlDatecreate);
		stmt.setDate(9,new Date(System.currentTimeMillis()));
		stmt.setInt(10,user.getActif() ? 1 : 0);
		stmt.setInt(11,user.getMarquerEffacer() ? 1 : 0);
		stmt.setInt(12,user.getVersion());
		stmt.setInt(13,user.getIdUtilisateur());
                stmt.executeUpdate();
            }
		
	} catch (SQLException e) {
            // TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
	
            ConnectionHelper.closeSqlResources(stmt, result);
	}
    
        return user;
    }
    
    @Override
    public boolean deleteUtilisateur(Utilisateur user) {
    	
    	PreparedStatement stmt = null;
    	ResultSet result = null;

    	if(findUtilisateurById(user.getIdUtilisateur()) == null) return false;
    		
    	try {
    			
            if(user.getIdUtilisateur() != null) {
    				
    		stmt = this.conn.prepareStatement("DELETE FROM Utilisateur WHERE idUtilisateur = ? ");
    		stmt.setInt(1, user.getIdUtilisateur());
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
    
    public Utilisateur createUtilisateurWithSQLObject(ResultSet rset) {
    	
    	List<Adresse> adresse = new ArrayList<Adresse>();
    	
    	PreparedStatement stmt = null;
    	ResultSet result = null;
    	
    	try {
    		
		if(rset.getInt("Utilisateur.idUtilisateur") > 0 && rset.getInt("Utilisateur.idRole") > 0 && rset.getString("Utilisateur.civilite") != null 
			&& rset.getString("Utilisateur.prenom") != null && rset.getString("Utilisateur.nom") != null && rset.getString("Utilisateur.identifiant") != null
			&& rset.getString("Utilisateur.motPasse") != null && rset.getDate("Utilisateur.dateNaissance") != null && rset.getDate("Utilisateur.dateCreation") != null
			&& rset.getDate("Utilisateur.dateModification") != null && rset.getInt("Utilisateur.actif") >= 0 && rset.getInt("Utilisateur.marquerEffacer") >= 0 && rset.getInt("Utilisateur.version") >= 0 
			&& rset.getInt("Role.idRole") > 0 && rset.getString("Role.identifiant") != null && rset.getString("Role.description") != null && rset.getInt("Role.marquerEffacer") >= 0 && rset.getInt("Role.version") >= 0) {
	    		
                    stmt = this.conn.prepareStatement("SELECT * FROM Utilisateur INNER JOIN Adresse WHERE Utilisateur.idUtilisateur = ? AND Utilisateur.idUtilisateur = Adresse.idUtilisateur");
                    stmt.setInt(1, rset.getInt("Utilisateur.idUtilisateur"));
                    result = stmt.executeQuery();
					
		    if(result != null) {
                        while(result.next()) {

                            if(result.getInt("Adresse.idAdresse") > 0 && result.getString("Adresse.rue") != null && result.getString("Adresse.codePostal")  != null && result.getString("Adresse.ville") != null 
		    			&& result.getString("Adresse.pays") != null  && result.getString("Adresse.statut") != null && result.getString("Adresse.typeAdresse") != null && result.getInt("Adresse.principale") >=0 
		    			&& result.getInt("Adresse.version") >= 0 && result.getInt("Adresse.idUtilisateur") > 0) {
		    					
                                            adresse.add(new Adresse(result.getInt("Adresse.idAdresse"),result.getString("Adresse.rue"),result.getString("Adresse.codePostal"),result.getString("Adresse.ville"),result.getString("Adresse.pays"),
		    				result.getString("Adresse.statut"), result.getString("Adresse.typeAdresse"),result.getInt("Adresse.principale") == 1 ? true : false,result.getInt("Adresse.version"),result.getInt("Adresse.idUtilisateur")));
                            }
		    	}
		    }
	    		
					
                    return new Utilisateur(rset.getInt("Utilisateur.idUtilisateur"), rset.getString("Utilisateur.civilite"), rset.getString("Utilisateur.prenom"),
                                                rset.getString("Utilisateur.nom"),rset.getString("Utilisateur.identifiant"),rset.getString("Utilisateur.motPasse"),rset.getDate("Utilisateur.dateNaissance"),
                                                rset.getDate("Utilisateur.dateCreation"),rset.getDate("Utilisateur.dateModification"),rset.getInt("Utilisateur.actif") == 1 ? true : false,rset.getInt("Utilisateur.marquerEffacer") == 1 ? true : false, rset.getInt("Utilisateur.version"), 
		    				new Role(rset.getInt("Role.idRole"),rset.getString("Role.identifiant"),rset.getString("Role.description"), rset.getInt("Role.marquerEffacer") == 1 ? true : false, rset.getInt("Role.version")),adresse);
		}
			
	} catch (SQLException e) {
            // TODO Auto-generated catch block
		e.printStackTrace();
	}finally {

            ConnectionHelper.closeSqlResources(stmt, result);
    	}
    	
    	return null;
    }
    
    @Override
    public Utilisateur authenticate(String email, String password) {
    	
    	PreparedStatement stmt = null;
    	ResultSet result = null;
    	
    	try {
    		
            stmt = this.conn.prepareStatement("SELECT * FROM Utilisateur INNER JOIN Role WHERE Utilisateur.idRole = Role.idRole AND Utilisateur.identifiant = ? AND Utilisateur.motPasse = ? ");
            stmt.setString(1,email);
            stmt.setString(2,password);
            result = stmt.executeQuery();
			
            if(result.first() != false) return createUtilisateurWithSQLObject(result);
			
    	} catch (SQLException e) {
    		// TODO Auto-generated catch block
			e.printStackTrace();
    	}finally {

            ConnectionHelper.closeSqlResources(stmt, result);
    	}
    	
        return null;
    }
}
