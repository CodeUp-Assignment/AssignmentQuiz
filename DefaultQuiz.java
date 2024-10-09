package practice.java;

/**
 * The DefaultQuiz class represents a default quiz with pre-defined questions.
 * It is used when no quizzes have been created by the user.
 * 
 * Creator : Uddeshya-Patidar
 * 
 * Date of Creation : 08/10/2024
 */
public class DefaultQuiz extends Quiz {
    
    // Constructor that initializes the default quiz with a title
    public DefaultQuiz() {
        super("Default Java Quiz");
        initializeDefaultQuestions();
    }

    // Method to initialize the default quiz questions and options
    private void initializeDefaultQuestions() {
        // Example questions and options for the default quiz
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

        // Add the questions to the quiz
        for (int i = 0; i < questions.length; i++) {
            Question question = new Question();
            question.setQuestionText(questions[i]);

            // Set options
            for (int j = 0; j < options[i].length; j++) {
                question.setOption(j, options[i][j]);
            }

            // Set the correct answer
            question.setAnswer(answers[i]);
            addQuestion(question); // Method inherited from Quiz class
        }
    }
}
