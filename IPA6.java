import java.util.*;

public class IPA6 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        RRT [] arr = new RRT[4];
        for(int i = 0 ; i < arr.length ; i++){
            int a = sc.nextInt(); sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt(); sc.nextLine();
            String e = sc.nextLine();
            arr[i] = new RRT(a,b,c,d,e);
        }
        String findByProject = sc.nextLine();
        RRT ans = getTicketWithHighestPriority(arr , findByProject);
        if(ans != null){
            System.out.println(ans.getTicketNo());
            System.out.println(ans.getRaisedBy());
            System.out.println(ans.getAssignedTo());
        }else{
            System.out.println("No ticket found");
        }
    }
    public static RRT getTicketWithHighestPriority(RRT [] arr , String target){
        RRT ans = arr[0];
        for(int i = 1 ; i < arr.length ; i++){
            if(arr[i].getPriority() < ans.getPriority() && arr[i].getProject().equals(target)){
                ans = arr[i];
            }
        }
        return ans;
    }
}

class RRT{
    private int ticketNo;
    private String raisedBy;
    private String assignedTo;
    private int priority;
    private String project;

    public RRT(int ticketNo , String raisedBy , String assignedTo , int priority , String project){
        this.ticketNo = ticketNo;
        this.raisedBy = raisedBy;
        this.assignedTo = assignedTo;
        this.priority = priority;
        this.project = project;
    }

    public int getTicketNo(){
        return ticketNo;
    }
    public String getRaisedBy(){
        return raisedBy;
    }
    public String getAssignedTo(){
        return assignedTo;
    }
    public int getPriority(){
        return priority;
    }
    public String getProject(){
        return project;
    }
    public void setTicketNo(int ticketNo){
        this.ticketNo = ticketNo;
    }
    public void setRaisedBy(String raisedBy){
        this.raisedBy = raisedBy;
    }
    public void setAssignedTo(String assignedTo){
        this.assignedTo = assignedTo;
    }
    public void setPriority(int priority){
        this.priority = priority;
    }
    public void setProject(String project){
        this.project = project;
    }
}
