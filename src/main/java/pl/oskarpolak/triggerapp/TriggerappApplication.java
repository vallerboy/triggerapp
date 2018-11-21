package pl.oskarpolak.triggerapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TriggerappApplication {

	public static void main(String[] args) {
		SpringApplication.run(TriggerappApplication.class, args);
	}
}
