package assignment_java_programming;

/***
 * This class is created for attempting the quiz. The user gets the questions and their options,
 * and then they must answer the question or navigate through the quiz.
 * 
 * Created by - Kiran Choudhary
 * 
 * Date - 08 october 2024
 */
import java.util.Scanner;

public class Participant extends User {
	
	public Participant(String name, String email) {
		super(name, email);
	 }
		
	/**
	 * This method is used to show the participant name who perform the quiz.
	 */
	public void performAction(Scanner input) {
		System.out.println(Constants.PARTICIPANT + getName() + Constants.PERFORMING_QUIZ);
		System.out.println(Constants.START_QUIZ);
	}


	/**
	 * This method is used to show the available Quizes name and ask the user which quiz they want to play.
	 */
	public void participateInQuiz(Scanner input, DefaultQuiz defaultQuiz) {
		while (true) {
			System.out.println(Constants.AVAILABLE_QUIZ);
			System.out.println("1. " + defaultQuiz.getTitle());
			Creators creator = new Creators(Constants.PLACEHOLDER, Constants.EMAIL_ID);
			Quiz createdQuiz = creator.getQuiz();
			if (createdQuiz != null) {
				System.out.println("2. " + createdQuiz.getTitle());
	        }
			
			System.out.println(Constants.START_QUIT_QUIZ);
			String choice = input.nextLine();
			Quiz selectedQuiz = null;
			if (choice.equals("1")) {
				selectedQuiz = defaultQuiz;
	        } else if (choice.equals("2") && createdQuiz != null) {
	        	selectedQuiz = createdQuiz;
	        } else if (choice.equalsIgnoreCase(Constants.EXIT_QUIZ)) {
	        	return;
	        } else {
	        	System.out.println(Error.INVALID);
	        	continue;
	        }
			if (selectedQuiz != null) {
				playFullQuiz(input, selectedQuiz);
	        }
		}
	}


	/**
     * Method to display all quiz questions one by one and allow the participant to answer them.
     */
	private void playFullQuiz(Scanner input, Quiz quiz) {
		System.out.println(Constants.WELCOME + quiz.getTitle());
		int questionCount = quiz.getQuestionCount();
		String[] userAnswers = new String[questionCount]; 
		int currentQuestionIndex = 0; 
		System.out.println(Constants.PARTICIPANT_CHOICE);
		while (true) {
			if (currentQuestionIndex < 0) {
				currentQuestionIndex = 0; 
				System.out.println(Constants.FIRST_QUESTION);
			}
			if (currentQuestionIndex >= questionCount) {
				currentQuestionIndex = questionCount - 1; 
				System.out.println(Constants.LAST_QUESTION);
			}
			Question currentQuestion = quiz.getQuestion(currentQuestionIndex);
			if (currentQuestion != null) {
				System.out.println(Constants.QUESTION_NO+ (currentQuestionIndex + 1) + ": " + currentQuestion.getQuestionText());
				for (int i = 0; i < 4; i++) {
					System.out.println((i + 1) + ") " + currentQuestion.getOption(i));
	            }
				System.out.println(Constants.NEXT_PREVIOUS_QUESTION);;
	        } else {
	        	System.out.println(Constants.QUESTION_NO + (currentQuestionIndex + 1) + Constants.NOT_AVAILABLE);
	        	currentQuestionIndex++; 
	        	continue;
	        }
			System.out.println(Constants.USERS_CHOICE);
			String answer = input.nextLine();
			switch (answer) {
				case "1":
				case "2":
				case "3":
				case "4":
					userAnswers[currentQuestionIndex] = answer; 
					currentQuestionIndex++; 
	                break;
				case "j": 
					currentQuestionIndex--;
					break;
				case "l":
					currentQuestionIndex++;
					break;
				case "k":
					calculateScore(userAnswers, quiz);
					return;
				case "": 
					currentQuestionIndex++;
					break;
				default:
					System.out.println(Error.INVALID);
					break;
			}	
		}
	}

	/**
	 * Method to calculate and display the participant's score at the end of the quiz.
	 */
	private void calculateScore(String[] userAnswers, Quiz quiz) {
		int score = 0;
		for (int i = 0; i < userAnswers.length; i++) {
			Question question = quiz.getQuestion(i);
			if (question != null && userAnswers[i] != null) {
				String correctAnswer = question.getAnswer();
				String userAnswer = question.getOption(Integer.parseInt(userAnswers[i]) - 1);
				if (correctAnswer.equals(userAnswer)) {
					score++;
				}
			}
		}
		System.out.println(Constants.FINISH);
		System.out.println(Constants.SCORE + score + Constants.OUT_OF + userAnswers.length);
	}
}
