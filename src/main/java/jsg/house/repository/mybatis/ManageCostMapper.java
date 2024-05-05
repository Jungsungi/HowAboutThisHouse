package jsg.house.repository.mybatis;

import jsg.house.domain.ManageCost;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ManageCostMapper {

    void save(ManageCost manageCost);

    void update(ManageCost manageCost);

    void delete(Long hoseId);

    ManageCost findByHouseId(Long houseId);
}
