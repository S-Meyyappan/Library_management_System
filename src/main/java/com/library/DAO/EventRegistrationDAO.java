package com.library.DAO;

import com.library.model.EventRegistration;
import com.library.model.Member;

import java.util.List;

public interface EventRegistrationDAO {

    EventRegistration findEventById(long eventId);

    List<Member> findNoShowMembers(long eventId);

}
