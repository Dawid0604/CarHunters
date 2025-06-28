package pl.dawid0604.carhunters.user.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Application runtime.
 */
@EnableCaching
@EnableDiscoveryClient
@SpringBootApplication
@SuppressWarnings("PMD.UseUtilityClass")
class CarHuntersUserServiceApplication {

	/**
	 * Simple main method.
	 * @param args arguments
	 */
	public static void main(final String[] args) {
		SpringApplication.run(CarHuntersUserServiceApplication.class, args);
	}

}
