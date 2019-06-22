package com.cours.ebenus.service;

import com.cours.ebenus.dao.IAdresseDao;
import com.cours.ebenus.dao.IArticleCommandeDao;
import com.cours.ebenus.dao.ICommandeDao;
import com.cours.ebenus.dao.IProduitDao;
import com.cours.ebenus.dao.IRoleDao;
import com.cours.ebenus.dao.IUtilisateurDao;

public interface IServiceFacade {
	
    public IUtilisateurDao getUtilisateurDao();

    public IRoleDao getRoleDao();
    
    public IAdresseDao getAdresseDao();
    
    public IProduitDao getProduitDao();
    
    public ICommandeDao getCommandeDao();
    
    public IArticleCommandeDao getArticleCommandeDao();

}
