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
import com.cours.ebenus.dao.IRoleDao;
import com.cours.ebenus.entities.Role;

public class RoleDao implements IRoleDao {

	private static final Log log = LogFactory.getLog(RoleDao.class);
    
    private Connection conn = null;
    
    public RoleDao(Connection connexion) {
    	this.conn = connexion;
    }
	
    @Override
    public List<Role> findAllRoles() {
    	
            List<Role> role = new ArrayList<Role>();
    	
            PreparedStatement stmt = null;
            ResultSet result = null;
    	
            try {
    		
    		stmt = this.conn.prepareStatement("SELECT * FROM Role");
    		result = stmt.executeQuery();
    		
    		if(result != null) {
                    while(result.next()) {

    			role.add(createRoleWithSQLObject(result));
                    }
    		}
			
            } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
            }finally {
	
		ConnectionHelper.closeSqlResources(stmt, result);
            }
    	
        return role;
    }
    
    @Override
    public Role findRoleById(int idRole) {
    	
            PreparedStatement stmt = null;
            ResultSet result = null;
    	
            try {
    		
                stmt = this.conn.prepareStatement("SELECT * FROM Role WHERE idRole = ? ");
                stmt.setInt(1,idRole);
		result = stmt.executeQuery();
			
		if(result.first() != false) return createRoleWithSQLObject(result);
				
            } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
            }finally {
	
		ConnectionHelper.closeSqlResources(stmt, result);
            }

            return null;
    }
    
    @Override
    public List<Role> findRoleByIdentifiant(String identifiantRole) {
    	
            List<Role> role = new ArrayList<Role>();
            PreparedStatement stmt = null;
            ResultSet result = null;
    	
            try {
    		
		stmt = this.conn.prepareStatement("SELECT * FROM Role WHERE identifiant = ? ");
		stmt.setString(1,identifiantRole);
		result = stmt.executeQuery();
			
		if(result != null) {
                    while(result.next()) {
    			role.add(createRoleWithSQLObject(result));
                    }
    		}
				
            } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
            }finally {
	
		ConnectionHelper.closeSqlResources(stmt, result);
            }
    	
        return role;
    }
    
    @Override
    public Role createRole(Role role) {
    	
        PreparedStatement stmt = null;
        ResultSet result = null;
    	
        if(role.getIdentifiant() != null && findRoleByIdentifiant(role.getIdentifiant()).size() > 0) return role;
    
    		
        try {
    		
            if(role.getIdentifiant() != null && role.getDescription() != null) {
    			
                stmt = this.conn.prepareStatement("INSERT INTO Role(identifiant, description) VALUES(?,?)");
                stmt.setString(1,role.getIdentifiant());
                stmt.setString(2, role.getDescription());
                stmt.executeUpdate();
				
                role = findRoleByIdentifiant(role.getIdentifiant()).get(0);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
	
            ConnectionHelper.closeSqlResources(stmt, result);
        }
    	
        return role;
    }    
    
    @Override
    public Role updateRole(Role role) {
    	
    	PreparedStatement stmt = null;
    	ResultSet result = null;

    	if(role.getIdRole() > 0 && findRoleById(role.getIdRole()) == null) return role;
    	
        try {
    		
            if(role.getIdRole() > 0  && role.getIdentifiant() != null && role.getDescription() != null
                    && role.getMarquerEffacer() != null && role.getVersion() >= 0) {
    			
		stmt = this.conn.prepareStatement("UPDATE Role SET identifiant = ?, description = ?, marquerEffacer = ?, version = ? WHERE idRole = ?");
		stmt.setString(1, role.getIdentifiant());
		stmt.setString(2, role.getDescription());
		stmt.setInt(3,role.getMarquerEffacer() ? 1 : 0);
		stmt.setInt(4, role.getVersion());
		stmt.setInt(5, role.getIdRole());
		stmt.executeUpdate();
            }
            
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
				
            ConnectionHelper.closeSqlResources(stmt, result);
	}
        
    	return role;
    }
    
    @Override
    public boolean deleteRole(Role role) {
    	
    	PreparedStatement stmt = null;
    	ResultSet result = null;
    	
    	if(role.getIdRole() > 0 && findRoleById(role.getIdRole()) == null) return false;
    	
    
   	try {
   			
            if(role.getIdRole() != null) {
   		stmt = this.conn.prepareStatement("DELETE FROM Role WHERE idRole = ? ");
   		stmt.setInt(1,role.getIdRole());
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
    
    public Role createRoleWithSQLObject(ResultSet rset) {
    	
    	try {
    		
            if(rset.getInt("idRole") > 0 && rset.getString("identifiant") != null && rset.getString("description") != null
                    && rset.getInt("marquerEffacer") >= 0  && rset.getInt("version") >= 0) {
				
                return new Role(rset.getInt("idRole"),rset.getString("identifiant"),rset.getString("description"),rset.getInt("marquerEffacer") == 1 ? true : false,rset.getInt("version"));
            }
			
            } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
            }
    	
    	return null;
    }
}
