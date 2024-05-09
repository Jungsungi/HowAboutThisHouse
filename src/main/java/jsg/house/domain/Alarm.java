package jsg.house.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Alarm {
    private Long alarmId;

    private String content;
    private String type;
    private String checkFlag;
    private Long memberId;
    private Long houseId;

    private String createDate;
    private String lastUpdateDate;
}
