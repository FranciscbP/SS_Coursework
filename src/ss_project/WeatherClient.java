package ss_project;
import java.net.*;
import java.io.*;  
import java.util.UUID;
//import java.util.*;

public class weatherClient 
{
    public static void main(String[] args) throws IOException
    {            
        //Generate sensor readings
        double tempnum = Math.random() * 37;
        int Temp = (int)tempnum;

        double pressurenum = Math.random() * 10;
        int pressure = (int)pressurenum;

        double hunum = Math.random() * 100;
        int humidity = (int)hunum;

        double WSnum = Math.random() * 14;
        int windspeed = (int)WSnum;

        double WDnum = Math.random() * 360;
        int winddirection = (int)WDnum;

        double Rlvlnum = Math.random() * 70;
        int rainlevel = (int)Rlvlnum;
        
        double Solarnum = Math.random() * 5;
        int radiation = (int)Solarnum;
        
        //Identify Client as Weather Statition
        int clientType = 2;
        String uniqueID = UUID.randomUUID().toString();
        System.out.println(uniqueID);
                
        //Connect to server
        Socket server = new Socket("localhost",9090);
        DataInputStream dataFromServer = new DataInputStream(server.getInputStream());
        DataOutputStream dataToServer = new DataOutputStream(server.getOutputStream());
        
        //Send to Server
        dataToServer.writeInt(clientType);
        dataToServer.writeUTF(uniqueID);

        //Receive from Server
        String dataReceived = dataFromServer.readUTF();
        System.out.println(dataReceived);    
        
        while (true) 
        {
        dataToServer.writeInt(Temp);
        dataToServer.writeInt(pressure);
        dataToServer.writeInt(humidity);
        dataToServer.writeInt(windspeed);
        dataToServer.writeInt(winddirection);
        dataToServer.writeInt(rainlevel);
        dataToServer.writeInt(radiation);
        }
    }
}
