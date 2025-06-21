package pl.dawid0604.carhunters.favorite.service.config;

import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import static lombok.AccessLevel.PACKAGE;

/**
 * Utility to enabling JPA Auditing.
 */
@Configuration
@EnableJpaAuditing
@SuppressWarnings("unused")
@NoArgsConstructor(access = PACKAGE)
class AuditingConfig { }
