import java.util.Scanner;

public class Creator {
    private static final int MAX_QUESTION_LENGTH = 100;
    private static final int MAX_OPTION_LENGTH = 50;
    
    private Quiz quiz;

    public void createQuiz(Scanner scanner) {
     
        System.out.println("Enter the title of the quiz: ");
        String title = scanner.nextLine();
        quiz = new Quiz(title);

        boolean addingQuestions = true;
        while (addingQuestions) {
            try {
                Question question = new Question();

                // Get valid question text (not empty and within max length)
                String questionText;
                do {
                    System.out.println("Enter the question text: ");
                    questionText = scanner.nextLine();
                    if (questionText.trim().isEmpty()) {
                        System.out.println("Question cannot be empty. Please try again.");
                    } else if (questionText.length() > MAX_QUESTION_LENGTH) {
                        System.out.println("Question is too long. Maximum allowed length is " + MAX_QUESTION_LENGTH + " characters.");
                    }
                } while (questionText.trim().isEmpty() || questionText.length() > MAX_QUESTION_LENGTH);
                question.setQuestionText(questionText);

                // Get 4 valid options (not empty and within max length)
                for (int j = 0; j < 4; j++) {
                    String option;
                    do {
                        System.out.println("Enter option " + (j + 1) + ":");
                        option = scanner.nextLine();
                        if (option.trim().isEmpty()) {
                            System.out.println("Option cannot be empty. Please try again.");
                        } else if (option.length() > MAX_OPTION_LENGTH) {
                            System.out.println("Option is too long. Maximum allowed length is " + MAX_OPTION_LENGTH + " characters.");
                        }
                    } while (option.trim().isEmpty() || option.length() > MAX_OPTION_LENGTH);
                    question.setOption(j, option);
                }

                // Get valid correct answer (must match one of the options)
                String correctAnswer;
                do {
                    System.out.println("Enter the correct answer (must match one of the options):");
                    correctAnswer = scanner.nextLine();

                    if (!question.setAnswer(correctAnswer)) {
                        System.out.println("Invalid answer. Please choose an answer from the provided options.");
                    }
                } while (!question.setAnswer(correctAnswer));

                // Add the question to the quiz
                quiz.addQuestion(question);
                System.out.println("Question added successfully.");

            } catch (Exception e) {
                System.out.println("Error while adding the question. Please try again.");
                continue;
            }
            try {
                System.out.println("Do you want to add another question? (yes/no)");
                String response = scanner.nextLine();
                if (response.equalsIgnoreCase("no")) {
                    addingQuestions = false;
                }
            } catch (Exception e) {
                System.out.println("Error reading your response. Ending quiz creation.");
                addingQuestions = false;
            }
        }

        scanner.close();

        // Display the quiz
        try {
            quiz.displayQuiz();
        } catch (Exception e) {
            System.out.println("Error displaying the quiz. Please check the questions.");
        }
    }

    public static void main(String[] args) {
    	
    	Scanner scanner = new Scanner(System.in);
    	   
        Creator create = new Creator();
        create.createQuiz(scanner);
        

        scanner.close();
    }
}
