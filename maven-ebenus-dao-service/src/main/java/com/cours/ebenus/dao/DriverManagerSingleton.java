package com.cours.ebenus.dao;

import java.sql.DriverManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.cours.ebenus.utils.Constants;
import java.sql.Connection;

public class DriverManagerSingleton {
	
    private static final Log log = LogFactory.getLog(DriverManagerSingleton.class);
	 
    public final static String className = DriverManagerSingleton.class.getName();
	 
    // Url de connexion en base de donnée
    private static final String url = Constants.DATABASE_URL;
	 
    // Utilisateur de la base de données
    private static final String user = Constants.DATABASE_USER;
	
    // Mot de passe de la base de données
    private static final String password = Constants.DATABASE_PASSWORD;
	
    // Drivers Jdbc
    private static final String jdbcDriver = Constants.JDBC_DRIVER;
    
    private Connection connection = null;
    
    public DriverManagerSingleton () {
    	
    	try {
    		 
            Class.forName(jdbcDriver);
			
            this.connection = DriverManager.getConnection(url,user,password);
			
    	} catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
    	}
    }
    
    private static class DriverManagerSingletonHolder {
    	public final static DriverManagerSingleton instance = new DriverManagerSingleton();
    }
    
    public static DriverManagerSingleton getInstance() {
    	return DriverManagerSingletonHolder.instance;
    }
    
    public Connection getConnectionInstance () {
		return connection;
    }
}
