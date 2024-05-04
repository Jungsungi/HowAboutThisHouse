package jsg.house.repository.mybatis;

import jsg.house.domain.House;
import jsg.house.domain.HouseSearch;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HouseMapper {

    void save(House house);

    void update(House house);

    void delete(Long houseId);

    House findById(Long houseId);

    List<House> findByUserId(Long userId);

    List<House> findAll(HouseSearch houseSearch);
}
