package com.library.controller;

import com.library.model.Member;
import com.library.service.MemberService;

import java.util.List;

public class MemberController {
    MemberService memberService = new MemberService();

    public Member addMember(Member member) {
        return memberService.addMember(member);
    }

    public Member findMemberById(long id) {
        return memberService.findMemberById(id);
    }

    public List<Member> fetchAllBooks() {
        return memberService.fetchAllMembers();
    }

    public Member updateBook(Member updateMember) {
        return memberService.updateMember(updateMember);
    }

    public void deleteMember(long id) {
        memberService.deleteMember(id);
    }
}
