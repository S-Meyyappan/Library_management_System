package com.library.DAO.Impl;

import com.library.DAO.AuthorDAO;
import com.library.config.HbmConfig;
import com.library.model.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class AuthorDAOImpl implements AuthorDAO {

    private final SessionFactory sessionFactory;

    public AuthorDAOImpl() {
        sessionFactory = HbmConfig.getSessionFactory();
    }

    @Override
    public Author addAuthor(Author author) {
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            session.persist(author);
            transaction.commit();
            return author;
        } catch (Exception e) {
            if(transaction != null)
                transaction.rollback();
            throw new RuntimeException(e.getMessage());
        }
    }
}
