package backend.housekeeper.houseelegantservice.interfaces.rest.transform;


import backend.housekeeper.houseelegantservice.domain.model.command.CreateMensajeriaCommand;
import backend.housekeeper.houseelegantservice.domain.model.command.CreateMensajeriaTravellerCommand;
import backend.housekeeper.houseelegantservice.interfaces.rest.resources.CreateMensajeriaTravellerResource;

public class CreateMensajeriaTravellerCommandFromResourceAssembler {
    public static CreateMensajeriaTravellerCommand toCommandFromResource(CreateMensajeriaTravellerResource resource)  {
        return new CreateMensajeriaTravellerCommand(
                resource.nombre(),
                resource.description(),
                resource.photoFace()
        );

    }
}
