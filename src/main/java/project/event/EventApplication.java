package project.event;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
public class EventApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventApplication.class, args);
	}
}
