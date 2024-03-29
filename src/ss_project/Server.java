package ss_project;
import java.net.*;
import java.io.*;  
import java.util.*;

public class Server 
{      
    //Variables
    int wsCounter = 0; 
    Vector<Integer> weatherStations = new Vector<Integer>();
    
    //Weather Station Data
    int maximumWeatherStations = 20;
    int[][] weatherStationData = new int[maximumWeatherStations][8];
       
    
    public Server()
    {
        runServer();
    }
    
    public static void main(String[] args) throws IOException
    {    
        new Server();
    }
    
    public void runServer()
    {
        try
        {
            //Start Socket Server
            ServerSocket server = new ServerSocket(9090);    
            System.out.println("Server Running...");  
            
            //Accepting Clients Continuously 
            //Star new Thread for Each new Client
            while (true) 
            {
                Socket client = server.accept();
                System.out.println("Client Connected: " + client);

                DataInputStream dataFromClient = new DataInputStream(client.getInputStream());

                int clientType = dataFromClient.readInt();

                Thread tr = new ClientHandler(client,clientType);
                tr.start();
            }
            
        }catch (IOException e) {System.out.println("An error occurred.");}
    }
    
    //Thread Runner
    class ClientHandler extends Thread
    {
        Socket client;
        int clientType;

        public ClientHandler(Socket _client,int _clientType) {
            client = _client;
            clientType = _clientType;
        }

        public void run() 
        {
            try
            {
                DataOutputStream dataToClient = new DataOutputStream(client.getOutputStream());

                //If Client Type = 1 then Client = User
                //Else Client Type = 2 then Client = Weather Station
                if(clientType == 1)
                {
                    //Handshake
                    dataToClient.writeUTF("Server -> Connected as User");
                    
                    //Receive Data from User Client Continuously 
                    while(true)
                    {
                        DataInputStream dataFromClient = new DataInputStream(client.getInputStream());                        
                        String clientMessage = dataFromClient.readUTF();

                        //Request From User Client to get connected Weather Stations
                        if(clientMessage.equals("GET_WEATHER_CLIENTS"))
                        {                  
                            dataToClient.writeInt(weatherStations.size()); 
                            dataToClient.flush();
                            
                            for(int count = 0; count < weatherStations.size(); count ++)
                            {
                                dataToClient.writeInt(weatherStations.get(count)); 
                                dataToClient.flush();
                            }
                        }//Request From User Client to get data from expecific connected Weather Station
                        else if(clientMessage.equals("GET_WEATHER_DATA"))
                        {
                            String userName = dataFromClient.readUTF();
                            int getDataID = dataFromClient.readInt();                            
 
                            System.out.println(userName + " -> Get Data from Weather Station: " + getDataID);
                            
                            dataToClient.writeInt(weatherStationData[getDataID - 1][0]); 
                            dataToClient.flush();
                            dataToClient.writeInt(weatherStationData[getDataID - 1][1]); 
                            dataToClient.flush();
                            dataToClient.writeInt(weatherStationData[getDataID - 1][2]); 
                            dataToClient.flush();
                            dataToClient.writeInt(weatherStationData[getDataID - 1][3]); 
                            dataToClient.flush();
                            dataToClient.writeInt(weatherStationData[getDataID - 1][4]); 
                            dataToClient.flush();
                            dataToClient.writeInt(weatherStationData[getDataID - 1][5]); 
                            dataToClient.flush();
                            dataToClient.writeInt(weatherStationData[getDataID - 1][6]); 
                            dataToClient.flush();
                            dataToClient.writeInt(weatherStationData[getDataID - 1][7]); 
                            dataToClient.flush();
                        }
                    }
                }
                else
                {
                    //Generate and send Unique ID to Weather Station
                    
                    wsCounter = wsCounter + 1; 
                    weatherStations.add(wsCounter);
                    
                    dataToClient.writeUTF("Server -> Connected as Weather Station"); 
                    dataToClient.flush();
                    
                    
                    dataToClient.writeInt(wsCounter); 
                    dataToClient.flush();
                   
                    //Get data from Weather Station
                    getWeatherData(client);  
                    
                }
            }
            catch(IOException e){}                    
        }
    }
    
    //Get up-to-date data from Weather Station every 5 seconds and store it on a Bidimensional Array 
    public void getWeatherData(Socket client)
    {        
        while (true) 
        { 
            try{        
                DataInputStream dataFromClient = new DataInputStream(client.getInputStream());
 
                int weatherStationId = dataFromClient.readInt();
                int temperature = dataFromClient.readInt();
                int pressure = dataFromClient.readInt();
                int humidity = dataFromClient.readInt();
                int windSpeed = dataFromClient.readInt();
                int windDirection = dataFromClient.readInt();
                int rainLevel = dataFromClient.readInt();
                int radiation = dataFromClient.readInt();
                
                weatherStationData[weatherStationId - 1][0] = weatherStationId;
                weatherStationData[weatherStationId - 1][1] = temperature;
                weatherStationData[weatherStationId - 1][2] = pressure;
                weatherStationData[weatherStationId - 1][3] = humidity;
                weatherStationData[weatherStationId - 1][4] = windSpeed;
                weatherStationData[weatherStationId - 1][5] = windDirection;
                weatherStationData[weatherStationId - 1][6] = rainLevel;
                weatherStationData[weatherStationId - 1][7] = radiation;     
                
                Thread.sleep(5 * 1000);
                
            }catch(Exception IOException){}
        }
    }
}