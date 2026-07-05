package com.library.service;

import com.library.DAO.Impl.MemberDAOImpl;
import com.library.DAO.MemberDAO;
import com.library.model.Member;

import java.util.List;

public class MemberService {

    MemberDAO memberDAO = new MemberDAOImpl();

    public Member addMember(Member member) {
        return memberDAO.addMember(member);
    }

    public Member findMemberById(long id) {
        return memberDAO.findMemberById(id);
    }

    public List<Member> fetchAllMembers() {
        return memberDAO.findAllMembers();
    }

    public Member updateMember(Member updateMember) {
        return memberDAO.updateMember(updateMember);
    }
}
