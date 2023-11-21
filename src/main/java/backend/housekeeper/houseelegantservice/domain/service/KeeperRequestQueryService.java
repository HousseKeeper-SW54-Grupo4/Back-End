package backend.housekeeper.houseelegantservice.domain.service;

import backend.housekeeper.houseelegantservice.domain.model.aggregates.KeeperRequest;
import backend.housekeeper.houseelegantservice.domain.model.query.GetAllKeeperRequestsQuery;
import backend.housekeeper.houseelegantservice.domain.model.query.GetKeeperRequestByIdQuery;

import java.util.List;
import java.util.Optional;

public interface KeeperRequestQueryService {
    Optional<KeeperRequest> handle(GetKeeperRequestByIdQuery query);
    List<KeeperRequest> handle(GetAllKeeperRequestsQuery query);
}
