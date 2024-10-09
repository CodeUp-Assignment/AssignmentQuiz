public class Question {
    private String questionText;
    private String[] options = new String[4];
    private String answer;

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public void setOption(int index, String option) {
        if (index >= 0 && index < 4) {
            this.options[index] = option;
        }
    }

    public boolean setAnswer(String answer) {
        for (String option : options) {
            if (answer.equalsIgnoreCase(option)) {
                this.answer = answer;
                return true;
            }
        }
        return false;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getOption(int index) {
        if (index >= 0 && index < 4) {
            return options[index];
        }
        return null;
    }

    public String getAnswer() {
        return answer;
    }

    public void displayQuestion(int questionNumber) {
        System.out.println("Q" + questionNumber + ": " + questionText);
        for (int i = 0; i < 4; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
        System.out.println("Answer: " + answer);
    }
}
