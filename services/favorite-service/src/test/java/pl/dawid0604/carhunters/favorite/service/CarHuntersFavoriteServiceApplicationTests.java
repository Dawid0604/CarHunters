package pl.dawid0604.carhunters.favorite.service;

import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import static lombok.AccessLevel.PACKAGE;
import static org.assertj.core.api.Assertions.assertThat;

@NoArgsConstructor(access = PACKAGE)
@SuppressWarnings("PMD.CommentRequired")
class CarHuntersFavoriteServiceApplicationTests extends IntegrationTestBase {

	@Autowired
	@SuppressWarnings("unused")
	private ApplicationContext applicationContext;

	@Test
	void contextLoads() {
		assertThat(applicationContext).isNotNull();
	}

}
