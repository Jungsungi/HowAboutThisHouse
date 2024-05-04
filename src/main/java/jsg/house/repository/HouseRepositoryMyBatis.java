package jsg.house.repository;

import jsg.house.domain.House;
import jsg.house.domain.HouseSearch;
import jsg.house.repository.mybatis.HouseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class HouseRepositoryMyBatis implements HouseRepository {

    private final HouseMapper houseMapper;
    @Override
    public void save(House house) {
        houseMapper.save(house);
    }

    @Override
    public void update(House house) {
        houseMapper.update(house);
    }

    @Override
    public void delete(Long houseId) {
        houseMapper.delete(houseId);
    }

    @Override
    public House findById(Long houseId) {
        return houseMapper.findById(houseId);
    }

    @Override
    public List<House> findByUserId(Long userId) {
        return houseMapper.findByUserId(userId);
    }

    @Override
    public List<House> findAll(HouseSearch houseSearch) {
        return houseMapper.findAll(houseSearch);
    }
}
