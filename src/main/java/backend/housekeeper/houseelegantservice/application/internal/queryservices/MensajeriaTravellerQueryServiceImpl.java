package backend.housekeeper.houseelegantservice.application.internal.queryservices;

import backend.housekeeper.houseelegantservice.domain.model.aggregates.MensajeriaTraveller;
import backend.housekeeper.houseelegantservice.domain.model.query.GetAllMensajesQuery;
import backend.housekeeper.houseelegantservice.domain.model.query.GetMensajeriaTravellerByIdQuery;
import backend.housekeeper.houseelegantservice.domain.service.MensajeriaTravellerQueryService;
import backend.housekeeper.houseelegantservice.infrastucture.persistence.jpa.repositories.MensajeriaTravellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MensajeriaTravellerQueryServiceImpl implements MensajeriaTravellerQueryService {
    private final MensajeriaTravellerRepository mensajeriaTravellerRepository;

    @Autowired
    public MensajeriaTravellerQueryServiceImpl(MensajeriaTravellerRepository mensajeriaTravellerRepository) {
        this.mensajeriaTravellerRepository = mensajeriaTravellerRepository;
    }

    @Override
    public Optional<MensajeriaTraveller> handle(GetMensajeriaTravellerByIdQuery query) {
        return mensajeriaTravellerRepository.findById(query.mensajeriaTravellerId());
    }

    @Override
    public List<MensajeriaTraveller> handle(GetAllMensajesQuery query) {
        return mensajeriaTravellerRepository.findAll();
    }
}
