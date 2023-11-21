package backend.housekeeper.houseelegantservice.application.internal.commandservices;

import backend.housekeeper.houseelegantservice.domain.model.aggregates.Mensajeria;
import backend.housekeeper.houseelegantservice.domain.model.command.CreateMensajeriaCommand;
import backend.housekeeper.houseelegantservice.domain.service.MensajeriaCommandService;
import backend.housekeeper.houseelegantservice.infrastucture.persistence.jpa.repositories.MensajeriaRepository;
import org.springframework.stereotype.Service;

@Service
public class MensajeriaCommandServiceImpl implements MensajeriaCommandService {
    private final MensajeriaRepository mensajeriaRepository;

    public MensajeriaCommandServiceImpl(MensajeriaRepository mensajeriaRepository) {
        this.mensajeriaRepository = mensajeriaRepository;
    }


    @Override
    public Long handle(CreateMensajeriaCommand command) {
        var mensajeria = new Mensajeria(command.nombre(), command.description(), command.photoFace());
        mensajeriaRepository.save(mensajeria);
        return mensajeria.getId();
    }
}