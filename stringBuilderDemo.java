public class stringBuilderDemo {
    public static void main(String[] args) {
        // Creating a new String object with initial value "hello"
        String str = new String("hello");
        int i;

        // Start measuring time for String concatenation
        long startTimeStr = System.currentTimeMillis();
        
        // Concatenating "world" to the string 1,000,000 times
        for(i = 0; i < 1000000; i++){
            str = str + "world";  // Creates new String objects in each iteration (inefficient)
        }
        
        // End time for String concatenation and calculate total time taken
        long endTimeStr = System.currentTimeMillis();
        long totalTimeStr = (endTimeStr - startTimeStr) / 1000;  // Dividing by 1000 to convert to seconds

        // Creating a StringBuilder object with initial value "hello"
        StringBuilder sb = new StringBuilder("hello");

        // Start measuring time for StringBuilder append operation
        long startTimeSb = System.currentTimeMillis();
        
        // Appending "world" to the StringBuilder 1,000,000 times
        for(i = 0; i < 1000000; i++){
            sb.append("world");  // Efficient in-place modification of the StringBuilder object
        }

        // End time for StringBuilder operation and calculate total time taken
        long endTimeSb = System.currentTimeMillis();
        long totalTimeSb = (endTimeSb - startTimeSb) / 1000;  // Converting milliseconds to seconds
        
        // Print the total time taken for String concatenation and StringBuilder append
        System.out.println(totalTimeStr);  // Time taken for String concatenation
        System.out.println(totalTimeSb);   // Time taken for StringBuilder append
    }
}
