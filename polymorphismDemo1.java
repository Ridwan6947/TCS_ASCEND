//method overloading - (compile time polymorphism)

public class polymorphismDemo1 {

    // Method to add two integers
    public static int add(int a, int b){
        return a + b; // Returns the sum of two integers
    }

    // Overloaded method to add three integers
    public static int add(int a, int b, int c){
        return a + b + c; // Returns the sum of three integers
    }

    public static void main(String[] args) {
        // Calling the add method with two arguments
        // This will call the first add method (with two parameters)
        System.out.println(add(10, 20)); // Output: 30

        // Calling the add method with three arguments
        // This will call the overloaded add method (with three parameters)
        System.out.println(add(10, 20, 30)); // Output: 60
    }
}
