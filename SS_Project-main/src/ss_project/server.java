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
            int clientType = dataFromClient.readInt();
                                
            Thread tr = new ClientHandler(client,clientType);
            tr.start();           
        }
    }
}

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

