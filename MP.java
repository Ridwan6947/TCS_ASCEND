import java.util.*;

class Artist{
    int id;
    String name;
    String genre;
    List<Album> albums;

    public Artist(int id , String name , String genre , List<Album> albums ){
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.albums = albums;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getGenre(){
        return genre;
    }
    public List<Album> getAlbums(){
        return albums;
    }
}
class Album{
    int aID;
    String atitle;
    int year;

    public Album(int aID , String atitle , int year){
        this.aID = aID;
        this.atitle = atitle;
        this.year = year;
    }
    public int getAid(){
        return aID;
    }
    public String getATitle(){
        return atitle;
    }
    public int getYear(){
        return year;
    }

}


public class MP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Artist[] artists = new Artist[n];
        for(int i = 0 ; i < artists.length ; i++){
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt();
            Album[] albums = new Album[d];
            for(int j = 0 ; j < albums.length ; j++){
                int e = sc.nextInt();
                sc.nextLine();
                String f = sc.nextLine();
                int g = sc.nextInt();
                sc.nextLine();
                albums[j] = new Album(e,f,g);
            }
            ArrayList<Album> list = new ArrayList<>();
            for(int k = 0 ; k < albums.length ; k++){
                list.add(albums[k]); 
            }
            artists[i] = new Artist(a,b,c,list);
        }
        int artistId = sc.nextInt();
        sc.nextLine();
        int startYear = sc.nextInt();
        sc.nextLine();
        int endYear = sc.nextInt();
        sc.nextLine();
        List<String> ans = getAlbumsByYear(artists , artistId , startYear , endYear);
        String res = getGenreWithMost(artists);
        System.out.println("___________________________");
        if(!ans.isEmpty()){
            for(String res1 : ans){
                System.out.println(res1);
            }
        }else{
            System.out.println("Artist Not Found");
        }
        if(res != ""){
            System.out.println(res);
        }else{
            System.out.println("No Albums Found");
        }
        
    }
    public static String getGenreWithMost(Artist [] arr){
        String ans = "";
        HashMap<String , Integer> map = new HashMap<>();
        for(int i = 0 ; i < arr.length ; i++){
            map.put(arr[i].getGenre() , map.getOrDefault(arr[i].getGenre(), 0) + 1);
        } 
        int maxCount = 0;
        for(Map.Entry<String , Integer> entry : map.entrySet()){
            if(entry.getValue() > maxCount){
                maxCount = entry.getValue();
                ans = entry.getKey();
            }
        }
        return ans;
    }
    public static List<String> getAlbumsByYear(Artist[] arr , int target , int start , int end){
        List<String> ans = new ArrayList<>();
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i].getId() == target){
                for(Album a : arr[i].getAlbums()){
                    if(a.getYear() >= start && a.getYear() <= end){
                        ans.add(a.getATitle());
                    }
                }
            }
        }
        return ans;
    }

}
