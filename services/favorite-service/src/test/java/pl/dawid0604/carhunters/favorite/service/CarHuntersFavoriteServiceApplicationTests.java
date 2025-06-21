package pl.dawid0604.carhunters.favorite.service;

import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import static lombok.AccessLevel.PACKAGE;
import static org.junit.jupiter.api.Assertions.assertTrue;

@NoArgsConstructor(access = PACKAGE)
@SuppressWarnings("PMD.CommentRequired")
class CarHuntersFavoriteServiceApplicationTests extends IntegrationTestBase {

	@Test
	@SuppressWarnings("PMD")
	void contextLoads() {
		assertTrue(true);
	}

}
