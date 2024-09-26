import java.util.*;

public class vowelsConsonents {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    int ans[] = countVowelsConsonents(str);
    System.out.println("Number of vowels: " + ans[0]);
    System.out.println("Number of consonents: " + ans[1]);
  }
  
  public static int[] countVowelsConsonents(String str){
    int[] ans = new int[2];
    for(char c : str.toCharArray()){
        if(c =='a' || c =='e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U'){
            ans[0]++;
        }else if(c <= 'z' && c >= 'a' || c <= 'Z' && c >= 'A'){
            ans[1]++;
        }
    }
    return ans;
  }
}
