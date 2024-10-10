package assignment_java_programming;

/**
 * The Quiz class represents a quiz with a title and a collection of questions.
 * It provides methods for adding questions and displaying quiz information.
 * 
 * Creator : Avadhi-Singhal
 * 
 * Date of Creation : 08/10/2024
 */

public class Quiz {
    private String title; 
    private Question[] questions = new Question[5]; 
    private int currentQuestionCount = 0; 
    /** 
     * Constructs a Quiz object with a specified title.
     */
    public Quiz(String title) {
        this.title = title;
    }

    /** 
     * Adds a question to the quiz.
     * If the current question count exceeds the capacity of the questions array, it resizes the array.
     */
    public void addQuestion(Question question) {
        if (currentQuestionCount >= questions.length) {
            resizeQuestionsArray(); 
        }
        questions[currentQuestionCount++] = question;
        System.out.println("Question added to quiz: " + question.getQuestionText());
    }

    /** 
     * Resizes the questions array to add more questions by doubling its size.
     */
    private void resizeQuestionsArray() {
        Question[] newQuestions = new Question[questions.length * 2];
        for (int i = 0; i < questions.length; i++) {
            newQuestions[i] = questions[i]; 
        }
        questions = newQuestions; 
    }

    /** 
     * @return the number of questions in the quiz
     */
    public int getQuestionCount() {
        return currentQuestionCount; 
    }

    /** 
     * @return the title of the quiz
     */
    public String getTitle() {
        return title; 
    }

    /** 
     * Retrieves a question by its index.
     * @return the Question object at the specified index, or null if the index is invalid
     */
    public Question getQuestion(int index) {
        if (index >= 0 && index < currentQuestionCount) {
            return questions[index]; 
        }
        return null; 
    }

    /** 
     * Displays the title of the quiz and all its questions.
     */
    public void displayQuiz() {
        System.out.println("Quiz Title: " + title);
        for (int i = 0; i < currentQuestionCount; i++) {
            System.out.println("ID: " + questions[i].getQuestionText()); 
        }
    }
}
