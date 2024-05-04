package jsg.house.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class House {

    private Long houseId;
    private String title;
    private int deposit;
    private String type;
    private String dealType;
    private int hit;
    private int floor;
    private int price;
    private int area;
    private String aspect;
    private String loc;
    private String detail;
    private Long memberId;
    private int manage;
    private String state;
    private String lat;
    private String lng;
    private String inputTime;

    private String createDate;
    private String lastUpdateDate;

    private String useYn;
}
