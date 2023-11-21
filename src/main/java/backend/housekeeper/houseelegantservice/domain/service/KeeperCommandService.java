package backend.housekeeper.houseelegantservice.domain.service;

import backend.housekeeper.houseelegantservice.domain.model.aggregates.Keeper;
import backend.housekeeper.houseelegantservice.domain.model.command.CreateKeeperCommand;
import backend.housekeeper.houseelegantservice.domain.model.command.UpdateKeeperProfileCommand;

import java.util.Optional;


public interface KeeperCommandService {
    Long handle (CreateKeeperCommand command);
    Optional<Keeper> handle(UpdateKeeperProfileCommand command);
}
