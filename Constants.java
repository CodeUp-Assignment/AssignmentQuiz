/**
 * This class contains a set of constant string that are used throughout the program to display messages. 
 * Owner-->Pratul Agarwal
 * Date of creation-->09/09/2024
 */
package assignment_java_programming;
public final class Constants {
	public static final String NAME = "Enter your name: ";
	public static final String E_MAIL = "Enter your email: ";
			
	 public static final String USER_CHOICE ="Wait A Minute! Who are you...?\n" +
			 "1. Creator\n2. Participant\n"  +
			 "Enter 1 for Creator\n"  +
			 "Enter 2 for Participant\n" +
			 "Type exit to not use this application\n";
			     
	public static final String CHOICE = "Do you want to create a quiz, add questions, or exit?\n" +
		    "Type create quiz to create a new Quiz\n" +
		    "Type add questions to add new questions\n" +
		    "Type exit to not create a quiz\n";
		     
    public static final String QUESTION = "Enter the question text (cannot be empty and must be less than 100 characters):";
    
    public static final String ADD_QUESTIONS = "You can add multiple questions. Type 'done' when you are finished.";
    
    public static final String ANSWER = "Enter the correct answer (must be one of the options and cannot be empty):";
      
    public static final String QUESTION_ID = "Enter the question ID to add to the quiz (or type 'done' to finish): ";
    
    public static final String NO_QUESTIONS = "No questions available to add to the quiz. Returning to main menu.";
        
    public static final String QUIZ_TITLE =  "Enter the title of the quiz (cannot be empty and must be less than 100 characters): ";
    
    public static final String NO_QUIZ = "There is no Quiz created yet.";
    
    public static final String PARTICIPANT_CHOICE = "For Answer - Select from 1-4 \n" +
    		"For Skip - Click Enter \n" +
    		"For Previous Question - Write j \n " +
    		"For Next Question - Write l \n " +
    		"For Ending a Quiz and submitting your answer - Write k";
     
    public static final String[] DEFAULT_QUESTIONS =  {
            "What is the keyword used to create a class in Java?",
            "Which data type is used to create a variable that should store text?",
            "What is the correct way to create an object in Java?",
            "Which method can be used to find the length of a string in Java?",
            "What is the output of 10 + 20 + \"30\" in Java?"
        };
    
    public static final String[][] DEFAULT_OPTIONS = {
            {"class", "Class", "CLASS", "All of the above"},
            {"String", "String[]", "char", "int"},
            {"new ClassName()", "ClassName new()", "new Class()", "Class new()"},
            {"length()", "size()", "getLength()", "length"},
            {"102030", "30", "10", "Error"}
        };
    
    public static final String[] DEFAULT_ANSWERS = {
            "All of the above",
            "String",
            "new ClassName()",
            "length()",
            "102030"
        };  
  
    public static final String EXIT = "Exiting program...";
}