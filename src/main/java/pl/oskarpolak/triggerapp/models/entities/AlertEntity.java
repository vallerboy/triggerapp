package pl.oskarpolak.triggerapp.models.entities;


import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

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
}
