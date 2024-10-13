package tn.esprit.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class GestionStationSkiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionStationSkiApplication.class, args);
		System.out.println("hello word");
		int x=5;
		int y=6;
		System.out.println(x+y);

	}

}
