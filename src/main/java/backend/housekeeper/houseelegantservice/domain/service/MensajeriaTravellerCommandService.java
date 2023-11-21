package backend.housekeeper.houseelegantservice.domain.service;

//import backend.housekeeper.houseelegantservice.domain.model.command.CreateMensajeriaTravellerCommand;



import backend.housekeeper.houseelegantservice.domain.model.aggregates.MensajeriaTraveller;

import backend.housekeeper.houseelegantservice.domain.model.command.CreateMensajeriaTravellerCommand;

public interface MensajeriaTravellerCommandService {
    Long handle(CreateMensajeriaTravellerCommand command);

}
