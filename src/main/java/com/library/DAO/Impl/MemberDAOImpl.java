package com.library.DAO.Impl;

import com.library.DAO.MemberDAO;
import com.library.config.HbmConfig;
import com.library.model.Member;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

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

    @Override
    public Member findMemberById(long id) {
        try(Session session = sessionFactory.openSession()){
            Member member = session.find(Member.class, id);
            return member;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Member> findAllMembers() {
        try(Session session = sessionFactory.openSession()){
            Query<Member> query = session.createQuery("from Member", Member.class);
            return query.list();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Member updateMember(Member updateMember) {
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            session.merge(updateMember);
            transaction.commit();
            return updateMember;
        } catch (Exception e) {
            if(transaction != null)
                transaction.rollback();
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void deleteMember(long id) {
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            Member member = session.find(Member.class, id);
            session.remove(member);
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null)
                transaction.rollback();
            throw new RuntimeException(e.getMessage());
        }
    }
}
