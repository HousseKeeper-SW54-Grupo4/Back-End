package backend.housekeeper.houseelegantservice.infrastucture.persistence.jpa.repositories;
import backend.housekeeper.houseelegantservice.domain.model.aggregates.Keeper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeeperRepository extends JpaRepository<Keeper, Long> {
}
