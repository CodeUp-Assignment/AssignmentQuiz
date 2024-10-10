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

	   private Question[] questions; 
	    private int questionCount;
    /** 
     * Constructor for the DefaultQuiz class, initializing the quiz with a predefined title and loading the default questions.
     */
    public DefaultQuiz() {
        super("Default Java Quiz"); 
        questions = new Question[Constants.DEFAULT_QUESTIONS.length]; 
        questionCount = 0; 
        defaultQuestions();     }

    /** 
     * Initializes the default questions, options, and answers for the quiz.
     * It creates Question objects and adds them to the quiz.
     */
    private void defaultQuestions() {
        String[] questionsData = Constants.DEFAULT_QUESTIONS;
        String[][] optionsData = Constants.DEFAULT_OPTIONS;
        String[] answersData = Constants.DEFAULT_ANSWERS;
        for (int i = 0; i < questionsData.length; i++) {
            Question question = new Question(questionsData[i], optionsData[i], answersData[i]); 
            addQuestion(question);  
        }
    }
    
    /**
     * This method is use to add questions to the array
     */
    public void addQuestion(Question question) {
        if (questionCount < questions.length) { 
            questions[questionCount] = question; 
            questionCount++; 
        } else {
            System.out.println("Cannot add more questions, quiz is full.");
        }
    }
    
    
    public Question getQuestion(int index) {
        if (index >= 0 && index < questionCount) {
            return questions[index]; 
        }
        return null;
    }
    
    public int getQuestionCount() {
        return questionCount; 
    }
    
    public String getTitle() {
        return super.getTitle(); 
    }

}
