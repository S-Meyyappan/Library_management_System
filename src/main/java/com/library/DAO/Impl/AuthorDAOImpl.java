package com.library.DAO.Impl;

import com.library.DAO.AuthorDAO;
import com.library.config.HbmConfig;
import com.library.model.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

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

    @Override
    public Author findAuthorById(long id) {
        try(Session session = sessionFactory.openSession()){
            Author author = session.find(Author.class,id);
            return author;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Author> fetchAllAuthors() {
        try(Session session = sessionFactory.openSession()){
            Query<Author> query = session.createQuery("from Author", Author.class);
            return query.getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
