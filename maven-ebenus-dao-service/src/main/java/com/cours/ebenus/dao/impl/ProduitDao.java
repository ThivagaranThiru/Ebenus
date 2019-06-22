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
import com.cours.ebenus.dao.IProduitDao;
import com.cours.ebenus.entities.Produit;

public class ProduitDao implements IProduitDao {
	
	private static final Log log = LogFactory.getLog(ProduitDao.class);
	
	private Connection conn = null;
	
	public ProduitDao (Connection connexion) {
		this.conn = connexion;
	}

	@Override
	public List<Produit> findAllProduits() {
		// TODO Auto-generated method stub
		
            List<Produit> produit = new ArrayList<Produit>();
		
            PreparedStatement stmt = null;
            ResultSet result = null;
		
            try {
			
		stmt = this.conn.prepareStatement("SELECT * FROM Produit");
		result = stmt.executeQuery();
			
                if(result != null) {
                    while(result.next()) {
					
                    produit.add(createProduitWithSQLObject(result));
                    }
		}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
	
			ConnectionHelper.closeSqlResources(stmt, result);
		}
		
		return produit;
	}

	@Override
	public Produit findProduitById(int idProduit) {
		// TODO Auto-generated method stub
		
            PreparedStatement stmt = null;
            ResultSet result = null;
    	
            try {
    		
		stmt = this.conn.prepareStatement("SELECT * FROM Produit WHERE idProduit = ? ");
		stmt.setInt(1,idProduit);
		result = stmt.executeQuery();
			
		if(result.first() != false) return createProduitWithSQLObject(result);
				
            } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
            }finally {
	
		ConnectionHelper.closeSqlResources(stmt, result);
            }
    	
            return null;
	}

	@Override
	public List<Produit> findProduitByReference(String reference) {
		// TODO Auto-generated method stub
		
            List<Produit> produit = new ArrayList<Produit>();
            PreparedStatement stmt = null;
            ResultSet result = null;
    	
            try {
    		
		stmt = this.conn.prepareStatement("SELECT * FROM Produit WHERE reference = ? ");
		stmt.setString(1,reference);
		result = stmt.executeQuery();
			
		if(result != null) {
                    while(result.next()) {
    			produit.add(createProduitWithSQLObject(result));
                    }
    		}
				
            } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
            }finally {
	
		ConnectionHelper.closeSqlResources(stmt, result);
            }
    	
            return produit;
	}

	@Override
	public List<Produit> findProduitsByPrix(Double prix) {
		// TODO Auto-generated method stub
		
            List<Produit> produit = new ArrayList<Produit>();
            PreparedStatement stmt = null;
            ResultSet result = null;
    	
            try {
    		
		stmt = this.conn.prepareStatement("SELECT * FROM Produit WHERE prix = ? ");
		stmt.setDouble(1,prix);
		result = stmt.executeQuery();
			
		if(result != null) {
                    while(result.next()) {
    			produit.add(createProduitWithSQLObject(result));
                    }
    		}
				
            } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
            }finally {
	
		ConnectionHelper.closeSqlResources(stmt, result);
            }
    	
            return produit;
	}

	@Override
	public List<Produit> findProduitsByNom(String nom) {
		// TODO Auto-generated method stub
		
            List<Produit> produit = new ArrayList<Produit>();
            PreparedStatement stmt = null;
            ResultSet result = null;
    	
            try {
    		
		stmt = this.conn.prepareStatement("SELECT * FROM Produit WHERE nom = ? ");
		stmt.setString(1,nom);
		result = stmt.executeQuery();
			
		if(result != null) {
                    while(result.next()) {
    			produit.add(createProduitWithSQLObject(result));
                    }
    		}
				
            } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
            }finally {
	
		ConnectionHelper.closeSqlResources(stmt, result);
            }
    	
            return produit;
	}

	@Override
	public Produit createProduit(Produit produit) {
		// TODO Auto-generated method stub
		
            PreparedStatement stmt = null;
            ResultSet result = null;
    	
            if(produit.getReference() != null && findProduitByReference(produit.getReference()).size() > 0) return produit;
    		
            try {
			
    		if(produit.getReference() != null && produit.getPrix() >= 0 && produit.getNom() != null 
        			&& produit.getDescription() != null && produit.getStock() >= 0 && produit.getActif() != null) {
    			
    			stmt = this.conn.prepareStatement("INSERT INTO Produit(reference, prix, nom, description, stock, active) VALUES(?,?,?,?,?,?)");
    			stmt.setString(1, produit.getReference());
    			stmt.setDouble(2, produit.getPrix());
    			stmt.setString(3, produit.getNom());
    			stmt.setString(4, produit.getDescription());
    			stmt.setInt(5, produit.getStock());
    			stmt.setInt(6, produit.getActif() ? 1 : 0);
    			stmt.executeUpdate();
    			
    			produit = findProduitByReference(produit.getReference()).get(0);
    		}
    		
            } catch (SQLException e) {
		// TODO Auto-generated catch block
                    e.printStackTrace();
            }finally {
	
		ConnectionHelper.closeSqlResources(stmt, result);
            }   	
    		
            return produit;
	}

	@Override
	public Produit updateProduit(Produit produit) {
		// TODO Auto-generated method stub
		
            PreparedStatement stmt = null;
            ResultSet result = null;
    	
            if(produit.getIdProduit() > 0 && findProduitById(produit.getIdProduit()) == null) return produit;
    		
            try {
    		
        	if(produit.getIdProduit() > 0 && produit.getReference() != null && produit.getPrix() >= 0 
        			&& produit.getNom() != null && produit.getDescription() != null && produit.getStock() >= 0 
        			&& produit.getActif() != null && produit.getMarquerEffacer() != null && produit.getVersion() >= 0) {
        		
        		stmt = this.conn.prepareStatement("UPDATE Produit SET reference = ?, prix = ?, nom = ?, description = ?, stock = ?, active = ?, marquerEffacer = ?, version = ? WHERE idProduit = ?");
    			stmt.setString(1, produit.getReference());
    			stmt.setDouble(2, produit.getPrix());
    			stmt.setString(3, produit.getNom());
    			stmt.setString(4, produit.getDescription());
    			stmt.setInt(5, produit.getStock());
    			stmt.setInt(6, produit.getActif() ? 1 : 0);
    			stmt.setInt(7, produit.getMarquerEffacer() ? 1 : 0);
    			stmt.setInt(8, produit.getVersion());
    			stmt.setInt(9, produit.getIdProduit());
    			stmt.executeUpdate();
        		
            }

            } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
            }finally {
	
		ConnectionHelper.closeSqlResources(stmt, result);
            } 
    		
            return produit;
	}

	@Override
	public boolean deleteProduit(Produit produit) {
		// TODO Auto-generated method stub
		
            PreparedStatement stmt = null;
            ResultSet result = null;
    	
            if(produit.getIdProduit() > 0  && findProduitById(produit.getIdProduit()) == null) return false;
    	
    	
            try {
    		
    		if(produit.getIdProduit() != null) {
    			stmt = this.conn.prepareStatement("DELETE FROM Produit WHERE idProduit = ?");
    			stmt.setInt(1, produit.getIdProduit());
    			stmt.executeUpdate();
    		}

            } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
            } finally {
			
		ConnectionHelper.closeSqlResources(stmt, result);
            }
    	
            return true;
	}
	
	public Produit createProduitWithSQLObject(ResultSet rset) {
		
		try {
			
                    if(rset.getInt("idProduit") > 0 && rset.getString("reference") != null && rset.getDouble("prix") >= 0
				&& rset.getString("nom") != null && rset.getString("description") != null && rset.getInt("stock") >= 0
				&& rset.getInt("active") >= 0 && rset.getInt("marquerEffacer") >= 0  && rset.getInt("version") >= 0) {
			
                            return new Produit(rset.getInt("idProduit"), rset.getString("reference"), rset.getDouble("prix"), rset.getString("nom"), 
					rset.getString("description"), rset.getInt("stock"), rset.getInt("active") == 1 ? true : false , 
							rset.getInt("marquerEffacer") == 1 ? true : false, rset.getInt("version"));
                    }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
