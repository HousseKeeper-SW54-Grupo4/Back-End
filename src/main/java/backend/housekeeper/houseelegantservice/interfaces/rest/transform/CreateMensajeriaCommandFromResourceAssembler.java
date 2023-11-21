package backend.housekeeper.houseelegantservice.interfaces.rest.transform;

import backend.housekeeper.houseelegantservice.domain.model.command.CreateMensajeriaCommand;
import backend.housekeeper.houseelegantservice.interfaces.rest.resources.CreateMensajeriaResource;

public class CreateMensajeriaCommandFromResourceAssembler {
    public static CreateMensajeriaCommand toCommandFromResource(CreateMensajeriaResource resource) {
        return new CreateMensajeriaCommand(
                resource.nombre(),
                resource.description(),
                resource.photoFace()
        );
    }
}