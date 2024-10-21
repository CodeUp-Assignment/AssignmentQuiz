package assignment_java_programming;
/***
 * The Question class represents an individual question in a quiz, including its text, answer options,
 * and correct answer. Each Question object has a unique ID that can be used to reference it in a question 
 * bank or quiz.
 * 
 * Owner : Avadhi-Singhal
 * 
 * Date of Creation: 21/10/2024
 */

public class Question {
    private final int id;
    private String questionText;
    private String[] options;
    private String answer;

    // Constructor for initializing the question
    public Question(int id, String questionText, String[] options, String answer) {
        this.id = id;
        this.questionText = questionText;
        this.options = new String[options.length];
        for (int i = 0; i < options.length; i++) {
            this.options[i] = options[i];
        }
        this.answer = answer;
    }

    // Getter for ID
    public int getId() {
        return id;
    }

    // Getter for question text
    public String getQuestionText() {
        return questionText;
    }

    // Getter for answer
    public String getAnswer() {
        return answer;
    }

    // Getter for options
    public String[] getOptions() {
        return options;
    }
}
