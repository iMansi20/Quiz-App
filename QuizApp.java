import java.util.Scanner;

public class QuizApp {

    // ==== Question Class ====
    static class Question {
        String question;
        String[] options;
        char correctOption;

        public Question(String question, String[] options, char correctOption) {
            this.question = question;
            this.options = options;
            this.correctOption = correctOption;
        }

        public void display() {
            System.out.println("\n" + question);
            char optionChar = 'A';
            for (String option : options) {
                System.out.println(optionChar + ". " + option);
                optionChar++;
            }
        }

        public boolean isCorrect(char answer) {
            return Character.toUpperCase(answer) == Character.toUpperCase(correctOption);
        }
    }

    // ==== Main Method ====
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Question[] questions = {
            new Question("What is the capital of France?",
                new String[]{"Berlin", "Paris", "Madrid", "Rome"}, 'B'),
            new Question("Which language is used for Android app development?",
                new String[]{"Swift", "Python", "Java", "Ruby"}, 'C'),
            new Question("What is 5 * 6?",
                new String[]{"30", "35", "25", "40"}, 'A'),
            new Question("Who is the founder of Microsoft?",
                new String[]{"Steve Jobs", "Bill Gates", "Mark Zuckerberg", "Elon Musk"}, 'B'),
            new Question("Which planet is known as the Red Planet?",
                new String[]{"Earth", "Venus", "Jupiter", "Mars"}, 'D')
        };

        int score = 0;

        for (int i = 0; i < questions.length; i++) {
            questions[i].display();
            System.out.print("Your answer (A/B/C/D): ");
            char answer = scanner.next().charAt(0);
            if (questions[i].isCorrect(answer)) {
                System.out.println("✅ Correct!");
                score++;
            } else {
                System.out.println("❌ Incorrect! The correct answer was: " + questions[i].correctOption);
            }
        }

        // Final Score
        System.out.println("\n==== Quiz Finished ====");
        System.out.println("Your Score: " + score + " out of " + questions.length);
        double percentage = (double) score / questions.length * 100;
        System.out.printf("Percentage: %.2f%%\n", percentage);

        scanner.close();
    }
}
