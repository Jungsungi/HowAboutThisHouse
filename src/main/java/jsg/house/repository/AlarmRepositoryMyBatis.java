package jsg.house.repository;

import jsg.house.domain.Alarm;
import jsg.house.repository.mybatis.AlarmMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AlarmRepositoryMyBatis implements AlarmRepository{

    private final AlarmMapper alarmMapper;

    @Override
    public void save(Alarm alarm) {
        alarmMapper.save(alarm);
    }

    @Override
    public void check(Long alarmId) {
        alarmMapper.check(alarmId);
    }

    @Override
    public void delete(Long alarmId) {
        alarmMapper.delete(alarmId);
    }

    @Override
    public List<Alarm> findByMemberId(Long memberId) {
        return alarmMapper.findByMemberId(memberId);
    }
}
