package pl.oskarpolak.triggerapp.models.entities;


import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import pl.oskarpolak.triggerapp.models.forms.AlertForm;

import javax.persistence.*;

@Entity
@Data
@Table(name = "alert")
public class AlertEntity {
    public enum TriggerType{
        GREATER, SMALLER, EQUAL;
    }

    @Id @GeneratedValue
    private int id;
    private String phone;
    private String message;
    private int temperature;
    @Column(name = "char_trigger")
    @Enumerated(EnumType.STRING)
    private TriggerType triggerType;


    public AlertEntity(AlertForm alertForm){
        this.message = alertForm.getMessage();
        this.phone = alertForm.getPhone();
        this.temperature =alertForm.getTemperature();
        this.triggerType = alertForm.getTriggerType();
    }

}
