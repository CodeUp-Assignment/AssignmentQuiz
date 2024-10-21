package assignment_java_programming;
/***
 * The QuestionBank class is responsible for managing a collection of Question objects. It allows adding new questions, 
 * retrieving questions by their ID, and displaying all stored questions. The class dynamically resizes its internal 
 * array to accommodate more questions when needed.
 * 
 * Owner : Avadhi-Singhal
 * 
 * Date of Creation : 10/10/2024
 */

public class QuestionBank {
    private Question[] questions;
    private int questionCount;

    public QuestionBank() {
        this.questions = new Question[10]; 
        this.questionCount = 0;
    }

    // Adds a new question to the question bank. Expands the array if needed.
    public void addQuestion(String questionText, String[] options, String answer) {
        if (questionCount >= questions.length) {
            resizeQuestionBank();
        }
        questions[questionCount++] = new Question(questionCount, questionText, options, answer);
        System.out.println("Question added with ID: " + questionCount);
    }

    // Retrieves a question by ID.
    public Question getQuestionById(int id) {
        for (int i = 0; i < questionCount; i++) {
            if (questions[i].getId() == id) {
                return questions[i];
            }
        }
        return null;
    }

    // Displays all questions in the question bank.
    public void displayQuestions() {
        if (questionCount == 0) {
            System.out.println("No questions available in the question bank.");
        } else {
            for (int i = 0; i < questionCount; i++) {
                System.out.println("ID: " + questions[i].getId() + " - " + questions[i].getQuestionText());
            }
        }
    }

    // Resizes the question bank array when needed.
    private void resizeQuestionBank() {
        Question[] newQuestions = new Question[questions.length * 2];
        for (int i = 0; i < questions.length; i++) {
            newQuestions[i] = questions[i];
        }
        questions = newQuestions;
    }
}
