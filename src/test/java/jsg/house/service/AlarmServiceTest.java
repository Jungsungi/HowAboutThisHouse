package jsg.house.service;

import jsg.house.domain.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class AlarmServiceTest {
    @Autowired HouseService houseService;
    @Autowired AlarmService alarmService;
    @Autowired MemberService memberService;

    @Test
    void alarmInsert() throws Exception {
        //given
        memberService.saveMember(createMember());

        Member member = memberService.findMemberByUserName("test");

        House house = createHouse(member);
        ManageCost manageCost = createManageCost();
        Options options = createOption();
        Security security = createSecurity();

        houseService.saveHouse(house, manageCost, options, security);

        Alarm alarm = createAlarm();
        alarm.setHouseId(house.getHouseId());
        alarm.setMemberId(member.getMemberId());

        //when
        alarmService.saveAlarm(alarm);
        List<Alarm> alarm1 = alarmService.findAlarm(alarm.getMemberId());

        //then
        assertThat(alarm1.size()).isEqualTo(1);
        assertThat(alarm1.get(0).getContent()).isEqualTo("알람 등록");
    }

    private static House createHouse(Member member) {
        House house = new House();
        house.setTitle("title");
        house.setMemberId(member.getMemberId());
        house.setDetail("detail");
        house.setState("Y");
        house.setLat("123");
        house.setLng("123");
        house.setManage(10000);
        house.setArea(123);
        house.setLoc("loc");
        house.setAspect("aspect");
        house.setPrice(10000);
        house.setFloor(3);
        house.setType("type");
        house.setDeposit(12);
        house.setDealType("123");

        return house;
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

    private static ManageCost createManageCost() {
        ManageCost manageCost = new ManageCost();

        manageCost.setWaterCost(10000);
        manageCost.setInternetCost(5000);
        manageCost.setGasCost(30000);
        manageCost.setParkCost(20000);
        manageCost.setElecCost(30000);

        return manageCost;
    }

    private static Options createOption() {
        Options options = new Options();

        options.setGas("Y");
        return options;
    }

    private static Security createSecurity() {
        Security security = new Security();

        security.setCctv("Y");
        security.setFireAlarm("Y");

        return security;
    }

    private static Alarm createAlarm() {
        Alarm alarm = new Alarm();
        alarm.setContent("알람 등록");
        alarm.setType("I");

        return alarm;
    }

}