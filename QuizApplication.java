package practice.java;

/*
 * It provides the main menu options for the user to create or take a quiz.
 * 
 * Created By: Sachin-Gupta
 * Date of Creation: 08/10/2024
 */

import java.util.Scanner;

public class QuizApplication {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in); 
        Scanner input = new Scanner(System.in); 
        QuestionBank questionBank = new QuestionBank(); 
        DefaultQuiz defaultQuiz = new DefaultQuiz(); 
        Quiz quiz = new Quiz(""); 

        // Loop to keep the application running until the user exits
        while (true) {

            System.out.println(Constants.USER_CHOICE); 
            String choice = input.nextLine(); 
            if (choice.equalsIgnoreCase(Constants.EXIT)) {
                System.out.println(Message.EXIT); 
                break; 
            }

            switch (choice) {
                case "1":
                    // Option 1: Create a quiz
                    Creator creator = new Creator(questionBank, quiz); 
                    creator.create();
                    break;

                case "2":
                    // Option 2: Participate in a quiz
                    Participant participant = new Participant(quiz, questionBank, defaultQuiz); 
                    participant.takeQuiz();
                    break;

                default:
                    // Handle invalid choices
                    System.out.println(Constants.INVALID_CHOICE);
                    break;
            }
        }
    }
}
