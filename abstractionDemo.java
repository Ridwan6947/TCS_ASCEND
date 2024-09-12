public class abstractionDemo {
    public static void main(String[] args) {
        
        // Create an instance of Circle using Shape reference
        Shape obj = new Circle();
        obj.draw();  // Call the draw method of Circle
        
        // Reassign obj to a new Rectangle instance
        obj = new Rectangle();
        obj.draw();  // Call the draw method of Rectangle
    }
}

// Abstract class Shape which defines an abstract method 'draw'
abstract class Shape {
    // Abstract method which needs to be implemented by subclasses
    abstract void draw();
}

// Circle class which extends Shape and provides implementation of 'draw'
class Circle extends Shape {
    // Override the draw method to provide specific behavior for Circle
    void draw() {
        System.out.println("Drawing Circle");
    }
}

// Rectangle class which extends Shape and provides implementation of 'draw'
class Rectangle extends Shape {
    // Override the draw method to provide specific behavior for Rectangle
    void draw() {
        System.out.println("Drawing Rectangle");
    }
}
