package atmpro;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Information extends JFrame {

	private JPanel contentPane;
	private JTextField infoname;
	private JTextField infoaddr;
	private JLabel lblNewLabel_2;
	private JTextField infoemail;
	private JLabel lblNewLabel_3;
	private JTextField infophone;
	private JLabel lblNewLabel_4;
	private JTextField infobalance;
	private JButton btnNewButton;
	private JLabel lblNewLabel_5;
	private String userid4;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Information frame = new Information();
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
	public Information() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 439);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("First Name :");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(49, 59, 79, 14);
		contentPane.add(lblNewLabel);
		
		infoname = new JTextField();
		infoname.setBounds(138, 53, 180, 29);
		contentPane.add(infoname);
		infoname.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Address :");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setBounds(49, 120, 68, 14);
		contentPane.add(lblNewLabel_1);
		
		infoaddr = new JTextField();
		infoaddr.setBounds(138, 114, 180, 29);
		contentPane.add(infoaddr);
		infoaddr.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Email :");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2.setBounds(49, 184, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		infoemail = new JTextField();
		infoemail.setBounds(138, 178, 180, 29);
		contentPane.add(infoemail);
		infoemail.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Phone :");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_3.setBounds(49, 241, 68, 14);
		contentPane.add(lblNewLabel_3);
		
		infophone = new JTextField();
		infophone.setBounds(137, 235, 181, 29);
		contentPane.add(infophone);
		infophone.setColumns(10);
		
		lblNewLabel_4 = new JLabel("Balance :");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4.setBounds(49, 304, 79, 14);
		contentPane.add(lblNewLabel_4);
		
		infobalance = new JTextField();
		infobalance.setBounds(138, 298, 180, 29);
		contentPane.add(infobalance);
		infobalance.setColumns(10);
		
		btnNewButton = new JButton("Load Info");
		btnNewButton.addActionListener(new ActionListener() {
			private ResultSet rs;

			public void actionPerformed(ActionEvent e) {
				String INSERT_USERS_SQL = "select * from resgisteruser where email = ? ";
				 
				 
			        try (Connection connection = DriverManager
			            .getConnection("jdbc:mysql://localhost:3306/emploee", "root", "root");
			        		PreparedStatement ps = connection.prepareStatement(INSERT_USERS_SQL)){    
 				         ps.setString(1, userid4);
 				        rs = ps.executeQuery();
 				       while(rs.next()){
 				          infoname.setText(rs.getString("firstname") );
 				         infoemail.setText(rs.getString("email"));
 				         infoaddr.setText(rs.getString("Address"));
 				          
 				          infophone.setText(rs.getString("phoneno"));
 				         infobalance.setText(rs.getString("Balance"));
 				          }
 				          
 				        connection.close();
 				        
			        } catch (SQLException e1) {
						 
						e1.printStackTrace();
					}
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLUE);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton.setBounds(78, 347, 98, 29);
		contentPane.add(btnNewButton);
		
		lblNewLabel_5 = new JLabel("Information");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(173, 11, 98, 14);
		contentPane.add(lblNewLabel_5);
		
		btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton_1.setBounds(248, 347, 89, 29);
		contentPane.add(btnNewButton_1);
		setUndecorated(true);
	}

	public void getuserID4(String userID) {
		 userid4 = userID;
		
	}
}
