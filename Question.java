/***
 * This class represents a question in a quiz, including its text, answer options, and the correct answer. 
 * It also maintains a static question bank to store multiple questions.
 * 
 * Owner : Avadhi-Singhal
 * 
 * Date of Creation : 08/10/2024
 */
public class Question {
    private static int questionCount = 0; 
    private static Question[] questionBank = new Question[10]; 
    private final int id; 
    private String questionText;
    private String[] options = new String[4];
    private String answer;

    //Initializes a new instance of the Question class with the specified question text, answer options, and correct answer.    
    public Question(String questionText, String[] options, String answer) {
        this.id = ++questionCount; 
        this.questionText = questionText;
        this.options = options;
        this.answer = answer;
    }

    //Takes a question text, an array of answer options, and the correct answer as arguments. 
    //It creates a new Question object and adds it to the question bank. If the bank is full, it expands its size.
    public static void addQuestionBank(String questionText, String[] options, String answer) {
        if (questionCount >= questionBank.length) {
            resizeQuestionBank();
        }
        questionBank[questionCount] = new Question(questionText, options, answer);
        System.out.println("Question added with ID: " + questionCount);
    }

    //Accepts an ID as an argument and returns the Question object that matches the given ID. 
   //If no match is found, it returns null.
    public static Question getQuestionById(int id) {
        for (int i = 0; i < questionCount; i++) {
            if (questionBank[i].id == id) {
                return questionBank[i];
            }
        }
        return null; 
    }

    //Displays all questions in the question bank. If there are no questions, it informs the user.
    public static void displayQuestions() {
        if (questionCount == 0) {
            System.out.println("No questions available in the question bank.");
        } else {
            for (int i = 0; i < questionCount; i++) {
                System.out.println("ID: " + questionBank[i].id + " - " + questionBank[i].questionText);
            }
        }
    }

    //A private method that expands the size of the questionBank array when it is full.
    private static void resizeQuestionBank() {
        Question[] newBank = new Question[questionBank.length * 2]; 
        System.arraycopy(questionBank, 0, newBank, 0, questionBank.length);
        questionBank = newBank;
    }

    //Getter for returning the text of the question
    public String getQuestionText() {
        return questionText;
    }

    //Getters for returning the correct answer for the question
    public String getAnswer() {
        return answer;
    }

    //Getter for returning the total number of questions currently in the question bank
    public static int getTotalQuestions() {
        return questionCount;
    }
}
