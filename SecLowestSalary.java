import java.util.*;

public class SecLowestSalary {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Employee employee[] = new Employee[n];
        for(int i = 0 ; i < employee.length ; i++){
            int id = sc.nextInt();sc.nextLine();
            String name = sc.nextLine();
            int age = sc.nextInt();sc.nextLine();
            char gender = sc.next().charAt(0);sc.nextLine();
            double salary = sc.nextDouble();sc.nextLine();
            employee[i] = new Employee(id , name , age , gender , salary);
        }
        int countAge = sc.nextInt();
        if(employee.length < 2){
            System.out.print("null");
        }else{
            Employee ans1 = getEmployeeWithSecondLowestSalaray(employee);
            System.out.println(ans1.getEmployeeId()+ "#" + ans1.getEmployeeName());
        }
        int ageBelowCount = countEmployeeBasedOnAge(employee , countAge);
        System.out.println(ageBelowCount);
    }
    public static Employee getEmployeeWithSecondLowestSalaray(Employee employee[]){
        Double minSal = Double.MAX_VALUE;
        Double secMinSal = Double.MAX_VALUE;
        Employee secMinEmp = null;
        for(int i = 0 ; i < employee.length ; i++){
            if(employee[i].getEmployeeSalary() < minSal){
                secMinSal = minSal;
                minSal = employee[i].getEmployeeSalary();
            }else if(employee[i].getEmployeeSalary() < secMinSal && employee[i].getEmployeeSalary() != minSal){
                secMinSal = employee[i].getEmployeeSalary();
                secMinEmp = employee[i];
            }
        }
        return secMinEmp;
    }


    public static int countEmployeeBasedOnAge(Employee employee[] , int target){
        int count = 0;
        for(int i = 0 ; i < employee.length ; i++){
            if(employee[i].getEmployeeAge() < target){
                count++;
            }
        }
        return count;
    }
}

class Employee{
    private int employeeId;
    private String employeeName;
    private int employeeAge;
    private char employeeGender;
    private double employeeSalary;

    public Employee(int employeeId , String employeeName , int employeeAge , char employeeGender , double employeeSalary){
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeAge = employeeAge;
        this.employeeGender = employeeGender;
        this.employeeSalary = employeeSalary;
    }

    public int getEmployeeId(){
        return employeeId;
    }
    public String getEmployeeName(){
        return employeeName;
    }
    public int getEmployeeAge(){
        return employeeAge;
    }
    public char getEmployeeGender(){
        return employeeGender;
    }
    public double getEmployeeSalary(){
        return employeeSalary;
    }
    public void setEmployeeId(int employeeId){
        this.employeeId = employeeId;
    }
    public void setEmployeeName(String employeeName){
        this.employeeName = employeeName;
    }
    public void setEmployeeAge(int employeeAge){
        this.employeeAge = employeeAge;
    }
    public void setEmployeeGender(char employeeGender){
        this.employeeGender = employeeGender;
    }
    public void setEmployeeSalary(double employeeSalary){
        this.employeeSalary = employeeSalary;
    }
}
