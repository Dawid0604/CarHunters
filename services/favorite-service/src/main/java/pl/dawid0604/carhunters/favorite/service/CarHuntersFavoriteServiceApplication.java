package pl.dawid0604.carhunters.favorite.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableCaching
@EnableDiscoveryClient
@SpringBootApplication
@SuppressWarnings("PMD")
class CarHuntersFavoriteServiceApplication {

	public static void main(final String[] args) {
		SpringApplication.run(CarHuntersFavoriteServiceApplication.class, args);
	}

}
