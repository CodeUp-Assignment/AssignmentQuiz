
//public class Question {
//	public String question = "";
//	public String option1 = "";
//	public String option2 = "";
//	public String option3 = "";
//	public String option4 = "";
//	public String answer = "";
//
//}


public class Question {
    private String question;
    private String[] options = new String[4];  
    private String answer;

    // Setters to allow iterative question building
    public void setQuestionText(String questionText) {
        this.question = questionText;
    }

    public void setOption(int index, String option) {
        if (index >= 0 && index < 4) {
            this.options[index] = option;
        }
    }

    // Validates and sets the answer only if it matches one of the options
    public boolean setAnswer(String answer) {
        for (String option : options) {
            if (answer.equalsIgnoreCase(option)) {
                this.answer = answer;
                return true;
            }
        }
        return false;  
    }

    // Getters for accessing question details
    public String getQuestionText() {
        return question;
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

    // Method to display a single question
    public void displayQuestion(int questionNumber) {
        System.out.println("Q" + questionNumber + ": " + question);
        for (int i = 0; i < 4; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
        System.out.println("Answer: " + answer);
    }
}
