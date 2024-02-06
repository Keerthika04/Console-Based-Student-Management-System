/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sms;
import java.sql.*;
import java.util.Scanner;

public class SMS {
    private static DB_Connection DB_connection = DB_Connection.get_Instance();
    
    //title
    public static void title(){
        System.out.println("\n -------------------------------------------------------");
        System.out.println(" | Welcome to Developer Stack Student Managment System |");  
        System.out.println(" -------------------------------------------------------\n");
    }
    
    //Login
    public static void login()throws Exception {
        title();
        Scanner input = new Scanner(System.in); 
        System.out.println("                   ----------------");
        System.out.println("                   |     Login     |");  
        System.out.println("                   ----------------\n");
        
        System.out.print("    Enter your username : ");
        String username = input.nextLine();
        System.out.print("    Enter your password : ");
        String password = input.nextLine();
        
        try(Connection con = DB_connection.dbConnection()){
          CallableStatement cs = con.prepareCall("call User_Authentication(?,?)");
          cs.setString(1, username);
          cs.setString(2, password);
          
          
          ResultSet rs = cs.executeQuery();
           
          if( rs.next() && (rs.getString(2)) != null){     
              dashboard();
          }else{
              System.out.print("\033[H\033[2J");
              System.out.flush();
              System.out.println("    Invalid username or password, Try Again!\n");
              login();
          }
            
        }catch(Exception e){
            System.out.println("Error:" + e);
        } 
        
    }
    
    //dashboard
    public static void dashboard() throws Exception{
        System.out.print("\033[H\033[2J");

        title();
        Scanner input = new Scanner(System.in);    
        System.out.println("    1 -> view all Students");
        System.out.println("    2 -> Search Student");
        System.out.println("    3 -> Save new Student");
        System.out.println("    4 -> Edit Student");
        System.out.println("    5 -> Remove Student");
        System.out.println("    6 -> Log Out \n");

        System.out.print("    Enter Your Choice : ");
        int choice = input.nextInt();
        System.out.println(choice);

        switch (choice) {
            case 1:
                System.out.print("\033[H\033[2J");
                title();
                viewAllStudents();
                break;
            case 2:
                System.out.print("\033[H\033[2J");
                title();
                searchStudent();
                break;
            case 3:
                System.out.print("\033[H\033[2J");
                title();
                saveStudent();
                break;    
            case 4:
                System.out.print("\033[H\033[2J");
                title();
                //searchStudent();
                break;    
       
            case 5:
                System.out.print("\033[H\033[2J");
                title();
                //removeStudent();
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
    
    //View all students
    public static void viewAllStudents() throws Exception{

        System.out.println("                   --------------------");
        System.out.println("                   | View All Student |");  
        System.out.println("                   --------------------\n");

        String query = "Select * from Students;";
        try(Connection con = DB_connection.dbConnection()){
            
          Statement st = con.createStatement();
          ResultSet rs = st.executeQuery(query);
          
          while(rs.next()){
              for(int i =1; i<=6;i++){
                  if(i == 4 || i == 5){
                      System.out.println("    " + rs.getInt(i));
                  }
                  System.out.println("    " + rs.getString(i));
              }
              System.out.println("\n -------------------------------------------------------\n");
          }
            
        }catch(Exception e){
            System.out.println("Error:" + e);
        } 

        Scanner input = new Scanner(System.in);
        System.out.print("\n press any letter to go to dashboard ");
            String selection= input.nextLine();
           
            if(selection != null){
                System.out.print("\033[H\033[2J");
                dashboard();
            }
           
    }
    
    //Search student by Id
    public static void searchStudent() throws Exception{

        Scanner input= new Scanner(System.in);

        System.out.println("                   ------------------");
        System.out.println("                   | Search Student |");  
        System.out.println("                   ------------------\n");

        System.out.print("    Enter the Student ID: ");
        int Id = input.nextInt();
        
        String query = "Select * from Students where Student_id = ?;";
        try(Connection con = DB_connection.dbConnection()){
            
          PreparedStatement ps = con.prepareStatement(query);
          ps.setInt(1, Id);
          
          ResultSet rs = ps.executeQuery();
  
          rs.next();
            System.out.println();
              for(int i =1; i<=6;i++){
                  if(i == 4 || i == 5){
                      System.out.println("      " + rs.getInt(i));
                  }
                  System.out.println("      " + rs.getString(i));
              }
              
          Scanner in = new Scanner(System.in);
          System.out.print("\n press any letter to go to dashboard \n");
           String selection= in.nextLine();
           
            if(selection != null){
                System.out.print("\033[H\033[2J");
                dashboard();
            }
            
        }catch(Exception e){
            System.out.println("Error:" + e);
        } 
           
    }
    
    //save students
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
             int age = input.nextInt();
        System.out.print("    Enter Student Contact Number: ");
             int contactNumber = input.nextInt();
        System.out.print("    Enter Student Gender: ");
            String gender = input.nextLine();
            gender = input.nextLine();
        System.out.print("    Enter Student Department: ");
            String dep = input.nextLine();

        if(name.equals("") || nic.equals("") || age == 0 || contactNumber == 0 || gender.equals("") || dep.equals("")){
            System.out.print("\033[H\033[2J"); 
            title();
            System.out.print("\n    Please fill all of the fields!\n    You missed a field\n\n");
            saveStudent();
        } 
        
        String query = "INSERT INTO Students (Name,NIC,Age,Contact,Gender,Department) VALUES (?,?,?,?,?,?)";
        try(Connection con = DB_connection.dbConnection()){
            
          PreparedStatement ps = con.prepareStatement(query);
          ps.setString(1, name);
          ps.setString(2, nic);
          ps.setInt(3, age);
          ps.setInt(4, contactNumber);
          ps.setString(5, gender);
          ps.setString(6, dep);
          
            int rs = ps.executeUpdate();
  
            if(rs>0){
                Scanner in = new Scanner(System.in);
          
                System.out.print("\n Successfully Saved!!!\n To Check Press 'y' or press any letter to go to dashboard: ");
                 String selection= in.nextLine();
                 if((selection.toLowerCase()).equals("y")){
                     viewAllStudents();
                 }else{
                     dashboard();
                 }
            }
            
        }catch(Exception e){
            System.out.println("Error:" + e);
        } 

    }
    
    public static void main(String[] args) throws Exception {
        login();
    }
    
}
