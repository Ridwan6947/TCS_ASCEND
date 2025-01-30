import java.util.*;

public class reportManagement {
    public static void main(String[] args){
        int n = 4;
        Scanner sc = new Scanner(System.in);
        Report report[] = new Report[n];
        for(int i = 0 ; i < report.length ; i++){
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();
            sc.nextLine();
            String d = sc.nextLine();
            report[i] = new Report(a,b,c,d);
        }
        String targetLab = sc.nextLine();
        int noOfReport = countReportByLab(report , targetLab);
        if(noOfReport != 0){
            System.out.println(noOfReport);
        }else{
            System.out.println("No Such Report Found");
        }
        Report thirdLowestPrice = getThirdLowest(report);
        System.out.println(thirdLowestPrice.getId());
        System.out.println(thirdLowestPrice.getName());
        System.out.println(thirdLowestPrice.getPrice());
        System.out.println(thirdLowestPrice.getLab());
    }
    public static int countReportByLab(Report report[] , String target){
        int count = 0;
        for(int i = 0 ; i < report.length ; i++){
            if(report[i].getLab().equalsIgnoreCase(target)){
                count++;
            }
        }
        return count;
    }
    public static Report getThirdLowest(Report[] report) {
        Report lowest = null;
        Report secondLowest = null;
        Report thirdLowest = null;
        
        for(int i = 0; i < report.length; i++) {
            Report current = report[i];
            if(lowest == null || current.getPrice() < lowest.getPrice()) {
                thirdLowest = secondLowest;
                secondLowest = lowest;
                lowest = current;
            } else if(secondLowest == null || current.getPrice() < secondLowest.getPrice()) {
                thirdLowest = secondLowest;
                secondLowest = current;
            } else if(thirdLowest == null || current.getPrice() < thirdLowest.getPrice()) {
                thirdLowest = current;
            }
        }
        return (thirdLowest != null && thirdLowest.getPrice() % 2 != 0) ? thirdLowest : null;
    }
}
class Report{
    private int reportId;
    private String reportName;
    private int reportPrice;
    private String reportLab;

    public Report(int reportId , String reportName , int reportPrice , String reportLab){
        this.reportId = reportId;
        this.reportName = reportName;
        this.reportPrice = reportPrice;
        this.reportLab = reportLab;
    }

    public int getId(){
        return reportId;
    }
    public String getName(){
        return reportName;
    }
    public int getPrice(){
        return reportPrice;
    }
    public String getLab(){
        return reportLab;
    }
    public void setId(int reportId){
        this.reportId = reportId;
    }
    public void setName(String reportName){
        this.reportName = reportName;
    }
    public void setPrice(int reportPrice){
        this.reportPrice = reportPrice;
    }
    public void setLab(String reportLab){
        this.reportLab = reportLab;
    }
}
