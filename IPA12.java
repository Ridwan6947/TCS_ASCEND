import java.util.*;

class Student{
    private int rollNo;
    private String name;
    private String subject;
    private char grade;
    private String date;

    public Student(int rollNo , String name , String subject , char grade , String date){
        this.rollNo = rollNo;
        this.name = name;
        this.subject = subject;
        this.grade = grade;
        this.date = date;
    }
    public int getRollNo(){
        return rollNo;
    }
    public String getName(){
        return name;
    }
    public String getSubject(){
        return subject;
    }
    public char getGrade(){
        return grade;
    }
    public String getDate(){
        return date;
    }
    public void setRollNo(int rollNo){
        this.rollNo = rollNo;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setSubject(String subject){
        this.subject = subject;
    }
    public void setGrade(char grade){
        this.grade = grade;
    }
    public void setDate(String date){
        this.date = date;
    }
}

public class Main{

    public static Student[] findStudentByGradeAndMonth(Student[] arr , char gr , int  mo){
        ArrayList<Student> list = new ArrayList<>();

        for(int i = 0 ; i < arr.length ; i++){
            String[] month =arr[i].getDate().split("/");
            int studentMonth = Integer.parseInt(month[1]);
            if(arr[i].getGrade() == gr && studentMonth == mo){
                list.add(arr[i]);
            }
        }
        Student [] ans1 = new Student[list.size()];
        Iterator<Student> it = list.iterator();
        int index = 0;
        while(it.hasNext()){
        	ans1[index++] = it.next();
        }
       
        for(int i = 0 ; i < ans1.length-1 ; i++){
            for(int j = 0 ; j < ans1.length - i - 1 ; j++){
                if(ans1[j].getRollNo() > ans1[j+1].getRollNo()){
                    Student temp = ans1[j];
                    ans1[j] = ans1[j+1];
                    ans1[j+1] = temp;
                }
            }
        }
        return ans1;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Student [] student = new Student[4];
        for(int i = 0 ; i < student.length ; i++){
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            char d = sc.nextLine().charAt(0);
            String e = sc.nextLine();
            student[i] = new Student(a,b,c,d,e);
        }
        char gradeToFind = sc.nextLine().charAt(0);
        int monthToFind = sc.nextInt();sc.nextLine();
        Student[] ans = findStudentByGradeAndMonth(student , gradeToFind , monthToFind);
        if(ans != null){
            for(Student students : ans){
                System.out.println(students.getName());
            }
            System.out.println(ans.length);
        }else{
            System.out.println("null");
        }
    }
}
 