package ss_project;
import java.net.*;
import java.io.*; 
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;


public class userClient 
{
    
    public static void main(String[] args) throws IOException
    {    
        //Identify Client as User
        int clientType = 1;
        
        //Connect to server
        Socket server = new Socket("localhost",9090);
        DataInputStream dataFromServer = new DataInputStream(server.getInputStream());
        DataOutputStream dataToServer = new DataOutputStream(server.getOutputStream());
        
        //Send to Server
        dataToServer.writeInt(clientType);
        
        //Receive from Server
        String dataReceived = dataFromServer.readUTF();
        System.out.println(dataReceived);
        
        
        Scanner UserIn = new Scanner(System.in);
        System.out.println("use 'signup' command to save login details or use 'login' to log in. ");
        String command = UserIn.nextLine();
            if ("signup".equals(command)) {
             SignUp();  
            }
            if ("login".equals(command)) {
             login();  
            } 
    }

        
  public static void SignUp() {
    Scanner UserIn = new Scanner(System.in);  // Create a Scanner object
    try {
    FileWriter Data= new FileWriter("C:\\Users\\rocko\\Desktop\\SS_Project-main\\Login.txt");
    
    System.out.println("Enter username");
    String username = UserIn.nextLine();  // Read user input
    Data.write(username+",");
    
    System.out.println("Enter Password");
    String password = UserIn.nextLine();  // Read user input
    Data.write(password);
    
    System.out.println("Password Saved");
    System.out.println("Successfully Saved Login data close and reopen to log in");
    Data.close();
      }
    catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
      }
  }
   public static void VerifyLogin(String username, String password){
       Scanner check;
       boolean found = false;
       String tempUsername = "";
       String tempPassword = "";
       
       try{
           check = new Scanner(new File("C:\\Users\\rocko\\Desktop\\SS_Project-main\\Login.txt"));
           check.useDelimiter("[,\n]");
           
           while(check.hasNext() && !found){
               tempUsername = check.next();
               tempPassword = check.next();
               
               if(tempUsername.trim().equals(username)&& tempPassword.trim().equals(password)){
                   found=true;  
               }
           }
        check.close();
        System.out.println("Login successful!");
       }
    catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
      }
   }
   public static void login() {
       Scanner UserIn = new Scanner(System.in);
       System.out.println("Enter username");
       String username = UserIn.nextLine();
       System.out.println("Enter Password");
       String password = UserIn.nextLine();
       VerifyLogin(username, password);
   }

}



