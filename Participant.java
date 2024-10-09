//package QuizProject;
//
//import java.util.Scanner;
//
//public class Participant extends User {
// Constructor to initialize Participant with name and email
//public Participant(String name, String email) {
//    super(name, email);
//}
//    @Override
//    public void performAction(Scanner scanner) {
//        Creator creator = new Creator();
//        attempt(scanner, creator);
//    }
//
//    /*
//     * This method is used for attempting the quiz and show the question and options to the user.
//     */
//    public void attempt(Scanner scanner, Creator host) {
//        Scanner input = new Scanner(System.in);
//        try {
//            int questionLength = host.quiz.questions.length;
//            String[] userAnswer = new String[questionLength];
//            System.out.println("Welcome to Quiz : \nFor Answer - Select from 1-4 \nFor Skip - Click Enter \nFor Previous Question - Write j \nFor Next Question - Write l \nFor Submit - Write k");
//            for (int i = 0; i < questionLength; i++) {
//                System.out.println(host.quiz.questions[i].getQuestionText());
//                for (int j = 0; j < 4; j++) {
//                    System.out.println(host.quiz.questions[i].getOption(j));
//                    System.out.println("Previous Question\t\t Next Question\t\t Submit");
//                    System.out.println("Enter your Choice : ");
//                    String answer = input.nextLine();
//                    switch (answer) {
//                        case "1":
//                            userAnswer[i] = answer;
//                            break;
//                        case "2":
//                            userAnswer[i] = answer;
//                            break;
//                        case "3":
//                            userAnswer[i] = answer;
//                            break;
//                        case "4":
//                            userAnswer[i] = answer;
//                            break;
//                        case "j":
//                            int previousQuestionIndex = i - 1;
//                            previousQuestion(previousQuestionIndex, answer, userAnswer, host);
//                            break;
//                        case "l":
//                            int nextQuestionIndex = i + 1;
//                            nextQuestion(nextQuestionIndex, answer, userAnswer, host);
//                            break;
//                        case "k":
//                            submit(userAnswer);
//                            break;
//                        default:
//                            System.out.println("Invalid Input! Please select the correct one.");
//                            break;
//                    }
//                }
//            }
//
//        } catch (NullPointerException e) {
//            System.out.println("Their is no Quiz created yet.");
//        }
//
//    }
//
//    /*
//     * This method is used for next Question in Quiz.
//     */
//    public static void nextQuestion(int nextQuestionIndex, String answer, String[] userAnswer, Creator host) {
//        System.out.println(host.quiz.questions[nextQuestionIndex].getQuestionText());
//        for (int i = 0; i < 1; i++) {
//            System.out.println(host.quiz.questions[nextQuestionIndex].getOption(i));
//            userAnswer[nextQuestionIndex] = answer;
//        }
//    }
//
//    /*
//     * This method is used for previous Question in Quiz.
//     */
//    public static void previousQuestion(int previousQuestionIndex, String answer, String[] userAnswer, Creator host) {
//        System.out.println(host.quiz.questions[previousQuestionIndex].getQuestionText());
//        for (int i = 0; i < 1; i++) {
//            System.out.println(host.quiz.questions[previousQuestionIndex].getOption(i));
//            userAnswer[previousQuestionIndex] = answer;
//        }
//    }
//
//    /*
//     * This method is used for Submit the Quiz.
//     */
//    public static void submit(String[] userAnswer) {
//        Quiz quiz = new Quiz();
//        for (int i = 0; i < userAnswer.length; i++) {
//            int score = 0;
//            if (userAnswer[i] == quiz.questions[i].getAnswer()) {
//                score++;
//            }
//            System.out.println("Total Score : " + score);
//        }
//    }
//}
//
