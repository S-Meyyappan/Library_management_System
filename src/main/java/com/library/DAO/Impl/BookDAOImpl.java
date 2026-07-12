package com.library.DAO.Impl;

import com.library.DAO.BookDAO;
import com.library.config.HbmConfig;
import com.library.enums.BookStatus;
import com.library.enums.Genre;
import com.library.model.Book;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
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
            Query<Book> query = session.createQuery("select b "+
                                                        "from Book b "+
                                                        "join b.author a "+
                                                        "where a.id = :authorId",Book.class);
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

    @Override
    public List<Book> getBooksByGenreAndStatus(Genre genre, BookStatus bookStatus) {
        try(Session session = sessionFactory.openSession()){

            // 1. Create Builder
            CriteriaBuilder cb = session.getCriteriaBuilder();

            // 2. Create Query of the type Book class
            CriteriaQuery<Book> cq = cb.createQuery(Book.class);

            // 3. Create Root using "from"
            Root<Book> root = cq.from(Book.class);

            // 4. Create List of Predicates
            List<Predicate> predicates = new ArrayList<>();

            // 4.1 Check null and add predicates to the list by comp
            if (genre != null) {
                predicates.add(cb.equal(root.get("genre"),genre));
            }

            // 4.2 Check null and add predicates to the list
            if (bookStatus != null) {
                predicates.add(cb.equal(root.get("status"),bookStatus));
            }

            // 5. Add all predicates to the query using "where"
            cq.where(cb.and(predicates.toArray(new Predicate[0])));

            // 6. Create Query object
            Query<Book> query = session.createQuery(cq);

            // 7. Get Result List
            List<Book> list = query.getResultList();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
