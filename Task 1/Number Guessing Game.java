import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();
    static int score = 0;
    public static void main(String[] args) {

        System.out.println("================================");
        System.out.println("     NUMBER GUESSING GAME");
        System.out.println("================================");

        char playAgain;

        do {
            playRound();

            System.out.print("\nPlay Again? (Y/N): ");
            playAgain = sc.next().toUpperCase().charAt(0);

        } while (playAgain == 'Y');

        System.out.println("\nFinal Score: " + score);
        System.out.println("Thanks for playing!");
    }

    private static void playRound() {

        int target = random.nextInt(100) + 1;
        int attemptsLeft = 7;
        boolean guessed = false;

        System.out.println("\nGuess a number between 1 and 100");
        System.out.println("You have " + attemptsLeft + " attempts.\n");

        while (attemptsLeft > 0) {

            int guess = getValidInput();

            if (guess < 1 || guess > 100) {
                System.out.println("Enter a number between 1 and 100.");
                continue;
            }

            attemptsLeft--;

            if (guess == target) {

                guessed = true;

                int roundScore = attemptsLeft + 1;
                score += roundScore;

                System.out.println("\nCorrect! 🎉");
                System.out.println("Attempts Remaining: " + attemptsLeft);
                System.out.println("Round Score: " + roundScore);

                break;

            } else if (guess > target) {

                System.out.println("Too High ↑");

            } else {

                System.out.println("Too Low ↓");
            }

            if (attemptsLeft > 0) {
                System.out.println("Attempts Left: " + attemptsLeft);
            }
        }

        if (!guessed) {
            System.out.println("\nGame Over!");
            System.out.println("The number was: " + target);
        }
    }

    private static int getValidInput() {

        while (true) {

            try {

                System.out.print("Enter your guess: ");
                return sc.nextInt();

            } catch (InputMismatchException e) {

                System.out.println("Invalid input. Enter numbers only.");
                sc.nextLine();
            }
        }
    }
}
