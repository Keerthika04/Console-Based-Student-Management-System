import java.util.Arrays;
import java.util.Scanner;

class main{
    static String[][] studentList= new String[50][6];
    static String[][] tempList= new String[50][6];

    public static void title(){
        System.out.println("\n -------------------------------------------------------");
        System.out.println(" | Welcome to Developer Stack Student Managment System |");  
        System.out.println(" -------------------------------------------------------\n");
    }

    public static void dashboard(){
        title();
        Scanner input = new Scanner(System.in);    
        System.out.println("    1 -> Save new Student");
        System.out.println("    2 -> Edit Student");
        System.out.println("    3 -> view all Students");
        System.out.println("    4 -> Search Student");
        System.out.println("    5 -> Remove Student");
        System.out.println("    6 -> Log Out \n");

        System.out.print("    Enter Your Choice : ");
        int choice = input.nextInt();
        System.out.println(choice);

        switch (choice) {
            case 1:
                System.out.print("\033[H\033[2J");
                title();
                saveStudent();
                break;
            case 2:
                System.out.print("\033[H\033[2J");
                title();
                editStudent();
                break;
            case 3:
                System.out.print("\033[H\033[2J");
                title();
                viewAllStudents();
                break;    
            case 4:
                System.out.print("\033[H\033[2J");
                title();
                searchStudent();
                break;    
       
            case 5:
                System.out.print("\033[H\033[2J");
                title();
                removeStudent();
                break;    
       
            case 6:
            System.exit(0);
                break;  

            default:
                System.out.print("\033[H\033[2J");  
                System.out.println("    Invalid Choice Try Again!\n");          
                dashboard();
                break;
        }
    }

    public static void saveStudent(){
        System.out.println("                   ----------------");
        System.out.println("                   | Save Student |");  
        System.out.println("                   ----------------\n");

        Scanner input= new Scanner(System.in);
 
        System.out.print("    Enter Student Name: ");
             String name = input.nextLine();
        System.out.print("    Enter Student NIC: ");
            String nic = input.nextLine();
        System.out.print("    Enter Student Age: ");
             String age = input.nextLine();
        System.out.print("    Enter Student Contact Number: ");
             String contactNumber = input.nextLine();
        System.out.print("    Enter Student Gender: ");
            String gender = input.nextLine();
        System.out.print("    Enter Student DOB: ");
            String dob = input.nextLine();

        if(name.equals("") || nic.equals("") || age.equals("") || contactNumber.equals("") || gender.equals("") || dob.equals("")){
            System.out.print("\033[H\033[2J"); 
            title();
            System.out.print("\n    Please fill all of the fields!\n    You missed a field\n\n");
            saveStudent();
        }
 
            int index=0;
            for(int i=0; i<studentList.length; i++){
                if(studentList[i][0]==null){
                    index=i;
                    break;
                }
            }

            studentList[index][0]=name;
            studentList[index][1]=nic;
            studentList[index][2]=age;
            studentList[index][3]=contactNumber;
            studentList[index][4]=dob;
            studentList[index][5]=gender;    

            System.out.println("\n    Sucessfully added "+Arrays.toString(studentList[index]));
            System.out.print("\n  Do you want to save another student press \"y\" or press any letter: ");
            String selection= input.nextLine();
            if(selection.equalsIgnoreCase("y")){
                System.out.print("\033[H\033[2J"); 
                title();
                saveStudent();
            }
            else {
                System.out.print("\033[H\033[2J");
                dashboard();
            }

    }

    public static void editStudent(){

        System.out.println("                   ----------------");
        System.out.println("                   | Edit Student |");  
        System.out.println("                   ----------------\n");

        Scanner input = new Scanner(System.in);

        System.out.print("   Enter Student NIC Number: ");
        String nic = input.nextLine();
        int index=-1;
       
        for(int i = 0; i< studentList.length;i++){
            if(studentList[i][1].equals(nic)){
                index=i;
                break;
            }else{

                System.out.print("\n  Ops! That NIC does\'t exist do you want to try again press \"y\" or press any letter to go back to dashboard: ");
                String selection= input.nextLine();
                if(selection.equalsIgnoreCase("y")){
                    System.out.print("\033[H\033[2J");
                    title();
                    editStudent();
                }
                else {
                    System.out.print("\033[H\033[2J");
                    dashboard();
                 }

            }
        }
        
        System.out.println(Arrays.toString(studentList[index]) + "\n");

        System.out.println("    which field to be edit?\n");
        System.out.println("      0 - Name ");
        System.out.println("      1 - NIC ");
        System.out.println("      2 - Age ");
        System.out.println("      3 - Contact Number ");
        System.out.println("      4 - Date of Birth ");
        System.out.println("      5 - Gender ");

        System.out.print("\n     Your input: ");

        Scanner scanner= new Scanner(System.in);
        int choice= input.nextInt();
        switch (choice) {
            case 0:
                System.out.print("     Enter name to be update: ");
                String name=scanner.nextLine();
                studentList[index][0]=name;
                break;
            case 1:
                System.out.print("     Enter Nic to be update: ");
                String nic2=scanner.nextLine();
                studentList[index][1]=nic2;
                break;
            case 2:
                System.out.print("     Enter age to be update: ");
                String age=scanner.nextLine();
                studentList[index][2]=age;
                break;
            case 3:
                System.out.print("     Enter Contact Number to be update: ");
                String cn=scanner.nextLine();
                studentList[index][3]=cn;
                break;
            case 4:
                System.out.print("     Enter date of birth  to be update: ");
                String dob=scanner.nextLine();
                studentList[index][4]=dob;
                break;  
            case 5:
                System.out.print("     Enter gender to be update: ");
                String gender=scanner.nextLine();
                studentList[index][5]=gender;   
                break;        
            default:
                System.out.print("     invalid choice!");
                break;
        }

            System.out.print("\n   press any letter to go to dashboard ");
            String selection= scanner.nextLine();
           
            if(selection != null){
                System.out.print("\033[H\033[2J");
                dashboard();
            }
    }

    public static void viewAllStudents(){

        System.out.println("                   --------------------");
        System.out.println("                   | View All Student |");  
        System.out.println("                   --------------------\n");

        for(int i=0;i<studentList.length;i++){

            if(studentList[i][0]==null){
                break;
            }

                System.out.println("      Name: " + studentList[i][0]);
                System.out.println("      NIC: " + studentList[i][1]);
                System.out.println("      Age: " + studentList[i][2]);
                System.out.println("      Contact No: " + studentList[i][3]);
                System.out.println("      Gender: " + studentList[i][4]);
                System.out.println("      DOB: " + studentList[i][5] + "\n");
        }

        Scanner input = new Scanner(System.in);
        System.out.print("\n press any letter to go to dashboard ");
            String selection= input.nextLine();
           
            if(selection != null){
                System.out.print("\033[H\033[2J");
                dashboard();
            }
           
    }

    public static void searchStudent(){

        Scanner input= new Scanner(System.in);

        System.out.println("                   ------------------");
        System.out.println("                   | Search Student |");  
        System.out.println("                   ------------------\n");

        System.out.print("    Enter Student NIC Number: ");
        String nic = input.nextLine();
        for(int i = 0; i< studentList.length;i++){
           
            if(studentList[i][1].equals(nic)){
                System.out.println("      Name: " + studentList[i][0]);
                System.out.println("      NIC: " + studentList[i][1]);
                System.out.println("      Age: " + studentList[i][2]);
                System.out.println("      Contact No: " + studentList[i][3]);
                System.out.println("      Gender: " + studentList[i][4]);
                System.out.println("      DOB: " + studentList[i][5]);
                break;
            }else{

                System.out.print("\n  Ops! That NIC does\'t exist do you want to try again press \"y\" or press any letter to go back to dashboard: ");
                String selection= input.nextLine();
                if(selection.equalsIgnoreCase("y")){
                    System.out.print("\033[H\033[2J");
                    title();
                    searchStudent();
                }
                else {
                    System.out.print("\033[H\033[2J");
                    dashboard();
                 }

            }
            
        }
            System.out.print("\n press any letter to go to dashboard \n");
            String selection= input.nextLine();
           
            if(selection != null){
                System.out.print("\033[H\033[2J");
                dashboard();
            }
           
    }

    public static void removeStudent(){

        Scanner input = new Scanner(System.in);

        System.out.println("                   ------------------");
        System.out.println("                   | Remove Student |");  
        System.out.println("                   ------------------\n");


        System.out.print("   Enter Student NIC Number: ");
        String nic = input.nextLine();
            int index = -1;
       
            for(int i = 0; i< studentList.length;i++){

                if(studentList[i][1].equals(nic)){
                index=i;
                break;
                }
            }
            
            int x=0; 
            for(int k=0;k<studentList.length;k++){
                    if(k==index){
                        System.out.println("\n   Successfully removed " + Arrays.toString(studentList[k]));
                        continue;
                    }

                    tempList[x]=studentList[k];
                    x++;
            }

            studentList=tempList;

            System.out.print("\n   press any letter to go to dashboard \n");
            String selection= input.nextLine();
           
            if(selection != null){
                System.out.print("\033[H\033[2J");
                dashboard();
            }
                       
    }


    public static void main(String[] args) {
        dashboard();
    }
}
