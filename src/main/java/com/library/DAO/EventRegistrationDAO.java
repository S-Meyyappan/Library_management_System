package com.library.DAO;

import com.library.model.EventRegistration;
import com.library.model.Member;

import java.util.List;

public interface EventRegistrationDAO {

    List<Member> findNoShowMembers(long eventId);

}
