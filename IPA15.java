// import java.util.*;

// public class IPA15 {
//     public static void main(String[] args){
//         Scanner sc = new Scanner(System.in);
//         Phone[] phones = new Phone[4];
//         for(int i = 0 ; i < phones.length ; i++){
//             int a = sc.nextInt();
//             sc.nextLine();
//             String b = sc.nextLine();
//             String c = sc.nextLine();
//             int d = sc.nextInt();
//             sc.nextLine();
//             phones[i] = new Phone(a,b,c,d);
//         }
//         String brandToFind = sc.nextLine();
//         String osToFind = sc.nextLine().toLowerCase();
//         int totalCost = findPriceForGivenBrand(phones , brandToFind);
//         if(totalCost > 0){
//             System.out.println(totalCost);
//         }else{
//             System.out.println("No phone found");
//         }
//         Phone ans = getPhoneIdBasedOnOs(phones , osToFind);
//         if(ans != null){
//             System.out.println(ans.getPhoneId());
//         }else{
//             System.out.println("No phone found");
//         }
//     }
//     public static int findPriceForGivenBrand(Phone[] arr , String target){
//         int totalCost = 0;
//         for(int i = 0 ; i < arr.length ; i++){
//             if(arr[i].getPhoneBrand().equals(target)){
//                 totalCost += arr[i].getPhonePrice();
//             }
//         }
//         return totalCost;
//     }
//     public static Phone getPhoneIdBasedOnOs(Phone[] arr , String target){
//         Phone ans = null;
//         for(int i = 0 ; i < arr.length ; i++){
//             if(arr[i].getPhoneOs().equals(target) && arr[i].getPhonePrice() >= 50000){
//                 ans = arr[i];
//                 return ans;
//             }
//         }
//         return ans;
//     }
// }

// class Phone{
//     private int phoneId;
//     private String phoneOs;
//     private String phoneBrand;
//     private int phonePrice;

//     public Phone(int phoneId , String phoneOs , String phoneBrand , int phonePrice){
//         this.phoneId = phoneId;
//         this.phoneOs = phoneOs;
//         this.phoneBrand = phoneBrand;
//         this.phonePrice = phonePrice;
//     }

//     public int getPhoneId(){
//         return phoneId;
//     }
//     public String getPhoneOs(){
//         return phoneOs;
//     }
//     public String getPhoneBrand(){
//         return phoneBrand;
//     }
//     public int getPhonePrice(){
//         return phonePrice;
//     }
//     public void setPhoneId(int phoneId){
//         this.phoneId = phoneId;
//     }
//     public void setPhoneOs(String phoneOs){
//         this.phoneOs = phoneOs;
//     }
//     public void setPhoneBrand(String phoneBrand){
//         this.phoneBrand = phoneBrand;
//     }
//     public void setPhonePrice(int phonePrice){
//         this.phonePrice = phonePrice;
//     }
// }

/*
111
iOS
Apple
30000
222
android
Samsung
50000
333
Symbian
HTC
12000
444
Paranoid
HTC
89000
HTC
aNdRoid
*/

import java.util.*;

public class IPA15{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Phone[] phones = new Phone[4];
        for(int i = 0 ; i < phones.length ; i++){
            int a  = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt();
            sc.nextLine();
            phones[i] = new Phone(a,b,c,d);
        }
        String findBrand = sc.nextLine();
        int amt = findPriceForGivenBrand(phones , findBrand);
        String phoneOs = sc.nextLine();
        Phone ans = getPhoneIdBasedOnOs(phones, phoneOs);
        if(amt > 0){
            System.out.println(amt);
        }else{
            System.out.println("No phone found");
        }
        if(ans != null){
            System.out.println(ans.getId());
        }else{
            System.out.println("No phone found");
        }
    }
    public static int findPriceForGivenBrand(Phone[] phones , String findBrand){
        int total = 0;
        for(int i = 0 ; i < phones.length ; i++){
            if(phones[i].getBrand().equals(findBrand)){
                total += phones[i].getPrice();
            }
        }
        return total;
    }
    public static Phone getPhoneIdBasedOnOs(Phone[] arr , String phoneOs){
        Phone id = null;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i].getOs().equalsIgnoreCase(phoneOs) && arr[i].getPrice() >= 50000){
                id = arr[i];
                return id;
            }
        }
        return id;
    }
}

class Phone{
    private int id;
    private String os;
    private String brand;
    private int price;

    public Phone(int id , String os , String brand , int price){
        this.id = id;
        this.os = os;
        this.brand = brand;
        this.price = price;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setOs(String os){
        this.os = os;
    }
    public void setBrand(String brand){
        this.brand = brand;
    }
    public void setPrice(int price){
        this.price = price;
    }

    public int getId(){
        return id;
    }
    public String getOs(){
        return os;
    }
    public String getBrand(){
        return brand;
    }
    public int getPrice(){
        return price;
    }
}
