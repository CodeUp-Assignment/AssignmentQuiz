package practice.java;
/**
 * This class contains a set of constant string that are used throughout the program to display messages. 
 * Owner-->Pratul Agarwal
 * Date of creation-->09/09/2024
 */

public final class Constants {
	public static final String NAME = "Enter your name: ";
	public static final String E_MAIL = "Enter your email: ";
			
	 public static final String USER_CHOICE ="Do you want to create a quiz or attempt a quiz\n" +
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
         
    public static final String TITLE =  "Enter the title of the quiz (cannot be empty and must be less than 100 characters): ";
       
    public static final String PARTICIPANT_CHOICE = "For Answer - Select from 1-4 \n" +
    		"For Skip - Write -  \n" +
    		"For Previous Question - Write p \n" +
    		"For Next Question - Write n \n" +
    		"For Ending a Quiz and submitting your answer - Write s";
     
    public static final String START_QUIT_QUIZ = "Type 1 to play the default quiz. Type 'exit' to leave.";
   
    public static final String USERS_CHOICE = "Enter your Choice : ";

   
    public String EXIT_MESSAGE = "Exiting...";
	  public static final String INVALID_CHOICE =  "Invalid choice. Please try again.";
  public String EMPTY_QUESTION_BANK_MSG = "No questions available to add to the quiz. Returning to main menu.";
  public String ADD_QUESTION_BY_ID = "Enter the question ID to add to the quiz (or type 'done' to finish): ";
  public String DONE = "done";
  public String ADD_QUESTION = "Adding question: ";
  public String INVALID_QUESTION_ID = "Invalid question ID.";
  public String PROMPT_VALID_INTEGER = "Please enter a valid number or 'done' to finish.";
  public String MULTIPLE_QUESTION_MESSAGE = "You can add multiple questions. Type 'done' when you are finished.";
  public String ENTER_OPTION = "Enter option ";
  public String CONSTRAINT_MSG = " (type 'done' to finish adding options, cannot be empty and must be less than 100 characters):";
  public int DEFAULT_OPTIONS_SIZE = 15;
  public int DEFAULT_QUESTION_NUMBERS = 10;
  public int MAXIMUM_CHARACTERS = 100;
  public String EMPTY_OPTION_MSG = "Option cannot be empty and must be less than 100 characters. Please try again.";
  public String DUPLICATE_OPTION_MSG = "Duplicate option detected. Please enter a different option.";
  public String QUIZ_TITLE = "Quiz Title: ";
  public String ID = "ID: ";
  public String HYPHEN = " - ";
  public String QUESTION_ADDED_MSG = "Question added with ID: ";
  public String NO_QUESTION_AVAILABLE = "No questions available in the question bank.";
  public String CHOOSE_OPTION = "Choose an option: \n1. Create quiz \n2. Add questions \n3. Exit";
  public String ENTER_CHOICE = "Enter your choice (1-3): ";
  public String INVALID_NUMBER = "Please enter a number between 1 and 3.";
  public String PROMPT_VALID_CHOICE = "Invalid input. Please enter a number between 1 and 3.";
  public String PROMPT_TITLE = "Enter the title of the quiz (cannot be empty and must be less than 100 characters): ";
  public String PROMPT_QUESTION_TEXT = "Enter the question text (cannot be empty and must be less than 100 characters):";
  public static final String SELECT_QUIZ = "Select a quiz to play :";
  public static final String EXIT = "EXIT";
    
  } 
