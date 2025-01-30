import java.util.*;

public class studentGrade {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stud [] studs = new Stud[n];
        for(int i = 0 ; i < studs.length ; i++){
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt();
            sc.nextLine();
            studs[i] = new Stud(a,b,c,d);
        }
        String sName = sc.nextLine();
        float calcAvg = calculateAverage(studs , sName);
        if(calcAvg == 0){
            System.out.println("Invalid Grade");
        }else if(calcAvg == 1){
            System.out.println("No Student Present");
        }else{
            System.out.println(calcAvg);
        }
        int passingStudent = countPassingStudent(studs , sName);
        System.out.println(passingStudent);

    }    
    public static int countPassingStudent(Stud[] arr , String target){
        int count = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i].getSchoolName().equalsIgnoreCase(target) && arr[i].getGrade() >= 60){
                count++;
            }
        }
        return count;
    }
    public static float calculateAverage(Stud[] arr , String target){
        int count = 0;
        float avg = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i].getSchoolName().equalsIgnoreCase(target) && arr[i].getGrade() < 0){
                return 0;
            }
            else if(arr[i].getSchoolName().equalsIgnoreCase(target) && arr[i].getGrade() > 0){
                count++;
                avg += arr[i].getGrade();
            }
        }
        if(count == 0){
            return 1;
        }else{
            return avg / count;
        }
    }

}
class Stud{
    private int id;
    private String name;
    private String schoolName;
    private int grade;
    
    public Stud(int id , String name , String schoolName , int grade){
        this.id = id;
        this.name = name;
        this.schoolName = schoolName;
        this.grade = grade;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setSchoolName(String schoolName){
        this.schoolName = schoolName;
    }
    public void setGrade(int grade){
        this.grade = grade;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getSchoolName(){
        return schoolName;
    }
    public int getGrade(){
        return grade;
    }
}
