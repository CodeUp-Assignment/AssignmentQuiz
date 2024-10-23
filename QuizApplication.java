package assignment_java_programming;

/*
 * It provides the main menu options for the user to create or take a quiz.
 *
 * Created By: Sachin-Gupta
 * Date of Creation: 08/10/2024
 */

import java.util.Scanner;

public class QuizApplication {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        QuestionBank questionBank = new QuestionBank();
        DefaultQuiz defaultQuiz = new DefaultQuiz();
        Quiz quiz = null;
        int count=0;

        // Loop to keep the application running until the user exits
        while (true) {
            System.out.println("Enter your name: ");
            String name = input.nextLine();
            System.out.println(Constant.USER_CHOICE);
            String choice = input.nextLine();
            if (choice.equalsIgnoreCase(Constant.EXIT)) {
                System.out.println(Message.EXIT);
                break;
            }
            User user;
            switch (choice) {
                case "1":
                    // Option 1: Create a quiz
                    Creator creator = new Creator(name, questionBank);
                    creator.create();
                    quiz = creator.getQuiz();
                    break;
                case "2":
                    // Option 2: Participate in a quiz
                    Participant[] participant;
                    participant = new Participant[5];
                    if(count<5){
                        participant[count] = new Participant(name, defaultQuiz);
                        participant[count].takeQuiz(quiz);
                        count++;
                    }
                    break;

                case "exit":
                    break;

                default:
                    // Handle invalid choices
                    System.out.println(Constant.INVALID_CHOICE);
                    break;
            }
        }
    }
}
