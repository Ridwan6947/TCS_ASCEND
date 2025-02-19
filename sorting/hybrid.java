package sorting;

public class hybrid {
    public static void main(String[] args) {
        exp1 e1 = new exp1();
        e1.methodA();
        e1.methodB();
    }
}
interface a{
    void methodA();
}
interface b extends a{
    void methodB();
}
class exp1 implements b{
    @Override
    public void methodA() {
        System.out.println("Meth a");
        
    }
    @Override
    public void methodB(){
        System.out.println("emasdaB");
    }
}
