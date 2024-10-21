package assignment_java_programming;

/*
 * This is the class from where the program runs.
 * Created By : Sachin-Gupta
 * Date of Creation : 08/10/2024
 */

import java.util.Scanner;
import static assignment_java_programming.Utils.isValidEmail;

public class QuizApplication {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        QuestionBank questionBank = new QuestionBank(); 

        while (true) {
            System.out.println(Constants.NAME);
            String name = input.nextLine();

            System.out.println(Constants.E_MAIL);
            String email = input.nextLine();

            if (!isValidEmail(email)) {
                System.out.println(Error.INVALID);
                continue;
            }

            System.out.println(Constants.USER_CHOICE);
            String choice = input.nextLine();

            if (choice.equalsIgnoreCase("exit")) {
                System.out.println(Constants.EXIT);
                break;
            }

            switch (choice) {
                case "1":
                    // Creator can create the quiz 
                    Creator creator = new Creator(questionBank);
                    creator.create();
                    break;
                case "2":
                    // Participant takes the quiz
                    if (questionBank.getQuestions().isEmpty()) {
                        System.out.println("No quiz available. Please create a quiz first.");
                    } else {
                        Participant participant = new Participant(questionBank);
                        participant.takeQuiz();
                    }
                    break;
                default:
                    System.out.println("Invalid Choice, please try again.");
                    break;
            }
        }
    }
}

