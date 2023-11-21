package backend.housekeeper.houseelegantservice.domain.service;

import backend.housekeeper.houseelegantservice.domain.model.aggregates.House;
import backend.housekeeper.houseelegantservice.domain.model.queries.GetHouseByIdQuery;

import java.util.Optional;

public interface HouseQueryService {
    Optional<House> handle(GetHouseByIdQuery query);
}
