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
	
	//Initiates the quiz creation process. It prompts the user to choose between creating a quiz, adding questions, 
	//or exiting the application. Depending on the user's choice, it either creates a quiz or adds questions.
    public void create(Scanner scanner) {
        while (true) {
            System.out.println("Do you want to create a quiz, add questions, or exit? (create quiz/add questions/exit)");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("exit")) {
                return; 
            }
            
            switch (choice.toLowerCase()) {
                case "create quiz":
                    String title = getValidTitle(scanner);
                    Quiz quiz = new Quiz(title);
                    createQuiz(scanner, quiz);
                    break;

                case "add questions":
                    addQuestions(scanner);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    //Prompts the user for the title of the quiz and validates the input to ensure it is not empty and does not exceed 
    //100 characters. Returns a valid title.
    private String getValidTitle(Scanner scanner) {
        String title;
        do {
            System.out.println("Enter the title of the quiz (cannot be empty and must be less than 100 characters): ");
            title = scanner.nextLine();
        } while (title.trim().isEmpty() || title.length() > 100); 
        return title;
    }

    //Displays the available questions in the question bank and allows the user to add questions to the specified 
    //quiz using their IDs. If no questions are available, it returns to the main menu.
    private void createQuiz(Scanner scanner, Quiz quiz) {
        Question.displayQuestions(); 

        if (Question.getTotalQuestions() == 0) {
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
                Question question = Question.getQuestionById(questionId);
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

    //Allows the user to add multiple questions to the question bank. The user can input questions 
    //and options until they type 'done' to finish.
    private void addQuestions(Scanner scanner) {
        System.out.println("You can add multiple questions. Type 'done' when you are finished.");

        while (true) {
            String questionText = getQuestionText(scanner);
            if (questionText.equalsIgnoreCase("done")) {
                break; 
            }

            String[] options = getOptions(scanner);
            String answer = getAnswer(scanner, options); 
            Question.addQuestionBank(questionText, options, answer);
        }
    }

    //Prompts the user for the text of the question, ensuring it is not empty and does not exceed 100 characters. 
    //If the user types 'done', it returns this input. Otherwise, it returns a valid question text.
    private String getQuestionText(Scanner scanner) {
        String questionText;
        do {
            System.out.println("Enter the question text (cannot be empty and must be less than 100 characters):");
            questionText = scanner.nextLine();
            if (questionText.equalsIgnoreCase("done")) {
                return questionText; 
            }
        } while (questionText.trim().isEmpty() || questionText.length() > 100); 
        return questionText;
    }

    //Prompts the user to enter four options for a question, validating that each option is not empty and does not 
    //exceed 100 characters. Returns an array of valid options.
    private String[] getOptions(Scanner scanner) {
        String[] options = new String[4];
        for (int i = 0; i < 4; i++) {
            String option;
            do {
                System.out.println("Enter option " + (i + 1) + " (cannot be empty and must be less than 100 characters):");
                option = scanner.nextLine();
            } while (option.trim().isEmpty() || option.length() > 100); 
            options[i] = option;
        }
        return options;
    }

    //Prompts the user to enter the correct answer for the question, ensuring that it matches one of the provided
    //options and is not empty. Returns a valid answer.
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
            
            if (answer.trim().isEmpty() || answer.length() > 100 || !isValid) {
                System.out.println("Invalid answer. Please make sure it is one of the options and not empty.");
            } else {
                break; 
            }
        }
        return answer;
    }

}
