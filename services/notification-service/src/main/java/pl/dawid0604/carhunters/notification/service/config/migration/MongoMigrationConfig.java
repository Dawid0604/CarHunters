package pl.dawid0604.carhunters.notification.service.config.migration;

import io.mongock.runner.springboot.EnableMongock;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Configuration;

import static lombok.AccessLevel.PACKAGE;

/**
 * The configuration class enabling Mongock for
 * MongoDB migrations.
 * <p>
 *     Mongock is a Java-based migration tool for
 *     MongoDB, inspired by tools like Flyway. It
 *     allows to manage database schema and data migrations
 *     using Java code.
 * </p>
 */
@EnableMongock
@Configuration
@SuppressWarnings({ "unused", "PMD.CommentSize" })
@NoArgsConstructor(access = PACKAGE)
class MongoMigrationConfig { }
