package jsg.house.service;

import jsg.house.domain.Member;
import jsg.house.exception.MemberFailException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {
    @Autowired MemberService memberService;

    @Test
    @DisplayName("회원가입 테스트")
    void saveMember() throws Exception {
        //given
        Member member = createMember();
        //when
        memberService.saveMember(member);
        Member findMember = memberService.findMemberByUserName("test");
        //then
        assertThat(member.getUserName()).isEqualTo(findMember.getUserName());
    }

    @Test
    @DisplayName("회원 아이디 중복 체크 테스트")
    void uniqueTest() throws Exception {
        //given
        Member member1 = createMember();
        Member member2 = createMember();
        //when

        memberService.saveMember(member1);
        //then
        org.junit.jupiter.api.Assertions.
                assertThrows(Exception.class, () -> memberService.saveMember(member2));

    }

    @Test
    @DisplayName("회원 수정 테스트")
    void updateMember() throws Exception {
        //given
        Member member = createMember();
        memberService.saveMember(member);

        Member findMember = memberService.findMemberByUserName("test");
        String pwd = "비밀번호";
        findMember.setPwd(pwd);
        //when
        memberService.updateMember(findMember);
        Member afterMember = memberService.findMemberByUserName("test");

        //then
        assertThat(findMember.getMemberId()).isEqualTo(afterMember.getMemberId());
        assertThat(afterMember.getPwd()).isEqualTo(pwd);
        assertThat(afterMember.getPwd()).isEqualTo(findMember.getPwd());
    }

    @Test
    @DisplayName("회원 삭제 테스트")
    void deleteMember() throws Exception {
        //given
        Member member = createMember();
        memberService.saveMember(member);

        Member savedMember = memberService.findMemberByUserName(member.getUserName());

        //when
        memberService.deleteMember(savedMember.getMemberId());
        //then
        org.junit.jupiter.api.Assertions.assertThrows(Exception.class, () ->
                memberService.findMemberById(savedMember.getMemberId()));
    }

    private static Member createMember() {
        Member member = new Member();
        member.setUserName("test");
        member.setPwd("pwd");
        member.setName("name");
        member.setEmail("email");
        member.setPhone("phone");
        return member;
    }
}