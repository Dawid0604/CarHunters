package pl.dawid0604.carhunters.user.service.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
@SuppressWarnings("unused")
class AuditingConfig { }
