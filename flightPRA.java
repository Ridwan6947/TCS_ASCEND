import java.util.*;

class Flight{
    private int flightNumber;
    private String origin;
    private String destination;
    private double distance;
    private double pricePerMile;
    
    public Flight(int flightNumber , String origin , String destination , double distance , double pricePerMile){
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.distance = distance;
        this.pricePerMile = pricePerMile;
    }
    public void setFlightNumber(int flightNumber){
        this.flightNumber = flightNumber;
    }
    public void setOrigin(String origin){
        this.origin = origin;
    }
    public void setDestination(String destination){
        this.destination = destination;
    }
    public void setDistance(double distance){
        this.distance = distance;
    }
    public void setPricePerMile(double pricePerMile){
        this.pricePerMile = pricePerMile;
    }
    public int getFlighNumber(){
        return flightNumber;
    }
    public String getOrigin(){
        return origin;
    }
    public String getDestination(){
        return destination;
    }
    public double getDistance(){
        return distance;
    }
    public double getPricePerMile(){
        return pricePerMile;
    }

}

public class flightPRA{

    public static double findTotalPrice(Flight[] arr, int target) {
        double totalPrice = 0;
        
        for(int i = 0; i < arr.length; i++) {
            if(arr[i].getFlighNumber() == target) {
                // Calculate price for each matching flight: distance * pricePerMile
                totalPrice += arr[i].getDistance() * arr[i].getPricePerMile();
            }
        }
        return totalPrice;
    }

    public static Flight findFlightWithSecondLowest(Flight[] arr){
        Flight lowest = null;
        Flight secondLowest = null;
        for(int i = 0 ; i < arr.length ; i++){
            if(lowest == null || arr[i].getPricePerMile() < lowest.getPricePerMile()){
                secondLowest = lowest;
                lowest = arr[i];
            }
            else if(secondLowest == null || arr[i].getPricePerMile() < secondLowest.getPricePerMile()){
                secondLowest = arr[i];
            }
        }
        return secondLowest;

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Flight flights[] = new Flight[n];
        for(int i = 0 ; i < flights.length ; i++){
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            double d = sc.nextDouble();
            sc.nextLine();
            double e = sc.nextDouble();
            sc.nextLine();
            flights[i] = new Flight(a,b,c,d,e);
        }
        int fNumber = sc.nextInt();
        double totalPrice = findTotalPrice(flights , fNumber);
        System.out.println("Total Price - " + totalPrice);
        Flight res1 = findFlightWithSecondLowest(flights);
        if(res1 != null){
            System.out.println("flightNumber - " + res1.getFlighNumber());
            System.out.println("origin - " + res1.getOrigin());
            System.out.println("destination - " + res1.getDestination());
            System.out.println("distance - " + res1.getDistance());
            System.out.println("pricePerMile - " + res1.getPricePerMile());
        }

    }
}