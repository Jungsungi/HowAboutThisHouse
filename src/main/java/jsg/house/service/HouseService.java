package jsg.house.service;

import jsg.house.domain.*;
import jsg.house.repository.HouseRepository;
import jsg.house.repository.ManageCostRepository;
import jsg.house.repository.OptionsRepository;
import jsg.house.repository.SecurityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class HouseService {

    private final HouseRepository houseRepository;
    private final ManageCostRepository manageCostRepository;
    private final OptionsRepository optionsRepository;
    private final SecurityRepository securityRepository;

    public void saveHouse(House house, ManageCost manageCost, Options options, Security security) {
        houseRepository.save(house);

        Long houseId = house.getHouseId();

        manageCost.setHouseId(houseId);
        options.setHouseId(houseId);
        security.setHouseId(houseId);

        manageCostRepository.save(manageCost);
        optionsRepository.save(options);
        securityRepository.save(security);
    }

    public void updateHouse(House house) {
        houseRepository.update(house);
    }

    public void deleteHouse(Long houseId) {
        houseRepository.delete(houseId);
    }

    public House findHouseById(Long hoseId) {
        return houseRepository.findById(hoseId);
    }

    public List<House> findHouseByUserId(Long userId) {
        return houseRepository.findByUserId(userId);
    }

    public List<House> searchHouse(HouseSearch houseSearch) {
        return houseRepository.findAll(houseSearch);
    }
}
