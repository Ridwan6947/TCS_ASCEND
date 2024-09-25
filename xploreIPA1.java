import java.util.*;
public class xploreIPA1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int ans = countLowerCase(str);
        if(ans == 0){
            System.out.println("Empty String");
        }else{
            System.out.println("Number of lowercase characters: " + ans);
        }
    }

    public static int countLowerCase(String str) {
        int count = 0;
        for(char c : str.toCharArray()){
            if(c <= 'z' && c >= 'a'){
                count++;
            }
        }
        return count;
    }
}
