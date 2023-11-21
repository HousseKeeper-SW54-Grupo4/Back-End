package backend.housekeeper.houseelegantservice.domain.service;

import backend.housekeeper.houseelegantservice.domain.model.aggregates.Keeper;
import backend.housekeeper.houseelegantservice.domain.model.queries.GetKeeperAllQuery;
import java.util.List;

public interface KeeperQueryService {
    List<Keeper> handle(GetKeeperAllQuery query);
}