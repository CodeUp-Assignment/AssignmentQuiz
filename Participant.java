/***
 * This class allows participants to attempt the quiz. 
 * Users can answer the questions or navigate through the quiz.
 * 
 * Created by - Kiran Choudhary
 * 
 * Date - 08 October 2024
 */
package project;

import java.util.Scanner;

public class Participant {
    private QuestionBank questionBank;   
    private DefaultQuiz defaultQuiz;     

    /**
     *  Constructor to initialize QuestionBank and DefaultQuiz
     * @param questionBank
     * @param defaultQuiz
     */
    public Participant(QuestionBank questionBank, DefaultQuiz defaultQuiz) {
        this.questionBank = questionBank;
        this.defaultQuiz = defaultQuiz;
    }

    /**
     * Displays the available quizzes and lets the user select which quiz to play.
     */
    public void takeQuiz() {
        Scanner input = new Scanner(System.in);

        System.out.println(Constants.AVAILABLE_QUIZ);
        System.out.println("1. " + defaultQuiz.getTitle());  

        System.out.print("Select a quiz to play (1): ");
        String selectedQuiz = input.nextLine();

        if (selectedQuiz == 1) {
            play(defaultQuiz);  
        } else {
            System.out.println(Error.INVALID);
        }
    }

    /**
     * Method to display all quiz questions one by one and allow the participant to answer them.
     */
    public String[] play(DefaultQuiz defaultQuiz) {
        Scanner input = new Scanner(System.in);
        System.out.println(Constants.WELCOME + defaultQuiz.getTitle());
        int questionCount = defaultQuiz.getQuestionCount();
        String[] userAnswers = new String[questionCount];  
        System.out.println(Constants.PARTICIPANT_CHOICE);
        int index = 0;  
        while (index < questionCount) {
            Question questions = defaultQuiz.getQuestion(index); 
            System.out.println(Constants.QUESTION_NO + (index + 1) + ": " + questions.getQuestionText());
            String[] options = questions.getOptions();
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ") " + options[i]);
            }
            System.out.println(Constants.NEXT_PREVIOUS_QUESTION);
            String answer = input.nextLine();
            switch (answer) {
                case "1":
                case "2":
                case "3":
                case "4":
                    userAnswers[index] = answer;  
                    index = index + 1;  
                    break;
                case "p":  
                    index = index - 1;
                    break;
                case "n":
                    index = index + 1;
                    break;
                case "s":  
                	System.out.println(Constants.FINISH);
                    return userAnswers;
                default:
                    System.out.println(Error.INVALID);
                    break;
            }
        }
        return userAnswers;
    }
}
