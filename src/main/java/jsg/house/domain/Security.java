package jsg.house.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Security {
    private Long securityId;
    private Long houseId;
    private String cctv;
    private String videoPhone;
    private String interPhone;
    private String fireAlarm;
    private String frontDoor;

    private String createDate;
    private String lastUpdateDate;
}
