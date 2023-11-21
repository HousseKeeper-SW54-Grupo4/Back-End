package backend.housekeeper.houseelegantservice.infrastucture.persistence.jpa.repositories;

import backend.housekeeper.houseelegantservice.domain.model.aggregates.House;
import backend.housekeeper.houseelegantservice.domain.model.valueobjects.StreetAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HouseRepository extends JpaRepository<House, Long> {
    Optional<House> findByAddress(StreetAddress address);
}
