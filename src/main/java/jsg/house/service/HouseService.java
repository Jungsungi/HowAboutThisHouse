package jsg.house.service;

import jsg.house.domain.House;
import jsg.house.domain.HouseSearch;
import jsg.house.repository.HouseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class HouseService {

    private final HouseRepository houseRepository;

    public void saveHouse(House house) {
        houseRepository.save(house);
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
