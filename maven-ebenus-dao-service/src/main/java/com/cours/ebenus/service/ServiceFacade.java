package com.cours.ebenus.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.cours.ebenus.dao.IAdresseDao;
import com.cours.ebenus.dao.IArticleCommandeDao;
import com.cours.ebenus.dao.ICommandeDao;
import com.cours.ebenus.dao.IProduitDao;
import com.cours.ebenus.dao.IRoleDao;
import com.cours.ebenus.dao.IUtilisateurDao;
import com.cours.ebenus.factory.AbstractDaoFactory;
import com.cours.ebenus.factory.AbstractDaoFactory.FactoryDaoType;

public class ServiceFacade implements IServiceFacade{
	
    private static final Log log = LogFactory.getLog(ServiceFacade.class);
    private final AbstractDaoFactory.FactoryDaoType DEFAULT_IMPLEMENTATION = AbstractDaoFactory.FactoryDaoType.JDBC_DAO_FACTORY;

    private IUtilisateurDao utilisateurDao = null;

    private IRoleDao roleDao = null;
    
    private IAdresseDao adresseDao = null;
    
    private IProduitDao produitDao = null;
    
    private ICommandeDao commandeDao = null;
    
    private IArticleCommandeDao articleCommandeDao = null;
    
    public ServiceFacade() {
        
        utilisateurDao = AbstractDaoFactory.getFactory(DEFAULT_IMPLEMENTATION).getUtilisateurDao();
        roleDao = AbstractDaoFactory.getFactory(DEFAULT_IMPLEMENTATION).getRoleDao();
        adresseDao = AbstractDaoFactory.getFactory(DEFAULT_IMPLEMENTATION).getAdresseDao();
        produitDao = AbstractDaoFactory.getFactory(DEFAULT_IMPLEMENTATION).getProduitDao();
        commandeDao = AbstractDaoFactory.getFactory(DEFAULT_IMPLEMENTATION).getCommandeDao();
        articleCommandeDao = AbstractDaoFactory.getFactory(DEFAULT_IMPLEMENTATION).getArticleCommandeDao();
    }
    
    public ServiceFacade(FactoryDaoType daoType) {
        
        utilisateurDao = AbstractDaoFactory.getFactory(daoType).getUtilisateurDao();
        roleDao = AbstractDaoFactory.getFactory(daoType).getRoleDao();
        adresseDao = AbstractDaoFactory.getFactory(daoType).getAdresseDao();
        produitDao = AbstractDaoFactory.getFactory(daoType).getProduitDao();
        commandeDao = AbstractDaoFactory.getFactory(daoType).getCommandeDao();
        articleCommandeDao = AbstractDaoFactory.getFactory(daoType).getArticleCommandeDao();
        
    }
    
    @Override
    public IUtilisateurDao getUtilisateurDao() {
	// TODO Auto-generated method stub
	return utilisateurDao;
    }

    @Override
    public IRoleDao getRoleDao() {
        // TODO Auto-generated method stub
	return roleDao;
    }

    @Override
    public IAdresseDao getAdresseDao() {
	// TODO Auto-generated method stub
	return adresseDao;
    }

    @Override
    public IProduitDao getProduitDao() {
        // TODO Auto-generated method stub
	return produitDao;
    }

    @Override
    public ICommandeDao getCommandeDao() {
        // TODO Auto-generated method stub
            return commandeDao;
    }

    @Override
    public IArticleCommandeDao getArticleCommandeDao() {
	// TODO Auto-generated method stub
	return articleCommandeDao;
    }
}
