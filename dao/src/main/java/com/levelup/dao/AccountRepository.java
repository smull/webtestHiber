package com.levelup.dao;

import com.levelup.model.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import javax.security.auth.login.Configuration;

/**
 * Created by SMULL on 14.02.2015.
 */
public class AccountRepository {

    private Session session;

    public AccountRepository() {
        SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();

        session = sessionFactory.openSession();

    }

    public Account getAccountById(Long id){
        Account account = (Account) session.get(Account.class,1);
        return account;
    }

}
