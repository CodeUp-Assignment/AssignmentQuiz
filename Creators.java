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

public class Creators extends User {
    private Quiz currentQuiz; // To hold the currently created quiz

    public Creators(String name, String email) {
        super(name, email);
    }

    /** 
     * Performs an action based on user input by calling the create method.
     */
    public void performAction(Scanner input) {
        creatorChoice(input);
    }

    /** 
     * The user can choose to create a quiz, add questions, or exit the process.
     */
    public void creatorChoice(Scanner input) {
        while (true) {
            System.out.println(Constants.CHOICE);
            String choice = input.nextLine();

            if (choice.equalsIgnoreCase("exit")) {
                return;
            }

            switch (choice.toLowerCase()) {
                case "create quiz":
                    String title = getValidTitle(input);
                    currentQuiz = new Quiz(title); 
                    createQuiz(input, currentQuiz);
                    break;

                case "add questions":
                    addQuestions(input);
                    break;

                default:
                    System.out.println(Error.INVALID);
                    break;
            }
        }
    }

    /** 
     * Returns the current quiz being created.
     */
    public Quiz getQuiz() { 
        return currentQuiz;
    }

    /** 
     * Prompts the user for a valid quiz title, ensuring it is not empty and less than 100 characters.
     * @return a valid quiz title
     */
    private String getValidTitle(Scanner input) {
        String title;
        do {
            System.out.println(Constants.QUIZ_TITLE);
            title = input.nextLine();
        } while (title.trim().isEmpty() || title.length() > 100);
        return title;
    }

    /** 
     * Displays available questions in the question bank and allows the user to add questions to the specified quiz using their IDs.
     * If no questions are available, it notifies the user and returns to the main menu.
     */
    private void createQuiz(Scanner input, Quiz quiz) {
        Question.displayQuestions();

        if (Question.getTotalQuestions() == 0) {
            System.out.println(Constants.NO_QUESTIONS);
            return;
        }

        while (true) {
            System.out.println(Constants.QUESTION_ID);
            String id = input.nextLine();
            if (id.equalsIgnoreCase("done")) {
                break;
            }

            try {
                int questionId = Integer.parseInt(id);
                Question question = Question.getQuestionById(questionId);
                if (question != null) {
                    quiz.addQuestion(question);
                } else {
                    System.out.println(Error.INVALID);
                }
            } catch (NumberFormatException e) {
                System.out.println(Error.EXCEPTION);
            }
        }
        quiz.displayQuiz();
    }

    private void addQuestions(Scanner input) {
        System.out.println(Constants.ADD_QUESTIONS);

        while (true) {
            String questionText = getQuestionText(input);
            if (questionText.equalsIgnoreCase("done")) {
                break;
            }

            String[] options = getOptions(input);
            String answer = getAnswer(input, options);
            Question.addQuestionBank(questionText, options, answer);
        }
    }

    /** 
     * @return the valid question text
     */
    private String getQuestionText(Scanner input) {
        String questionText;
        do {
            System.out.println(Constants.QUESTION);
            questionText = input.nextLine();
            if (questionText.equalsIgnoreCase("done")) {
                return questionText;
            }
        } while (questionText.trim().isEmpty() || questionText.length() > 100);
        return questionText;
    }

    /** 
     * @return an array of valid options
     */
    private String[] getOptions(Scanner input) {
        String[] options = new String[4];
        for (int i = 0; i < 4; i++) {
            String option;
            do {
                System.out.println("Enter option " + (i + 1) + " (cannot be empty and must be less than 100 characters):");
                option = input.nextLine();
            } while (option.trim().isEmpty() || option.length() > 100);
            options[i] = option;
        }
        return options;
    }

    /** 
     * @return the valid answer
     */
    private String getAnswer(Scanner input, String[] options) {
        String answer;
        while (true) {
            System.out.println(Constants.ANSWER);
            answer = input.nextLine();

            boolean isValid = false;
            for (String option : options) {
                if (answer.equals(option)) {
                    isValid = true;
                    break;
                }
            }

            if (answer.trim().isEmpty() || answer.length() > 100 || !isValid) {
                System.out.println(Error.INVALID);
            } else {
                break;
            }
        }
        return answer;
    }
}
