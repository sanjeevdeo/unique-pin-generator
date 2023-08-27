package com.deo.soft.uniquepingenerator;

import com.deo.soft.uniquepingenerator.exception.InvalidInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Test class to test the unique pin generator functionality
 */
class UniquePinGeneratorTest {

	@Test
	@DisplayName("Test to get the single unique pin")
	void getSingleUniquePin() {
		UniquePinGenerator uniquePinGenerator = new UniquePinGenerator();
		assertEquals(1, uniquePinGenerator.getUniquePin().size());
	}

	@Test
	void getUniquePinWithBatchSize1() {
		UniquePinGenerator uniquePinGenerator = new UniquePinGenerator();
		assertThat(uniquePinGenerator.getUniquePin(1).size()).isEqualTo(1);
	}

	@ParameterizedTest
	@MethodSource("getValidBatchInputAndExpectedBatchOutput")
	void testGetUniquePinWithMultipleBatchSize(int inputBatchSize, int outputBatchSize) {
		UniquePinGenerator uniquePinGenerator = new UniquePinGenerator();

		assertEquals(true, uniquePinGenerator.getUniquePin(inputBatchSize).size() == outputBatchSize);
	}

	@ParameterizedTest
	@MethodSource("getBatchSizeValueGreaterThanMax")
	void testGetUniquePinWithBatchSizeGreaterThanMaxThresholdThrowsException(int inputBatchSize) {
		UniquePinGenerator uniquePinGenerator = new UniquePinGenerator();

		Exception thrown = assertThrows(IllegalArgumentException.class, () -> uniquePinGenerator.getUniquePin(inputBatchSize));

		assertEquals(thrown.getMessage(), "Batch size greater than the maximum threshold ...!!!");
	}

	@ParameterizedTest
	@MethodSource("getBatchSizeValueZeroOrNegative")
	void testGetUniquePinWithBatchSizeZeroOrNegativeThrowsException(int inputBatchSize) {
		UniquePinGenerator uniquePinGenerator = new UniquePinGenerator();

		Exception thrown = assertThrows(InvalidInputException.class, () -> uniquePinGenerator.getUniquePin(inputBatchSize));

		assertEquals(thrown.getMessage(), "Batch size must be greater than 0 ...!!!");
	}

	private static Stream<Arguments> getValidBatchInputAndExpectedBatchOutput() {
		return Stream.of(
				Arguments.of(1, 1),
				Arguments.of(10, 10),
				Arguments.of(50, 50),
				Arguments.of(99, 99),
				Arguments.of(100, 100),
				Arguments.of(999, 999),
				Arguments.of(1000, 1000),
				Arguments.of(4999, 4999),
				Arguments.of(7000, 7000),
				Arguments.of(9000, 9000)
		);
	}

	private static Stream<Arguments> getBatchSizeValueGreaterThanMax() {
		return Stream.of(
				Arguments.of(9001),
				Arguments.of(9999),
				Arguments.of(10000),
				Arguments.of(10001)
		);
	}

	private static Stream<Arguments> getBatchSizeValueZeroOrNegative() {
		return Stream.of(
				Arguments.of(0),
				Arguments.of(-1),
				Arguments.of(-99),
				Arguments.of(-1000)
		);
	}
}
