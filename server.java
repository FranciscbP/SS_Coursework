package ss_project;
import java.net.*;
import java.io.*;  



public class server 
{        
    public static void main(String[] args) throws IOException
    {        
        ServerSocket server = new ServerSocket(9090);    
        System.out.println("Server Running...");  
        while (true) 
        {
            Socket client = server.accept();
            System.out.println("Client Connected: " + client);
            
            DataInputStream dataFromClient = new DataInputStream(client.getInputStream());
            DataOutputStream dataToClient = new DataOutputStream(client.getOutputStream());
            
            int clientType = dataFromClient.readInt();
            
            Thread tr = new ClientHandler(client,clientType);
            tr.start();
            SendData(dataFromClient, dataToClient);
        }
    }
public static void SendData(DataInputStream dataFromClient,DataOutputStream dataToClient){
        while (true) { 
            try{
                int Temp = dataFromClient.readInt();
                int pressure = dataFromClient.readInt();
                int humidity = dataFromClient.readInt();
                int windspeed = dataFromClient.readInt();
                int winddirection = dataFromClient.readInt();

                System.out.println("temperature reading is: "+Temp+ "C");
                System.out.println("Barometric pressure reading is: 10"+pressure+"hPa");
                System.out.println("Relative humidity reading is: "+humidity+"%");
                System.out.println("Wind Speed is: "+windspeed+"mph");
                System.out.println("Wind direction is: "+winddirection+"degrees");


                dataToClient.writeInt(Temp);
                dataToClient.flush();

                dataToClient.writeInt(pressure);
                dataToClient.flush();

                dataToClient.writeInt(humidity);
                dataToClient.flush();

                dataToClient.writeInt(windspeed);
                dataToClient.flush();

                dataToClient.writeInt(winddirection);
                dataToClient.flush();
                
                Thread.sleep(5 * 1000);
            }
        catch(Exception IOException){}
    }
}

static class ClientHandler extends Thread
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
        
            if(clientType == 1)
            {
                dataToClient.writeUTF("Server: Connected as User");    
            }
            else
            {
                dataToClient.writeUTF("Server: Connected as Weather Station");            
            }
        }
        catch(IOException e){}                    
    }
}
}

