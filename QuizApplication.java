package assignment_java_programming;

/*
 * This is the class from where the program runs.
 * Created By : Sachin-Gupta
 * Date of Creation : 08/10/2024
 */

import java.util.Scanner;

public class QuizApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        QuestionBank questionBank = new QuestionBank();
        DefaultQuiz defaultQuiz = new DefaultQuiz();
        Quiz quiz = new Quiz("");

        while (true) {
            System.out.println(Constants.USER_CHOICE);
            String choice = input.nextLine();

            if (choice.equalsIgnoreCase("exit")) {
                System.out.println(Constants.EXIT);
                break;
            }

            switch (choice) {
                case "1":
                    Creator creator = new Creator(questionBank, quiz);
                    creator.create(scanner);
                    break;
                case "2":
                    Participant participant = new Participant(quiz, questionBank, defaultQuiz);
                    participant.takeQuiz();
                    break;
                default:
                    System.out.println("Invalid Choice, please try again.");
                    break;
            }
        }
    }
}

