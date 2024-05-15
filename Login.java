package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
//import java.awt.event.ActionListener;


public class Login extends JFrame implements ActionListener{
    
    JPasswordField Password;
    JTextField tfusername,tfpassword;
    JLabel lblpassword;
    JCheckBox showPassword;
    
    Login(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40, 20, 100, 30);
        add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(150, 20, 150, 30);
        add(tfusername);
        
        lblpassword = new JLabel("Password");
        lblpassword.setBounds(40, 70, 100, 30);
        add(lblpassword);
        
        tfpassword = new JPasswordField();
        tfpassword.setBounds(150, 70, 150, 30);
        add(tfpassword);
        
//        lable_password = new JLabel("Password");
//        lable_password.setBounds(40,70,100,30); 
//        add(lable_password);
//        
//        password = new JPasswordField();
//        password.setBounds(150,70,150,30);
//        add(password);
//        
        showPassword = new JCheckBox("Show Password");
        showPassword.setBounds(140,110,150,30);
        showPassword.addActionListener(this);
        add(showPassword);
     
        
       
        
       
        
        
        
        JButton login = new JButton("LOGIN");
        login.setBounds(170, 170, 150, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
         JButton forgotPassword = new JButton("Forgot Password");
        forgotPassword.setBounds(10,170,140,30);
        forgotPassword.addActionListener(this);
        add(forgotPassword);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 200, 200);
        add(image);
        
       
        
       
        
        
        
        setSize(600, 300);
        setLocation(450, 200);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
               
        
        try {
            String username = tfusername.getText();
            String password = tfpassword.getText();
            
           if(ae.getSource()== showPassword){
               if(showPassword.isSelected()){
                  Password.setEchoChar((char)0);
                
            }else{
                 Password.setEchoChar('*');
            }
         } 
          
            
            Conn c = new Conn();
            String query = "select * from login where username = '"+username+"' and password = '"+password+"'";
            
            ResultSet rs = c.s.executeQuery(query);
            if (rs.next()) {
                setVisible(false);
                new Home();
                
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password");
                setVisible(false);
            }
             
            
            
          
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }  
    
   
    
    
        
    
    
    public static void main(String[] args){
        new Login();
    }
}