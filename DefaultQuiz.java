package assignment_java_programming;

/**
 * The DefaultQuiz class represents a default quiz with pre-defined questions.
 * It is used when no quizzes have been created by the user.
 * 
 * Creator : Uddeshya-Patidar
 * 
 * Date of Creation : 08/10/2024
 */

public class DefaultQuiz extends Quiz {

    /** 
     * Constructor for the DefaultQuiz class, initializing the quiz with a predefined title and loading the default questions.
     */
    public DefaultQuiz() {
        super("Default Java Quiz"); 
        defaultQuestions(); 
    }

    /** 
     * Initializes the default questions, options, and answers for the quiz.
     * It creates Question objects and adds them to the quiz.
     */
    private void defaultQuestions() {
        String[] questions = Constants.DEFAULT_QUESTIONS ;
        String[][] options = Constants.DEFAULT_OPTIONS ;

        String[] answers = Constants.DEFAULT_ANSWERS;

        // Loop through each question and create a Question object
        for (int i = 0; i < questions.length; i++) {
            Question question = new Question(questions[i], options[i], answers[i]); 
            addQuestion(question);  
        }
    }
}