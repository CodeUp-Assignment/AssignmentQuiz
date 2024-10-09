/**
 * The Quiz class represents a quiz with a title and a collection of questions.
 * It provides methods for adding questions and displaying quiz information.
 * 
 * Creator : Avadhi-Singhal
 * 
 * Date of Creation : 08/10/2024
 */
public class Quiz {
    private String title;
    private Question[] questions = new Question[5]; 
    private int currentQuestionCount = 0;

    //Constructs a Quiz object with the specified title..
    public Quiz(String title) {
        this.title = title;
    }

    //Adds a question to the quiz. 
    //If the current number of questions exceeds the array length, the array is resized.
    public void addQuestion(Question question) {
        if (currentQuestionCount >= questions.length) {
            resizeQuestionsArray();
        }
        questions[currentQuestionCount++] = question;
        System.out.println("Question added to quiz: " + question.getQuestionText());
    }

    //Resizes the questions array to accommodate more questions by doubling its size.
    //This method does not return any value.
    private void resizeQuestionsArray() {
        Question[] newQuestions = new Question[questions.length * 2];
        System.arraycopy(questions, 0, newQuestions, 0, questions.length);
        questions = newQuestions;
    }

    //Displays the title of the quiz and the questions it contains.
    //This method does not return any value.
    public void displayQuiz() {
        System.out.println("Quiz Title: " + title);
        for (int i = 0; i < currentQuestionCount; i++) {
            System.out.println("ID: " + questions[i].getQuestionText());
        }
    }
}
