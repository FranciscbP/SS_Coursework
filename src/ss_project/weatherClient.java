package ss_project;
import java.net.*;
import java.io.*;  
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.util.*;

public class weatherClient 
{
    public static void main(String[] args) throws IOException
    {           
               
        
        //Identify Client as Weather Statition
        int clientType = 2;
                
        //Connect to server
        Socket server = new Socket("localhost",9090);
        DataInputStream dataFromServer = new DataInputStream(server.getInputStream());
        DataOutputStream dataToServer = new DataOutputStream(server.getOutputStream());
        
        //Send to Server
        dataToServer.writeInt(clientType);
        dataToServer.flush();
        
        //Receive from Server
        String dataReceived = dataFromServer.readUTF();
        System.out.println(dataReceived);
        
        genData(dataToServer);
    } 
public static void genData(DataOutputStream dataToServer){
    try{
        while (true) {
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
        
        System.out.println("temperature reading is: "+Temp+ "C");
        System.out.println("Barometric pressure reading is: 10"+pressure+"hPa");
        System.out.println("Relative humidity reading is: "+humidity+"%");
        System.out.println("Wind Speed is: "+windspeed+"mph");
        System.out.println("Wind direction is: "+winddirection+"degrees");
        System.out.println("Rain Level is: "+rainlevel+"mm");
        System.out.println("Solar radiation readings: "+radiation+"W/m2");
        System.out.println("\n");
        
        dataToServer.writeInt(Temp);
        dataToServer.flush();
        
        dataToServer.writeInt(pressure);
        dataToServer.flush();
        
        dataToServer.writeInt(humidity);
        dataToServer.flush();
        
        dataToServer.writeInt(windspeed);
        dataToServer.flush();
        
        dataToServer.writeInt(winddirection);
        dataToServer.flush();
        
        Thread.sleep(5 * 1000);
            }
    }   
    catch(Exception IOException){}
}
}
