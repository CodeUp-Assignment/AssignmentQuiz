
//public class Quiz {
//	public String title = "";
//	public int maxQuestion = 0;
//	
//	public Quiz() {
//	
//	}
//	
//	public Quiz(String title, int maxQuestion) {
//		this.title = title;
//		this.maxQuestion = maxQuestion;
//	}
//}


public class Quiz {
    private String title;
    private int maxQuestions;
    private Question[] questions;  
    private int currentQuestionCount = 0;  
    
    // Constructor to initialize quiz title and maximum questions
    public Quiz(String title, int maxQuestions) {
        this.title = title;
        this.maxQuestions = maxQuestions;
        questions = new Question[maxQuestions];  
    }

    // Method to add a question to the quiz
    public boolean addQuestion(Question newQuestion) {
        // Check if the quiz is already full
        if (currentQuestionCount >= maxQuestions) {
            System.out.println("Cannot add more questions. Maximum limit reached.");
            return false;
        }
        for (int i = 0; i < currentQuestionCount; i++) {
            if (questions[i].getQuestionText().equalsIgnoreCase(newQuestion.getQuestionText())) {
                System.out.println("Duplicate question found. Cannot add the same question twice.");
                return false;
            }
        }
        questions[currentQuestionCount] = newQuestion;
        currentQuestionCount++;
        return true;
    }

    // Method to display all questions
    public void displayQuiz() {
        System.out.println("Quiz Title: " + title);
        for (int i = 0; i < currentQuestionCount; i++) {
            questions[i].displayQuestion(i + 1);  
            System.out.println("------------------------");
        }
    }
}

