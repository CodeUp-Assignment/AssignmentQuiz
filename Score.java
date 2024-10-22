package practice.java;



/**
 * The Score class manages the scoring system for a quiz.
 * It calculates and displays the user's total score based on correct and incorrect answers.
 */
public class Score {
    private int totalScore; 
    private int correctCount; 
    private int incorrectCount; 
    
    /**
     * Constructor for the Score class.
     * Initializes the total score, correct count, and incorrect count to zero.
     */
    public Score() {
        this.totalScore = 0; 
        this.correctCount = 0; 
        this.incorrectCount = 0; 
    }

    /**
     * Calculates the score based on correct answers and user answers.
     * 
     * @return void
     */
    public void calculateScore(String[] correctAnswers, String[] userAnswers) {
        
    	if (correctAnswers.length != userAnswers.length) {
            System.out.println("Error: Mismatch in number of questions and answers.");
            return; // Exit if there is a mismatch
        }

        // Calculate the score based on correct and incorrect answers
    	for (int i = 0; i < correctAnswers.length; i++) {
            if (correctAnswers[i].equalsIgnoreCase(userAnswers[i])) {
                totalScore += 1; 
                correctCount++; 
            } else {
                totalScore -= 2; // Decrement score for incorrect answer
                incorrectCount++; // Increment incorrect answer count
            }
        }
    }

    /**
     * Displays the results of the quiz.
     * Prints the total score, number of correct answers, and number of incorrect answers.
     * 
     * @return void
     */
    public void displayResults() {
        System.out.println("Quiz Results:");
        System.out.println("Total Score: " + totalScore); // Print total score
        System.out.println("Correct Answers: " + correctCount); // Print count of correct answers
        System.out.println("Incorrect Answers: " + incorrectCount); // Print count of incorrect answers
    }
}
