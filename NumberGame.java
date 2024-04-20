import java.util.Scanner;
import java.util.Random;

public class NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1; // Minimum value of the range
        int maxRange = 100; // Maximum value of the range
        int attempts = 5; // Number of attempts allowed
        int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange; // Generating the target number

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println(" please select a number between " + minRange + " and " + maxRange + ".");
        System.out.println("You have " + attempts + " attempts to guess it.");

        int guess;
        boolean guessedCorrectly = false;

        while (attempts > 0 && !guessedCorrectly) {
            System.out.print("Enter your guess: ");
            guess = sc.nextInt();
            sc.nextLine(); // Consume newline

            if (guess == targetNumber) {
                guessedCorrectly = true;
                System.out.println("Congratulations! You guessed the correct number: " + targetNumber);
            } else {
                attempts--;
                if (attempts > 0) {
                    System.out.println("Incorrect guess! You have " + attempts + " attempts left.");
                    if (guess < targetNumber) {
                        System.out.println("Try a higher number.");
                    } else {
                        System.out.println("Try a lower number.");
                    }
                } else {
                    System.out.println("oops Out of attempts! The correct number was: " + targetNumber);
                }
            }
        }

        sc.close();
    }
}
