package ss_project;
import java.net.*;
import java.io.*;  

public class WeatherClient 
{
    int weatherClientId ;
    int id;
    
    public WeatherClient()
    {
        runClient();
    }
    
    public static void main(String[] args) throws IOException
    {           
                     
        new WeatherClient();
    } 
    
    public void runClient()
    {
        //Identify Client as Weather Statition
        int clientType = 2;             
        
        try
        {
            //Connect to server
            Socket server = new Socket("localhost",9090);
            DataInputStream dataFromServer = new DataInputStream(server.getInputStream());
            DataOutputStream dataToServer = new DataOutputStream(server.getOutputStream());

            //Send to Server
            dataToServer.writeInt(clientType);
            dataToServer.flush();

            //Receive from Server
            String dataReceived = dataFromServer.readUTF();
            int idReceived = dataFromServer.readInt();
            weatherClientId = idReceived;
            
            System.out.println(dataReceived + " - " + weatherClientId);

            //Send Data
            genData(server);
            
        }catch (IOException e) {System.out.println("An error occurred.");}
        
    }
    
    public void genData(Socket server)
    {
        try{         
            while (true) 
            {
                DataOutputStream dataToServer = new DataOutputStream(server.getOutputStream());
                
                System.out.println("Sending Data to Server...");

                //Generate sensor readings
                double tempnum = Math.random() * 37;
                int temperature = (int)tempnum;

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

                dataToServer.writeInt(weatherClientId);
                dataToServer.flush();

                dataToServer.writeInt(temperature);
                dataToServer.flush();

                dataToServer.writeInt(pressure);
                dataToServer.flush();

                dataToServer.writeInt(humidity);
                dataToServer.flush();

                dataToServer.writeInt(windspeed);
                dataToServer.flush();

                dataToServer.writeInt(winddirection);
                dataToServer.flush();

                dataToServer.writeInt(rainlevel);
                dataToServer.flush();

                dataToServer.writeInt(radiation);
                dataToServer.flush(); 
                
                Thread.sleep(5 * 1000);
            }               
        }   
        catch(Exception IOException){System.out.println("Server is Offline!");}
    }
}