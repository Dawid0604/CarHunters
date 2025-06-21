package pl.dawid0604.carhunters.car.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.PostgreSQLContainer;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PROTECTED;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

/**
 * The base of all integration tests.
 * <p>
 *     Provides the server port for RestAssured and sets up
 *     required infrastructure components, such as databases,
 *     message brokers etc. This setup closely reflects
 *     the real application state.
 * </p>
 *
 * Extend this class in your integration tests to ensure proper
 * environment configuration.
 */
@Getter(PROTECTED)
@Import(IntegrationTestBase.ContainersConfig.class)
@NoArgsConstructor(access = PACKAGE)
@SpringBootTest(webEnvironment = RANDOM_PORT)
@SuppressWarnings({ "PMD.CommentSize", "PMD.AbstractClassWithoutAbstractMethod" })
public abstract class IntegrationTestBase {

    /**
     * The port injected by framework for use in integration tests.
     * <p>Example usage</p>
     * <pre>
     * {@code
     *  RestAssured.given()
     *             .port(serverPort) // this variable
     *             .when();
     * }
     * </pre>
     * <p>The port is assigned dynamically by framework during test startup.</p>
     */
    @LocalServerPort
    private int serverPort;

    /**
     * Test configuration that provides containerized dependencies for
     * integration tests.
     *
     * <p>
     *     This class configures and exposes required dependencies as {@link Bean}, which
     *     are used by tests running in the Spring Boot environment. Thanks to the
     *     {@link ServiceConnection} annotation, the containers are automatically connected
     *     as data sources for the application context.
     * </p>
     */
    @TestConfiguration
    @SuppressWarnings("PMD.CommentDefaultAccessModifier")
    static class ContainersConfig {

        /**
         * Creates and configures the PostgreSQL container (Version 17-alpine) for
         * integration tests.
         * @return a new PostgreSQL container instance running in the environment
         */
        @Bean
        @ServiceConnection
        @SuppressWarnings("unused")
        PostgreSQLContainer<?> postgreSQLContainer() {
            return new PostgreSQLContainer<>("postgres:17-alpine");
        }
    }
}
