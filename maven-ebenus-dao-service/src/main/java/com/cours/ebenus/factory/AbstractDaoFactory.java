package com.cours.ebenus.factory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.cours.ebenus.dao.IAdresseDao;
import com.cours.ebenus.dao.IArticleCommandeDao;
import com.cours.ebenus.dao.ICommandeDao;
import com.cours.ebenus.dao.IProduitDao;
import com.cours.ebenus.dao.IRoleDao;
import com.cours.ebenus.dao.IUtilisateurDao;

public abstract class AbstractDaoFactory {
	
    public static String className = AbstractDaoFactory.class.getName();
    private static final Log log = LogFactory.getLog(AbstractDaoFactory.class);
    
    public enum FactoryDaoType {

        JDBC_DAO_FACTORY;
    }

    public abstract IUtilisateurDao getUtilisateurDao();

    public abstract IRoleDao getRoleDao();
    
    public abstract IAdresseDao getAdresseDao();
    
    public abstract IProduitDao getProduitDao();
    
    public abstract ICommandeDao getCommandeDao();
    
    public abstract IArticleCommandeDao getArticleCommandeDao();

    
    public static AbstractDaoFactory getFactory(FactoryDaoType daoType) {
    	
    	switch(daoType) {
    		case JDBC_DAO_FACTORY :
    			return new DaoFactory();
    		default :
    			break;	
    	}
    	
        return null;
    }
}
