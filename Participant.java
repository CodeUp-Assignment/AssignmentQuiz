/***
 * This class is created for attempting the quiz. The user gets the questions and their options,
 * and then they must answer the question or navigate through the quiz.
 */

package practice.java;

import java.util.Scanner;

public class Participant {

    /** 
     * Allows the user to attempt a quiz created by the host.
     */
    public void attemptQuiz(Creator host, Scanner input) { 
        Quiz quiz = host.getQuiz(); 

        if (quiz == null || quiz.getQuestionCount() == 0) {
            System.out.println("There is no Quiz created yet."); // Check if the quiz exists
            return;
        }

        System.out.println("Welcome to the Quiz: " + quiz.getTitle()); 

        int questionLength = quiz.getQuestionCount();
        String[] userAnswer = new String[questionLength]; 

        System.out.println("For Answer - Select from 1-4 \nFor Skip - Click Enter \nFor Previous Question - Write j \nFor Next Question - Write l \nFor Submit - Write k");
        int i = 0; 

        while (true) {
            if (i < 0) i = 0;        
            if (i >= questionLength) i = questionLength - 1;

            Question currentQuestion = quiz.getQuestion(i);
            if (currentQuestion != null) {
                System.out.println("Ques" + (i + 1) + ") " + currentQuestion.getQuestionText());
                for (int j = 0; j < 4; j++) {
                    System.out.println((j + 1) + ") " + currentQuestion.getOption(j)); 
                }
            } else {
                System.out.println("Question " + (i + 1) + " is not available."); 
                i++;
                continue; 
            }

            String answer = input.nextLine(); 
            switch (answer) {
                case "1":
                case "2":
                case "3":
                case "4":
                    userAnswer[i] = answer; 
                    i++; 
                    break;
                case "j":
                    if (i > 0) i--;
                    break;
                case "l":
                    if (i < questionLength - 1) i++; 
                    break;
                case "k":
                    submit(userAnswer, quiz); 
                    return;
                case "":
                    i++; 
                    break;
                default:
                    System.out.println("Invalid Input! Please select the correct one."); 
                    break;
            }
        }
    }

    /** 
     * Submits the user's answers and calculates the score.
     */
    private void submit(String[] userAnswer, Quiz quiz) {
        int score = 0; 
        for (int i = 0; i < userAnswer.length; i++) {
            if (userAnswer[i] != null && userAnswer[i].equals(quiz.getQuestion(i).getAnswer())) {
                score++;
            }
        }
        System.out.println("Total Score: " + score);
    }
}
