import java.util.*;

public class IPA12 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Medicine[] medicines = new Medicine[4];
        for(int i = 0 ; i < medicines.length ; i++){
            String a = sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt();
            sc.nextLine();
            medicines[i] = new Medicine(a,b,c,d);
        }
        String diseaseToFind = sc.nextLine();
        int[] ans = getPriceByDisease(medicines , diseaseToFind);
        if(ans != null){
            for(int i = 0 ; i < ans.length ; i++){
                System.out.println(ans[i]);
            }
        }
    }
    public static int[] getPriceByDisease(Medicine[] arr , String target){
        List<Integer> ans = new ArrayList<>();
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i].getDisease().equals(target)){
                ans.add(arr[i].getPrice());
            }
        }
        int [] ansArray = new int[ans.size()];
        for(int i = 0 ; i < ans.size() ; i++){
            ansArray[i] = ans.get(i);
        }
        
        return ansArray;
    }    
}

class Medicine{
    private String medicineName;
    private String batch;
    private String disease;
    private int price;

    public Medicine(String medicineName , String batch , String disease , int price){
        this.medicineName = medicineName;
        this.batch = batch;
        this.disease = disease;
        this.price = price;
    }

    public String getMedicineName(){
        return medicineName;
    }
    public String getBatch(){
        return batch;
    }
    public String getDisease(){
        return disease;
    }
    public int getPrice(){
        return price;
    }
    public void setMedicineName(String medicineName){
        this.medicineName = medicineName;
    }
    public void setBatch(String batch){
        this.batch = batch;
    }
    public void setDisease (String disease){
        this.disease = disease;
    }
    public void setPrice( int price){
        this.price = price;
    }
}
