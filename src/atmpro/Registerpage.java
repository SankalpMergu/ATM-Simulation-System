package atmpro;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Button;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;

import com.toedter.calendar.JDateChooser;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Registerpage extends JFrame {

	private JPanel contentPane;
	private JTextField firstname;
	private JTextField middlename;
	private JTextField lastname;
	private JTextField email;
	private JTextField address;
	private JPasswordField passwordField;
	private JTextField phoneno;
	private JTextField balance;
	private JRadioButton radio1;
	private JRadioButton radio2;
	private JDateChooser dob;
	 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registerpage frame = new Registerpage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Registerpage() {
		setFont(new Font("Times New Roman", Font.BOLD, 20));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 394, 683);
		contentPane = new JPanel();
		contentPane.setToolTipText("Please Enter No");
		
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REGISTER");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(136, 11, 102, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First Name :");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(36, 70, 82, 14);
		contentPane.add(lblNewLabel_1);
		
		firstname = new JTextField();
		firstname.setBounds(160, 66, 190, 24);
		contentPane.add(firstname);
		firstname.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Middle Name :");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2.setBounds(36, 118, 102, 14);
		contentPane.add(lblNewLabel_2);
		
		middlename = new JTextField();
		middlename.setBounds(160, 114, 189, 24);
		contentPane.add(middlename);
		middlename.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Last Name :");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_3.setBounds(36, 165, 102, 14);
		contentPane.add(lblNewLabel_3);
		
		lastname = new JTextField();
		lastname.setBounds(160, 160, 190, 24);
		contentPane.add(lastname);
		lastname.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Gender");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_4.setBounds(36, 204, 64, 14);
		contentPane.add(lblNewLabel_4);
		
		radio1 = new JRadioButton("Male");
		radio1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radio1.isSelected()) {
					 radio2.setSelected(false);
			}
			}
		});
		radio1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		radio1.setBackground(Color.WHITE);
		radio1.setBounds(159, 200, 64, 23);
		contentPane.add(radio1);
		
		radio2 = new JRadioButton("Female");
		radio2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radio2.isSelected()) {
					 radio1.setSelected(false);
			}
			}
		});
		radio2.setFont(new Font("Times New Roman", Font.BOLD, 12));
		radio2.setBackground(Color.WHITE);
		radio2.setBounds(241, 200, 109, 23);
		contentPane.add(radio2);
		
		JLabel lblNewLabel_5 = new JLabel("Email Address :");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_5.setBounds(36, 239, 113, 14);
		contentPane.add(lblNewLabel_5);
		
		email = new JTextField();
		email.setBounds(159, 234, 190, 24);
		contentPane.add(email);
		email.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Password :");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_6.setBounds(36, 283, 82, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Address :");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_7.setBounds(36, 329, 71, 14);
		contentPane.add(lblNewLabel_7);
		
		address = new JTextField();
		address.setBounds(160, 324, 190, 24);
		contentPane.add(address);
		address.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Date Of Birth :");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_8.setBounds(36, 372, 102, 14);
		contentPane.add(lblNewLabel_8);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(160, 281, 190, 24);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_9 = new JLabel("Phone No :");
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_9.setBounds(36, 415, 82, 14);
		contentPane.add(lblNewLabel_9);
		
		phoneno = new JTextField();
		phoneno.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(!Character.isDigit(e.getKeyChar())) {
					e.consume();
				}
			}
		});
		phoneno.setBounds(160, 413, 190, 24);
		contentPane.add(phoneno);
		phoneno.setColumns(10);
		
		JCheckBox atc = new JCheckBox("Accept Terms And Conditions");
		atc.setBackground(Color.WHITE);
		atc.setFont(new Font("Times New Roman", Font.BOLD, 12));
		atc.setBounds(36, 502, 202, 23);
		contentPane.add(atc);
		
 
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			private String bdate;

			public void actionPerformed(ActionEvent e) {
				String Gender;
			String fname =	firstname.getText();
			String mname =	middlename.getText();
			String lname =	lastname.getText();
			String remail =	email.getText();
			String raddress =	address.getText();
			String rphoneno =	phoneno.getText();
			String rpass =	String.valueOf(passwordField.getPassword());
			String rbalance =	balance.getText();
			if(radio1.isSelected()) {
			  Gender = "Male";
			}
			else {
				  Gender = "Female";
			}
			 
//			String bda =	dateChooser.getDate();
// 		  	SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
// bdate = dateformat.format(dob.getDate());
 
	 			 if(verifyfields()) {
	 				 if(!checkuser()) {
	 			String INSERT_USERS_SQL = "INSERT INTO resgisteruser" +
			            "  (id, firstname,middlename, last,Gender,email,password,Address,DOB,phoneno,Balance) VALUES " +
			            " (?,?,?,?,?,?,?,?,?,?,?);";
 
				 int i=0;
				 i++;
	 			try (Connection connection = DriverManager
			            .getConnection("jdbc:mysql://localhost:3306/emploee", "root", "root");

			            // Create a statement using connection object
			            PreparedStatement ps = connection.prepareStatement(INSERT_USERS_SQL)) {
	 				ps.setInt(1, i);
	 				 ps.setString(2,fname );
                   ps.setString(3, mname );
                    ps.setString(4, lname );
                    ps.setString(5, Gender);
                    ps.setString(6, remail );
                    ps.setString(7, rpass);
                    ps.setString(8, raddress);
                    ps.setString(9, "55" );
                    ps.setString(10,rphoneno );
                   
                    ps.setString(11, rbalance);
                    			            

			           // System.out.println(preparedStatement);
                    int l = ps.executeUpdate();
                   if (l > 0) {
                   	firstname.setText("");
                   	middlename.setText("");
                   	lastname.setText("");
                        address.setText("");
                        email.setText("");
                        passwordField.setText("");
                        phoneno.setText("");
                      balance.setText("");
                        
                       JOptionPane.showMessageDialog(btnNewButton,"Account Created Successful");
                       dispose();
                       Loginpage frame = new Loginpage();
   					frame.setVisible(true);
                   } else {
                   	 JOptionPane.showMessageDialog(btnNewButton,"Failed To Add New Customer");
                        
                   }
                   ps.close();
			           connection.close();

			        } catch (Exception exception) {
                     exception.printStackTrace();
                      
 		                }
			        
   			 }
 	 		 else {
 	 				JOptionPane.showMessageDialog(btnNewButton,"This email is already exist,choose another one ");
 	 			 }
	 			 }
	            
			
			 
				 
			}//acion

			private boolean verifyfields() {
				String Gender;
				String fname =	firstname.getText();
				String mname =	middlename.getText();
				String lname =	lastname.getText();
				String remail =	email.getText();
				String raddress =	address.getText();
				String rphoneno =	phoneno.getText();
				String rpass =	String.valueOf(passwordField.getPassword());
				String rbalance =	balance.getText();
				
				if(radio1.isSelected()) {
				  Gender = "Male";
				}
				else {
					  Gender = "Female";
				} 
				
if (fname.isEmpty() || lname.isEmpty() ||remail.isEmpty() || raddress.isEmpty() || rphoneno.isEmpty() || rpass.isEmpty() || rbalance.isEmpty() ) {
	                
	                JOptionPane.showMessageDialog(btnNewButton,"Please Fill Up Everything" );
	                return false;
					
	            }else if(rphoneno.length() != 10 || rphoneno.length() > 10 ) { 
            	     
            	     JOptionPane.showMessageDialog(btnNewButton,"Phone Number should be of Length 10 ");
            	     return false;
            		 }
	            else   if( Integer.parseInt(rbalance) <= 500) { 
 		            JOptionPane.showMessageDialog(btnNewButton,"Minimum Balance Requirement Is 500 Rs.");
 		           return false;
 		           }
               else  if(!atc.isSelected()) {
					 JOptionPane.showMessageDialog(btnNewButton,"Please Accept Terms And Conditions");
					 return false;
				 }else {
					 return true; 
				 }
			}

			
			
 		private boolean checkuser() {
 				String userName =email.getText();
 			String INSERT_USERS_SQL = "select *  from resgisteruser where email =?";
 				 try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/emploee", "root", "root");
 						PreparedStatement ps = connection.prepareStatement(INSERT_USERS_SQL)){    
 				        ps.setString(1,userName);	
 			           ResultSet x = ps.executeQuery();
 				           if (x.next()) {
 		                          return true;
 		 	                    }
 						}
 				  catch (Exception exception) {
 					 
                      exception.printStackTrace();
                      
                      
  		                }
 				 return false;
 			}
			
		 
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(255, 69, 0));
		btnNewButton.setBounds(49, 549, 89, 30);
		contentPane.add(btnNewButton);
		
		Button button = new Button("Clear");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstname.setText("");
				lastname.setText("");
				middlename.setText("");
				email.setText("");
				address.setText("");
				phoneno.setText(" ");
				passwordField.setText("");
				
			}
		});
		button.setFont(new Font("Times New Roman", Font.BOLD, 12));
		button.setForeground(new Color(255, 255, 255));
		button.setBackground(new Color(154, 205, 50));
		button.setBounds(246, 549, 82, 30);
		contentPane.add(button);
		
		JLabel s = new JLabel("Balance :");
		s.setFont(new Font("Times New Roman", Font.BOLD, 15));
		s.setBounds(36, 460, 82, 14);
		contentPane.add(s);
		
		balance = new JTextField();
		balance.setToolTipText("Please enter no");
		balance.setBounds(160, 456, 190, 24);
		contentPane.add(balance);
		balance.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Already Have Account ?  ");
		lblNewLabel_10.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_10.setBounds(78, 603, 130, 14);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Click Here");
		lblNewLabel_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				Loginpage frame = new Loginpage();
				frame.setVisible(true);
			}
		});
		lblNewLabel_11.setForeground(new Color(0, 0, 255));
		lblNewLabel_11.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_11.setBounds(221, 603, 64, 14);
		contentPane.add(lblNewLabel_11);
		
		dob = new JDateChooser();
		dob.setBounds(160, 372, 190, 20);
		contentPane.add(dob);
		
	
// 		setUndecorated(true);
	}
}
