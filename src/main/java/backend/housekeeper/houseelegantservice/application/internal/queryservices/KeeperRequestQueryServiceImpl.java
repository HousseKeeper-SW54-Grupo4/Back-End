package backend.housekeeper.houseelegantservice.application.internal.queryservices;

import backend.housekeeper.houseelegantservice.domain.model.aggregates.KeeperRequest;
import backend.housekeeper.houseelegantservice.domain.model.query.GetAllKeeperRequestsQuery;
import backend.housekeeper.houseelegantservice.domain.model.query.GetKeeperRequestByIdQuery;
import backend.housekeeper.houseelegantservice.domain.service.KeeperRequestQueryService;
import backend.housekeeper.houseelegantservice.infrastucture.persistence.jpa.repositories.KeeperRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KeeperRequestQueryServiceImpl implements KeeperRequestQueryService {

    private final KeeperRequestRepository keeperRequestRepository;

    @Autowired
    public KeeperRequestQueryServiceImpl(KeeperRequestRepository keeperRequestRepository) {
        this.keeperRequestRepository = keeperRequestRepository;
    }

    @Override
    public Optional<KeeperRequest> handle(GetKeeperRequestByIdQuery query) {
        return keeperRequestRepository.findById(query.requestId());
    }

    @Override
    public List<KeeperRequest> handle(GetAllKeeperRequestsQuery query) {
        return keeperRequestRepository.findAll();
    }
}