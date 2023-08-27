package com.deo.soft.uniquepingenerator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class to test the unique pin generator functionality
 */
class UniquePinGeneratorTest {

	@Test
	@DisplayName("Test getUniquePin to get singale value")
	void getUniquePin() {
		UniquePinGenerator uniquePinGenerator = new UniquePinGenerator();
		assertEquals(1, uniquePinGenerator.getUniquePin().size());
	}

}
