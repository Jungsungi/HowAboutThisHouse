package jsg.house.repository;

import jsg.house.domain.House;
import jsg.house.domain.HouseSearch;

import java.util.List;

public interface HouseRepository {

    void save(House house);

    void update(House house);

    void delete(Long houseId);

    House findById(Long houseId);

    List<House> findByUserId(Long userId);

    List<House> findAll(HouseSearch houseSearch);
}
