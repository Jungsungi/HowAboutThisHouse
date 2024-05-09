package jsg.house.repository.mybatis;

import jsg.house.domain.Alarm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AlarmMapper {

    void save(Alarm alarm);

    void check(Long alarmId);

    void delete(Long alarmId);

    List<Alarm> findByMemberId(Long memberId);
}
