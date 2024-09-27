import java.util.*;

public class footwearManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Footwear[] footwears = new Footwear[4];
        for(int i = 0 ; i < footwears.length ; i++){
            int iid = sc.nextInt();sc.nextLine();
            String nname = sc.nextLine();
            String ttype = sc.nextLine();
            int pprice = sc.nextInt();sc.nextLine();
            footwears[i] = new Footwear(iid, nname, ttype, pprice);
        }

        String ttype = sc.nextLine();
        int ans = countFootwearByType(footwears , ttype);
        if(ans == 0){
            System.out.println("No footwear found");
        }else{
            System.out.println(ans);
        }
    }

    public static int countFootwearByType(Footwear[] footwears , String ttype){
        int count = 0;
        for(int i = 0 ; i < footwears.length ; i++){
            if(footwears[i].getType().equals(ttype)){
                count++;
            }
        }
        return count;
    }
}

class Footwear{
    private int id;
    private String name;
    private String type;
    private int price;

    public Footwear(int id , String name , String type , int price){
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getType(){
        return type;
    }

    public int getPrice(){
        return price;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setType(String type){
        this.type = type;
    }

    public void setPrice(int price){
        this.price = price;
    }
}