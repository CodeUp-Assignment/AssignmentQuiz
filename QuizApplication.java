/*
 * This is the class from where the program runs.
 * Created By : Sachin Gupta
 * Date of Creation : 08/10/2024
 */
package QuizProject;

import java.util.Scanner;

public class QuizApplication {
    private static boolean isValidEmail(String email) {
        return email.contains("@") && email.contains(".");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                System.out.println("Enter your name: ");
                String name = scanner.nextLine();

                System.out.println("Enter your email: ");
                String email = scanner.nextLine();

                if (!isValidEmail(email)) {
                    System.out.println("Invalid email format. Please try again.");
                    continue;
                }

                System.out.println("Wait A Minute! Who are you...?");
                System.out.println("1. Creator\n2. Participant");
                System.out.println("Enter 1 for Creator and 2 for Participant (or type 'exit' to quit):");

                String choice = scanner.nextLine();

                if (choice.equalsIgnoreCase("exit")) {
                    System.out.println("Exiting the quiz system...");
                    break;
                }

                User user;
                switch (choice) {
                    case "1":
                        user = new Creator(name, email);
                        user.performAction(scanner);
                        break;
                    case "2":
//                        user = new Participant(name, email);
//                        user.performAction(scanner);
                        break;
                    default:
                        System.out.println("Invalid Choice, please try again.");
                        break;
                }
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
