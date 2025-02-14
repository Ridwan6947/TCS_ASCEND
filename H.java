import java.util.*;

public class H{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int  n = sc.nextInt();
        Doctor[] arr = new Doctor[n];
        for(int i = 0 ; i < arr.length ; i++){
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt();
            sc.nextLine();
            Patient[] arr2 = new Patient[d];
            ArrayList<Patient> list = new ArrayList<>();
            
            for(int j = 0 ; j < arr2.length ; j++){
                int e = sc.nextInt();
                sc.nextLine();
                String f = sc.nextLine();
                String g = sc.nextLine();
                arr2[j] = new Patient(e,f,g);
            }
            
            for(int k = 0 ; k < arr2.length ; k++){
                list.add(arr2[k]);
            }

            arr[i] = new Doctor(a,b,c,list);
        }
        int doID = sc.nextInt();
        sc.nextLine();
        String specToFind = sc.nextLine();
        TreeSet<String >ans = getUniqueIllness(arr , doID );
        List<String> res = getDoctorBySpec(arr , specToFind);
        

        for(String illness : ans) {
            System.out.println(illness);
        }
        
        for(String doctor : res) {
            System.out.println(doctor);
        }
    } 
    public static TreeSet<String> getUniqueIllness(Doctor[] arr , int target){
        TreeSet<String> ans = new TreeSet<>();
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] != null && arr[i].getDid() == target){
                for(Patient p : arr[i].getPatients()){
                    if(p != null) {
                        ans.add(p.getIllness());
                    }
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
class Doctor{
    int did;
    String dname;
    String spec;
    List<Patient> patients;

    public Doctor(int did , String dname , String spec , List<Patient> patients){
        this.did = did;
        this.dname = dname;
        this.spec = spec;
        this.patients = patients;
    }
    public int getDid(){
        return did;
    }
    public String getDname(){
        return dname;
    }
    public String getSpec(){
        return spec;
    }
    public List<Patient> getPatients(){
        return patients;
    }
}
class Patient{
    int pid;
    String pname;
    String illness;

    public Patient(int pid , String pname , String illness){
        this.pid = pid;
        this.pname = pname;
        this.illness = illness;
    }
    public int getPid(){
        return pid;
    }
    public String getPname(){
        return pname;
    }
    public String getIllness(){
        return illness;
    }

}