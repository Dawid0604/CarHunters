package pl.dawid0604.carhunters.gateway.service.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.properties.AbstractSwaggerUiConfigProperties.SwaggerUrl;
import org.springdoc.core.properties.SwaggerUiConfigProperties;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.toSet;
import static lombok.AccessLevel.PACKAGE;

/**
 * The configuration class for dynamic Swagger UI endpoints
 * in the Spring application.
 *
 * <p>
 *     This class automatically discovers all microservices registered
 *     as router in the gateway and exposes their OpenAPI docs.
 * </p>
 *
 * <p>
 *     The list of endpoints is refreshed every minute using
 *     scheduled task. The class uses {@link RouteDefinitionLocator}
 *     to obtain the current list of routes and {@link SwaggerUiConfigProperties}
 *     to update the Swagger UI configuration dynamically.
 * </p>
 *
 * <p>
 *     <b>How iw works:</b>
 *     <ul>
 *         <li>
 *             Every 60 seconds, the {@link #refresh()} method is called
 *             to update the list of available Swagger endpoints.
 *         </li>
 *
 *         <li>
 *             Only routes matching the pattern <code>.*-service</code>
 *             are included.
 *         </li>
 *
 *         <li>
 *             Each service's documentation is exposed under
 *             <code>/v3/api-docs/{service-name}</code>. So if you
 *             have a route with id equal "user-service", its documentation
 *             will be available at "/v3/api-docs/user".
 *         </li>
 *     </ul>
 * </p>
 *
 * @see RouteDefinitionLocator
 * @see SwaggerUiConfigProperties
 * @see Scheduled
 */
@Slf4j
@Configuration
@RequiredArgsConstructor(access = PACKAGE)
@SuppressWarnings({ "unused", "PMD.CommentDefaultAccessModifier", "PMD.CommentSize" })
class SwaggerConfig {
    /**
     * Provides access to the current route definitions.
     */
    private final RouteDefinitionLocator locator;

    /**
     * Configuration properties for customizing the Springdoc.
     */
    private final SwaggerUiConfigProperties swaggerUiProps;

    /**
     * The base path for OpenAPI documentation endpoints.
     */
    private static final String API_DOCS_URL = "/v3/api-docs";

    /**
     * Pattern used to match microservice route Ids following the convention:
     * any name ending with '-service'.
     */
    @SuppressWarnings("PMD.LongVariable")
    private static final Pattern SERVICE_NAME_PATTERN = Pattern.compile(".+-service");

    /**
     * Interval in milliseconds for refreshing Swagger endpoints (1 minute).
     */
    @SuppressWarnings("PMD.LongVariable")
    private static final int SWAGGER_REFRESH_INTERVAL = 60_000;

    /**
     * Periodically refreshes the list of Swagger UI
     * endpoints. This method is called every 60 seconds.
     */
    @Scheduled(fixedDelay = SWAGGER_REFRESH_INTERVAL)
    void refresh() {
        log.info("Refreshing swagger endpoints");
        swaggerUiProps.setUrls(getUrls());
        log.info("Refreshing swagger endpoints completed");
    }

    /**
     * Returns the set of SwaggerUrl objects representing available
     * microservice documentation endpoints.
     * @return set of SwaggerUrl objects for Swagger UI
     */
    private Set<SwaggerUrl> getUrls() {
        return Optional.ofNullable(locator.getRouteDefinitions()
                                          .collectList()
                                          .block())
                       .orElseGet(List::of)
                       .stream()
                       .filter(this::matches)
                       .map(this::map)
                       .collect(toSet());
    }

    /**
     * Check if a given {@link RouteDefinition} matches the
     * service naming pattern.
     * @param routeDefinition the route definition to check.
     * @return true if the route id matches the pattern, false otherwise.
     */
    private boolean matches(final RouteDefinition routeDefinition) {
        return Optional.ofNullable(routeDefinition)
                       .map(rd -> SERVICE_NAME_PATTERN.matcher(rd.getId()).matches())
                       .orElse(false);
    }

    /**
     * Maps a RouteDefinition to a SwaggerUrl object.
     * @param routeDefinition the route definition to map.
     * @return SwaggerUrl representing the OpenAPI endpoint for
     * the service.
     */
    private SwaggerUrl map(final RouteDefinition routeDefinition) {
        final String name = routeDefinition.getId()
                                           .replace("-service", "");

        return new SwaggerUrl(name, asUrl(name), null);
    }

    /**
     * Constructs the OpenAPI docs URL for a given service name.
     * @param name the service name.
     * @return the OpenAPI documentation URl for the service.
     */
    private static String asUrl(final String name) {
        return API_DOCS_URL + "/" + name;
    }
}
