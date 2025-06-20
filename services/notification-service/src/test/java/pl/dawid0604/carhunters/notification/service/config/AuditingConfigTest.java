package pl.dawid0604.carhunters.notification.service.config;

import lombok.NoArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Spy;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

import static lombok.AccessLevel.PACKAGE;

@NoArgsConstructor(access = PACKAGE)
class AuditingConfigTest {

    @Spy
    private final AuditingConfig auditingConfig = new AuditingConfig();

    @Nested
    @DisplayName("Success")
    @NoArgsConstructor(access = PACKAGE)
    class Success {

        @Test
        void shouldReturnEmptyAuditor() {
            // Given
            // When
            // Then
            Assertions.assertThat(auditingConfig.auditorAware())
                      .extracting(AuditorAware::getCurrentAuditor)
                      .matches(Optional::isEmpty);
        }
    }
}