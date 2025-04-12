package practiceJava;

public class multiple {
    public static void main(String[] args) {
        exp e1 = new exp();
        e1.methodA();
        e1.methodB();
        e1.methodC();
    }
}
interface a{
    public void methodA();
}
interface b{
    public void methodB();
}
interface c extends a,b{         //used extends in interface to combine multiple and hyrerical inhgeritance to perform hybrid
    public void methodC();
}
class exp implements c{
    public void methodA(){
        System.out.println("method a called");
    }
    public void methodC(){
        System.out.println("Method c called");
    }
    public void methodB(){
        System.out.println("method b called");
    }
}
