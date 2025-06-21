package pl.dawid0604.carhunters.image.service;

import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import static lombok.AccessLevel.PACKAGE;
import static org.assertj.core.api.Assertions.assertThat;

@NoArgsConstructor(access = PACKAGE)
@SuppressWarnings("PMD.CommentRequired")
class CarHuntersImageServiceApplicationTests extends IntegrationTestBase {

	@Autowired
	@SuppressWarnings("unused")
	private ApplicationContext context;

	@Test
	void contextLoads() {
		assertThat(context).isNotNull();
	}

}
