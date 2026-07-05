package com.library.DAO.Impl;

import com.library.DAO.MemberDAO;
import com.library.config.HbmConfig;
import com.library.model.Member;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class MemberDAOImpl implements MemberDAO {

    private final SessionFactory sessionFactory;

    public MemberDAOImpl() {
        sessionFactory = HbmConfig.getSessionFactory();
    }

    @Override
    public Member addMember(Member member) {
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            session.persist(member);
            transaction.commit();
            return member;
        } catch (Exception e) {
            if(transaction != null)
                transaction.rollback();
            throw new RuntimeException(e.getMessage());
        }
    }
}
