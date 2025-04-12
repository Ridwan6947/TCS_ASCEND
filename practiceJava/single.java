package practiceJava;

public class single {
    public static void main(String[] args) {
        Child c1 = new Child();
        c1.display();
        c1.childDisplay();
    }
}
class Parent{
    void display(){
        System.out.println("parent class called");
    }
}
class Child extends Parent{
    void childDisplay(){
        System.out.println("Child class called");
    }
}
