package atmpro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Button;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;


public class Loginpage extends JFrame {
	private JPanel contentPane;
	public JTextField loginusernm;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JPasswordField loginpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loginpage frame = new Loginpage();
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
	public Loginpage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 541, 339);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Times New Roman", Font.BOLD, 12));
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		loginusernm = new JTextField();
		loginusernm.setBounds(164, 116, 219, 29);
		contentPane.add(loginusernm);
		loginusernm.setColumns(10);
		
		Button button = new Button("LOGIN");
		button.setForeground(Color.WHITE);
		button.setBackground(Color.BLUE);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName = loginusernm.getText();
				String password = String.valueOf(loginpass.getPassword());
			 
 
				String INSERT_USERS_SQL = "select email,password,firstname from resgisteruser where email ='"+userName +"' and password ='"+password +"'";
 
				 int i=0;
				 i++;
			        try (Connection connection = DriverManager
			            .getConnection("jdbc:mysql://localhost:3306/emploee", "root", "root");

			            Statement Statement = connection.createStatement()) {
			           ResultSet x = Statement.executeQuery(INSERT_USERS_SQL);
			           if (x.next()) {
			        	   dispose();
			        	   UserHome frame = new UserHome();
							frame.setVisible(true);
							frame.Name.setText(x.getString("firstname"));
                         JOptionPane.showMessageDialog(button, "login Sucessful");
                         frame.GetUserID(loginusernm.getText() , x.getString("firstname"));
 	                    }else {
 	                    	JOptionPane.showMessageDialog(button, "Invalid Username And Password"); 	
 	                    }
			           
			           connection.close();

			        } catch (Exception exception) {
                     exception.printStackTrace();
 		                }
			        

			} 
		});
		button.setBounds(192, 223, 166, 29);
		contentPane.add(button);
		
		lblNewLabel_1 = new JLabel("Username  :");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		 
		lblNewLabel_1.setBounds(65, 123, 89, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Pin :");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(65, 173, 73, 14);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("No Account ? ");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_3.setBounds(215, 300, 73, 14);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Click Here");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				Registerpage frame = new Registerpage();
				frame.setVisible(true);
			}
		});
		
		lblNewLabel_4.setForeground(new Color(0, 0, 255));
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_4.setBounds(295, 300, 58, 14);
		contentPane.add(lblNewLabel_4);
		
		loginpass = new JPasswordField();
		loginpass.setBounds(164, 166, 219, 29);
		contentPane.add(loginpass);
		
		JLabel lblNewLabel_6 = new JLabel(" WELCOME TO ATM");
		lblNewLabel_6.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_6.setBounds(162, 58, 236, 14);
		contentPane.add(lblNewLabel_6);
		setUndecorated(true);
	}
}
