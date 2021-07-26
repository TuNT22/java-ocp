package chapter8.io.interactingwithuser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SystemInSample {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.print("Input: ");
        String userInput = reader.readLine();
        System.out.println("You entered the following: "+userInput);
    }
}
