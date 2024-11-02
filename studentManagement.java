import java.util.*;

public class studentManagement {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Student[] students = new Student[4];
        for(int i = 0 ; i < students.length ; i++){
            int a  = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            double d = sc.nextDouble();
            sc.nextLine();
            boolean e = sc.nextBoolean();
            students[i] = new Student(a,b,c,d,e);
        }
        int count = findCountOfDayScholar(students);
        System.out.println(count);
        Student ans = findStudentWithSecondHighestScore(students);
        if(ans != null){
            System.out.println(ans.getRollNo() + " # " + ans.getName() + " # " + ans.getScore());
        }else{
            System.out.println("l");
        }
    }
    public static int findCountOfDayScholar(Student[] arr){
        int ans = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i].getDayScholar() == true){
                ans++;
            }
        }
        return ans;
    }
    public static Student findStudentWithSecondHighestScore(Student[] arr){
        Double highest = Double.MIN_VALUE;
        Double secHighest = Double.MIN_VALUE;
        Student ans = null;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i].getScore() > highest){
                secHighest = highest;
                highest = arr[i].getScore();
            }else if(arr[i].getScore() > secHighest &&  arr[i].getScore() != highest){
                secHighest = arr[i].getScore();
                ans = arr[i];
            }
        }
        return ans;
    }
}

class Student{
    private int rollNo;
    private String name;
    private String branch;
    private double score;
    private boolean dayScholar;

    public Student(int rollNo , String name , String branch , double score , boolean dayScholar){
        this.rollNo = rollNo;
        this.name = name;
        this.branch = branch;
        this.score = score;
        this.dayScholar = dayScholar;
    }
    public int getRollNo(){
        return rollNo;
    }
    public String getName(){
        return name;
    }
    public String getBranch(){
        return branch;
    }
    public double getScore(){
        return score;
    }
    public boolean getDayScholar(){
        return dayScholar;
    }
    public void setRollNo(int rollNo){
        this.rollNo = rollNo;
    }
    public void setName(String name){
        this.name  = name;
    }
    public void setBranch(String branch){
        this.branch = branch;
    }
    public void setScore(double score){
        this.score = score;
    }
    public void setDayScholar(boolean dayScholar){
        this.dayScholar = dayScholar;
    }
}
