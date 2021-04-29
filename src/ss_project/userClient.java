/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss_project;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;  
import javax.swing.*;

/**
 *
 * @author Kiko
 */
public class UserClient 
{
    //Variables
    JFrame frame = null;
    JPanel container = null;
    JPanel panel2 = null;
    JLabel loggedInLbl = null;
    JLabel usernameLbl = null;
    JLabel dataDispLbl = null;
    JTextArea dataDispTxt = null;
    JLabel connectedWSLbl = null;
    JList connectedWSList = null;
    JButton connectBtn = null;
    JButton downloadBtn = null;
    JButton logOutBtn = null;
    
    public UserClient()
    {

        initMainPage();
    }
    
    public void initMainPage()
    {
        //Creating the Frame     
        frame = new JFrame("User Client");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(614, 430);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
                
        container = new JPanel();
        container.setBackground(new java.awt.Color(26, 29, 57));
        container.setLayout(null);
        
        panel2 = new JPanel();
        panel2.setBackground(new java.awt.Color(32, 36, 69));
        panel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        panel2.setBounds(10, 10, 280, 70);
        container.add(panel2);
        
        loggedInLbl = new JLabel("Logged In as: ");
        loggedInLbl.setForeground(Color.WHITE);
        loggedInLbl.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        
        usernameLbl = new JLabel();               
        usernameLbl.setForeground(Color.WHITE);
        usernameLbl.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        usernameLbl.setText("KIKO");
              
        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup
        (
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(loggedInLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        panel2Layout.setVerticalGroup
        (
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loggedInLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        
        dataDispLbl = new JLabel("Data Display");
        dataDispLbl.setForeground(Color.WHITE);
        dataDispLbl.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        dataDispLbl.setBounds(25, 70, 200, 70);
        container.add(dataDispLbl);
        
        dataDispTxt = new JTextArea(); 
        dataDispTxt.setBackground(new java.awt.Color(32, 36, 69));
        dataDispTxt.setForeground(Color.WHITE);
        dataDispTxt.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        dataDispTxt.setBounds(10,120, 280, 200);
        dataDispTxt.setEnabled(false);        
        container.add(dataDispTxt);
        
        connectedWSLbl = new JLabel("Connected Weather Stations");
        connectedWSLbl.setForeground(Color.WHITE);
        connectedWSLbl.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        connectedWSLbl.setBounds(325, 70, 300, 70);
        container.add(connectedWSLbl);
        
        connectedWSList = new JList();
        connectedWSList.setBackground(new java.awt.Color(32, 36, 69));
        connectedWSList.setForeground(Color.WHITE);
        connectedWSList.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        connectedWSList.setBounds(310,120, 280, 200);
        connectedWSList.setEnabled(false);        
        container.add(connectedWSList);
        
        connectBtn = new JButton("Connect");
        connectBtn.setFocusPainted(false);
        connectBtn.setBounds(10,335,130,30);
        connectBtn.setForeground(Color.WHITE);
        connectBtn.setBackground(new java.awt.Color(32, 36, 69));
        connectBtn.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        container.add(connectBtn);
        
        connectBtn.addActionListener(new ActionListener() 
        {
         public void actionPerformed(ActionEvent e) 
         {
             connectBtnActionPerformed(e);        
         }
        });
        
        downloadBtn = new JButton("Download");
        downloadBtn.setFocusPainted(false);
        downloadBtn.setBounds(160,335,130,30);
        downloadBtn.setForeground(Color.WHITE);
        downloadBtn.setBackground(new java.awt.Color(32, 36, 69));
        downloadBtn.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        container.add(downloadBtn);
        
        downloadBtn.addActionListener(new ActionListener() 
        {
         public void actionPerformed(ActionEvent e) 
         {
             downloadBtnActionPerformed(e);        
         }
        });
        
        logOutBtn = new JButton("Log Out");
        logOutBtn.setFocusPainted(false);
        logOutBtn.setBounds(460,335,130,30);
        logOutBtn.setForeground(Color.WHITE);
        logOutBtn.setBackground(new java.awt.Color(32, 36, 69));
        logOutBtn.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        container.add(logOutBtn);
        
        logOutBtn.addActionListener(new ActionListener() 
        {
         public void actionPerformed(ActionEvent e) 
         {
            logOutBtnActionPerformed(e);
         }
        });
        
        frame.getContentPane().add(container);
        frame.setVisible(true);
    }
    
    public static void main(String args[])
    {
        /* Create and display the form */
        new UserClient();
        //socket();
    }
    
    private void connectBtnActionPerformed(ActionEvent e) 
    {            
        connectBtn.setEnabled(false);
        socket();
    }    
    
    private void downloadBtnActionPerformed(ActionEvent e) 
    {                                          
        // TODO add your handling code here:
        
    }    
    
    private void logOutBtnActionPerformed(ActionEvent e) 
    {                                          
        // TODO add your handling code here:
        System.exit(0);
    }   
    
    
    public void socket()
    {       
        int clientType = 1;

        try
        {
            //Connect to server
            Socket server = new Socket("localhost",9090);
            DataInputStream dataFromServer = new DataInputStream(server.getInputStream());
            DataOutputStream dataToServer = new DataOutputStream(server.getOutputStream());

            //Send to Server
            dataToServer.writeInt(clientType);

            //Receive from Server
            String dataReceived = dataFromServer.readUTF();
            dataDispTxt.append(dataReceived + "\n");
        }
        catch(Exception IOException){}
    }
}
