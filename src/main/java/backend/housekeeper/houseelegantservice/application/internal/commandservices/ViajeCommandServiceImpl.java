package backend.housekeeper.houseelegantservice.application.internal.commandservices;


import backend.housekeeper.houseelegantservice.domain.model.aggregates.Viaje;
import backend.housekeeper.houseelegantservice.domain.model.command.CreateViajeCommand;
import backend.housekeeper.houseelegantservice.domain.service.ViajeCommandService;
import backend.housekeeper.houseelegantservice.infrastucture.persistence.jpa.repositories.ViajeRepository;
import org.springframework.stereotype.Service;

@Service
public class ViajeCommandServiceImpl implements ViajeCommandService {
    private final ViajeRepository viajeRepository;

    public ViajeCommandServiceImpl(ViajeRepository viajeRepository) {
        this.viajeRepository = viajeRepository;
    }

    @Override
    public Long handle(CreateViajeCommand command) {
        viajeRepository.getViajeByTitle(command.title()).map(viaje -> {
            throw new IllegalArgumentException("Viaje with title " + command.title() + " already exists");
        });
        var viaje = new Viaje(command.title(), command.description(), command.photoUrl(), command.rating());
        viajeRepository.save(viaje);
        return viaje.getId();
    }
}