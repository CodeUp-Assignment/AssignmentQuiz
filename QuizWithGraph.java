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

        // Render the block graph
        renderBlockGraph();
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

    // Render the block graph with stars outlining the blocks
    private void renderBlockGraph() {
        int maxScore = getMaxScore();  // Get the maximum score to determine graph height

        // For each row (from max score down to 1), print blocks
        for (int i = maxScore; i > 0; i--) {
            for (int j = 0; j < scoreCount; j++) {
                if (scores[j].getScore() >= i) {
                    printBlock(i, scores[j].getScore());
                } else {
                    System.out.print("     ");  // Empty space for participants with lower scores
                }
            }
            System.out.println();  // New line after each row
        }

        // Print the X-axis with participant names
        for (int i = 0; i < scoreCount; i++) {
            System.out.print(" " + manualPadString(scores[i].getName(), 5) + " ");
        }
        System.out.println();
    }

    // Print a block for a given score (stars as outline)
    private void printBlock(int currentRow, int score) {
        if (currentRow == score || currentRow == 1) {
            System.out.print(" *** ");  // Top or bottom row of the block
        } else {
            System.out.print(" * * ");  // Middle part of the block (stars on the sides)
        }
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

    // Manually pad a string to the specified length
    private String manualPadString(String name, int length) {
        char[] paddedName = new char[length];
        int nameLength = name.length();

        // Copy the original name into the char array
        for (int i = 0; i < length; i++) {
            if (i < nameLength) {
                paddedName[i] = name.charAt(i);  // Copy character from name
            } else {
                paddedName[i] = ' ';  // Fill remaining spaces with space
            }
        }

        // Convert char array to string without using inbuilt functions
        String result = "";
        for (int i = 0; i < paddedName.length; i++) {
            result += paddedName[i];  // Concatenate each character
        }

        return result;
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
