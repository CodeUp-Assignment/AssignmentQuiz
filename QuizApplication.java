package assignment_java_programming;

/*
 * This is the class from where the program runs.
 * Created By : Sachin-Gupta
 * Date of Creation : 08/10/2024
 */

import java.util.Scanner;

public class QuizApplication {

    // Validates the email format by checking for "@" and "."
    private static boolean isValidEmail(String email) {
        return email.contains("@") && email.contains(".");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            while (true) {
                System.out.println(Constants.NAME);
                String name = input.nextLine();

                System.out.println(Constants.E_MAIL);
                String email = input.nextLine();

                if (!isValidEmail(email)) {
                    System.out.println(Error.INVALID);
                    continue;
                }               
                System.out.println(Constants.USER_CHOICE);              
                String choice = input.nextLine();

                if (choice.equalsIgnoreCase("exit")) {
                    System.out.println(Constants.EXIT);
                    break;
                }

                User user;
                switch (choice) {
                    case "1":
                        // Create a new Creator instance and perform actions related to quiz creation
                        user = new Creators(name, email);
                        user.performAction(input);
                        break;
                    case "2":
                        // Placeholder for Participant actions 
                        break;
                    default:
                        System.out.println("Invalid Choice, please try again.");
                        break;
                }
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        } finally {
            input.close();
        }
    }
}