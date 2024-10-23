/***
 * This class allows participants to attempt the quiz.
 * Users can answer the questions or navigate through the quiz.
 *
 * Created by - Kiran Choudhary
 *
 * Date - 08 October 2024
 */
package assignment_java_programming;

import java.util.Scanner;

public class Participant extends User {
    private DefaultQuiz defaultQuiz;
    private Scanner input;
    private int score = 0;

    /**
     * Constructor to initialize QuestionBank and DefaultQuiz
     *
     * @param defaultQuiz
     */
    public Participant(String name, DefaultQuiz defaultQuiz) {
        super(name);
        this.defaultQuiz = defaultQuiz;
        this.input = new Scanner(System.in);
    }

    /**
     * Displays the available quizzes and lets the user select which quiz to play.
     */
    public void takeQuiz(Quiz quiz) {
        System.out.println(Constant.AVAILABLE_QUIZ);
        System.out.println("1. " + defaultQuiz.getTitle());
        if (quiz != null) {
            System.out.println("2. " + quiz.getTitle());
        }
        System.out.print("Select a quiz to play : ");
        String selectedQuiz = input.nextLine();
        if (selectedQuiz.equals("1")) {
            attempt(defaultQuiz);
        } else if (selectedQuiz.equals("2")) {
            attempt(quiz);
        } else {
            System.out.println(Error.INVALID);
        }
    }

    public String[] attempt(Quiz quiz) {
        int questionCount = quiz.getCurrentQuestionCount();
        String[] userAnswers = new String[questionCount];
        int index = 0;
        while (index < questionCount) {
            displayQuestion(quiz, index);
            String choice = input.nextLine();
            index = handleUserChoice(choice, index, userAnswers);
        }
        System.out.println(Constant.FINISH);
        calculateScore(userAnswers, quiz);
        return userAnswers;
    }

    public void displayQuestion(Quiz quiz, int index) {
        Question question = quiz.getQuestions()[index];
        System.out.println(Constant.QUESTION_NO + (index + 1) + ": " + question.getQuestionText());

        String[] options = question.getOptions();
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ") " + options[i]);
        }
        System.out.println(Constant.NEXT_PREVIOUS_QUESTION);
    }

    /**
     * Method to display all quiz questions one by one and allow the participant to answer them.
     */
    public String[] attempt(DefaultQuiz defaultQuiz) {
        System.out.println(Constant.WELCOME + defaultQuiz.getTitle());
        int questionCount = defaultQuiz.getQuestionCount();
        String[] userAnswers = new String[questionCount];
        System.out.println(Constant.PARTICIPANT_CHOICE);
        int index = 0;
        while (index < questionCount) {
            displayQuestion(defaultQuiz, index);
            String choice = input.nextLine();
            index = handleUserChoice(choice, index, userAnswers);
        }
        System.out.println(Constant.FINISH);
//        calculateScore(userAnswers);
        return userAnswers;
    }

    /**
     * @param quiz
     * @param index
     */
    public void displayQuestion(DefaultQuiz quiz, int index) {
        Question question = quiz.getQuestion(index);
        System.out.println(Constant.QUESTION_NO + (index + 1) + ": " + question.getQuestionText());
        String[] options = question.getOptions();
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ") " + options[i]);
        }
        System.out.println(Constant.NEXT_PREVIOUS_QUESTION);
    }

    public int handleUserChoice(String choice, int index, String[] userAnswers) {
        switch (choice) {
            case "1":
            case "2":
            case "3":
            case "4":
                userAnswers[index] = choice;
                return index + 1;

            case "p":
                return index - 1;

            case "n":
                return index + 1;

            case "s":
                System.out.println(Constant.FINISH);
                return 1;

            default:
                System.out.println(Error.INVALID);
                return index;
        }
    }

    /**
     * Calculates and displays the participant's score.
     */
    public void calculateScore(String[] userAnswers, Quiz quiz) {

        for (int i = 0; i < userAnswers.length; i++) {
            Question[] question = quiz.getQuestions();
            String correctAnswer = question[i].getAnswer();
            String[] options = question[i].getOptions();
            if (correctAnswer.equals(options[Integer.parseInt(userAnswers[i]) - 1])) {
                score += 1;
            }

            System.out.println(Constant.SCORE + score + Constant.OUT_OF + userAnswers.length);
        }
    }

    public int getScore() {
        return score;
    }
}


