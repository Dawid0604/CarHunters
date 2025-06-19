package pl.dawid0604.carhunters.discovery.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.catchThrowable;

@SpringBootTest
class CarHuntersDiscoveryServiceApplicationTests {

	@Test
	void contextLoads() {
		Assertions.assertThat(catchThrowable(() -> CarHuntersDiscoveryServiceApplication.main(new String[] { })))
				  .doesNotThrowAnyException();
	}
}
