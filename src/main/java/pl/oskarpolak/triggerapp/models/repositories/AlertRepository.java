package pl.oskarpolak.triggerapp.models.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.oskarpolak.triggerapp.models.entities.AlertEntity;

import java.util.List;

@Repository
public interface AlertRepository extends CrudRepository<AlertEntity, Integer> {
    List<AlertEntity> findAll();
}
