package assignment_java_programming;

/***
 * The Quiz class represents a quiz containing a title and a collection of questions. It provides functionality 
 * to add questions to the quiz and display the quiz content.
 * 
 * Owner : Avadhi-Singhal
 * 
 * Date of Creation : 10/10/2024
 */

public class Quiz {
    private String title;
    private Question[] questions;
    private int currentQuestionCount;

    // Constructor for quiz with a title
    public Quiz(String title) {
        this.title = title;
    }

    // Displays the quiz details
    public void displayQuiz() {
        System.out.println("Quiz Title: " + title);
        for (int i = 0; i < currentQuestionCount; i++) {
            System.out.println("ID: " + questions[i].getId() + " - " + questions[i].getQuestionText());
        }
    }
}
