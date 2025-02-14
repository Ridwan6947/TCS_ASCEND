import java.util.*;

public class musicLibrary {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Artist[] arr = new Artist[n];
        for(int i = 0 ; i < arr.length ; i++){
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt();
            sc.nextLine();
            Album[] arr2 = new Album[d];
            for(int j = 0 ; j < arr2.length ; j++){
                int e = sc.nextInt();
                sc.nextLine();
                String f = sc.nextLine();
                int g = sc.nextInt();
                sc.nextLine();
                arr2[j] = new Album(e,f,g);
            }
            List<Album> list = new ArrayList<>(); 
            for(int k = 0 ; k < arr2.length ; k++){
                list.add(arr2[k]);
            }
            arr[i] = new Artist(a,b,c,list);
        }
        int idToFind = sc.nextInt();
        sc.nextLine();
        int startYear = sc.nextInt();
        sc.nextLine();
        int endYear = sc.nextInt();
        sc.nextLine();
        List<String> ans = getAlbumsByYear(arr , idToFind , startYear , endYear);
        String res = getGenreWithMostAlbum(arr);
        Iterator it = ans.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println(res);


    }
    public static List<String> getAlbumsByYear(Artist arr[] , int idToFind , int start , int end){
        List<String> ans = new ArrayList<>();
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i].getId() == idToFind){
                for(Album a : arr[i].getAlbums()){
                    if(a.getYear() >= start && a.getYear() <= end){
                        ans.add(a.getAname());
                    }
                }
            }
        }
        return ans;
    }
    public static String getGenreWithMostAlbum(Artist[] arr){
        String ans = "";
        int count = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i].getAlbums().size() > count){
                count = arr[i].getAlbums().size();
                ans = arr[i].getGenre();
            }
        }
        return ans;
    }
}

class Artist{
    int id;
    String name;
    String genre;
    List<Album> albums;

    public Artist(int id , String name , String genre , List<Album> albums){
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
    int aId;
    String aName;
    int year;

    public Album(int aId , String aName , int year){
        this.aId = aId;
        this.aName = aName;
        this.year = year;
    }
    public int getAid(){
        return aId;
    }
    public String getAname(){
        return aName;
    }
    public int getYear(){
        return year;
    }

}
