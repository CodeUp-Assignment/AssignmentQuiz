package assignment_java_programming;

/***
 * The Creator class is responsible for facilitating the creation of quizzes and the addition of questions to a question bank. 
 * It provides methods to interact with the user, guiding them through the process of creating quizzes and managing questions.
 * 
 * Owner : Avadhi-Singhal
 * 
 * Date of Creation : 09/10/2024
 */

import java.util.Scanner;

public class Creator {

    // Initiates the quiz creation process with a termination condition
    public void create(Scanner scanner, QuestionBank questionBank) {
        boolean continueLoop = true;
        while (continueLoop) {
            System.out.println("Do you want to create a quiz, add questions, or exit? (create quiz/add questions/exit)");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("exit")) {
                continueLoop = false;
                return;
            }

            switch (choice.toLowerCase()) {
                case "create quiz":
                    String title = getValidTitle(scanner);
                    Quiz quiz = new Quiz(title);
                    createQuiz(scanner, quiz, questionBank);
                    continueLoop = false; 
                    break;

                case "add questions":
                    addQuestions(scanner, questionBank);
                    continueLoop = false; 
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    // Gets a valid title for the quiz
    private String getValidTitle(Scanner scanner) {
        String title;
        do {
            System.out.println("Enter the title of the quiz (cannot be empty and must be less than 100 characters): ");
            title = scanner.nextLine();
        } while (title.trim().isEmpty() || title.length() > 100);
        return title;
    }

    // Creates a quiz by adding questions from the question bank
    private void createQuiz(Scanner scanner, Quiz quiz, QuestionBank questionBank) {
        questionBank.displayQuestions();

        if (questionBank.getQuestionById(1) == null) {  
            System.out.println("No questions available to add to the quiz. Returning to main menu.");
            return;
        }

        while (true) {
            System.out.println("Enter the question ID to add to the quiz (or type 'done' to finish): ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) {
                break;
            }

            try {
                int questionId = Integer.parseInt(input);
                Question question = questionBank.getQuestionById(questionId);
                if (question != null) {
                    quiz.addQuestion(question);
                } else {
                    System.out.println("Invalid question ID.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number or 'done' to finish.");
            }
        }
        quiz.displayQuiz();
    }

    // Adds multiple questions to the question bank
    private void addQuestions(Scanner scanner, QuestionBank questionBank) {
        System.out.println("You can add multiple questions. Type 'done' when you are finished.");

        while (true) {
            String questionText = getQuestionText(scanner);
            if (questionText.equalsIgnoreCase("done")) {
                break;
            }

            String[] options = getOptions(scanner);
            String answer = getAnswer(scanner, options);
            questionBank.addQuestion(questionText, options, answer);
        }
    }

    // Gets a valid question text
    private String getQuestionText(Scanner scanner) {
        String questionText;
        do {
            System.out.println("Enter the question text (cannot be empty and must be less than 100 characters):");
            questionText = scanner.nextLine();
        } while (questionText.trim().isEmpty() || questionText.length() > 100);
        return questionText;
    }

    // Gets multiple valid options
    private String[] getOptions(Scanner scanner) {
        System.out.println("Enter the number of options: ");
        int optionCount = Integer.parseInt(scanner.nextLine());
        String[] options = new String[optionCount];
        for (int i = 0; i < optionCount; i++) {
            String option;
            do {
                System.out.println("Enter option " + (i + 1) + " (cannot be empty and must be less than 100 characters):");
                option = scanner.nextLine();
            } while (option.trim().isEmpty() || option.length() > 100);
            options[i] = option;
        }
        return options;
    }

    // Gets a valid answer
    private String getAnswer(Scanner scanner, String[] options) {
        String answer;
        while (true) {
            System.out.println("Enter the correct answer (must be one of the options and cannot be empty):");
            answer = scanner.nextLine();

            boolean isValid = false;
            for (String option : options) {
                if (answer.equals(option)) {
                    isValid = true;
                    break;
                }
            }

            if (answer.trim().isEmpty() || !isValid) {
                System.out.println("Invalid answer. Please choose from the given options.");
            } else {
                return answer;
            }
        }
    }
}
