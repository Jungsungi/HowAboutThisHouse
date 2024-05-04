package jsg.house.repository;

import jsg.house.domain.Member;
import jsg.house.repository.mybatis.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryMyBatis implements MemberRepository{

    private final MemberMapper memberMapper;

    @Override
    public void save(Member member) {
        memberMapper.save(member);
    }

    @Override
    public void update(Member member) {
        memberMapper.update(member);
    }

    @Override
    public Member findOne(Long id) {
        return memberMapper.findOne(id);
    }

    @Override
    public Member findByUserName(String userName) {
        return memberMapper.findByUserName(userName);
    }

    @Override
    public void delete(Long memberId) {
        memberMapper.delete(memberId);
    }
}
