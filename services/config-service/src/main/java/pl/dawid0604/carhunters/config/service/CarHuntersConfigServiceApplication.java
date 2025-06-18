package pl.dawid0604.carhunters.config.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableCaching
@EnableConfigServer
@SpringBootApplication
@SuppressWarnings("PMD")
class CarHuntersConfigServiceApplication {

	public static void main(final String[] args) {
		SpringApplication.run(CarHuntersConfigServiceApplication.class, args);
	}

}
