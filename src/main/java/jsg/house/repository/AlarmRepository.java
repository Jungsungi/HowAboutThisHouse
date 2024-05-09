package jsg.house.repository;

import jsg.house.domain.Alarm;

import java.util.List;

public interface AlarmRepository {

    void save(Alarm alarm);

    void check(Long alarmId);

    void delete(Long alarmId);

    List<Alarm> findByMemberId(Long memberId);
}
