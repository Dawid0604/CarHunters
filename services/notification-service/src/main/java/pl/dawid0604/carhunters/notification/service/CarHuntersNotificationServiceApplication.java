package pl.dawid0604.carhunters.notification.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Application runtime.
 */
@EnableCaching
@SpringBootApplication
@EnableDiscoveryClient
@SuppressWarnings("PMD.UseUtilityClass")
class CarHuntersNotificationServiceApplication {

	/**
	 * Simple main method.
	 * @param args arguments
	 */
	public static void main(final String[] args) {
		SpringApplication.run(CarHuntersNotificationServiceApplication.class, args);
	}

}
