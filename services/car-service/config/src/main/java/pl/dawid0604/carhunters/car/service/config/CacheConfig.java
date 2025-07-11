package pl.dawid0604.carhunters.car.service.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.RemovalCause;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static java.util.concurrent.TimeUnit.MINUTES;
import static lombok.AccessLevel.PACKAGE;

/**
 * Configuration class for the Caffeine cache.
 *
 * <p>
 *     This class sets up the cache with optimal parameters for a
 *     microservice. It defines expiration policies, maximum size,
 *     refresh intervals and enables cache statistics.
 * </p>
 *
 * <p>
 *     <b>Example usage:</b>
 *     <pre>
 *         {@code
 *            @Cacheable("application_cache")
 *            public Advertisement getAdvertisement(long id) {
 *                // Fetch advertisement from database or external service
 *            }
 *         }
 *     </pre>
 * </p>
 *
 * <p>
 *     By annotating this class with {@link EnableCaching}, the
 *     application enables effective caching and improves overall
 *     performance.
 * </p>
 *
 * @see EnableCaching
 */
@Slf4j
@EnableCaching
@Configuration
@SuppressWarnings({ "unused", "PMD.LongVariable", "PMD.CommentSize" })
@NoArgsConstructor(access = PACKAGE)
class CacheConfig {

    /**
     * Number of minutes after last access before a cache entry expires.
     */
    private static final int EXPIRE_AFTER_ACCESS_TIME = 45;

    /**
     * Number of minutes after last write before a cache entry expires.
     */
    private static final int EXPIRE_AFTER_WRITE_TIME = 30;

    /**
     * Maximum number of entries the cache may contain.
     */
    private static final int MAXIMUM_SIZE = 1500;

    /**
     * Initial capacity of cache.
     */
    private static final int INITIAL_CAPACITY = 100;

    /**
     * Configures and returns the Caffeine cache builder.
     * @return configured and prepared {@link Caffeine} cache builder
     */
    @Bean
    public Caffeine<Object, Object> caffeineConfig() {
        return Caffeine.newBuilder()
                       .initialCapacity(INITIAL_CAPACITY)
                       .expireAfterAccess(EXPIRE_AFTER_ACCESS_TIME, MINUTES)
                       .expireAfterWrite(EXPIRE_AFTER_WRITE_TIME, MINUTES)
                       .maximumSize(MAXIMUM_SIZE)
                       .removalListener(this::logRemoval)
                       .recordStats()
                       .weakKeys()
                       .softValues();
    }

    /**
     * Logs removal of cache entries, including the key and the
     * reason for removal.
     * @param key the key of removed entry.
     * @param value the value of removed entry.
     * @param cause the reason for removal.
     */
    private void logRemoval(@Nullable final Object key, @Nullable final Object value,
                                      final RemovalCause cause) {

        log.info("Key {} deleted with cause: {}", key, cause);
    }

    /**
     * Creates and configures the {@link CacheManager} bean using the provided
     * Caffeine configuration.
     * @param caffeine the configured {@link Caffeine} cache builder via
     * {@link #caffeineConfig()} method.
     * @return a fully configured {@link CacheManager}
     */
    @Bean
    public CacheManager cacheManager(final Caffeine<Object, Object> caffeine) {
        final CaffeineCacheManager cacheManager = new CaffeineCacheManager("application_cache");
                                   cacheManager.setCaffeine(caffeine);

        return cacheManager;
    }
}
