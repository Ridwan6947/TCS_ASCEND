import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class exceptionHandlingDemo {
    public static void main(String[] args) {
        // Demonstrating unchecked exception (ArithmeticException)
        try {
            int a = 10, b = 0;
            System.out.println("Dividing " + a + " by " + b);
            System.out.println(a / b); // This will throw an ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Caught Unchecked Exception: Can't divide by zero.");
        }

        // Demonstrating checked exception (FileNotFoundException)
        try {
            File file = new File("non_existing_file.txt");
            FileReader fr = new FileReader(file); // This will throw FileNotFoundException
        } catch (FileNotFoundException e) {
            System.out.println("Caught Checked Exception: File not found.");
        }

        // Demonstrating unchecked exception (NullPointerException)
        try {
            String str = null;
            System.out.println(str.length()); // This will throw a NullPointerException
        } catch (NullPointerException e) {
            System.out.println("Caught Unchecked Exception: Null pointer accessed.");
        }

        // Demonstrating checked exception (InterruptedException)
        try {
            System.out.println("Pausing execution for 2 seconds...");
            Thread.sleep(2000); // This can throw InterruptedException
            System.out.println("Resuming execution.");
        } catch (InterruptedException e) {
            System.out.println("Caught Checked Exception: Thread was interrupted.");
        }

        System.out.println("End of exception handling demo.");
    }
}
