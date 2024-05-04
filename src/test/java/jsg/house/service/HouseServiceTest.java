package jsg.house.service;

import jsg.house.domain.House;
import jsg.house.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HouseServiceTest {

    @Autowired HouseService houseService;
    @Autowired MemberService memberService;

    @Test
    void saveHouse() throws Exception {
        //given


        memberService.saveMember(createMember());
        Member member = memberService.findMemberByUserName("test");

        House house = createHouse(member);
        houseService.saveHouse(house);

        //when
        List<House> houseByUserId = houseService.findHouseByUserId(member.getMemberId());

        //then
        assertThat(houseByUserId.size()).isEqualTo(1);
        assertThat(houseByUserId.get(0).getTitle()).isEqualTo("title");
    }

    @Test
    void updateHouse() throws Exception {
        //given
        memberService.saveMember(createMember());
        Member member = memberService.findMemberByUserName("test");

        House house = createHouse(member);
        houseService.saveHouse(house);
        House findHouse = houseService.findHouseById(1L);
        //when
        findHouse.setTitle("Title");
        houseService.updateHouse(findHouse);

        findHouse = houseService.findHouseById(1L);

        //then
        assertThat(findHouse.getTitle()).isEqualTo("Title");
    }

    @Test
    void deleteHouse() throws Exception {
        //given
        memberService.saveMember(createMember());
        Member member = memberService.findMemberByUserName("test");

        House house = createHouse(member);
        houseService.saveHouse(house);

        //when
        houseService.deleteHouse(1L);
        House findHouse = houseService.findHouseById(1L);

        //then
        assertThat(findHouse).isNull();
    }

    @Test
    void findByUserId() throws Exception {
        //given
        memberService.saveMember(createMember());
        Member member = memberService.findMemberByUserName("test");

        House house1 = createHouse(member);
        House house2 = createHouse(member);

        houseService.saveHouse(house1);
        houseService.saveHouse(house2);

        //when
        List<House> findHouse = houseService.findHouseByUserId(member.getMemberId());

        //then
        assertThat(findHouse.size()).isEqualTo(2);
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
}