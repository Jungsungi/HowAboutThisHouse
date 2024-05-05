package jsg.house.repository;

import jsg.house.domain.Security;
import jsg.house.repository.mybatis.SecurityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class SecurityRepositoryMyBatis implements SecurityRepository{

    private final SecurityMapper securityMapper;

    @Override
    public void save(Security security) {
        securityMapper.save(security);
    }

    @Override
    public void update(Security security) {
        securityMapper.update(security);
    }

    @Override
    public Security findByHouseId(Long houseId) {
        return securityMapper.findByHouseId(houseId);
    }
}
