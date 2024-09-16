import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizGame {
    private static int score = 0;
    private static int totalQuestions = 0;
    private static boolean timeUp = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Array to store quiz questions, options, and correct answers
        String[][] questions = {
                {"What is the capital of France?", "A) Paris", "B) London", "C) Rome", "D) Berlin", "A"},
                {"Which planet is known as the Red Planet?", "A) Earth", "B) Mars", "C) Jupiter", "D) Venus", "B"},
                {"Who wrote 'Hamlet'?", "A) Charles Dickens", "B) Jane Austen", "C) William Shakespeare", "D) Mark Twain", "C"},
                {"What is the square root of 64?", "A) 6", "B) 7", "C) 8", "D) 9", "C"},
                {"Which element has the chemical symbol 'O'?", "A) Oxygen", "B) Hydrogen", "C) Gold", "D) Silver", "A"}
        };

        totalQuestions = questions.length;

        // Loop through all the questions
        for (int i = 0; i < totalQuestions; i++) {
            timeUp = false;
            System.out.println("\nQuestion " + (i + 1) + ": " + questions[i][0]);

            // Display options
            for (int j = 1; j <= 4; j++) {
                System.out.println(questions[i][j]);
            }

            // Timer for 10 seconds per question
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                public void run() {
                    timeUp = true;
                    System.out.println("\nTime's up!");
                    timer.cancel();
                }
            }, 10000);  // 10 seconds

            // Capture user input
            String userAnswer = "";
            while (!timeUp && !scanner.hasNext()) {
                // Wait for input or timeout
            }
            if (!timeUp) {
                userAnswer = scanner.next().toUpperCase();  // User's answer
                timer.cancel();  // Stop the timer if the answer is submitted
            }

            // Compare user's answer with the correct answer
            if (userAnswer.equals(questions[i][5])) {
                System.out.println("Correct!");
                score++;
            } else if (!timeUp) {
                System.out.println("Incorrect. The correct answer is " + questions[i][5]);
            }
        }

        // Display final score and result summary
        System.out.println("\n--- Quiz Summary ---");
        System.out.println("Total Questions: " + totalQuestions);
        System.out.println("Correct Answers: " + score);
        System.out.println("Incorrect Answers: " + (totalQuestions - score));
        System.out.println("Your final score is: " + score + " out of " + totalQuestions);

        scanner.close();
    }
}

