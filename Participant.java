	/***
	 * This class is create for attempting the quiz. In this the user get the questions and their options and after that they have to the user have to give the answer of that question or they can go to previous question or next question or they can submit the quiz in between the quiz if they want. In end they get the score of their quiz.
	 */
	
	package project;
	
	import java.util.Scanner;
	
	public class Participant {
		
		/*
		 * This method is used for attempting the quiz and show the question and options to the user.
		 */
		public void attemptQuiz(Creator host) {
			Scanner input = new Scanner(System.in);
			Quiz quiz = host.getQuiz();
			if (quiz == null || quiz.questions == null || quiz.questions.length == 0) {
	            System.out.println("There is no Quiz created yet.");
	            return; 
	        }
	        System.out.println("Welcome to the Quiz: " + quiz.title);
			int questionLength = quiz.questions.length;
			String[] userAnswer = new String[questionLength];
			System.out.println("For Answer - Select from 1-4 \nFor Skip - Click Enter \nFor Previous Question - Write j \nFor Next Question - Write l \nFor Submit - Write k");
			int i = 0;
			while(true) {
				if (i < 0) i = 0;         
				if (i >= questionLength) i = questionLength - 1; 
	            if (quiz.questions[i] != null) {
				System.out.println("Ques" + (i + 1) + ") " + quiz.questions[i].getQuestionText());
				for(int j = 0 ; j < 4 ; j++) {
					System.out.println((j+1) + ") " +  quiz.questions[i].options[j]);
					}
	            } else {
	                System.out.println("Question " + (i + 1) + " is not available.");
	                i++;
	                continue; 
	            }
				System.out.println("Previous Question\t\t Next Question\t\t Submit");
				System.out.println("Enter your Choice : ");
				String answer = input.nextLine();
				switch(answer) {
					case "1" : 
					case "2" : 
					case "3" : 
					case "4" : 
						userAnswer[i] = answer;
						i++;
						break;
					case "j" : 
						if(i > 0) {
							i--;
						}else { 
							System.out.println("Alredy at first Question.");
						}
						break;
					case "l" : 
						if(i < questionLength - 1) {
							i++;
						}else { 
							System.out.println("Alredy at last Question.");
						}
						break;
					case "k" : submit(userAnswer, quiz);
						return;
					case "" : i++;
						break;
					default : System.out.println("Invalid Input! Please select the correct one.");
						break;
				}
				if (i >= questionLength) {
					System.out.println("You've reached the end of the quiz. Do you want to submit? (Type 'k' to submit): ");
					String submit = input.nextLine();
					if(submit.equals("k")) {
						submit(userAnswer, quiz);
		        	}else {
		        		System.out.println("Invalid Input! The quiz has been completed but not submitted.");
		        	}
					return;
				}
			}	
		}
						
		/*
		 * This method is used for Submit the Quiz.
		 */
		public static void submit(String[] userAnswer, Quiz quiz) {
			int score = 0; 
			for(int i = 0 ; i < userAnswer.length ; i++) {
				if(userAnswer[i] != null && userAnswer[i].equals(quiz.questions[i].getAnswer())) {
					score++;
				}
			}
			System.out.println("Total Score : " + score);
	
		}
	}
