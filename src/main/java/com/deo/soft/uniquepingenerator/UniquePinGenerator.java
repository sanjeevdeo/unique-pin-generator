package com.deo.soft.uniquepingenerator;

import com.deo.soft.uniquepingenerator.exception.InvalidInputException;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Set;

/**
 * This class generate the random unique 4 digits pin
 */
public class UniquePinGenerator {
	private final int MAX_BATCH_SIZE = 9000;

	public Set<Integer> getUniquePin() {
		return generateUniquePin(1);
	}

	public Set<Integer> getUniquePin(final int batchSize) {
		if (batchSize > MAX_BATCH_SIZE)
			throw new InvalidInputException("Batch size greater than the maximum threshold ...!!!");

		if(batchSize <= 0)
			throw new InvalidInputException("Batch size must be greater than 0 ...!!!");

		return generateUniquePin(batchSize);
	}

	private Set<Integer> generateUniquePin(final int batchSize) {
		final Set<Integer> uniquePins = new HashSet<>();
		try {
			SecureRandom secureRandom = SecureRandom.getInstanceStrong();

			while (uniquePins.size() < batchSize) {
				uniquePins.add(secureRandom.nextInt(1000, 10000));
			}
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
		return uniquePins;
	}

}
