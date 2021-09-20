package Dapeng.DataHubService.repositories;

import Dapeng.DataHubService.entities.DowJonesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DataHubRepository extends JpaRepository<DowJonesEntity, Long> {
    @Query(value = "")
    List<DowJonesEntity> findByStock(String stock);

}
