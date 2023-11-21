package backend.housekeeper.houseelegantservice.application.internal.queryservices;


import backend.housekeeper.houseelegantservice.domain.model.aggregates.House;
import backend.housekeeper.houseelegantservice.domain.model.queries.GetHouseAllQuery;
import backend.housekeeper.houseelegantservice.domain.service.HouseQueryService;
import backend.housekeeper.houseelegantservice.infrastucture.persistence.jpa.repositories.HouseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseQueryServiceImpl implements HouseQueryService {
    private final HouseRepository houseRepository;

    public HouseQueryServiceImpl(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    @Override
    public List<House> handle(GetHouseAllQuery query) {
        return houseRepository.findAll();
    }
}
