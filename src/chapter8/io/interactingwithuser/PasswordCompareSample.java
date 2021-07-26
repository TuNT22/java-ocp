package chapter8.io.interactingwithuser;

import java.io.Console;
import java.io.IOException;
import java.util.Arrays;

public class PasswordCompareSample {
    public static void main(String[] args) throws NumberFormatException,
            IOException {
        Console console = System.console();
        if(console == null) {
            throw new RuntimeException("Console not available");
        } else {
            //  readPassword() method is similar to the readLine() method
            //  except that the user does not see the text they are typing
            char[] password = console.readPassword("Enter your password: ");

            console.format("Enter your password again: ");
            console.flush();
            char[] verify = console.readPassword();
            boolean match = Arrays.equals(password,verify);

            // Immediately clear passwords from memory
            // use loop
            for(int i=0; i<password.length; i++) {
                password[i]='x';
            }
            // or Arrays.fill()
            Arrays.fill(verify,'x');

            console.format("Your password was " + (match ? "correct": "incorrect"));
        }
    }
}
