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
        initializeDefaultQuestions(); 
    }

    /** 
     * Initializes the default questions, options, and answers for the quiz.
     * It creates Question objects and adds them to the quiz.
     */
    private void initializeDefaultQuestions() {
        String[] questions = {
            "What is the keyword used to create a class in Java?",
            "Which data type is used to create a variable that should store text?",
            "What is the correct way to create an object in Java?",
            "Which method can be used to find the length of a string in Java?",
            "What is the output of 10 + 20 + \"30\" in Java?"
        };

        String[][] options = {
            {"class", "Class", "CLASS", "All of the above"},
            {"String", "String[]", "char", "int"},
            {"new ClassName()", "ClassName new()", "new Class()", "Class new()"},
            {"length()", "size()", "getLength()", "length"},
            {"102030", "30", "10", "Error"}
        };

        String[] answers = {
            "All of the above",
            "String",
            "new ClassName()",
            "length()",
            "102030"
        };

        // Loop through each question and create a Question object
        for (int i = 0; i < questions.length; i++) {
            Question question = new Question(questions[i], options[i], answers[i]); 
            addQuestion(question);  
        }
    }
}
