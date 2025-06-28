package pl.dawid0604.carhunters.discovery.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Application runtime.
 */
@EnableCaching
@EnableEurekaServer
@SpringBootApplication
@SuppressWarnings("PMD")
class CarHuntersDiscoveryServiceApplication {

	/**
	 * Simple main method.
	 * @param args arguments
	 */
	public static void main(final String[] args) {
		SpringApplication.run(CarHuntersDiscoveryServiceApplication.class, args);
	}

}
