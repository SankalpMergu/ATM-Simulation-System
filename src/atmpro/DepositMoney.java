package atmpro;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DepositMoney extends JFrame {

	private JPanel contentPane;
	private JTextField depositmoney;
//	private String userID;
//	private String username;
	private String userID ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DepositMoney frame = new DepositMoney();
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
	public DepositMoney() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(76, 67, 62, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("The");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(138, 67, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Amount");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(200, 67, 89, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("You");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(310, 67, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Want");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_4.setBounds(126, 108, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("To");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_5.setBounds(188, 108, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Deposit");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(244, 110, 72, 14);
		contentPane.add(lblNewLabel_6);
		
		depositmoney = new JTextField();
		depositmoney.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(!Character.isDigit(e.getKeyChar())) {
					e.consume();
				}
			}
		});
		depositmoney.setHorizontalAlignment(SwingConstants.CENTER);
		depositmoney.setFont(new Font("Times New Roman", Font.BOLD, 15));
		depositmoney.setBounds(138, 159, 178, 28);
		contentPane.add(depositmoney);
		depositmoney.setColumns(10);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
		 
			public void actionPerformed(ActionEvent e) {
				   try {
			            if (depositmoney.getText().isEmpty() || Integer.parseInt(depositmoney.getText()) < 0) {
			               
			                JOptionPane.showMessageDialog(btnNewButton, "Please Enter A Valid Amount");
			            } else {
			            	String INSERT_USERS_SQL = "select *  from resgisteruser where email =? ";
							 try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/emploee", "root", "root");
									PreparedStatement ps = connection.prepareStatement(INSERT_USERS_SQL)){    
							        ps.setString(1,userID);
							         
						           ResultSet x = ps.executeQuery();
						           while (x.next()) {
						        	   int NewBalance = (x.getInt("Balance") + Integer.parseInt(depositmoney.getText()));
						        	   PreparedStatement   psp = connection.prepareStatement("UPDATE resgisteruser SET Balance =? WHERE email = '" + userID + "'");
					                    psp.setInt(1, NewBalance);
					                    psp.executeUpdate();
					                    JOptionPane.showMessageDialog(btnNewButton, "despo cash");
										 
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
				   depositmoney.setText("");
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 128));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(76, 209, 115, 28);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				 
			}
			
		});
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_1.setBounds(278, 209, 89, 27);
		contentPane.add(btnNewButton_1);
		setUndecorated(true);
		
	}
	 

	public void getUserID(String userID2) {
		 
		userID = userID2;
	}
}
