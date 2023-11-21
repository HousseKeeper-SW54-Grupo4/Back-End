package backend.housekeeper.houseelegantservice.domain.service;

import backend.housekeeper.houseelegantservice.domain.model.aggregates.Viaje;
import backend.housekeeper.houseelegantservice.domain.model.command.CreateViajeCommand;

public interface ViajeCommandService {
    Long handle(CreateViajeCommand command);
}
