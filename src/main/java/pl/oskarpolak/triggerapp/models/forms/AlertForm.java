package pl.oskarpolak.triggerapp.models.forms;


import lombok.Data;
import org.springframework.web.bind.annotation.PathVariable;
import pl.oskarpolak.triggerapp.models.entities.AlertEntity;

import javax.validation.constraints.Pattern;

@Data
public class AlertForm {

    @Pattern(regexp = "\\d{9}")
    private String phone;
    @Pattern(regexp = "[a-zA-Z0-9]{160}")
    private String message;
    private int temperature;
    private AlertEntity.TriggerType triggerType;

}
