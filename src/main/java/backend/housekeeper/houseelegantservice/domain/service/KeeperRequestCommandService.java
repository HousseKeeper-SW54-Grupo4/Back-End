package backend.housekeeper.houseelegantservice.domain.service;

import backend.housekeeper.houseelegantservice.domain.model.aggregates.KeeperRequest;
import backend.housekeeper.houseelegantservice.domain.model.command.CreateKeeperRequestCommand;

public interface KeeperRequestCommandService {
    Long handle(CreateKeeperRequestCommand command);

}