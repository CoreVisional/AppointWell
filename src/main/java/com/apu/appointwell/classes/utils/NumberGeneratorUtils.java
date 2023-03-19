package com.apu.appointwell.classes.utils;

import java.util.Random;

/**
 *
 * @author Alex
 */
public class NumberGeneratorUtils {
    
    public int generateRandomNumbers() {
        // Get the current time in milliseconds or nanoseconds
        long currentTime = System.currentTimeMillis(); // or System.nanoTime();

        // Use the last four digits of the time as a starting point
        int startingPoint = (int) (currentTime % 10000) + 1000;

        // Create a random number generator
        Random rand = new Random();

        // Generate a random number between 0 and 9999
        int randomNumber = rand.nextInt(10000);

        // Keep generating random numbers until we get one that doesn't repeat digits
        while (hasRepeatingDigits(startingPoint + randomNumber)) {
                randomNumber = rand.nextInt(10000);
        }
        
        return randomNumber;
    }
    
    public boolean hasRepeatingDigits(int num) {
        boolean[] digits = new boolean[10];
        while (num > 0) {
                int digit = num % 10;
                if (digits[digit]) {
                        return true;
                }
                digits[digit] = true;
                num /= 10;
        }
        return false;
    }
}
