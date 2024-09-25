import java.util.*;

public class cricketerManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Player[] players = new Player[n];
        for(int i = 0 ; i < players.length ; i++){
            int id = sc.nextInt();
            int match = sc.nextInt();
            int runs = sc.nextInt();
            String name = sc.next();
            String team = sc.next();
            players[i] = new Player(id, match, runs, name, team);
        }
        int newId = sc.nextInt();
        int minRunsId = findCrickterWithMinRuns(players);
        System.out.println(minRunsId);
        Player ref1 = findCrickterWithId(players , newId);
        if(ref1 != null){
            System.out.println(ref1.getPlayerId());
            System.out.println(ref1.getPlayerName());
        }else{
           System.out.println("null"); 
        }

    }
    public static int findCrickterWithMinRuns(Player[] players){
        int min = players[0].getRuns();
        int minId = players[0].getPlayerId();
        for(int i = 0 ; i < players.length ; i++){
            if(players[i].getRuns() < min){
                min = players[i].getRuns();
                minId = players[i].getPlayerId();
            }
        }
        return minId;
    }
    
    public static Player findCrickterWithId(Player[] players , int id){
        for(int i = 0 ; i < players.length ; i++){
            if(players[i].getPlayerId() == id){
                return players[i];
            }
        }
        return null;
    }
}

class Player {
    private int playerId;
    private int matchPlayed;
    private int runs;
    private String playerName;
    private String teamName;

    public Player(int playerId , int matchPlayed , int runs , String playerName , String teamName){
        this.playerId = playerId;
        this.matchPlayed = matchPlayed;
        this.runs = runs;
        this.playerName = playerName;
        this.teamName = teamName;
    }

    public int getPlayerId(){
        return playerId;
    }

    public int getMatchPlayed(){
        return matchPlayed;
    }

    public int getRuns(){
        return runs;
    }

    public String getPlayerName(){
        return playerName;
    }

    public String getTeamName(){
        return teamName;
    }

    public void setPlayerId(int playerId){
        this.playerId = playerId;
    }

    public void setMatchPlayed(int matchPlayed){
        this.matchPlayed = matchPlayed;
    }

    public void setRuns(int runs){
        this.runs = runs;
    }

    public void setPlayerName(String playerName){
        this.playerName = playerName;
    }

    public void setTeamName(String teamName){
        this.teamName = teamName;
    }
}

