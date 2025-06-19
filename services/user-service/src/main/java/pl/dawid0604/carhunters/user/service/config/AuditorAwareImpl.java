package pl.dawid0604.carhunters.user.service.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.Optional;

@SuppressWarnings("unused")
@Component("auditorAwareImpl")
class AuditorAwareImpl implements AuditorAware<String> {

    @NonNull
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.empty();
    }
}
