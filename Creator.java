package assignment_java_programming;

/***
 * The Creator class is responsible for facilitating the creation of quizzes and the addition of questions to a question bank. 
 * It provides methods to interact with the user, guiding them through the process of creating quizzes and managing questions.
 * 
 * Owner : Avadhi-Singhal
 * 
 * Date of Creation : 09/10/2024
 */

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

    public void create(Scanner scanner, QuestionBank questionBank) {
        boolean continueLoop = true;
        while (continueLoop) {
            displayMenu();

            int choice = getValidChoice(scanner);

            switch (choice) {
                case 1:
                    String title = getTitle(scanner);
                    Quiz quiz = new Quiz(title);
                    createQuiz(scanner, quiz, questionBank);
                    continueLoop = false; // End after creating quiz
                    break;

                case 2:
                    addQuestions(scanner, questionBank);
                    continueLoop = false; // End after adding questions
                    break;

                case 3:
                    continueLoop = false; // Exit option
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private void displayMenu() {
        System.out.println("Choose an option: ");
        System.out.println("1. Create quiz");
        System.out.println("2. Add questions");
        System.out.println("3. Exit");
    }

    private int getValidChoice(Scanner scanner) {
        int choice = 0;
        while (true) {
            try {
                System.out.print("Enter your choice (1-3): ");
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < 1 || choice > 3) {
                    System.out.println("Please enter a number between 1 and 3.");
                    continue;
                }
                break; // Valid choice, exit the loop
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 3.");
            }
        }
        return choice;
    }

    private String getTitle(Scanner scanner) {
        String title;
        do {
            System.out.println("Enter the title of the quiz (cannot be empty and must be less than 100 characters): ");
            title = scanner.nextLine();
        } while (title.trim().isEmpty() || title.length() > 100);
        return title;
    }

    private void createQuiz(Scanner scanner, Quiz quiz, QuestionBank questionBank) {
        questionBank.displayQuestions();

        if (questionBank.getQuestionCount() == 0) {
            System.out.println("No questions available to add to the quiz. Returning to main menu.");
            return;
        }

        boolean addingQuestions = true;
        while (addingQuestions) {
            System.out.println("Enter the question ID to add to the quiz (or type 'done' to finish): ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) {
                addingQuestions = false;
                break;
            }

            addQuestionToQuiz(scanner, input, quiz, questionBank);
        }
        quiz.displayQuiz(); // Display the quiz with added questions
    }

    private void addQuestionToQuiz(Scanner scanner, String input, Quiz quiz, QuestionBank questionBank) {
        try {
            int questionId = Integer.parseInt(input);
            Question question = questionBank.getQuestionById(questionId);
            if (question != null) {
                // Add the question directly to the Quiz display
                System.out.println("Adding question: " + question.getQuestionText());
                quiz.displayQuiz(); // Update the quiz display to show the added question
            } else {
                System.out.println("Invalid question ID.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number or 'done' to finish.");
        }
    }

    private void addQuestions(Scanner scanner, QuestionBank questionBank) {
        System.out.println("You can add multiple questions. Type 'done' when you are finished.");

        boolean addingQuestions = true;
        while (addingQuestions) {
            String questionText = getQuestionText(scanner);
            if (questionText.equalsIgnoreCase("done")) {
                addingQuestions = false;
                break;
            }

            String[] options = getOptions(scanner);
            String answer = getAnswer(scanner, options);
            questionBank.addQuestion(questionText, options, answer);
        }
    }

    private String getQuestionText(Scanner scanner) {
        String questionText;
        do {
            System.out.println("Enter the question text (cannot be empty and must be less than 100 characters):");
            questionText = scanner.nextLine();
        } while (questionText.trim().isEmpty() || questionText.length() > 100);
        return questionText;
    }

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

    private String getAnswer(Scanner scanner, String[] options) {
        String answer = null;
        boolean valid = false;

        while (!valid) {
            System.out.println("Enter the correct answer (must be one of the options and cannot be empty):");
            answer = scanner.nextLine();
            valid = !answer.trim().isEmpty();

            // Check if answer is one of the options
            for (String option : options) {
                if (answer.equals(option)) {
                    valid = true;
                    break;
                }
            }

            if (!valid) {
                System.out.println("Invalid answer. Please choose from the given options.");
            }
        }

        return answer; // Return the valid answer
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Creator creator = new Creator();
        QuestionBank questionBank = new QuestionBank();

        // Start the creation process
        creator.create(scanner, questionBank);

        // Close the scanner after use
        scanner.close();
    }
}








