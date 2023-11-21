package backend.housekeeper.houseelegantservice.application.internal.commandservices;

import backend.housekeeper.houseelegantservice.domain.model.aggregates.House;
import backend.housekeeper.houseelegantservice.domain.model.command.CreateHouseCommand;
import backend.housekeeper.houseelegantservice.domain.model.command.UpdateHouseCommand;
import backend.housekeeper.houseelegantservice.domain.model.valueobjects.StreetAddress;
import backend.housekeeper.houseelegantservice.domain.service.HouseCommandService;
import backend.housekeeper.houseelegantservice.infrastucture.persistence.jpa.repositories.HouseRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HouseCommandServiceImpl implements HouseCommandService {

    private final HouseRepository houseRepository;

    public HouseCommandServiceImpl(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }


    @Override
    public Long handle(CreateHouseCommand command) {
        var streetAddress = new StreetAddress(command.streetAddress(), command.city(), command.country());
        houseRepository.findByAddress(streetAddress).map(house ->{
            throw new IllegalArgumentException("House with address "+ streetAddress.getStreetAddress() +
                    " already exists");
        });

        var house = new House(command.streetAddress(), command.city(), command.country(), command.price(),
                command.photoUrl(), command.capacity(), command.rating());
        houseRepository.save(house);
        return house.getId();
    }

    @Override
    public Optional<House> handle(UpdateHouseCommand command) {
        return Optional.empty();
    }
}
