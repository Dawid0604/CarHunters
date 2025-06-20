package pl.dawid0604.carhunters.notification.service.config.migration;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import io.mongock.api.annotations.BeforeExecution;
import io.mongock.api.annotations.ChangeUnit;
import io.mongock.api.annotations.Execution;
import io.mongock.api.annotations.RollbackBeforeExecution;
import io.mongock.api.annotations.RollbackExecution;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;

import static lombok.AccessLevel.PACKAGE;

/**
 * Migrations wrapper.
 */
@Slf4j
@SuppressWarnings("unused")
@NoArgsConstructor(access = PACKAGE)
public final class MongoMigrationManager {

    /**
     * Migration that creates the 'users' collection in MongoDB.
     */
    @RequiredArgsConstructor
    @ChangeUnit(id = "V1__init", order = "001", author = "system")
    public static final class InitMigration {
        /**
         * MongoTemplate used for MongoDB operations.
         */
        @SuppressFBWarnings("EI_EXPOSE_REP2")
        private final MongoTemplate mongoTemplate;

        /**
         * Currently do nothing. For further development.
         */
        @Execution
        public void migrate() {
            log.info("Migration");
        }

        /**
         * Currently do nothing. For further development.
         */
        @BeforeExecution
        public void beforeExecution() {
            log.info("Before migration");
        }

        /**
         * Currently do nothing. For further development.
         */
        @RollbackBeforeExecution
        public void rollbackBeforeExecution() {
            log.error("Rollback before execution");
        }

        /**
         * Currently do nothing. For further development.
         */
        @RollbackExecution
        public void rollback() {
            log.error("Rollback");
        }
    }
}
