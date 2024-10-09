import java.util.Scanner;

// Main class to handle user choice
public class User {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            while (true) {
                System.out.println("Who are you !");
                System.out.println("1. Creator\n2. Participant");
                System.out.println("Enter 1 for Creator and 2 for Participant (or type 'exit' to quit):");

                String choice = scanner.next();

                if (choice.equalsIgnoreCase("exit")) {
                    System.out.println("Exiting the quiz system...");
                    break;
                }

                switch (choice) {
                    case "1":
                        Creator host = new Creator();
                        host.createQuiz(scanner);
                        break;
                    case "2":
                        Participant participant = new Participant();
                        participant.attemptQuiz();
                        break;
                    default:
                        System.out.println("Invalid Choice, please try again.");
                        break;
                }
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        } finally {
            scanner.close();
        }
    }
}
