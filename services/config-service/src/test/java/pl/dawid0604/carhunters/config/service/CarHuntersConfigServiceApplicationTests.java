package pl.dawid0604.carhunters.config.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.catchThrowable;

@SpringBootTest
class CarHuntersConfigServiceApplicationTests {

	@Test
	void contextLoads() {
		Assertions.assertThat(catchThrowable(() -> CarHuntersConfigServiceApplication.main(new String[] { })))
  				  .doesNotThrowAnyException();
	}

}
