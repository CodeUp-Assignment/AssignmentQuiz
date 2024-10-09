

import java.util.Scanner;

public class Create {
    private Quiz quiz;

    // Method to initialize quiz creation
    public void createQuiz() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the title of the quiz: ");
        String title = scanner.nextLine();
        
        System.out.println("Enter the maximum number of questions: ");
        int maxQuestions = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        quiz = new Quiz(title, maxQuestions);

        // Loop to add multiple questions
        for (int i = 0; i < maxQuestions; i++) {
            Question question = new Question();

            System.out.println("Enter question " + (i + 1) + ":");
            String questionText = scanner.nextLine();
            question.setQuestionText(questionText);

            // Input options
            for (int j = 0; j < 4; j++) {
                System.out.println("Enter option " + (j + 1) + ":");
                String option = scanner.nextLine();
                question.setOption(j, option);
            }

            // Input correct answer with validation
            String correctAnswer;
            do {
                System.out.println("Enter the correct answer (must match one of the options):");
                correctAnswer = scanner.nextLine();
                
                if (!question.setAnswer(correctAnswer)) {
                    System.out.println("Invalid answer. Please choose an answer from the provided options.");
                }
            } while (!question.setAnswer(correctAnswer));  // Keep asking until a valid answer is provided

            // Add the question to the quiz
            if (!quiz.addQuestion(question)) {
                System.out.println("Could not add the question. Please try again.");
                i--;  // Go back to add this question again
            } else {
                System.out.println("Question added successfully.");
            }
        }

        scanner.close();
        // Display the created quiz
        quiz.displayQuiz();
    }

    public static void main(String[] args) {
        Create create = new Create();
        create.createQuiz();
    }
}
