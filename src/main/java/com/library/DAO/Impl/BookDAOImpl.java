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

    @Override
    public Book updateBook(Book updateBook) {
        Transaction transaction = null;

        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            session.merge(updateBook);
            transaction.commit();
            return session.find(Book.class, updateBook.getId());
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void deleteBook(long id) {
        Transaction transaction = null;

        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            Book book = session.find(Book.class, id);
            session.remove(book);
            transaction.commit();
        } catch (Exception e) {

            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Book> getBooksByAuthor(long authorId) {
        try(Session session = sessionFactory.openSession()){
            //JPQL Implementation
            // Explicit Join Query
            Query<Book> query = session.createQuery("select b from Book b join b.author a where a.id = :authorId",Book.class);
            query.setParameter("authorId",authorId);
            List<Book> list = query.getResultList();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Book> getBooksByBorrower(long borrowerId) {
        try(Session session = sessionFactory.openSession()){
            //HQL Implementation
            Query<Book> query = session.createQuery("from Book b where b.borrower.id = :borrowerId",Book.class);
            query.setParameter("borrowerId",borrowerId);
            List<Book> list = query.getResultList();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
