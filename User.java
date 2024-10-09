import java.util.Scanner;

public class User {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            while (true) {
                System.out.println("Who are you !");
                System.out.println("1.Creator\n2.Participant");
                System.out.println("Enter 1 for Creator and 2 for Participant");
                String choice = input.next();

                switch (choice) {
                    case "1":
                        Creator host = new Creator();
                        host.createQuiz(Scanner);
                        break;
                    case "2":
                        Participant participant = new Participant();
                        participant.attemptQuiz();
                        break;
                    default:
                        System.out.println("Invalid Choice");
                        break;
                }
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}



