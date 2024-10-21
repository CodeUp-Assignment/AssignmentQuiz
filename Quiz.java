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
        this.questions = new Question[5];
        this.currentQuestionCount = 0;
    }

    // Adds a question to the quiz
    public void addQuestion(Question question) {
        if (currentQuestionCount >= questions.length) {
            resizeQuestionsArray();
        }
        questions[currentQuestionCount++] = question;
        System.out.println("Question added to quiz: " + question.getQuestionText());
    }

    // Displays the quiz details
    public void displayQuiz() {
        System.out.println("Quiz Title: " + title);
        for (int i = 0; i < currentQuestionCount; i++) {
            System.out.println("ID: " + questions[i].getId() + " - " + questions[i].getQuestionText());
        }
    }

    // Resizes the questions array
    private void resizeQuestionsArray() {
        Question[] newQuestions = new Question[questions.length * 2];
        for (int i = 0; i < questions.length; i++) {
            newQuestions[i] = questions[i];
        }
        questions = newQuestions;
    }
}
