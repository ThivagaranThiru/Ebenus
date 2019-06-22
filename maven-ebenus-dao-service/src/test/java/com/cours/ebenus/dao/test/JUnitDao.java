/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.ebenus.dao.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author thiva
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
	JUnitRoleDao .class,
	JUnitUtilisateurDao.class,
        JUnitProduitDao.class,
        JUnitAdresseDao.class,
        JUnitArticleCommandeDao.class,
        JUnitCommandeDao.class
})

public class JUnitDao extends JUnitEbenus{
    

}
