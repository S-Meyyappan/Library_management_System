package com.library.service;

import com.library.DAO.EventRegistrationDAO;
import com.library.DAO.Impl.EventRegistrationDAOImpl;
import com.library.dto.EventRegistrationDto;
import com.library.mapper.EventRegistrationMapper;
import com.library.model.EventRegistration;
import com.library.model.Member;

import java.util.List;

public class EventRegistrationService {

    EventRegistrationDAO eventRegistrationDAO = new EventRegistrationDAOImpl();

    public List<EventRegistrationDto> findEventRegistrationsById(long eventId) {

        EventRegistrationMapper eventRegistrationMapper = new EventRegistrationMapper();

        List<EventRegistration> list = eventRegistrationDAO.findEventRegistrationsById(eventId);

        return list.stream().map(eventRegistrationMapper::mapEntityToDto).toList();

    }

    public List<Member> findNoShowMembers(long eventId) {
        return eventRegistrationDAO.findNoShowMembers(eventId);
    }

}
