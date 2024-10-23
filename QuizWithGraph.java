package practice.java;

public class QuizWithGraph {
    private ParticipantScore[] scores;
    private int scoreCount;

    public QuizWithGraph() {
        scores = new ParticipantScore[10];  // Initial size for scores
        scoreCount = 0;
    }

    // Method to run the quiz and update the graph
    public void runQuizAndRenderGraph(String participantName, int participantScore) {
        System.out.println("Participant: " + participantName + " scored " + participantScore);

        // Store the score and resize the array if necessary
        addScoreToGraph(participantName, participantScore);

        // Render the vertical star ranking graph
        renderVerticalStarGraph();
    }

    // Add score to the graph
    private void addScoreToGraph(String name, int score) {
        if (scoreCount >= scores.length) {
            resizeArray();  // Manually resize array
        }
        scores[scoreCount++] = new ParticipantScore(name, score);
    }

    // Resize the array when it's full
    private void resizeArray() {
        ParticipantScore[] newScores = new ParticipantScore[scores.length * 2];
        for (int i = 0; i < scores.length; i++) {
            newScores[i] = scores[i];
        }
        scores = newScores;
    }

    // Render the graph with vertical stars representing the score
    private void renderVerticalStarGraph() {
        int maxScore = getMaxScore();  // Get the maximum score to determine graph height

        // Print the graph from top (max score) down to 1
        for (int i = maxScore; i > 0; i--) {
            for (int j = 0; j < scoreCount; j++) {
                if (scores[j].getScore() >= i) {
                    System.out.print(" * ");  // Print a star if the score is equal to or greater than the row
                } else {
                    System.out.print("   ");  // Empty space for scores lower than the current row
                }
            }
            System.out.println();  // New line after each row
        }

        // Print the participant names below the graph
        for (int i = 0; i < scoreCount; i++) {
            System.out.print(" " + padString(scores[i].getName(), 3) + " ");
        }
        System.out.println();
    }

    // Helper method to find the maximum score for graph height
    private int getMaxScore() {
        int maxScore = 0;
        for (int i = 0; i < scoreCount; i++) {
            if (scores[i].getScore() > maxScore) {
                maxScore = scores[i].getScore();
            }
        }
        return maxScore;
    }

    // Helper method to format participant names to a fixed width
    private String padString(String name, int length) {
        if (name.length() >= length) {
            return name.substring(0, length);  // Truncate if longer
        }

        // Pad with spaces if shorter
        StringBuilder paddedName = new StringBuilder(name);
        while (paddedName.length() < length) {
            paddedName.append(" ");
        }
        return paddedName.toString();
    }

    // ParticipantScore class to store participant's name and score
    private class ParticipantScore {
        private String name;
        private int score;

        public ParticipantScore(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public int getScore() {
            return score;
        }
    }
}
