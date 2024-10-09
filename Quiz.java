public class Quiz {
    private String title;
    public Question[] questions;
    private int currentQuestionCount = 0;

    public Quiz(String title) {
        this.title = title;
        this.questions = new Question[5];
    }

    public void addQuestion(Question newQuestion) {
        if (currentQuestionCount >= questions.length) {
            resizeQuestionsArray();
        }
        questions[currentQuestionCount] = newQuestion;
        currentQuestionCount++;
    }

    private void resizeQuestionsArray() {
        Question[] newQuestions = new Question[questions.length * 2];
        for (int i = 0; i < questions.length; i++) {
            newQuestions[i] = questions[i];
        }
        questions = newQuestions;
    }

    public void displayQuiz() {
        System.out.println("Quiz Title: " + title);
        for (int i = 0; i < currentQuestionCount; i++) {
            questions[i].displayQuestion(i + 1);
            System.out.println("------------------------");
        }
    }
}
