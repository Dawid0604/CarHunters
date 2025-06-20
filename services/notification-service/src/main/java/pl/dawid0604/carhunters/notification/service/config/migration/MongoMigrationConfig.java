package pl.dawid0604.carhunters.notification.service.config.migration;

import io.mongock.runner.springboot.EnableMongock;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Configuration;

import static lombok.AccessLevel.PACKAGE;

@EnableMongock
@Configuration
@SuppressWarnings("unused")
@NoArgsConstructor(access = PACKAGE)
class MongoMigrationConfig { }
