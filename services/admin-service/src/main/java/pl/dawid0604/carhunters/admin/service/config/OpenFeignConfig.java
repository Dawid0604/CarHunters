package pl.dawid0604.carhunters.admin.service.config;

import lombok.NoArgsConstructor;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

import static lombok.AccessLevel.PACKAGE;

/**
 * The configuration enabling support for OpenFeign.
 * <p>
 *     The OpenFeign is declarative REST client that simplifies
 *     the communication between microservices by automatic code
 *     generation to HTTP requests. Spring Cloud OpenFeign integrates
 *     also with the Spring ecosystem, supporting features such as
 *     service discovery (Eureka), circuit breakers, retries and timeouts.
 * </p>
 *
 * <p>
 *     The {@link EnableFeignClients} annotation scans the specified package
 *     for interfaces annotated with
 *     {@link org.springframework.cloud.openfeign.FeignClient} and registers them as
 *     {@link org.springframework.context.annotation.Bean}, making it easy to inject and use.
 * </p>
 *
 * <p>
 *     Additional configuration for Feign clients (e.g., timeouts, logging,
 *     interceptors, circuit breakers, retries) can be provided via application
 *     properties or dedicated configuration classes
 * </p>
 *
 * @see EnableFeignClients
 * @see org.springframework.cloud.openfeign.FeignClient
 * @see <a href="https://docs.spring.io/spring-cloud-openfeign/
 * docs/current/reference/html/">Spring Cloud OpenFeign Reference</a>
 */
@Configuration
@SuppressWarnings("unused")
@NoArgsConstructor(access = PACKAGE)
@EnableFeignClients(basePackages = "pl.dawid0604.carhunters.admin.service.clients")
class OpenFeignConfig { }
