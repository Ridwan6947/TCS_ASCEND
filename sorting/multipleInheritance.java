package sorting;

public class multipleInheritance {
    public static void main(String[] args) {
        exp e1 = new exp();
        e1.methodA();
        e1.methodB();
    }
}
interface a{
    void methodA();
}
interface b{
    void methodB();
}
class exp implements a , b{
    @Override
    public void methodA() {
        System.out.println("meth a");
    }

    @Override
    public void methodB() {
        System.out.println("meth b");
    }
}
