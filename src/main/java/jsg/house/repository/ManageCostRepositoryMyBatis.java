package jsg.house.repository;

import jsg.house.domain.ManageCost;
import jsg.house.repository.ManageCostRepository;
import jsg.house.repository.mybatis.ManageCostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ManageCostRepositoryMyBatis implements ManageCostRepository {

    private final ManageCostMapper manageCostMapper;

    @Override
    public void save(ManageCost manageCost) {
        manageCostMapper.save(manageCost);
    }

    @Override
    public void update(ManageCost manageCost) {
        manageCostMapper.update(manageCost);
    }

    @Override
    public void delete(Long hoseId) {

    }

    @Override
    public ManageCost findByHouseId(Long houseId) {
        return manageCostMapper.findByHouseId(houseId);
    }
}
