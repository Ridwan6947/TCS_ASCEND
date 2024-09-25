import java.util.*;

public class xploreIPA2 {
    public static void main(String[] args) {

        HeadSets [] headsets = new HeadSets[4];
        Scanner sc = new Scanner(System.in);
        for(int i = 0 ; i < headsets.length ; i++){
            String h = sc.nextLine();
            String b = sc.nextLine();
            int p = sc.nextInt();
            boolean a = sc.nextBoolean();
            sc.nextLine();
            headsets[i] = new HeadSets(h, b, p, a);
        }
        String brandToFind = sc.nextLine();
        int total = findTotalPriceForGivenBrand(headsets , brandToFind);
        if(total > 0){
            System.out.println("Total price for " + brandToFind + " is " + total);
        }else{
            System.out.println(brandToFind + " is not available");
        }
        HeadSets res1 = findAvailableHeadsetWithSecondMinPrice(headsets);
        if(res1 != null){
            System.out.println(res1.getHeadsetName());
            System.out.println(res1.getPrice());
        }else{
            System.out.println("No headset available");
        }
    }

    public static int findTotalPriceForGivenBrand(HeadSets [] headsets , String brandToFind){
        int total = 0;
        for(int i = 0 ; i < headsets.length ; i++){
            if(headsets[i].getBrand().equals(brandToFind)){
                total += headsets[i].getPrice();
            }
        }
        return total;
    }

    public static HeadSets findAvailableHeadsetWithSecondMinPrice(HeadSets [] headsets){
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        HeadSets res = null;
        for(int i = 0 ; i < headsets.length ; i++){
            if(headsets[i].getAvailable() && headsets[i].getPrice() < min1){
                min2 = min1;
                min1 = headsets[i].getPrice();
                res = headsets[i];
            }else if(headsets[i].getAvailable() && headsets[i].getPrice() < min2){
                min2 = headsets[i].getPrice();
                res = headsets[i];
            }
        }
        if(res != null && min2 != Integer.MAX_VALUE){
            res.setPrice(min2);
        }
        return res;
    }
}

class HeadSets{
    private String headsetName;
    private String brand;
    private int price;
    private boolean available;

    public HeadSets(String headsetName, String brand, int price, boolean available){
        this.headsetName = headsetName;
        this.brand = brand;
        this.price = price;
        this.available = available;
    }

    public String getHeadsetName(){
        return headsetName;
    }

    public String getBrand(){
        return brand;
    }

    public int getPrice(){
        return price;
    }

    public boolean getAvailable(){
        return available;
    }

    public void setHeadsetName(String headsetName){
        this.headsetName = headsetName;
    }
    public void setBrand(String brand){
        this.brand = brand;
    }
    public void setPrice(int price){
        this.price = price;
    }
    public void setAvailable(boolean available){
        this.available = available;
    }
}
