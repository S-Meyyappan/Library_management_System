package com.library.DAO.Impl;

import com.library.DAO.BookDAO;
import com.library.config.HbmConfig;
import com.library.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class BookDAOImpl implements BookDAO {

    private final SessionFactory sessionFactory;

    public BookDAOImpl() {
        sessionFactory = HbmConfig.getSessionFactory();
    }

    @Override
    public Book addBook(Book book) {
        Transaction transaction = null;

        try(Session session = sessionFactory.openSession()){

            transaction = session.beginTransaction();
            session.persist(book.getAuthor());
            session.persist(book);
            transaction.commit();
            return book;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException(e.getMessage());
        }
    }
}
