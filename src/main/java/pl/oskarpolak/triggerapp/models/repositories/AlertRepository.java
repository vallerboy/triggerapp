package pl.oskarpolak.triggerapp.models.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.oskarpolak.triggerapp.models.entities.AlertEntity;

@Repository
public interface AlertRepository extends CrudRepository<AlertEntity, Integer> {
}
