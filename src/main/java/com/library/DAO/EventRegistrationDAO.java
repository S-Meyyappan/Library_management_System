package com.library.DAO;

import com.library.model.EventRegistration;
import com.library.model.Member;

import java.util.List;

public interface EventRegistrationDAO {

    List<EventRegistration> findEventRegistrationsById(long eventId);

    List<Member> findNoShowMembers(long eventId);

}
