/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss_project;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.util.Scanner;
import java.io.*;  
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Kiko
 */
public class Login {
     
    public Login()
    {
        initLoginPage();
    }
    
//Login Page Variables
    JFrame logFrame = null;
    JPanel logContainer = null;
    JPanel panel1 = null;
    JLabel titleLbl = null;
    JLabel usernameLbl = null;
    JTextField usernameField = null;
    JLabel passwordLbl = null;
    JPasswordField passwordField = null;
    JLabel confirmPasswordLbl = null;
    JPasswordField confirmPasswordField = null;
    JButton loginBtn = null;
    JButton registerBtn = null;
    JButton changeToRegisterPage = null;
    JButton changeTologinPage = null;
    
    /**
     *
     */
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
        
        panel1 = new JPanel();
        panel1.setBackground(new java.awt.Color(32, 36, 69));
        panel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));      
        panel1.setBounds(0, 0, 614, 70);
        panel1.setLayout(null);
        logContainer.add(panel1);
    
        titleLbl = new JLabel("Login");
        titleLbl.setForeground(Color.WHITE);
        titleLbl.setBounds(280, 0, 100, 70);
        titleLbl.setFont(new java.awt.Font("Dialog", 0, 24));
        panel1.add(titleLbl);
        
        usernameLbl = new JLabel("Username");
        usernameLbl.setForeground(Color.WHITE);
        usernameLbl.setBounds(138, 100, 100, 70);
        usernameLbl.setFont(new java.awt.Font("Dialog", 0, 18));
        logContainer.add(usernameLbl);
        
        usernameField = new JTextField();
        usernameField.setForeground(Color.WHITE);
        usernameField.setBackground(new java.awt.Color(32, 36, 69));
        usernameField.setBounds(240, 120, 250, 30);
        usernameField.setFont(new java.awt.Font("Dialog", 0, 14));
        logContainer.add(usernameField);
        
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
            Login();
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
             Register();
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
    
    public static void main(String args[])
    {
        /* Create and display the form */
        new Login();
        //socket();
    }
    
    public static void VerifyLogin(String username, String password){
    Scanner check;
    boolean found = false;
    String tempUsername = "";
    String tempPassword = "";

    try{
        check = new Scanner(new File("user.txt"));
        check.useDelimiter("[,\n]");

        while(check.hasNext() && !found){
            tempUsername = check.next();
            tempPassword = check.next();

            if(tempUsername.trim().equals(username)&& tempPassword.trim().equals(password)){
                found=true;  
                System.out.println("Login successful!");
            }
            else{
                System.out.println("Login FAILED!");
            }
        }
    check.close();
        }
    catch (IOException e) {
        System.out.println("An error occurred.");
        }
    }

    
    public void Login()
    {
        String username = usernameField.getText();
        String password = passwordField.getText();
        VerifyLogin(username, password);
        
    }
    
    public void Register() 
    {
        String password = passwordField.getText();  // Read user input
        String username = usernameField.getText();  // Read user input
        VerifyReg(username,password);
    }
    
    public static void VerifyReg(String username,String password)
    {
    Scanner check;
    boolean found = false;
    String tempUsername = "";

    try{
        check = new Scanner(new File("user.txt"));
        check.useDelimiter("[,\n]");

            while(check.hasNext() && !found){
                tempUsername = check.next();

                if(tempUsername.trim().equals(username)){
                    found=true;  
                    System.out.println("User already exists");
                }
            else{
                try{
                    FileWriter Data = new FileWriter("user.txt",true);
                    Data.write(username+",");
                    Data.write(password);
                    System.out.println("Data Saved");
                    }
                catch (IOException e) {
                    System.out.println("An error occurred.");
                    }
                }
            }
        check.close();
        } catch (FileNotFoundException ex) {
            System.out.println("An error occurred.");
        }
    }
}
