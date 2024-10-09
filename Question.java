package assignment_java_programming;
/***
 * This class represents a question in a quiz, including its text, answer options, and the correct answer. 
 * It also maintains a static question bank to store multiple questions.
 * 
 * Owner : Avadhi-Singhal
 * 
 * Date of Creation : 08/10/2024
 */

public class Question {
    private static int questionCount = 0; 
    private static Question[] questionBank = new Question[10]; 
    private final int id; 
    private String questionText;
    private String[] options = new String[4];
    private String answer;

    // Initializes a new instance of the Question class with the specified question text, answer options, and correct answer.  
    public Question(String questionText, String[] options, String answer) {
        this.id = ++questionCount;
        this.questionText = questionText;
        this.options = options;
        this.answer = answer;

        // Add the question to the bank if there is space
        if (questionCount <= questionBank.length) {
            questionBank[questionCount - 1] = this; 
        }
    }

    /** 
     * Returns the unique identifier for the question
     * @return the ID of the question
     */
    public int getQuestionId() {
        return id;
    }

    /** 
     * Returns the text of the question.
     * @return the question text
     */
    public String getQuestionText() {
        return questionText;
    }

    /** 
     * Returns the option at the specified index.
     */
    public String getOption(int index) {
        if (index >= 0 && index < options.length) {
            return options[index];
        }
        return null; // Or throw an exception
    }

    /** 
     * Returns the correct answer for the question.
     */
    public String getAnswer() {
        return answer;
    }

    /** 
     * Displays all questions in the question bank.
     */
    public static void displayQuestions() {
        if (questionCount == 0) {
            System.out.println(Constants.NO_QUESTIONS);
            return;
        }
        for (int i = 0; i < questionCount; i++) {
            Question q = questionBank[i];
            System.out.println(q.id + ": " + q.getQuestionText());
            for (int j = 0; j < 4; j++) {
                System.out.println("  " + (j + 1) + ") " + q.getOption(j));
            }
        }
    }

    /** 
     * Returns the total number of questions in the question bank.
     */
    public static int getTotalQuestions() {
        return questionCount; // Returns the total number of questions added
    }

    /** 
     * Retrieves a question from the question bank by its ID.
     * @return the question if found, or null if not found
     */
    public static Question getQuestionById(int id) {
        for (int i = 0; i < questionCount; i++) {
            if (questionBank[i].getQuestionId() == id) {
                return questionBank[i];
            }
        }
        return null; // If not found
    }

    /** 
     * Adds a new question to the question bank.
     */
    public static void addQuestionBank(String questionText, String[] options, String answer) {
        new Question(questionText, options, answer); // Automatically adds to the question bank
    }
}