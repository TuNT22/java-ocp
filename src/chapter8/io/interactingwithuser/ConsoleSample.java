package chapter8.io.interactingwithuser;

import java.io.Console;

public class ConsoleSample {
    public static void main(String[] args) {
        Console console = System.console();

        // System.console() return null in environments where text interactions are not supported
        if(console != null) {
            String userInput = console.readLine("Input: ");
            console.writer().println ("You entered the following: "+userInput);
        }
    }
}
