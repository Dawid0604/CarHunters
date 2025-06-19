package pl.dawid0604.carhunters.user.service.config;

import lombok.NoArgsConstructor;
import org.springframework.data.domain.AuditorAware;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static lombok.AccessLevel.PACKAGE;

@SuppressWarnings("unused")
@Component("auditorAwareImpl")
@NoArgsConstructor(access = PACKAGE)
class AuditorAwareImpl implements AuditorAware<String> {

    @NonNull
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.empty();
    }
}
