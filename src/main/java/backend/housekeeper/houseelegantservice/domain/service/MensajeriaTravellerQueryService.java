package backend.housekeeper.houseelegantservice.domain.service;
import backend.housekeeper.houseelegantservice.domain.model.aggregates.MensajeriaTraveller;
import backend.housekeeper.houseelegantservice.domain.model.query.GetAllMensajesQuery;
import backend.housekeeper.houseelegantservice.domain.model.query.GetMensajeriaTravellerByIdQuery;

import java.util.List;
import java.util.Optional;

public interface MensajeriaTravellerQueryService {
    Optional<MensajeriaTraveller> handle(GetMensajeriaTravellerByIdQuery query);
    List<MensajeriaTraveller> handle(GetAllMensajesQuery query);
}
