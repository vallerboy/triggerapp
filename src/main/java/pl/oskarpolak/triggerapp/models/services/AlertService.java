package pl.oskarpolak.triggerapp.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.oskarpolak.triggerapp.models.entities.AlertEntity;
import pl.oskarpolak.triggerapp.models.repositories.AlertRepository;

import java.util.List;

@Service
public class AlertService {
    final AlertRepository alertRepository;

    @Autowired
    public AlertService(AlertRepository alertRepository) {
        this.alertRepository = alertRepository;
    }

    public List<AlertEntity> getAllAlerts(){
        return alertRepository.findAll();
    }
}
