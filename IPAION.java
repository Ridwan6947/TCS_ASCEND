import java.util.*;

public class IPAION {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Projector[] proj = new Projector[4];
        for(int i = 0 ; i < proj.length ; i++){
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();
            int d = sc.nextInt();
            sc.nextLine();
            String e = sc.nextLine();
            proj[i] = new Projector(a,b,c,d,e);
        }
        int ratingToFind = sc.nextInt();
        Projector ans = findMaximumPriceByRating(proj , ratingToFind);
        if(ans != null){
            System.out.println(ans.getId());
        }else{
            System.out.println("No such Projector");
        }
    }
    public static Projector findMaximumPriceByRating(Projector[] arr , int target){
        Projector ans = null;
        int maxPrice = Integer.MIN_VALUE;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i].getPrice() > maxPrice && arr[i].getRating() > target && arr[i].getAvailable().equalsIgnoreCase("TataCliq")){
                maxPrice = arr[i].getPrice();
                ans = arr[i];
            }
        }
        return ans;
    }
}

class Projector{
    private int id;
    private String name;
    private int price;
    private int rating;
    private String availableIn;

    public Projector(int id , String name , int price , int rating , String availableIn){
        this.id = id;
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.availableIn = availableIn;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public int getPrice(){
        return price;
    }
    public int getRating(){
        return rating;
    }
    public String getAvailable(){
        return availableIn;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setPrice(int price){
        this.price = price;
    }
    public void setRating(int rating){
        this.rating = rating;
    }
    public void setAvailable(String availableIn){
        this.availableIn = availableIn;
    }
}
