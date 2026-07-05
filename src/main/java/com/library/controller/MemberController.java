package com.library.controller;

import com.library.model.Member;
import com.library.service.MemberService;

public class MemberController {
    MemberService memberService = new MemberService();

    public Member addMember(Member member) {
        return memberService.addMember(member);
    }

    public Member findMemberById(long id) {
        return memberService.findMemberById(id);
    }
}
