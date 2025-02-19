package sorting;

public class hirericalInheritance {
    public static void main(String[] args) {
        mercedes m1 = new mercedes();
        m1.cPrint();
        m1.merc();
        bmw b1 = new bmw();
        b1.cPrint();
        b1.bm();
    }
}
class Car{
    void cPrint(){
        System.out.println("Car");
    }
}
class mercedes extends Car{
    void merc(){
        System.out.println("mercedes");
    }
}
class bmw extends Car{
    void bm(){
        System.out.println("bmw");
    }
}