package atmpro;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jfoenix.controls.JFXButton;

import javafx.scene.control.Labeled;

import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserHome extends JFrame {

	private JPanel contentPane;
	public JTextField Name;
	/**
	 * @wbp.nonvisual location=130,139
	 */
	protected Labeled loginusernm;
	public String userID;
	public String username;
	 
	 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserHome frame = new UserHome();
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
	public UserHome() {
		 
		 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 559, 463);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 204, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(SystemColor.window);
		panel.setBounds(30, 104, 480, 309);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton deposit = new JButton("Deposit");
		deposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DepositMoney frame = new DepositMoney();
				frame.setVisible(true);
				frame.getUserID(userID);
				
				
			}
		});
		 
		deposit.setFont(new Font("Times New Roman", Font.BOLD, 15));
		deposit.setForeground(SystemColor.controlLtHighlight);
		deposit.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		deposit.setBackground(new Color(51, 204, 153));
		deposit.setBounds(21, 45, 151, 40);
		panel.add(deposit);
		
		JButton btnNewButton_1 = new JButton("Withdraw");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WithDraw frame = new WithDraw();
				frame.setVisible(true);
				frame.getuserID1(userID);
				
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_1.setForeground(SystemColor.controlLtHighlight);
		btnNewButton_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		btnNewButton_1.setBackground(new Color(51, 204, 153));
		btnNewButton_1.setBounds(21, 136, 151, 40);
		panel.add(btnNewButton_1);
		
		
		JButton btnNewButton_2 = new JButton("Check Balance");
		btnNewButton_2.addActionListener(new ActionListener() {
			private String ubalance;

			public void actionPerformed(ActionEvent e) {
				
				 
				String INSERT_USERS_SQL = "select *  from resgisteruser where email =? and firstname = ?";
				 try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/emploee", "root", "root");
						PreparedStatement ps = connection.prepareStatement(INSERT_USERS_SQL)){    
				        ps.setString(1,userID);
				        ps.setString(2,username);
			           ResultSet x = ps.executeQuery();
			           while (x.next()) {
			        	   balancepage frame = new balancepage();
							frame.setVisible(true);
			        	   ubalance = Integer.toString(x.getInt("Balance")); 
			        	   
							frame.Accbalance.setText(ubalance);
		 	                    }
						}
				  catch (Exception exception) {
					 
                     exception.printStackTrace();
                     
                     
 		                }
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_2.setForeground(SystemColor.controlLtHighlight);
		btnNewButton_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		btnNewButton_2.setBackground(new Color(51, 204, 153));
		btnNewButton_2.setBounds(21, 230, 151, 40);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Change Password");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangePassword frame = new ChangePassword();
				frame.setVisible(true);
				frame.getuserid2(userID);
			}
		});
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_3.setForeground(SystemColor.controlLtHighlight);
		btnNewButton_3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		btnNewButton_3.setBackground(new Color(51, 204, 153));
		btnNewButton_3.setBounds(271, 45, 156, 40);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Balance Transfer");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BalanceTransfer frame = new BalanceTransfer();
				frame.setVisible(true);
				frame.getuserid3(userID);
			}
		});
		btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_4.setForeground(SystemColor.controlLtHighlight);
		btnNewButton_4.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		btnNewButton_4.setBackground(new Color(51, 204, 153));
		btnNewButton_4.setBounds(271, 136, 156, 40);
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Information");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Information frame = new Information();
				frame.setVisible(true);
				frame.getuserID4(userID);
			}
		});
		btnNewButton_5.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_5.setForeground(SystemColor.controlLtHighlight);
		btnNewButton_5.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		btnNewButton_5.setBackground(new Color(51, 204, 153));
		btnNewButton_5.setBounds(271, 230, 156, 40);
		panel.add(btnNewButton_5);
		
		JLabel Welcome = new JLabel("Welcome");
		Welcome.setHorizontalAlignment(SwingConstants.CENTER);
		Welcome.setFont(new Font("Times New Roman", Font.BOLD, 25));
		Welcome.setBounds(113, 54, 123, 23);
		contentPane.add(Welcome);
		
		JLabel logout = new JLabel("Logout");
		logout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				Loginpage frame = new Loginpage();
				frame.setVisible(true);
			}
		});
		logout.setBackground(Color.WHITE);
		logout.setHorizontalAlignment(SwingConstants.CENTER);
		logout.setForeground(Color.BLUE);
		logout.setFont(new Font("Times New Roman", Font.BOLD, 13));
		logout.setBounds(464, 11, 46, 14);
		contentPane.add(logout);
		
		Name = new JTextField();
		Name.setBorder(null);
		Name.setHorizontalAlignment(SwingConstants.LEFT);
		Name.setFont(new Font("Times New Roman", Font.BOLD, 20));
		Name.setBackground(new Color(51, 204, 153));
		Name.setBounds(260, 57, 172, 20);
		contentPane.add(Name);
		Name.setColumns(10);
	}

	public void GetUserID(String text, String string) {
		userID = text;
        username = string;
		
	}
	 
	 
}
