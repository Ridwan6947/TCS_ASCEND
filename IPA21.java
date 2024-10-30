import java.util.*;
public class IPA21 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Fruit[] fruits = new Fruit[4];
        for(int i = 0 ; i < fruits.length ; i++){
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();
            sc.nextLine();
            int d = sc.nextInt();
            sc.nextLine();
            fruits[i] = new Fruit(a,b,c,d);
        }
        int ratingToFind = sc.nextInt();
        int maxPrice = getMaxPriceByRating(fruits , ratingToFind);
        System.out.println(maxPrice);
    }
    public static int getMaxPriceByRating(Fruit[] arr , int target){
        int max = 0;
        int maxId = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i].getFruitPrice() > max && arr[i].getFruitRating() > target){
                max = arr[i].getFruitPrice();
                maxId = arr[i].getFruitId();
            }
        }
        return maxId;
    }
}

class Fruit{
    private int fruitId;
    private String fruitName;
    private int fruitPrice;
    private int fruitRating;

    public Fruit(int fruitId , String fruitName , int fruitPrice , int fruitRating){
        this.fruitId = fruitId;
        this.fruitName = fruitName;
        this.fruitPrice = fruitPrice;
        this.fruitRating = fruitRating;
    }

    public int getFruitId(){
        return fruitId;
    }
    public String getFruitName(){
        return fruitName;
    }
    public int getFruitPrice(){
        return fruitPrice;
    }
    public int getFruitRating(){
        return fruitRating;
    }
    public void setFruitId(int fruitId){
        this.fruitId = fruitId;
    }
    public void setFruitName(String fruitName){
        this.fruitName = fruitName;
    }
    public void setFruitPrice(int fruitPrice){
        this.fruitPrice = fruitPrice;
    }
    public void setFruitRatin(int fruitRating){
        this.fruitRating = fruitRating;
    }

}
