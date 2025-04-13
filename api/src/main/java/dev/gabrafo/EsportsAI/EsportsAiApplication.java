package dev.gabrafo.EsportsAI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class EsportsAiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EsportsAiApplication.class, args);
	}

}
