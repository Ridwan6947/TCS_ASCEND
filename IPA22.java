import java.util.*;

public class IPA22 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ass[] ass = new ass[5];
        for(int i = 0 ; i < ass.length ; i++){
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt();
            sc.nextLine();
            ass[i] = new ass(a,b,c,d);
        }
        String techToFind = sc.nextLine();
        ass[] ans = assForTech(ass , techToFind);
        if(ans != null){
            for(int i = 0 ; i < ans.length ; i++){
                System.out.println(ans[i].getId());
            }
        }
    }
    public static ass[] assForTech(ass[] arr , String target){
        List<ass> ans = new ArrayList<>();
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i].getTechnology().equalsIgnoreCase(target) && arr[i].getExpInYear() % 5 == 0){
                ans.add(arr[i]);
            }
        }
        ass[] result = new ass[ans.size()];
        return ans.toArray(result);
    }
}

class ass{
    private int id;
    private String name;
    private String technology;
    private int expInYear;

    public ass(int id , String name , String technology , int expInYear){
        this.id = id;
        this.name = name;
        this.technology = technology;
        this.expInYear = expInYear;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getTechnology(){
        return technology;
    }
    public int getExpInYear(){
        return expInYear;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setTechnology(String technology){
        this.technology = technology;
    }
    public void setExpInYear(int expInYear){
        this.expInYear = expInYear;
    }
}
