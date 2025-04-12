package practiceJava;

public class multilevel {
    public static void main(String[] args) {
        Child2 c2 = new Child2();
        c2.parentDisplay();
        c2.child1Display();
        c2.child2Display();
    }
}
class Parent{
    public void parentDisplay(){
        System.out.println("Parent class called");
    }
}
class Child1 extends Parent{
    public void child1Display(){
        System.out.println("Child 1 class called");
    }
}
class Child2 extends Child1{
    public void child2Display(){
        System.out.println("child 2 display called");
    }
}
