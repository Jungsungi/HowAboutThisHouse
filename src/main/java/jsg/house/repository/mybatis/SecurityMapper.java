package jsg.house.repository.mybatis;

import jsg.house.domain.Security;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SecurityMapper {

    void save(Security security);

    void update(Security security);

    Security findByHouseId(Long houseId);
}
