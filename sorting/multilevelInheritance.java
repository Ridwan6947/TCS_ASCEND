package sorting;

public class multilevelInheritance {
    public static void main(String[] args) {
        Bike b1 = new Bike();
        b1.vehiclePrint();
        b1.carPrint();
        b1.bikePrint();
    }
}
class Vehicle{
    void vehiclePrint(){
        System.out.println("Vehicle class called");
    }
}
class Car extends Vehicle{
    void carPrint(){
        System.out.println("Car class called");
    }
}
class Bike extends Car{
    void bikePrint(){
        System.out.println("Bike class called");
    }
}
