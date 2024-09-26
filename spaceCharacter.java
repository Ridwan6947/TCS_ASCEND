import java.util.*;

public class spaceCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int ans[] = countCharacterSpace(str);
        System.out.println("Number of spaces: " + ans[0]);
        System.out.println("Number of characters: " + ans[1]);
    }

    public static int[] countCharacterSpace(String str){
        int ans[] = new int[2];
        str = str.toLowerCase();
        for(char c : str.toCharArray()){
            if( c <= 'z' && c >= 'a' ){
                ans[1]++;
                System.out.print(c + " " + ans[1]);
            }else{
                ans[0]++;
            }
        }
        return ans;
    }
}
