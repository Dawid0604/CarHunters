package pl.dawid0604.carhunters.notification.service;

import lombok.NoArgsConstructor;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.kafka.KafkaContainer;

import static lombok.AccessLevel.PACKAGE;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static pl.dawid0604.carhunters.notification.service.IntegrationTestBase.ContainersConfig;

/**
 * The base of all integration tests.
 * <p>
 *     Extend this class in your integration tests
 *     to ensure proper environment configuration.
 * </p>
 */
@Import(ContainersConfig.class)
@NoArgsConstructor(access = PACKAGE)
@SpringBootTest(webEnvironment = RANDOM_PORT)
@SuppressWarnings({ "PMD.CommentSize", "PMD.AbstractClassWithoutAbstractMethod" })
public abstract class IntegrationTestBase {

    /**
     * Test configuration that provides containerized dependencies
     * for integration tests.
     *
     * <p>
     *     This class configures and exposes required dependencies
     *     as {@link Bean}, which are used by tests running in the
     *     Spring Boot environment. Thanks to the {@link ServiceConnection}
     *     annotation, the containers are automatically connected as data
     *     sources for teh application context.
     * </p>
     */
    @TestConfiguration
    @SuppressWarnings("PMD.CommentDefaultAccessModifier")
    static class ContainersConfig {

        /**
         * Creates and configures the MongoDB container (Version 8.0.9) for
         * integration tests.
         * @return a new MongoDB container instance running in the environment
         */
        @Bean
        @ServiceConnection
        @SuppressWarnings("unused")
        MongoDBContainer mongoDBContainer() {
            return new MongoDBContainer("mongo:8.0.9");
        }

        /**
         * Creates and configures the Apache Kafka container (Version 3.9.1) for
         * integration tests.
         * @return a new Kafka container instance running in the environment
         */
        @Bean
        @ServiceConnection
        @SuppressWarnings("unused")
        KafkaContainer kafkaContainer() {
            return new KafkaContainer("apache/kafka:3.9.1");
        }
    }
}
