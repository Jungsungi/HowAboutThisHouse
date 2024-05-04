package jsg.house.service;

import jsg.house.domain.Member;
import jsg.house.exception.MemberFailException;
import jsg.house.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public void saveMember(Member member) {
        memberRepository.save(member);
        Member findMember = null;

        try {
            findMember = memberRepository.findByUserName(member.getUserName());
        } catch (Exception e){
            throw new MemberFailException(e);
        }


        if (findMember == null) {
            throw new MemberFailException("회원 가입에 실패하였습니다. \n 다시 시도해 주세요.");
        }
    }

    @Transactional
    public void updateMember(Member member) {
        memberRepository.update(member);

        Member findMember = memberRepository.findOne(member.getMemberId());

        if (!member.equals(findMember)) {
            throw new MemberFailException("회원정보 수정에 실패하였습니다. \n 다시 시도해 주세요.");
        }
    }

    public Member findMemberById(Long memberId) {
        Member findMember = memberRepository.findOne(memberId);

        if (findMember == null) {
            throw new MemberFailException("해당 회원은 없는 회원입니다.");
        }
        return findMember;
    }

    public Member findMemberByUserName(String userName) {
        Member findMember = memberRepository.findByUserName(userName);

        return findMember;
    }

    @Transactional
    public void deleteMember(Long memberId) {
        memberRepository.delete(memberId);

        Member findMember = memberRepository.findOne(memberId);
        if (findMember != null) {
            throw new MemberFailException("회원 삭제에 실패하였습니다. \n 다시 시도해 주세요.");
        }
    }
}
