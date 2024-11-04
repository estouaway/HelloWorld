import java.time.LocalDate;
import java.util.Scanner;

// This is the main class of the program
// As we chose to use the demo code, the main class was created for our application
// But we can choose whatever name we like
public class Main {
    // This is the entry point for the java application
    // Java virtual machine looks for this method to start the execution
    public static void main(String[] args) {

        // Create a Scanner object to read input
        // it's basically a wrapper or abstraction over the system.ini to simplify it
        Scanner scanner = new Scanner(System.in);

        // Ask for user name
        System.out.print("How are you called?");

        // This nextLine blocks the thread and waits indefinitely for input
        // until a newline is detected.
        String name = scanner.nextLine();

        // Hello World!
        System.out.println("Hello, " + name + "!");

        // Asks for birth year
        System.out.print("Please enter your birth year (e.g., 1990): ");

        // While the input isn't an integer, shows an error and waits for a new input
        while (!scanner.hasNextInt()) {
            System.out.println("That's not a valid number, try again");
            // Discard invalid input so that next time user write anything,
            // this invalid input won't show up in the stream
            scanner.next();
        }

        // We officially have an integer input, lets read it
        int birthYear = scanner.nextInt();

        // Uses the time util from java to get the current year
        int currentYear = LocalDate.now().getYear();

        // Calculates age
        int age = currentYear - birthYear;

        // Prints user age
        System.out.println("You are " + age + " years old.");

        // Create a string variable to allocate a string
        String generation = getGeneration(birthYear, currentYear);

        // Print the user generation
        System.out.println("You are a " + generation + ".");

        // Close the scanner
        // This is an important practice to manage resources, in this case this is kind of pointless
        // because this is a short-lived application and will end here and jvm will shut down
        // avoiding any resource leak.
        // But it's important for consistence
        // and is good practice to release resources when they are not needed anymore
        scanner.close();
    }

    private static String getGeneration(int birthYear, int currentYear) {
        String generation;

        // This is a control flow that allow the program to make decisions.
        // We will identify the user generation according to its birth year
        // and assign the correct string to the previous created var
        if (birthYear >= 1946 && birthYear <= 1964) {
            generation = "Baby Boomer";
        } else if (birthYear >= 1965 && birthYear <= 1980) {
            generation = "Gen X";
        } else if (birthYear >= 1981 && birthYear <= 1996) {
            generation = "Millennial";
        } else if (birthYear >= 1997 && birthYear <= 2012) {
            generation = "Gen Z";
        } else if (birthYear >= 2013 && birthYear <= currentYear) {
            generation = "Gen Alpha";
        } else if (birthYear < 1946) {
            generation = "Traditionalist";
        } else {
            generation = "Future Generation";
        }
        return generation;
    }
}