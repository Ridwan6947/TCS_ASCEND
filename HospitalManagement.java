import java.util.*;

class Doctor{
    int dId;
    String dName;
    String spec;
    List<Patient> patients;

    public Doctor(int dId , String dName , String spec , List<Patient> patients){
        this.dId = dId;
        this.dName = dName;
        this.spec = spec;
        this.patients = patients;
    }
    public int getDid(){
        return dId;
    }
    public String getDname(){
        return dName;
    }
    public String getSpec(){
        return spec;
    }
    public List<Patient> getPatients(){
        return patients;
    }
}
class Patient{
    int pId;
    String pName;
    String illness;

    public Patient(int pId , String pName , String illness){
        this.pId = pId;
        this.pName = pName;
        this.illness = illness;
    }
    public int getPid(){
        return pId;
    }
    public String getPname(){
        return pName;
    }
    public String getIllness(){
        return illness;
    }
}

public class HospitalManagement{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Doctor[] doctors = new Doctor[n];
        for(int i = 0 ; i < doctors.length ; i++){
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt();
            sc.nextLine();
            Patient patients[] = new Patient[d];
            for(int j = 0 ; j < patients.length ; j++){
                int e = sc.nextInt();
                sc.nextLine();
                String f = sc.nextLine();
                String g = sc.nextLine();
                patients[j] = new Patient(e,f,g);
            }
            List<Patient> list = new ArrayList<>();
            for(int k = 0 ; k < patients.length ; k++){
                list.add(patients[k]);
            }
            doctors[i] = new Doctor(a,b,c,list);
        }
        int doctorID = sc.nextInt();
        sc.nextLine();
        String specToFind = sc.nextLine();
        TreeSet<String> ans = getUniqueIllness(doctors , doctorID);
        List<String> res = getDoctorBySpec(doctors , specToFind);
        for(String res1 : ans ){
            System.out.println(res1);
        }
        for(String res2 : res){
            System.out.println(res2);
        }

        
    }
    public static TreeSet<String> getUniqueIllness(Doctor[] arr , int target){
        TreeSet<String> ans = new TreeSet<>();
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i].getDid() == target){
                for(Patient p : arr[i].getPatients()){
                    ans.add(p.getIllness());
                }
            }
        }
        return ans;
    }
    public static List<String> getDoctorBySpec(Doctor[] arr , String target){
        List<String> ans = new ArrayList<>();
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i].getSpec().equalsIgnoreCase(target)){
                ans.add(arr[i].getDname());
            }
        }
        return ans;
    }
}