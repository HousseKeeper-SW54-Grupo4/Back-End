package backend.housekeeper.houseelegantservice.infrastucture.persistence.jpa.repositories;

import backend.housekeeper.houseelegantservice.domain.model.aggregates.Viaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ViajeRepository extends JpaRepository<Viaje, Long> {
    Optional<Viaje> getViajeByTitle(String title);
}