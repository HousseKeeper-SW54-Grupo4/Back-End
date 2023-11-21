package backend.housekeeper.houseelegantservice.application.internal.commandservices;

import backend.housekeeper.houseelegantservice.domain.model.aggregates.KeeperRequest;
import backend.housekeeper.houseelegantservice.domain.model.command.CreateKeeperRequestCommand;
import backend.housekeeper.houseelegantservice.domain.service.KeeperRequestCommandService;
import backend.housekeeper.houseelegantservice.infrastucture.persistence.jpa.repositories.KeeperRequestRepository;
import org.springframework.stereotype.Service;

@Service
public class KeeperRequestCommandServiceImpl  implements KeeperRequestCommandService {
    private final KeeperRequestRepository keeperRequestRepository;

    public KeeperRequestCommandServiceImpl(KeeperRequestRepository keeperRequestRepository) {
        this.keeperRequestRepository = keeperRequestRepository;
    }


    @Override
    public Long handle(CreateKeeperRequestCommand command) {
        var keeperRequest = new KeeperRequest(command.name(), command.message(), command.photoUrl(),
                command.rating());
        keeperRequestRepository.save(keeperRequest);
        return keeperRequest.getId();
    }
}