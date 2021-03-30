package ss_project;
import java.net.*;
import java.io.*;  

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
                        
    }
}