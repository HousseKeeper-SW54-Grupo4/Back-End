package backend.housekeeper.houseelegantservice.application.internal.queryservices;

import backend.housekeeper.houseelegantservice.domain.model.aggregates.Mensajeria;
import backend.housekeeper.houseelegantservice.domain.model.query.GetAllMensajesQuery;
import backend.housekeeper.houseelegantservice.domain.model.query.GetMensajeriaByIdQuery;
import backend.housekeeper.houseelegantservice.domain.service.MensajeriaQueryService;
import backend.housekeeper.houseelegantservice.infrastucture.persistence.jpa.repositories.MensajeriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MensajeriaQueryServiceImpl implements MensajeriaQueryService {

    private final MensajeriaRepository mensajeriaRepository;

    public MensajeriaQueryServiceImpl(MensajeriaRepository mensajeriaRepository) {
        this.mensajeriaRepository = mensajeriaRepository;
    }

    @Override
    public Optional<Mensajeria> handle(GetMensajeriaByIdQuery query) {
        return mensajeriaRepository.findById(query.mensajeriaId());
    }

    @Override
    public List<Mensajeria> handle(GetAllMensajesQuery query) {
        return mensajeriaRepository.findAll();
    }
}