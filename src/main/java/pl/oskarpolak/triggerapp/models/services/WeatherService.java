package pl.oskarpolak.triggerapp.models.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.oskarpolak.triggerapp.models.WeatherDto;

import javax.validation.Valid;

@Service
public class WeatherService {
    @Value("${api.key}")
    String apiKey;


    public WeatherDto loadWeatherForCity(String city){
        return getRestTemplate().getForObject("https://api.openweathermap.org/data/2.5/weather?q="
                                + city
                                + "&appid="
                                + apiKey,
                                 WeatherDto.class);
    }

    @Bean /* ilekroc wywolacie getRestTempplate - ta metoda zwroci ten
    sam obiekt!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*/
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
