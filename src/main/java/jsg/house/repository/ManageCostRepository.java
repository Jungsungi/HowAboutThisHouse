package jsg.house.repository;

import jsg.house.domain.ManageCost;

public interface ManageCostRepository {

    void save(ManageCost manageCost);

    void update(ManageCost manageCost);

    void delete(Long hoseId);

    ManageCost findByHouseId(Long houseId);
}
