package backend.housekeeper.houseelegantservice.interfaces.rest.transform;

import backend.housekeeper.houseelegantservice.domain.model.command.CreateViajeCommand;
import backend.housekeeper.houseelegantservice.interfaces.rest.resources.CreateViajeResource;

public class CreateViajeCommandFromResourceAssembler {
    public static CreateViajeCommand toCommandFromResource(CreateViajeResource resource) {
        return new CreateViajeCommand(
                resource.title(),
                resource.description(),
                resource.photoUrl(),
                resource.rating()
        );
    }
}