import java.util.*;

class Question {
    private String questionText;
    private String[] options;
    private char correctAnswer; // 'A', 'B', 'C', 'D'

    public Question(String questionText, String[] options, char correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public void displayQuestion() {
        System.out.println(questionText);
        char optionLabel = 'A';
        for (String option : options) {
            System.out.println(optionLabel + ". " + option);
            optionLabel++;
        }
    }

    public boolean isCorrect(char userAnswer) {
        return Character.toUpperCase(userAnswer) == correctAnswer;
    }
}

public class QuizApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Question> questions = new ArrayList<>();

        // Add quiz questions
        questions.add(new Question(
                "Which language is used for Android development?",
                new String[]{"Python", "Kotlin", "Swift", "Ruby"}, 'B'
        ));
        questions.add(new Question(
                "Which keyword is used to inherit a class in Java?",
                new String[]{"extends", "implements", "inherits", "super"}, 'A'
        ));
        questions.add(new Question(
                "Which of these is not an OOP concept?",
                new String[]{"Encapsulation", "Polymorphism", "Compilation", "Abstraction"}, 'C'
        ));

        int score = 0;
        System.out.println("===== Welcome to the Online Quiz App =====\n");

        // Display each question
        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println("Question " + (i + 1) + ":");
            q.displayQuestion();

            System.out.print("Enter your answer (A/B/C/D): ");
            char answer = sc.next().toUpperCase().charAt(0);

            if (q.isCorrect(answer)) {
                System.out.println("✅ Correct!\n");
                score++;
            } else {
                System.out.println("❌ Wrong!\n");
            }
        }

        // Display final score
        System.out.println("===== Quiz Finished! =====");
        System.out.println("Your final score: " + score + "/" + questions.size());
        sc.close();
    }
}
