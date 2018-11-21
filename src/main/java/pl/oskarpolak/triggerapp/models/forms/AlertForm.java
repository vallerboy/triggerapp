package pl.oskarpolak.triggerapp.models.forms;


import lombok.Data;
import pl.oskarpolak.triggerapp.models.entities.AlertEntity;

@Data
public class AlertForm {
    private String phone;
    private String message;
    private int temperature;
    private AlertEntity.TriggerType triggerType;

}
