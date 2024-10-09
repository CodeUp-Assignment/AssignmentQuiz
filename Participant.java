/***
 * This class is create for attempting the quiz. In this the user get the questions and their options and after that they have to the user have to give the answer of that question or they can go to previous question or next question or they can submit the quiz in between the quiz if they want. In end they get the score of their quiz.
 */

package project;

import java.util.Scanner;

public class Participant {
	
	/*
	 * This method is used for attempting the quiz and show the question and options to the user.
	 */
	public void attemptQuiz(Scanner input) {
		Quiz quiz = new Quiz();
		int questionLength = quiz.questions.length;
		String[] userAnswer = new String[questionLength];
		if(quiz == null || questionLength == 0) {
			System.out.println("Their is no Quiz created yet.");
		}else {
		System.out.println("Welcome to Quiz : \nFor Answer - Select from 1-4 \nFor Skip - Click Enter \nFor Previous Question - Write j \nFor Next Question - Write l \nFor Submit - Write k");
		for(int i = 0 ; i < questionLength ; i++) {
			System.out.println(quiz.questions[i].getQuestionText());
			for(int j = 0 ; j < 4 ; j++) {
				System.out.println(quiz.questions[i].getOption(j));
				System.out.println("Previous Question/t/t Next Question/t/t Submit");
				System.out.println("Enter your Choice : ");
				String answer = input.nextLine();
				switch(answer) {
					case "1" : userAnswer[i] = answer;
						break;
					case "2" : userAnswer[i] = answer;
						break;
					case "3" : userAnswer[i] = answer;
						break;
					case "4" : userAnswer[i] = answer;
						break;
					case "j" : 
						int previousQuestionIndex = i - 1;
						previousQuestion(previousQuestionIndex, answer, userAnswer);
						break;
					case "l" : 
						int nextQuestionIndex = i + 1;
						nextQuestion(nextQuestionIndex, answer, userAnswer);
						break;
					case "k" : submit(userAnswer);
						break;
					default : System.out.println("Invalid Input! Please select the correct one.");
						break;
				}
			}
		}
		}
	}

	/*
	 * This method is used for next Question in Quiz.
	 */
	public static void nextQuestion(int nextQuestionIndex, String answer, String[] userAnswer) {
		Quiz quiz = new Quiz();
		System.out.println(quiz.questions[nextQuestionIndex].getQuestionText());
		for(int i = 0 ; i < 1 ; i++) {
			System.out.println(quiz.questions[nextQuestionIndex].getOption(i));
			userAnswer[nextQuestionIndex] = answer;
		}
	}

	/*
	 * This method is used for previous Question in Quiz.
	 */
	public static void previousQuestion(int previousQuestionIndex, String answer, String[] userAnswer) {
		Quiz quiz = new Quiz();
		System.out.println(quiz.questions[previousQuestionIndex].getQuestionText());
		for(int i = 0 ; i < 1 ; i++) {
			System.out.println(quiz.questions[previousQuestionIndex].getOption(i));
			userAnswer[previousQuestionIndex] = answer;
		}
	}
	
	/*
	 * This method is used for Submit the Quiz.
	 */
	public static void submit(String[] userAnswer) {
		Quiz quiz = new Quiz();
		for(int i = 0 ; i < userAnswer.length ; i++) {
			int score = 0; 
			if(userAnswer[i] == quiz.questions[i].getAnswer()) {
				score++;
			}
			System.out.println("Total Score : " + score);
		}
	}
}
