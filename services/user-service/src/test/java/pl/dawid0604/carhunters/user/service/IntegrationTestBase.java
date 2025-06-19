package pl.dawid0604.carhunters.user.service;

import lombok.Getter;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.PostgreSQLContainer;

import static lombok.AccessLevel.PROTECTED;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static pl.dawid0604.carhunters.user.service.IntegrationTestBase.TestContainersConfig;

@Getter(PROTECTED)
@Import(TestContainersConfig.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public abstract class IntegrationTestBase {

    @LocalServerPort
    private int serverPort;

    @TestConfiguration
    static class TestContainersConfig {

        @Bean
        @ServiceConnection
        @SuppressWarnings("unused")
        PostgreSQLContainer<?> postgreSQLContainer() {
            return new PostgreSQLContainer<>("postgres:17-alpine");
        }
    }
}
