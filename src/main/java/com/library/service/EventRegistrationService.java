package com.library.service;

import com.library.DAO.EventRegistrationDAO;
import com.library.DAO.Impl.EventRegistrationDAOImpl;
import com.library.model.EventRegistration;
import com.library.model.Member;

import java.util.List;

public class EventRegistrationService {

    EventRegistrationDAO eventRegistrationDAO = new EventRegistrationDAOImpl();

    public EventRegistration findEventById(long eventId) {
        return eventRegistrationDAO.findEventById(eventId);
    }

    public List<Member> findNoShowMembers(long eventId) {
        return eventRegistrationDAO.findNoShowMembers(eventId);
    }

}
