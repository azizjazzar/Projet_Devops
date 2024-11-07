package tn.esprit.spring;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Lazy;

@SpringBootTest
@Lazy // Lazy initialization to avoid eager loading issues
class GestionStationSkiApplicationTests {

	@Test
	void contextLoads() {
		// Test application context loading
	}
}
