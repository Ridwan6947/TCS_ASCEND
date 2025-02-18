package sorting;

public class reverseWord2 {
    public static void main(String[] args) {
        String str = "My Name Is Ridwan";
        String arr[] = str.split(" ");

        for (int i = 0; i < arr.length; i++) {
            arr[i] = reverseWord(arr[i]); // Reverse each word manually
        }

        // Join the words back into a sentence
        String result = "";
        for (int i = 0; i < arr.length; i++) {
            result += arr[i]; // Append each reversed word
            if (i < arr.length - 1) {
                result += " "; // Add space between words
            }
        }

        System.out.println(result);
    }

    // Function to manually reverse a string
    public static String reverseWord(String word) {
        char[] chars = word.toCharArray();
        int si = 0, ei = chars.length - 1;

        while (si < ei) {
            char temp = chars[si];
            chars[si] = chars[ei];
            chars[ei] = temp;
            si++;
            ei--;
        }

        return new String(chars); // Convert back to String
    }
}
