package practice.java;

/*
 * The User class defines a blueprint for user objects with common properties (name and email) and an abstract method for performing role-specific actions in the quiz application.
 * Created By : Sachin-Gupta
 * Date of Creation : 08/10/2024
 */

import java.util.Scanner;
public abstract class User {
    private String name;
    private String email;

    // Constructor to initialize name and email
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Get the name
    public String getName() {
        return name;
    }
   
    // Set the name
    public void setName(String name) {
        this.name = name;
    }
    // Get the email
    public String getEmail() {
        return email;
    }
    // Set the email
    public void setEmail(String email) {
        this.email = email;
    }
    // performing role-specific actions
    public abstract void performAction(Scanner input);
}
