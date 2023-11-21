package backend.housekeeper.houseelegantservice.application.internal.commandservices;

import backend.housekeeper.houseelegantservice.domain.model.aggregates.MensajeriaTraveller;
import backend.housekeeper.houseelegantservice.domain.model.command.CreateMensajeriaTravellerCommand;
import backend.housekeeper.houseelegantservice.domain.service.MensajeriaTravellerCommandService;
import backend.housekeeper.houseelegantservice.infrastucture.persistence.jpa.repositories.MensajeriaTravellerRepository;
import org.springframework.stereotype.Service;

@Service
public class MensajeriaTravellerCommandServiceImpl implements MensajeriaTravellerCommandService{
    private final MensajeriaTravellerRepository mensajeriaTravellerRepository;

    public MensajeriaTravellerCommandServiceImpl(MensajeriaTravellerRepository mensajeriaTravellRepository) {
        this.mensajeriaTravellerRepository = mensajeriaTravellRepository;
    }

    @Override
    public Long handle(CreateMensajeriaTravellerCommand command) {
        var mensajeriaTraveller = new MensajeriaTraveller(command.nombre(), command.description(), command.photoFace());
        mensajeriaTravellerRepository.save(mensajeriaTraveller);
        return mensajeriaTraveller.getId();
    }
}