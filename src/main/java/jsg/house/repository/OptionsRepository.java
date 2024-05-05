package jsg.house.repository;

import jsg.house.domain.Options;

public interface OptionsRepository {

    void save(Options options);

    void update(Options options);

    Options findByHouseId(Long houseId);
}
