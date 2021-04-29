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
    String loggedUser = "";
    
    //Main Page Variables
    JFrame frame = null;
    JPanel container = null;
    JPanel panel = null;
    JLabel loggedInLbl = null;
    JLabel usernameLbl = null;
    JLabel dataDispLbl = null;
    JTextArea dataDispTxt = null;
    JLabel connectedWSLbl = null;
    JList connectedWSList = null;
    JButton connectBtn = null;
    JButton downloadBtn = null;
    JButton logOutBtn = null;
    
    //Login Page Variables
    JFrame logFrame = null;
    JPanel logContainer = null;
    JPanel logPanel = null;
    JLabel titleLbl = null;
    JLabel logUsernameLbl = null;
    JTextField logUsernameField = null;
    JLabel passwordLbl = null;
    JPasswordField passwordField = null;
    JLabel confirmPasswordLbl = null;
    JPasswordField confirmPasswordField = null;
    JButton loginBtn = null;
    JButton registerBtn = null;
    JButton changeToRegisterPage = null;
    JButton changeTologinPage = null;
    
    public UserClient()
    {
        initLoginPage();
    }
    
    //Create Main Page
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
        
        panel = new JPanel();
        panel.setBackground(new java.awt.Color(32, 36, 69));
        panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        panel.setBounds(10, 10, 280, 70);
        container.add(panel);
        
        loggedInLbl = new JLabel("Logged In as: ");
        loggedInLbl.setForeground(Color.WHITE);
        loggedInLbl.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        
        usernameLbl = new JLabel();               
        usernameLbl.setForeground(Color.WHITE);
        usernameLbl.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        usernameLbl.setText(loggedUser);
              
        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panel2Layout);
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
    
    //Create Login Page
    public void initLoginPage()
    {
        //Creating the Frame     
        logFrame = new JFrame("Login");
        logFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        logFrame.setSize(614, 430);
        logFrame.setLocationRelativeTo(null);
        logFrame.setResizable(false);
        
        logContainer = new JPanel();
        logContainer.setBackground(new java.awt.Color(26, 29, 57));
        logContainer.setLayout(null);
        
        logPanel = new JPanel();
        logPanel.setBackground(new java.awt.Color(32, 36, 69));
        logPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));      
        logPanel.setBounds(0, 0, 614, 70);
        logPanel.setLayout(null);
        logContainer.add(logPanel);
    
        titleLbl = new JLabel("Login");
        titleLbl.setForeground(Color.WHITE);
        titleLbl.setBounds(280, 0, 100, 70);
        titleLbl.setFont(new java.awt.Font("Dialog", 0, 24));
        logPanel.add(titleLbl);
        
        logUsernameLbl = new JLabel("Username");
        logUsernameLbl.setForeground(Color.WHITE);
        logUsernameLbl.setBounds(138, 100, 100, 70);
        logUsernameLbl.setFont(new java.awt.Font("Dialog", 0, 18));
        logContainer.add(logUsernameLbl);
        
        logUsernameField = new JTextField();
        logUsernameField.setForeground(Color.WHITE);
        logUsernameField.setBackground(new java.awt.Color(32, 36, 69));
        logUsernameField.setBounds(240, 120, 250, 30);
        logUsernameField.setFont(new java.awt.Font("Dialog", 0, 14));
        logContainer.add(logUsernameField);
        
        passwordLbl = new JLabel("Password");
        passwordLbl.setForeground(Color.WHITE);  
        passwordLbl.setBounds(140, 150, 100, 70);
        passwordLbl.setFont(new java.awt.Font("Dialog", 0, 18));
        logContainer.add(passwordLbl);
        
        passwordField = new JPasswordField();
        passwordField.setForeground(Color.WHITE);
        passwordField.setBackground(new java.awt.Color(32, 36, 69));
        passwordField.setBounds(240, 170, 250, 30);
        passwordField.setFont(new java.awt.Font("Dialog", 0, 14));
        logContainer.add(passwordField);
        
        confirmPasswordLbl = new JLabel("Confirm Password");
        confirmPasswordLbl.setForeground(Color.WHITE);  
        confirmPasswordLbl.setBounds(70, 200, 150, 70);
        confirmPasswordLbl.setFont(new java.awt.Font("Dialog", 0, 18));
        confirmPasswordLbl.setVisible(false);
        logContainer.add(confirmPasswordLbl);
        
        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setForeground(Color.WHITE);
        confirmPasswordField.setBackground(new java.awt.Color(32, 36, 69));
        confirmPasswordField.setBounds(240, 220, 250, 30);
        confirmPasswordField.setFont(new java.awt.Font("Dialog", 0, 14));
        confirmPasswordField.setVisible(false);
        logContainer.add(confirmPasswordField);
                
        loginBtn = new JButton("Login");
        loginBtn.setForeground(Color.WHITE);
        loginBtn.setBackground(new java.awt.Color(32, 36, 69));
        loginBtn.setFont(new java.awt.Font("Dialog", 0, 24));
        loginBtn.setFocusPainted(false);
        loginBtn.setBounds(245, 300, 130, 30); 
        loginBtn.setVisible(true);
        logContainer.add(loginBtn);
        
        loginBtn.addActionListener(new ActionListener() 
        {
         public void actionPerformed(ActionEvent e) 
         {
            loginBtnActionPerformed(e);
         }
        });
        
        registerBtn = new JButton("Register");
        registerBtn.setForeground(Color.WHITE);
        registerBtn.setBackground(new java.awt.Color(32, 36, 69));
        registerBtn.setFont(new java.awt.Font("Dialog", 0, 24));
        registerBtn.setFocusPainted(false);
        registerBtn.setBounds(245, 300, 130, 30); 
        registerBtn.setVisible(false);
        logContainer.add(registerBtn);
        
        registerBtn.addActionListener(new ActionListener() 
        {
         public void actionPerformed(ActionEvent e) 
         {
            registerBtnActionPerformed(e);
         }
        });
        
        changeToRegisterPage = new JButton("Register");
        changeToRegisterPage.setForeground(Color.WHITE);
        changeToRegisterPage.setBackground(new java.awt.Color(26, 29, 57));
        changeToRegisterPage.setFont(new java.awt.Font("Dialog", 0, 12));
        changeToRegisterPage.setFocusPainted(false);
        changeToRegisterPage.setBounds(245, 330, 130, 30); 
        changeToRegisterPage.setBorderPainted(false);
        changeToRegisterPage.setVisible(true);
        logContainer.add(changeToRegisterPage);
        
        changeToRegisterPage.addActionListener(new ActionListener() 
        {
         public void actionPerformed(ActionEvent e) 
         {
            titleLbl.setText("Register");
            loginBtn.setVisible(false);
            registerBtn.setVisible(true);
            confirmPasswordLbl.setVisible(true);
            confirmPasswordField.setVisible(true);
            changeToRegisterPage.setVisible(false);
            changeTologinPage.setVisible(true);
         }
        });
        
        changeTologinPage = new JButton("Login");
        changeTologinPage.setForeground(Color.WHITE);
        changeTologinPage.setBackground(new java.awt.Color(26, 29, 57));
        changeTologinPage.setFont(new java.awt.Font("Dialog", 0, 12));
        changeTologinPage.setFocusPainted(false);
        changeTologinPage.setBounds(245, 330, 130, 30); 
        changeTologinPage.setBorderPainted(false);
        changeTologinPage.setVisible(false);
        logContainer.add(changeTologinPage);
        
        changeTologinPage.addActionListener(new ActionListener() 
        {
         public void actionPerformed(ActionEvent e) 
         {
            titleLbl.setText("Login");
            loginBtn.setVisible(true);
            registerBtn.setVisible(false);
            confirmPasswordLbl.setVisible(false);
            confirmPasswordField.setVisible(false);
            changeToRegisterPage.setVisible(true);
            changeTologinPage.setVisible(false);
         }
        });
        
        logFrame.getContentPane().add(logContainer);
        logFrame.setVisible(true);
    }
    
    //Login Button - Login Page
    private void loginBtnActionPerformed(ActionEvent e) 
    {                                          
        VerifyLogin();
    }   
    
    //Register Button - Login Page
    private void registerBtnActionPerformed(ActionEvent e) 
    {                                          
        Register();
    } 
    
    //Verify Login - Login Page
    public void VerifyLogin()
    {
        String username = logUsernameField.getText();
        String password = String.valueOf(passwordField.getPassword());
       
        boolean found = false;
        
        try
            {
                File file = new File("user.txt");

                if(file.exists())
                {
                    FileReader reader = new FileReader(file);
                    BufferedReader br = new BufferedReader(reader);
                    String line = br.readLine();              
                    String[] data;
                    String dataName;
                    String dataPassword;

                    while(line != null && found != true)
                    {
                        data = line.split(",");
                        dataName = data[0];
                        dataPassword = data[1];

                        if(dataName.equals(username) == true && dataPassword.equals(password) == true)
                        {
                            found = true;
                        }
                        line = br.readLine();
                    }
                    br.close();    
                    
                    if(found == true)
                    {
                        JOptionPane.showMessageDialog(null, "Login Successful!");
                        loggedUser = username;
                        logFrame.dispose();
                        initMainPage();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Login Failed!");
                    }       
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "No Users Found on the Database!");
                } 

            }catch (IOException e) {System.out.println("An error occurred.");}
        
    }
    
    //Clear Inputs - Login Page
    public void clearInputs()
    {
        logUsernameField.setText("");
        passwordField.setText("");
        confirmPasswordField.setText("");
    }
    
    //Register - Login Page
    public void Register()
    {
        String username = logUsernameField.getText();
        String password = String.valueOf(passwordField.getPassword());
        String confirmPassword = String.valueOf(confirmPasswordField.getPassword());
             
        boolean found = false;
        
        if(password.equals(confirmPassword) == true)
        {
            try
            {
                File file = new File("user.txt");

                if(file.exists())
                {
                    FileReader reader = new FileReader(file);
                    BufferedReader br = new BufferedReader(reader);
                    String line = br.readLine();              
                    String[] data;
                    String dataName;

                    while(line != null && found != true)
                    {
                        data = line.split(",");
                        dataName = data[0];

                        if(dataName.equals(username) == true)
                        {
                            found = true;                    
                        }

                        line = br.readLine();
                    }
                    br.close();

                    if(found != true)
                    {
                        try
                        {                    
                            FileWriter fr = new FileWriter("user.txt", true); //Set true for append mode
                            PrintWriter pr = new PrintWriter(fr);
                            pr.println(username + "," + password);  //New line
                            pr.close();  
                            JOptionPane.showMessageDialog(null, "User Registered Successfully!");
                            
                            clearInputs();
                            
                            titleLbl.setText("Login");
                            loginBtn.setVisible(true);
                            registerBtn.setVisible(false);
                            confirmPasswordLbl.setVisible(false);
                            confirmPasswordField.setVisible(false);
                            changeToRegisterPage.setVisible(true);
                            changeTologinPage.setVisible(false);

                        }catch (IOException e) {System.out.println("An error occurred.");}   
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "User Already Exists!");
                        clearInputs();
                    }                          
                }
                else
                {
                    try
                    {                    
                        FileWriter fr = new FileWriter("user.txt", true); //Set true for append mode
                        PrintWriter pr = new PrintWriter(fr);
                        pr.println(username + "," + password);  //New line
                        pr.close();
                        JOptionPane.showMessageDialog(null, "User Registered Successfully!");  
                        
                        clearInputs();
                        
                        titleLbl.setText("Login");
                        loginBtn.setVisible(true);
                        registerBtn.setVisible(false);
                        confirmPasswordLbl.setVisible(false);
                        confirmPasswordField.setVisible(false);
                        changeToRegisterPage.setVisible(true);
                        changeTologinPage.setVisible(false);

                    }catch (IOException e) {System.out.println("An error occurred.");}   
                } 

            }catch (IOException e) {System.out.println("An error occurred.");}
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Passwords do not match!");
        }
       
    } 
    
    public static void main(String args[])
    {
        /* Create and display the form */        
        new UserClient();
    }
    
     //Connect to Socket - Main Page
    private void connectBtnActionPerformed(ActionEvent e) 
    {            
        connectBtn.setEnabled(false);
        socket();
    }    
    
    //Download data - Main Page
    private void downloadBtnActionPerformed(ActionEvent e) 
    {                                          
        // TODO add your handling code here:
        
    }    
    
    //Exit - Main Page
    private void logOutBtnActionPerformed(ActionEvent e) 
    {                                          
        // TODO add your handling code here:
        System.exit(0);
    }   
    
    //Socket Handler - Main Page
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
        catch(Exception IOException)
        {
            JOptionPane.showMessageDialog(null, "Server Is Offline!");
            connectBtn.setEnabled(true);
        }
    }
}
