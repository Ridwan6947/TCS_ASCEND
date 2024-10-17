import java.util.*;

public class removeCar {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Car car[] = new Car[5];
        for(int i = 0 ; i < car.length ; i++){
            int id = sc.nextInt(); sc.nextLine();
            String name = sc.nextLine();
            String fuel = sc.nextLine();
            car[i] = new Car(id , name , fuel);
        }
        int targetId = sc.nextInt();
        Car[] ans = removeAndRearrange(car , targetId);
        for(int i = 0 ; i < ans.length ; i++){
            System.out.println(ans[i].getCarId() + " : " + ans[i].getCarName());
        } 
    }
    public static Car[] removeAndRearrange(Car [] car , int id){
        List<Car> carList = new ArrayList<>();
        
        // Copy cars to a list, excluding the car with the target ID
        for (Car c : car) {
            if (c.getCarId() != id) {
                carList.add(c);
            }
        }
        
        // Convert list back to array
        return carList.toArray(new Car[0]);
    }
}
class Car{
    private int carId;
    private String carName;
    private String fuelType;

    public Car(int carId , String carName , String fuelType){
        this.carId = carId;
        this.carName = carName;
        this.fuelType = fuelType;
    }
    public int getCarId(){
        return carId;
    }
    public String getCarName(){
        return carName;
    }
    public String getFuelType(){
        return fuelType;
    }
    public void setCarId(int carId){
        this.carId = carId;
    }
    public void setCarName(String carName){
        this.carName = carName;
    }
    public void setFuelType(String fuelType){
        this.fuelType = fuelType;
    }
}