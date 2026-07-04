package com.library.DAO.Impl;

import com.library.DAO.BookDAO;
import com.library.config.HbmConfig;
import com.library.model.Book;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

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
            // Add author first
            session.persist(book.getAuthor());
            // Add book
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

    @Override
    public Book findBookById(long id) {
        try(Session session = sessionFactory.openSession()){
            Book book = session.find(Book.class, id);
            return book;
        }
    }

    @Override
    public List<Book> fetchAllBooks() {
        Transaction transaction = null;

        try(Session session = sessionFactory.openSession()){
            Query<Book> query = session.createQuery("from Book",Book.class);
            List<Book> list = query.getResultList();
            return list;
        }
    }
}
