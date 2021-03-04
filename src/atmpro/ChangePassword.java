package atmpro;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class ChangePassword extends JFrame {

	private JPanel contentPane;
	private String userid2;
	private JPasswordField newpassword;
	private JPasswordField confirmpassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangePassword frame = new ChangePassword();
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
	public ChangePassword() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New Password :");
		lblNewLabel.setForeground(new Color(0, 255, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(38, 101, 121, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Confirm Password :");
		lblNewLabel_1.setForeground(new Color(0, 255, 0));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setBounds(38, 174, 121, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Enter");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2.setBounds(59, 36, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Your");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_3.setBounds(132, 36, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Password");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(199, 36, 62, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Below :");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(296, 37, 62, 14);
		contentPane.add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("Ok");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String INSERT_USERS_SQL = "select *  from resgisteruser where email =? ";
				 try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/emploee", "root", "root");
						PreparedStatement ps = connection.prepareStatement(INSERT_USERS_SQL)){    
				        ps.setString(1,userid2);
				         
			           ResultSet x = ps.executeQuery();
			           while (x.next()) {
			        	   if(String.valueOf(newpassword.getPassword()).equals(String.valueOf(confirmpassword.getPassword())) ) {
			        		   String NewPassword =  String.valueOf(newpassword.getPassword());
				        	   PreparedStatement   psp = connection.prepareStatement("UPDATE resgisteruser SET password =? WHERE email = '" + userid2 + "'");
			                    psp.setString(1, NewPassword);
			                    psp.executeUpdate();
			        		   JOptionPane.showMessageDialog(btnNewButton, "Your Password Is Changed");
			        	   }else {
			        	  
		                    JOptionPane.showMessageDialog(btnNewButton, "Entered Passwords are not Equal");
			        	   }
							 
		 	                    }
			            
			           connection.close();
						}
				  catch (Exception exception) {
					 
                    exception.printStackTrace();
                    
                    
		                }  
			}
		});
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(75, 221, 89, 29);
		contentPane.add(btnNewButton);
		
		newpassword = new JPasswordField();
		newpassword.setBorder(null);
		newpassword.setHorizontalAlignment(SwingConstants.CENTER);
		newpassword.setFont(new Font("Times New Roman", Font.BOLD, 12));
		newpassword.setBounds(177, 99, 165, 29);
		contentPane.add(newpassword);
		
		confirmpassword = new JPasswordField();
		confirmpassword.setBorder(null);
		confirmpassword.setFont(new Font("Times New Roman", Font.BOLD, 12));
		confirmpassword.setHorizontalAlignment(SwingConstants.CENTER);
		confirmpassword.setBounds(177, 165, 165, 29);
		contentPane.add(confirmpassword);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBounds(241, 221, 89, 26);
		contentPane.add(btnNewButton_1);
		setUndecorated(true);
	}

	public void getuserid2(String userID) {
		 userid2 = userID;
		
	}
}
