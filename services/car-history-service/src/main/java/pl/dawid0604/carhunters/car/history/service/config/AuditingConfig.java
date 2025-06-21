package pl.dawid0604.carhunters.car.history.service.config;

import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

import java.util.Optional;

import static lombok.AccessLevel.PACKAGE;

/**
 * The configuration class enabling entity auditing for MongoDB.
 * <p>
 *     Registers the necessary beans to support auditing features,
 *     such as tracking who created or modified an entity. Currently,
 *     retrieval is not implemented.
 * </p>
 */
@Configuration
@EnableMongoAuditing
@SuppressWarnings("unused")
@NoArgsConstructor(access = PACKAGE)
class AuditingConfig {

    /**
     * Returns the identifier of the current auditor (e.g., username).
     * <p>
     *     This method is prepared for further development
     * </p>
     * @return empty {@link Optional}, since auditor
     * retrieval is not yet completed
     */
    @Bean
    public AuditorAware<String> auditorAware() {
        return Optional::empty;
    }
}
