package backend.housekeeper.houseelegantservice.domain.service;

import backend.housekeeper.houseelegantservice.domain.model.aggregates.House;
import backend.housekeeper.houseelegantservice.domain.model.command.CreateHouseCommand;
import backend.housekeeper.houseelegantservice.domain.model.command.UpdateHouseCommand;

import java.util.Optional;

public interface HouseCommandService {
    Long handle(CreateHouseCommand command);
    Optional<House> handle(UpdateHouseCommand command);
}
