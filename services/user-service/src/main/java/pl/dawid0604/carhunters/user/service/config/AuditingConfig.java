package pl.dawid0604.carhunters.user.service.config;

import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import static lombok.AccessLevel.PACKAGE;

@Configuration
@EnableJpaAuditing
@SuppressWarnings("unused")
@NoArgsConstructor(access = PACKAGE)
class AuditingConfig { }
