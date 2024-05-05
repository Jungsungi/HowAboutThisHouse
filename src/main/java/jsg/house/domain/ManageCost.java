package jsg.house.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ManageCost {
    private Long manageCostId;
    private Long houseId;
    private int elecCost;
    private int waterCost;
    private int internetCost;
    private int gasCost;
    private int parkCost;

    private String createDate;
    private String lastUpdateDate;
}
