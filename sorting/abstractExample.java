package sorting;

public class abstractExample {
    public static void main(String[] args) {
        Shape s1 = new circle();
        s1.display();
       // s1.display1();
        s1.draw();
    }
}
abstract class Shape{
    abstract void draw(); 


    void display(){
        System.out.println("this is shape class");
    }
}

class circle extends Shape{
    @Override
    public void draw(){
        System.out.println("Circle is drawn");
    }

}