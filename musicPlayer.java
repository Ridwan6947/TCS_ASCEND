import java.util.*;

public class musicPlayer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Music[] musics = new Music[4];
        
        // Inputting music details
        for (int i = 0; i < musics.length; i++) {
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();
            sc.nextLine();
            double d = sc.nextDouble();
            sc.nextLine();
            musics[i] = new Music(a, b, c, d);
        }
        
        int y = sc.nextInt();
        sc.nextLine();
        double duration = sc.nextDouble();
        sc.nextLine();
        
        int avg = findAvgOfCount(musics, y);
        System.out.println("Average count: " + avg);
        
        Music[] filteredMusic = sortTypeByDuration(musics, duration);
        for(int i = 0 ; i < filteredMusic.length ; i++){
            System.out.println(filteredMusic[i].getType());
        }
    }
    
    public static int findAvgOfCount(Music[] arr, int target) {
        int totalCount = 0;
        int count = 0;
        
        for (Music music : arr) {
            if (music.getCount() > target) {
                totalCount += music.getCount();
                count++;
            }
        }
        
        if (count == 0) return 0;
        return totalCount / count;
    }
    
    public static Music[] sortTypeByDuration(Music[] arr, double target) {
        List<Music> ans = new ArrayList<>();
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i].getDuration() > target){
                ans.add(arr[i]);
            }
        }
        Music[] newArr = new Music[ans.size()];
        for(int i = 0 ; i < ans.size() ; i++){
            newArr[i] = ans.get(i);
        }

        for(int i = 0 ; i < newArr.length-1 ; i++){
            for(int j = 0 ; j < newArr.length-1 ; j++){
                if(newArr[j].getDuration() > newArr[j+1].getDuration()){
                    Music temp = newArr[j];
                    newArr[j] = newArr[j+1];
                    newArr[j+1] = temp;
                }
            }
        }
        return newArr;
    }
}

class Music {
    private int playlistId;
    private String type;
    private int count;
    private double duration;

    public Music(int playlistId, String type, int count, double duration) {
        this.playlistId = playlistId;
        this.type = type;
        this.count = count;
        this.duration = duration;
    }

    public int getPlaylistId() {
        return playlistId;
    }

    public String getType() {
        return type;
    }

    public int getCount() {
        return count;
    }

    public double getDuration() {
        return duration;
    }

    public void setPlaylistId(int playlistId) {
        this.playlistId = playlistId;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }
}
