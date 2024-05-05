package jsg.house.repository;


import jsg.house.domain.Security;

public interface SecurityRepository {

    void save(Security security);

    void update(Security security);

    Security findByHouseId(Long houseId);
}
