package pl.dawid0604.carhunters.image.service.config;

import com.cloudinary.Cloudinary;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static lombok.AccessLevel.PACKAGE;

/**
 * The configuration class enabling Cloudinary support in the application.
 * @see <a href="https://cloudinary.com/documentation/java_integration">
 *     Cloudinary documentation for Java</a>
 */
@Configuration
@SuppressWarnings("unused")
@NoArgsConstructor(access = PACKAGE)
class CloudinaryConfig {

    /**
     * URL to connects with Cloudinary API.
     * <p>
     * Format: <pre>
     *     cloudinary://API_KEY:API_SECRET@CLOUD_NAME
     * </pre>
     * </p>
     */
    @Value("${cloudinary.url}")
    private String cloudinaryUrl;

    /**
     * It creates and exposes Cloudinary bean configured
     * using the {@code cloudinaryUrl} property.
     * @return {@link Cloudinary} instance ready for use.
     */
    @Bean
    public Cloudinary cloudinary() {
        return new Cloudinary(cloudinaryUrl);
    }
}
