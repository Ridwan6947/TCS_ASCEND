//method overriding - run time polymorphism

public class polymorphismDemo2 {
    public static void main(String[] args) {
        // Creating an instance of 'cricketer' but storing it in a reference of type 'athelete'
        // This demonstrates polymorphism, where the actual object type is cricketer, but the reference type is athelete.
        athelete obj = new cricketer();
        
        // Creating an instance of 'athelete'
        athelete obj2 = new athelete();
        
        // Calling run() method on 'obj'. Since 'obj' is a cricketer, it will call the overridden run() method in cricketer class.
        obj.run();
        
        // Calling run() method on 'obj2'. This will call the run() method in the athelete class since 'obj2' is of type athelete.
        obj2.run();
    }
}

// Base class 'athelete' which has a method run() that prints a message when called.
class athelete{
    public void run(){
        // Default behavior for athelete's run method
        System.out.println("Athlete is running");
    }
}

// Derived class 'cricketer' which extends athelete. It overrides the run() method to provide specific behavior for cricketers.
class cricketer extends athelete{
    public void run(){
        // Overridden behavior for cricketer's run method
        System.out.println("Cricketer is running");
    }
}
