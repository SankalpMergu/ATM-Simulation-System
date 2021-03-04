package atmpro;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class WithDraw extends JFrame {

	private JPanel contentPane;
	private JTextField withdraw;
	private String userID1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WithDraw frame = new WithDraw();
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
	public WithDraw() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 50, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(null);
		panel.setBounds(42, 36, 358, 167);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(35, 32, 68, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("The");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(113, 32, 46, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Amount");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(184, 32, 76, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("You");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(270, 32, 46, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Want");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_4.setBounds(96, 71, 46, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("To");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(147, 71, 46, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Withdraw");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_6.setBounds(194, 73, 81, 14);
		panel.add(lblNewLabel_6);
		
		withdraw = new JTextField();
		withdraw.setHorizontalAlignment(SwingConstants.CENTER);
		withdraw.setFont(new Font("Times New Roman", Font.BOLD, 12));
		withdraw.setBounds(97, 108, 178, 30);
		panel.add(withdraw);
		withdraw.setColumns(10);
		
		JButton btnNewButton = new JButton("WithDraw");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		            if (withdraw.getText().isEmpty() || Integer.parseInt(withdraw.getText()) < 0) {
		               
		                JOptionPane.showMessageDialog(btnNewButton, "Please Enter A Valid Amount");
		            } else {
		            	String INSERT_USERS_SQL = "select *  from resgisteruser where email =? ";
						 try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/emploee", "root", "root");
								PreparedStatement ps = connection.prepareStatement(INSERT_USERS_SQL)){    
						        ps.setString(1,userID1);
						         
					           ResultSet x = ps.executeQuery();
					           while (x.next()) {
					        	   if(x.getInt("Balance") <= 0 ) {
					        		   JOptionPane.showMessageDialog(btnNewButton, "Please Deposit Money You Have Low Balance ");
					        	   }else {
					        	   int NewBalance = (x.getInt("Balance") - Integer.parseInt(withdraw.getText()));
					        	   PreparedStatement   psp = connection.prepareStatement("UPDATE resgisteruser SET Balance =? WHERE email = '" + userID1 + "'");
				                    psp.setInt(1, NewBalance);
				                    psp.executeUpdate();
				                    JOptionPane.showMessageDialog(btnNewButton, "Please Collect Your Money ");
					        	   }
									 
				 	                    }
					            
					           connection.close();
								}
						  catch (Exception exception) {
							 
		                     exception.printStackTrace();
		                     
		                     
		 		                }  
		            }
		        } catch (NumberFormatException ec) {
		             
		            JOptionPane.showMessageDialog(btnNewButton, "Invalid Database Or Number Format");
		        }
				withdraw.setText("");
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 205));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton.setBounds(64, 214, 102, 36);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton_1.setBounds(263, 215, 89, 29);
		contentPane.add(btnNewButton_1);
		setUndecorated(true);
	}

	public void getuserID1(String userID) {
		userID1 = userID;
	}
}
