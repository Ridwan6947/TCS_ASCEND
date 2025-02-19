package sorting;

public class singleInheritance {
    public static void main(String[] args) {
        Car c1 = new Car();
        c1.print();
        c1.carPrint();
    }
}

class Vehicle{
    void print(){
        System.out.println("Vehicle class called");
    }
}
class Car extends Vehicle{
    void carPrint(){
        System.out.println("Car class called");
    }
}
