package pl.dawid0604.carhunters.user.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableCaching
@EnableDiscoveryClient
@SpringBootApplication
@SuppressWarnings("PMD")
class CarHuntersUserServiceApplication {

	public static void main(final String[] args) {
		SpringApplication.run(CarHuntersUserServiceApplication.class, args);
	}

}
