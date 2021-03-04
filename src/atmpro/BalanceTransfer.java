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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BalanceTransfer extends JFrame {

	private JPanel contentPane;
	private JTextField receiverid;
	private JTextField transferamt;
	private String userid3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BalanceTransfer frame = new BalanceTransfer();
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
	public BalanceTransfer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBalanceTransfer = new JLabel("Balance Transfer");
		lblBalanceTransfer.setHorizontalAlignment(SwingConstants.CENTER);
		lblBalanceTransfer.setForeground(new Color(255, 255, 255));
		lblBalanceTransfer.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblBalanceTransfer.setBounds(136, 40, 161, 14);
		contentPane.add(lblBalanceTransfer);
		
		JLabel lblNewLabel = new JLabel("Receiver Username :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(31, 93, 130, 14);
		contentPane.add(lblNewLabel);
		
		receiverid = new JTextField();
		receiverid.setBorder(null);
		receiverid.setBounds(187, 91, 170, 25);
		contentPane.add(receiverid);
		receiverid.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Transfer Amount :");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(31, 171, 124, 14);
		contentPane.add(lblNewLabel_1);
		
		transferamt = new JTextField();
		transferamt.setBorder(null);
		transferamt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(!Character.isDigit(e.getKeyChar())) {
					e.consume();
				}
			}
		});
		transferamt.setBounds(187, 167, 170, 25);
		contentPane.add(transferamt);
		transferamt.setColumns(10);
		
		JButton transfer = new JButton("Transfer");
		transfer.addActionListener(new ActionListener() {
			private ResultSet rs;

			public void actionPerformed(ActionEvent e) {
				  
			            if (transferamt.getText().isEmpty() || Integer.parseInt(transferamt.getText()) < 0   || receiverid.getText().isEmpty()) {
			            	JOptionPane.showMessageDialog(transfer, "Please Fill Up Everything Correctly."); 
			            }else {
			            	String INSERT_USERS_SQL = "select *  from resgisteruser where email =? ";
							 try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/emploee", "root", "root");
									PreparedStatement ps = connection.prepareStatement(INSERT_USERS_SQL)){    
							        ps.setString(1,userid3);
							        rs = ps.executeQuery();
							        if (rs.next()) {
					                    
					                    int newbalance = rs.getInt("Balance") - Integer.parseInt(transferamt.getText());
					                    if (newbalance < 0) {
					                    	JOptionPane.showMessageDialog(transfer, "You Dont Have Enough Money To Transfer.");
					                        
					                        transferamt.setText("");
					                        ps.close();
					                        rs.close();
					                    } else {
					                    	PreparedStatement ps3 = connection.prepareStatement("UPDATE resgisteruser SET Balance = ? WHERE email = '" + userid3 + "' ");
					                        ps3.setInt(1, newbalance);
					                        ps3.executeUpdate();
					                        ps3.close();
					                        rs.close();
					                        PreparedStatement ps2 = connection.prepareStatement("SELECT * FROM resgisteruser WHERE email =?");
					                        ps2.setString(1, receiverid.getText());
					                        ResultSet rs2 = ps2.executeQuery();
					                        if (rs2.next()) {
					                            int receivernewbalance = rs2.getInt("Balance") + Integer.parseInt(transferamt.getText());
					                            ps2 = connection.prepareStatement("UPDATE resgisteruser SET Balance =? WHERE email = '" + receiverid.getText() + "' ");
					                            ps2.setInt(1, receivernewbalance);
					                            ps2.executeUpdate();
 					                            ps2.close();
 					                            rs2.close();
					                            JOptionPane.showMessageDialog(transfer, "Transfer Successfull");
					                             
					                            receiverid.setText("");
					                            transferamt.setText("");
					                             
					                        }else {
					                        	JOptionPane.showMessageDialog(transfer,"UserID Invalid , Failed To Transfer.");
					                            
					                            receiverid.setText("");
					                           
					                            PreparedStatement pss = connection.prepareStatement("SELECT * FROM resgisteruser WHERE email =?");
					                            pss.setString(1, userid3);
					                            ResultSet rss = pss.executeQuery(); 

					                            while (rss.next()) {
					                                int addbalance = rss.getInt("Balance") + Integer.parseInt(transferamt.getText());
					                                pss = connection.prepareStatement("UPDATE resgisteruser SET Balance = ? WHERE email = '" + userid3 + "'");
					                                pss.setInt(1, addbalance);
					                                pss.executeUpdate();
					                            }
					                            pss.close();
					                            rss.close();
					                        }
					                    }
							        }else {
							        	JOptionPane.showMessageDialog(transfer,"Wrong Password Transaction Failed.");
					                }
							        connection.close();
					            }catch (Exception exception) {
				                     exception.printStackTrace();
				 		                }
							 }
			            
			                
			}
		});
		transfer.setBackground(Color.ORANGE);
		transfer.setFont(new Font("Times New Roman", Font.BOLD, 12));
		transfer.setForeground(Color.WHITE);
		transfer.setBounds(71, 216, 89, 23);
		contentPane.add(transfer);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setBounds(251, 216, 89, 23);
		contentPane.add(btnNewButton);
		setUndecorated(true);
	}

	public void getuserid3(String userID) {
		 userid3 = userID;
		
	}
}
