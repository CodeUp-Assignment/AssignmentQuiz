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
    public Question[] question;
    private int questionCount;

    public QuestionBank() {
        this.question = new Question[10]; 
        this.questionCount = 0;
    }

    // Adds a new question to the question bank. Expands the array if needed.
    public void addQuestion(String questionText, String[] options, String answer) {
        if (questionCount >= question.length) {
            resizeQuestionBank();
        }
        question[questionCount++] = new Question(questionCount, questionText, options, answer);
        System.out.println("Question added with ID: " + questionCount);
    }

    // Retrieves a question by ID.
    public Question getQuestionById(int id) {
        for (int i = 0; i < questionCount; i++) {
            if (question[i].getId() == id) {
                return question[i];
            }
        }
        return null;
    }

    // Retrieves the current question count.
    public int getQuestionCount() {
        return questionCount;
    }

    // Displays all questions in the question bank.
    public void displayQuestions() {
        if (questionCount == 0) {
            System.out.println("No questions available in the question bank.");
        } else {
            for (int i = 0; i < questionCount; i++) {
                System.out.println("ID: " + question[i].getId() + " - " + question[i].getQuestionText());
            }
        }
    }

    // Resizes the question bank array when needed.
    private void resizeQuestionBank() {
        Question[] newQuestions = new Question[question.length * 2];
        for (int i = 0; i < question.length; i++) {
            newQuestions[i] = question[i];
        }
        question = newQuestions;
    }
}
