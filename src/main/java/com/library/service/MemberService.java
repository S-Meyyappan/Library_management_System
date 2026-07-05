package com.library.service;

import com.library.DAO.Impl.MemberDAOImpl;
import com.library.DAO.MemberDAO;
import com.library.model.Member;

public class MemberService {

    MemberDAO memberDAO = new MemberDAOImpl();

    public Member addMember(Member member) {
        return memberDAO.addMember(member);
    }
}
