package services;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * Generator Service for strings and numbers and arrays
 */
public class GeneratorService {

    /**
     * Generate string with random numbers with required length.
     *
     * @param length int
     * @return String
     */
    public static String randomNumSequence(int length) {
        return RandomStringUtils.randomNumeric(length);
    }
}
