package com.library.DAO.Impl;

import com.library.DAO.EventRegistrationDAO;
import com.library.config.HbmConfig;
import com.library.enums.AttendanceStatus;
import com.library.model.EventRegistration;
import com.library.model.Member;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class EventRegistrationDAOImpl implements EventRegistrationDAO {

    private final SessionFactory sessionFactory;

    public EventRegistrationDAOImpl(){
        sessionFactory = HbmConfig.getSessionFactory();
    }

    @Override
    public List<EventRegistration> findEventRegistrationsById(long eventId) {
        try(Session session = sessionFactory.openSession()){
            String jpql = """
                    select er
                    from EventRegistration er
                    where er.libraryEvent.id = :eventId
                    """;
            Query<EventRegistration> query = session.createQuery(jpql, EventRegistration.class);
            query.setParameter("eventId",eventId);
            List<EventRegistration> list = query.getResultList();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    @Override
    public List<Member> findNoShowMembers(long eventId) {
        try(Session session = sessionFactory.openSession()){
            String jpql = """
                    select er.member
                    from EventRegistration er
                    where er.libraryEvent.id = :eventId
                    and er.attendanceStatus = :attendanceStatus
                    """;
            Query<Member> query = session.createQuery(jpql,Member.class);
            query.setParameter("eventId", eventId);
            query.setParameter("attendanceStatus", AttendanceStatus.NO_SHOW);
            return query.getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
