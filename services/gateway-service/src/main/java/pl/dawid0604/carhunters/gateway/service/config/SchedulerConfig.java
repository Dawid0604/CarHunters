package pl.dawid0604.carhunters.gateway.service.config;

import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import static lombok.AccessLevel.PACKAGE;

/**
 * The configuration class to enable task scheduling
 * in the Spring application.
 *
 * <p>
 *     This class activates support for scheduled tasks
 *     by using {@link EnableScheduling} annotation.
 * </p>
 *
 * <p>
 *     This allows methods annotated by {@link org.springframework.scheduling.annotation.Scheduled}
 *     in other components to executed periodically.
 * </p>
 *
 * <p>
 *     Example usage:
 *     <pre>
 *         {@code
 *            @Component
 *            public class ExampleScheduler {
 *
 *                 @Scheduled(fixedRate = 60000)
 *                 public void task() {
 *                     // code executed every minute
 *                 }
 *            }
 *         }
 *     </pre>
 * </p>
 *
 * @see org.springframework.scheduling.annotation.EnableScheduling
 * @see org.springframework.scheduling.annotation.Scheduled
 */
@Configuration
@EnableScheduling
@NoArgsConstructor(access = PACKAGE)
@SuppressWarnings({ "unused", "PMD.CommentSize" })
class SchedulerConfig { }
