package pl.oskarpolak.triggerapp.models;


import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.oskarpolak.triggerapp.models.entities.AlertEntity;
import pl.oskarpolak.triggerapp.models.services.AlertService;
import pl.oskarpolak.triggerapp.models.services.WeatherService;

@Component
@Log
public class AlertJob {

    final WeatherService weatherService;
    final AlertService alertService;

    @Autowired
    public AlertJob(WeatherService weatherService, AlertService alertService) {
        this.weatherService = weatherService;
        this.alertService = alertService;
    }

    @Scheduled(initialDelay = 5000, fixedRate = 1000 * 60)
    public void checkWeatherAndAlertsAndSendSms() {
        for (AlertEntity alert : alertService.getAllAlerts()) {
            WeatherDto weather = weatherService.loadWeatherForCity(alert.getCity());

            boolean shouldSendSms  = isShouldSendSms(alert, weather);

            if(shouldSendSms){
                sendSms(alert);
                log.info("Wysłano sms do: " + alert.getPhone() + ", task id: " + alert.getId());
            }
        }
    }

    private boolean isShouldSendSms(AlertEntity alert, WeatherDto weather) {
        switch (alert.getTriggerType()){
            case EQUAL: {
                if((int) weather.getTempDto().getTemperature() == alert.getTemperature()){
                    return true;
                }
                break;
            }
            case GREATER:{
                if((int) weather.getTempDto().getTemperature() > alert.getTemperature()){
                    return true;
                }
                break;
            }
            case SMALLER:{
                if((int) weather.getTempDto().getTemperature() < alert.getTemperature()){
                    return true;
                }
                break;
            }
        }
        return false;
    }


    private void sendSms(AlertEntity alertEntity){

    }

}
