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

@Import(ContainersConfig.class)
@NoArgsConstructor(access = PACKAGE)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public abstract class IntegrationTestBase {

    @TestConfiguration
    static class ContainersConfig {

        @Bean
        @ServiceConnection
        @SuppressWarnings("unused")
        MongoDBContainer mongoDBContainer() {
            return new MongoDBContainer("mongo:8.0.9");
        }

        @Bean
        @ServiceConnection
        @SuppressWarnings("unused")
        KafkaContainer kafkaContainer() {
            return new KafkaContainer("apache/kafka:3.9.1");
        }
    }
}
