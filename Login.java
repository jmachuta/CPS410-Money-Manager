import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	protected static final Component Login = null;
	private JPanel contentPane;
	private JTextField userNameEntry;
	private JTextField passwordEntry;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//SUBMIT BUTTON
		JButton Submit = new JButton("Submit ");
		Submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String uname = userNameEntry.getText();
				String pass = passwordEntry.getText();
				
				if(uname.equals("Name") && pass.equals("Pass")) {
					JOptionPane.showMessageDialog(Login, "Log in was sucessful");
					MainScreen mainscreen = new MainScreen();
					mainscreen.setVisible(true);
					setVisible(false);
					
				}
				
				else {
					JOptionPane.showMessageDialog(Login, "Error Invalid");
					
				}
			}
			
		});
		Submit.setForeground(Color.BLACK);
		Submit.setBackground(Color.GRAY);
		Submit.setFont(new Font("Tahoma", Font.BOLD, 12));
		Submit.setBounds(10, 167, 152, 42);
		contentPane.add(Submit);
		
		JButton newUser = new JButton("New User");
		newUser.setForeground(Color.BLACK);
		newUser.setFont(new Font("Tahoma", Font.BOLD, 12));
		newUser.setBackground(Color.GRAY);
		newUser.setBounds(272, 167, 152, 42);
		contentPane.add(newUser);
		
		JLabel Title = new JLabel("Login to Money Manager");
		Title.setForeground(Color.BLUE);
		Title.setFont(new Font("Times New Roman", Font.BOLD, 18));
		Title.setBounds(20, 11, 235, 23);
		contentPane.add(Title);
		
		JLabel lblUserName = new JLabel("User Name:");
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUserName.setBackground(Color.LIGHT_GRAY);
		lblUserName.setBounds(10, 45, 77, 23);
		contentPane.add(lblUserName);
		
		JLabel Password = new JLabel("Password:");
		Password.setFont(new Font("Tahoma", Font.BOLD, 13));
		Password.setBackground(Color.LIGHT_GRAY);
		Password.setBounds(10, 106, 77, 23);
		contentPane.add(Password);
		
		userNameEntry = new JTextField();
		userNameEntry.setBounds(97, 44, 294, 29);
		contentPane.add(userNameEntry);
		userNameEntry.setColumns(10);
		
		passwordEntry = new JTextField();
		passwordEntry.setColumns(10);
		passwordEntry.setBounds(97, 104, 294, 29);
		contentPane.add(passwordEntry);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLUE);
		separator.setBounds(0, 32, 434, 50);
		contentPane.add(separator);
	}
}
