package jsg.house.repository;

import jsg.house.domain.Member;

public interface MemberRepository {
    void save (Member member);

    void update (Member member);

    Member findOne (Long id);

    Member findByUserName (String userName);

    void delete(Long memberId);

    Member login(String loginId, String loginPwd);
}
