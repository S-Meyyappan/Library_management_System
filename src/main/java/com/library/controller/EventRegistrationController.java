package com.library.controller;

import com.library.model.EventRegistration;
import com.library.model.Member;
import com.library.service.EventRegistrationService;

import java.util.List;

public class EventRegistrationController {

    EventRegistrationService eventRegistrationService = new EventRegistrationService();

    public List<EventRegistration> findEventRegistrationsById(long eventId) {
        return eventRegistrationService.findEventRegistrationsById(eventId);
    }

    public List<Member> findNoShowMembers(long eventId) {
        return eventRegistrationService.findNoShowMembers(eventId);
    }

}
