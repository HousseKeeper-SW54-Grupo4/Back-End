package backend.housekeeper.houseelegantservice.domain.service;

import backend.housekeeper.houseelegantservice.domain.model.command.CreateMensajeriaCommand;
import org.springframework.stereotype.Service;

public interface MensajeriaCommandService {
    Long handle (CreateMensajeriaCommand command);
}
