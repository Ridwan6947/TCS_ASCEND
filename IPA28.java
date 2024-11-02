import java.util.*;

public class IPA28 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Team[] teams = new Team[n];
        for(int i = 0 ; i < teams.length ; i++){
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt();
            sc.nextLine();
            teams[i] = new Team(a,b,c,d);
        }
        int runs = sc.nextInt();
        sc.nextLine();
        String country = sc.nextLine();
        sc.nextLine();
        Team ans = findPlayer(teams , runs , country);
        if(ans != null){
            System.out.println(ans.getTeamId());
            System.out.println(ans.getTeamName());
            System.out.println(ans.getTeamCountry());
            System.out.println(ans.getTeamRun());
        }else{
            System.out.println("No such player found");
        }
    }
    public static Team findPlayer(Team[] arr , int run  , String country){
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i].getTeamCountry().equalsIgnoreCase(country) && arr[i].getTeamRun() > run){
                return arr[i];
            }
        }
        return null;
    }
}

class Team{
    private int teamId;
    private String teamName;
    private String teamCountry;
    private int teamRun;

    public Team(int teamId , String teamName , String teamCountry , int teamRun){
        this.teamId = teamId;
        this.teamName = teamName;
        this.teamCountry = teamCountry;
        this.teamRun = teamRun;
    }
    public int getTeamId(){
        return teamId;
    }
    public String getTeamName(){
        return teamName;
    }
    public String getTeamCountry(){
        return teamCountry;
    }
    public int getTeamRun(){
        return teamRun;
    }
    public void setTeamId(int teamId){
        this.teamId = teamId;
    }
    public void setTeamName(String teamName){
        this.teamName = teamName;
    }
    public void setTeamCountry(String teamCountry){
        this.teamCountry = teamCountry;
    }
    public void setTeamRun(int teamRun){
        this.teamRun = teamRun;
    }
}
