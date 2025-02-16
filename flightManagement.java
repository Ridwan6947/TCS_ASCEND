import java.util.*;

public class flightManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Flight[] arr = new Flight[n];
        for(int i = 0 ; i < arr.length ; i++){
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            double d = sc.nextDouble();
            sc.nextLine();
            double e = sc.nextDouble();
            sc.nextLine();
            arr[i] = new Flight(a,b,c,d,e);
        }
        int fNumber = sc.nextInt();
        sc.nextLine();
        double totalPrice = findTotalPrice(arr , fNumber);
        Flight res = secondLowest(arr);
        if(res != null){
            System.out.println(res.getNumber());
            System.out.println(res.getOrigin());
            System.out.println(res.getDestination());
            System.out.println(res.getPricePerMile());
        }else{
            System.out.println("No flight");
        }
        System.out.println(totalPrice);
    }
    public static double findTotalPrice(Flight[] arr , int target){
        double ans = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i].getNumber() == target){
                ans += arr[i].getDistance() * arr[i].getPricePerMile();
            }
        }
        return ans;
    }
    public static Flight secondLowest(Flight[] arr){
        double lowest = Double.MAX_VALUE;
        double secondLowest = Double.MAX_VALUE;
        Flight secondLowestFlight = null;

        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] != null) {
                double price = arr[i].getPricePerMile();
                if(price < lowest) {
                    secondLowest = lowest;
                    lowest = price;
                } else if(price < secondLowest && price != lowest) {
                    secondLowest = price;
                    secondLowestFlight = arr[i];
                }
            }
        }
        return secondLowestFlight;
    }
}
class Flight{
    int number;
    String origin;
    String desitnation;
    double distance;
    double pricePerMile;

    public Flight(int number , String origin , String destination , double distance , double pricePerMile){
        this.number = number;
        this.origin = origin;
        this.desitnation = destination;
        this.distance = distance;
        this.pricePerMile = pricePerMile;
    }
    public int getNumber(){
        return number;
    }
    public String getOrigin(){
        return origin;
    }
    public String getDestination(){
        return desitnation;
    }
    public double getDistance(){
        return distance;
    }
    public double getPricePerMile(){
        return pricePerMile;
    }
}