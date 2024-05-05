package jsg.house.repository;

import jsg.house.domain.Options;
import jsg.house.repository.mybatis.OptionsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OptionsRepositoryMyBatis implements OptionsRepository{

    private final OptionsMapper optionsMapper;

    @Override
    public void save(Options options) {
        optionsMapper.save(options);
    }

    @Override
    public void update(Options options) {
        optionsMapper.update(options);
    }

    @Override
    public Options findByHouseId(Long houseId) {
        return optionsMapper.findByHouseId(houseId);
    }
}
