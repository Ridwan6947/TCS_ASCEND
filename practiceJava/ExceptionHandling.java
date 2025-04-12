public class ExceptionHandling {
    public static void main(String[] args) {
        Thread t = new Thread(new ExceptionExample()); // Creating a thread
        t.start(); // Start the thread
    }
}

class ExceptionExample implements Runnable {
    @Override
    public void run() {
        try {
            int a = 10;
            int b = 0;
            int res = a / b; // This will throw ArithmeticException
            System.out.println("Result: " + res);
        } catch (ArithmeticException e) {
            System.out.println("Exception caught: Division by zero is not allowed.");
        }
    }
}
