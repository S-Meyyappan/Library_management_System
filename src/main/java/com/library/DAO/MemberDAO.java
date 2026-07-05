package com.library.DAO;

import com.library.model.Member;

import java.util.List;

public interface MemberDAO {
    Member addMember(Member member);

    Member findMemberById(long id);

    List<Member> findAllMembers();

    Member updateMember(Member updateMember);
}
