package backend.housekeeper.houseelegantservice.interfaces.rest.transform;

import backend.housekeeper.houseelegantservice.domain.model.command.CreateKeeperRequestCommand;
import backend.housekeeper.houseelegantservice.interfaces.rest.resources.CreateKeeperRequestResource;

public class CreateKeeperRequestCommandFromResourceAssembler {
    public static CreateKeeperRequestCommand toCommandFromResource(CreateKeeperRequestResource resource) {
        return new CreateKeeperRequestCommand(
                resource.name(),
                resource.message(),
                resource.photoUrl(),
                resource.rating()
        );
    }
}