package backend.housekeeper.houseelegantservice.domain.service;

import backend.housekeeper.houseelegantservice.domain.model.aggregates.House;
import backend.housekeeper.houseelegantservice.domain.model.queries.GetHouseAllQuery;

import java.util.List;
import java.util.Optional;

public interface HouseQueryService {
    List<House> handle(GetHouseAllQuery query);
}
