package com.cours.ebenus.factory;

import com.cours.ebenus.dao.DriverManagerSingleton;
import com.cours.ebenus.dao.IAdresseDao;
import com.cours.ebenus.dao.IArticleCommandeDao;
import com.cours.ebenus.dao.ICommandeDao;
import com.cours.ebenus.dao.IProduitDao;
import com.cours.ebenus.dao.IRoleDao;
import com.cours.ebenus.dao.IUtilisateurDao;
import com.cours.ebenus.dao.impl.AdresseDao;
import com.cours.ebenus.dao.impl.ArticleCommandeDao;
import com.cours.ebenus.dao.impl.CommandeDao;
import com.cours.ebenus.dao.impl.ProduitDao;
import com.cours.ebenus.dao.impl.RoleDao;
import com.cours.ebenus.dao.impl.UtilisateurDao;

public class DaoFactory extends AbstractDaoFactory{
	
    protected static final DriverManagerSingleton con = DriverManagerSingleton.getInstance();

    @Override
    public IUtilisateurDao getUtilisateurDao() {
        // TODO Auto-generated method stub
	return new UtilisateurDao(con.getConnectionInstance());
    }

    @Override
    public IRoleDao getRoleDao() {
	// TODO Auto-generated method stub
        return new RoleDao(con.getConnectionInstance());
    }

    @Override
    public IAdresseDao getAdresseDao() {
        // TODO Auto-generated method stub
	return new AdresseDao(con.getConnectionInstance());
    }

    @Override
    public IProduitDao getProduitDao() {
	// TODO Auto-generated method stub
	return new ProduitDao(con.getConnectionInstance());
    }

    @Override
    public ICommandeDao getCommandeDao() {
	// TODO Auto-generated method stub
	return new CommandeDao(con.getConnectionInstance());
    }

    @Override
    public IArticleCommandeDao getArticleCommandeDao() {
	// TODO Auto-generated method stub
	return new ArticleCommandeDao(con.getConnectionInstance());
    }
}
