package pl.dawid0604.carhunters.image.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PROTECTED;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

/**
 * The base of all integration tests.
 * <p>
 *     Provides the server port for RestAssured. This setup
 *     closely reflects the real application state.
 * </p>
 *
 * Extend this class in your integration tests to ensure proper
 * environment configuration.
 */
@Getter(PROTECTED)
@NoArgsConstructor(access = PACKAGE)
@SpringBootTest(webEnvironment = RANDOM_PORT)
@SuppressWarnings({ "PMD.CommentSize", "PMD.AbstractClassWithoutAbstractMethod" })
public abstract class IntegrationTestBase {

    /**
     * The port injected by framework for use in integration tests.
     * <p>Example usage</p>
     * <pre>
     * {@code
     *  RestAssured.given()
     *             .port(serverPort) // this variable
     *             .when();
     * }
     * </pre>
     * <p>The port is assigned dynamically by framework during test startup.</p>
     */
    @LocalServerPort
    private int serverPort;
}
