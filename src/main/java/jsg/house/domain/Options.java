package jsg.house.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Options {
    private Long optionsId;
    private Long houseId;
    private String park;
    private String aircon;
    private String refrige;
    private String washer;
    private String gas;
    private String micro;
    private String elevator;
    private String builtin;

    private String createDate;
    private String lastUpdateDate;
}
