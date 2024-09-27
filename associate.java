import java.util.*;

public class associate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Associates[] associates = new Associates[n];
        for(int i = 0 ; i < associates.length ; i++){
            int id = sc.nextInt();sc.nextLine();
            String name = sc.nextLine();
            double scores = sc.nextDouble();
            int exprience = sc.nextInt();sc.nextLine();
            associates[i] = new Associates(id , name , scores , exprience);
        }
        double newScore = sc.nextDouble();
        Associates res1 = searchAssociateWithMatchingScore(associates , newScore);
        if(res1 != null){
            System.out.println(res1.getId());
            System.out.println(res1.getName());
        }
        Associates res2 = searchMaxExp(associates);
        System.out.println(res2.getId());
    }

    public static Associates searchAssociateWithMatchingScore(Associates[] associates , double newScore){
        for(int i = 0 ; i < associates.length ; i++){
            if(associates[i].getScores()==newScore){
                return associates[i];
            }
        }
        return null;
    } 

    public static Associates searchMaxExp(Associates[] associates){
        Associates max = associates[0];
        for(int i = 1 ; i < associates.length ; i++){
            if(associates[i].getExprience() > max.getExprience()){
                max = associates[i];
            }
        }
        return max;
    }
}

class Associates{
    private int id;
    private String name;
    private double scores;
    private int exprience;

    public Associates(int id , String name , double scores , int exprience){
        this.id = id;
        this.name = name;
        this.scores = scores;
        this.exprience = exprience;
    }

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public double getScores(){
        return scores;
    }
    public int getExprience(){
        return exprience;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setScores(double scores){
        this.scores = scores;
    }
    public void setExprience(int exprience){
        this.exprience = exprience;
    }

}
