import java.util.*;

public class hotelManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hotel[] hotels = new Hotel[4];
        for(int i = 0 ; i < hotels.length ; i++){
            int id = sc.nextInt();sc.nextLine();
            String name = sc.nextLine();
            String cab = sc.nextLine();
            int rating = sc.nextInt();sc.nextLine();
            int fees = sc.nextInt();sc.nextLine();
            hotels[i] = new Hotel(id , name , cab , rating , fees);
        }
        String cabF = sc.nextLine();
        int ans = hotelByHighestRating(hotels , cabF);
        if(ans == 0){
            System.out.println("No hotel found");
        }else{
            System.out.println(ans);
        }  
    }
    public static int hotelByHighestRating(Hotel[] hotels , String cabF){
        int maxRating = hotels[0].getHotelRating();
        for(int i = 0 ; i < hotels.length ; i++){
            if(hotels[i].getHotelRating() > 5 && hotels[i].getCabFacility().equalsIgnoreCase(cabF)){
                maxRating = hotels[i].getHotelRating();
            }
        }
        return maxRating;
    }

}

class Hotel{
    private int hotelId;
    private String hotelName;
    private String cabFacility;
    private int hotelRating;
    private int hotelFees;

    public Hotel(int hotelId , String hotelName , String cabFacility , int hotelRating , int hotelFees){
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.cabFacility = cabFacility;
        this.hotelRating = hotelRating;
        this.hotelFees = hotelFees;
    }

    public void setHotelId(int hotelId){
        this.hotelId = hotelId;
    }
    public void setHotelName(String hotelName){
        this.hotelName = hotelName;
    }
    public void setCabFacility(String cabFacility){
        this.cabFacility = cabFacility;
    }
    public void setHotelRating(int hotelRating){
        this.hotelRating = hotelRating;
    }
    public void setHotelFees(int hotelFees){
        this.hotelFees = hotelFees;
    }
    public int getHotelId(){
        return hotelId;
    }
    public String getHotelName(){
        return hotelName;
    }
    public String getCabFacility(){
        return cabFacility;
    }
    public int getHotelRating(){
        return hotelRating;
    }
    public int getHotelFees(){
        return hotelFees;
    }
}
