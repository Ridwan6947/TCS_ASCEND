import java.util.*;

public class libManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Genre[] arr = new Genre[n];
        for(int i = 0 ; i < arr.length ; i++){
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();
            Book[] arr2 = new Book[c];
            for(int j = 0 ; j < arr2.length ; j++){
                int d = sc.nextInt();
                sc.nextLine();
                String e = sc.nextLine();
                String f = sc.nextLine();
                arr2[j] = new Book(d, e, f);
            }
            HashMap<Integer,Book> map = new HashMap<>();
            for(int k = 0 ; k < arr2.length ; k++){
                map.put(arr2[k].getBid() , arr2[k]);
            }
            arr[i] = new Genre(a,b,map);
        }
        int genreId = sc.nextInt();
        sc.nextLine();
        String authorName = sc.nextLine();
        int bokID = sc.nextInt();
        sc.nextLine();
        TreeSet<String> map = getBooksByAuthor(arr , genreId , authorName);
        List<String > res = getGenre(arr , bokID);
        for(String ans : map){
            System.out.println(ans);
        }
        for(String ans : res){
            System.out.println(ans);
        }
    } 
    public static List<String> getGenre(Genre[] arr , int target){
        List<String> ans = new ArrayList<>();
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i].getBooks().containsKey(target)){
                ans.add(arr[i].getName());
            }
        }
        return ans;
    }
    public static TreeSet<String> getBooksByAuthor(Genre[] arr , int id , String target){
        TreeSet<String> ans = new TreeSet<>();
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i].getId() == id){
                for(Book b : arr[i].getBooks().values()){
                    if(b.getAuthName().equalsIgnoreCase(target)){
                        ans.add(b.getTitle());
                    }
                }
            }
        }
        return ans;
    }   
}
class Genre{
    int id;
    String name;
    Map<Integer , Book> books;

    public Genre(int id , String name , Map<Integer,Book> books){
        this.id = id;
        this.name = name;
        this.books = books;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public Map<Integer,Book> getBooks(){
        return books;
    }
}
class Book{
    int bId;
    String title;
    String authName;

    public Book(int bId , String title , String authName){
        this.bId = bId;
        this.title = title;
        this.authName = authName;
    }
    public int getBid(){
        return bId;
    }
    public String getTitle(){
        return title;
    }
    public String getAuthName(){
        return authName;
    }
}
