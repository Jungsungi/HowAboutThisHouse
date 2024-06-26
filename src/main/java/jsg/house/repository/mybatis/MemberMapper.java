package jsg.house.repository.mybatis;

import jsg.house.domain.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MemberMapper {

    void save (Member member);

    void update (Member member);

    Member findOne (Long id);

    Member findByUserName (String userName);

    void delete(Long memberId);

    Member login(@Param("userName") String loginId, @Param("pwd") String loginPwd);

}
