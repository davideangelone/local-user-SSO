package it.iad;

import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class LocalUserSsoApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocalUserSsoApplication.class, args);
		
		log.info("Variabili di ambiente:");
		for (Map.Entry<String, String> entry : System.getenv().entrySet()) {
			log.info("[{}] = [{}]", entry.getKey(),  entry.getValue());
		}
		
		log.info("Apis at : /api-docs");
	}

}
