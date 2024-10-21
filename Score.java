package assignment_java_programming;

import java.util.List;

public class Score {
    private int totalScore;
    private int correctCount;
    private int incorrectCount;
    
    
    public Score() {
        this.totalScore = 0;
        this.correctCount = 0;
        this.incorrectCount = 0;
    }

   
    public void calculateScore(List<String> correctAnswers, List<String> userAnswers) {
        
        if (correctAnswers.size() != userAnswers.size()) {
            System.out.println("Error: Mismatch in number of questions and answers.");
            return;
        }

        
        for (int i = 0; i < correctAnswers.size(); i++) {
            if (correctAnswers.get(i).equalsIgnoreCase(userAnswers.get(i))) {
                
                totalScore += 1;
                correctCount++;
            } else {
                
                totalScore -= 2;
                incorrectCount++;
            }
        }
    }

   
    public void displayResults() {
        System.out.println("Quiz Results:");
        System.out.println("Total Score: " + totalScore);
        System.out.println("Correct Answers: " + correctCount);
        System.out.println("Incorrect Answers: " + incorrectCount);
    }
}
