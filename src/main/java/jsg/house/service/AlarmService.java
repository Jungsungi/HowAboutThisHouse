package jsg.house.service;

import jsg.house.domain.Alarm;
import jsg.house.repository.AlarmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AlarmService {
    private final AlarmRepository alarmRepository;

    public void saveAlarm(Alarm alarm) {
        alarmRepository.save(alarm);
    }

    public void changeCheckFlag(Long memberId) {
        alarmRepository.check(memberId);
    }

    public List<Alarm> findAlarm(Long memberID) {
        return alarmRepository.findByMemberId(memberID);
    }

    public void deleteAlarm(Long alarmId) {
        alarmRepository.delete(alarmId);
    }
}
