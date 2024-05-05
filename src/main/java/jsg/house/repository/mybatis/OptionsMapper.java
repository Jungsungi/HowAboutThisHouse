package jsg.house.repository.mybatis;

import jsg.house.domain.Options;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OptionsMapper {

    void save(Options options);

    void update(Options options);

    Options findByHouseId(Long houseId);
}
