package pl.dawid0604.carhunters.car.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Application runtime.
 */
@EnableDiscoveryClient
@SpringBootApplication
@SuppressWarnings("PMD.UseUtilityClass")
class CarHuntersCarServiceApplication {

	/**
	 * Simple main method.
	 * @param args arguments
	 */
	public static void main(final String[] args) {
		SpringApplication.run(CarHuntersCarServiceApplication.class, args);
	}

}
