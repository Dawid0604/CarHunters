package pl.dawid0604.carhunters.notification.service.config;

import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

import java.util.Optional;

import static lombok.AccessLevel.PACKAGE;

@SuppressWarnings("unused")
@Configuration
@EnableMongoAuditing
@NoArgsConstructor(access = PACKAGE)
class AuditingConfig {

    @Bean
    public AuditorAware<String> auditorAware() {
        return Optional::empty;
    }
}
