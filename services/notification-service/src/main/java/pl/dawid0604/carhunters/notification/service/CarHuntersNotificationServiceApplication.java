package pl.dawid0604.carhunters.notification.service;

import lombok.NoArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import static lombok.AccessLevel.PACKAGE;

@EnableCaching
@SpringBootApplication
@EnableDiscoveryClient
@SuppressWarnings("PMD.UseUtilityClass")
class CarHuntersNotificationServiceApplication {

	public static void main(final String[] args) {
		SpringApplication.run(CarHuntersNotificationServiceApplication.class, args);
	}

}
