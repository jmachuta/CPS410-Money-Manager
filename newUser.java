import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSlider;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.awt.event.ActionEvent;

public class newUser extends JFrame {

	private JPanel contentPane;
	private JTextField newUserName;
	private JTextField newUserPass;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
public static void newUserScreen1() {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				newUser frame = new newUser();
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
public newUser() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 883, 401);
	contentPane = new JPanel();
	contentPane.setBackground(Color.LIGHT_GRAY);
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLabel lblNewUserSign = new JLabel("New User Sign Up");
	lblNewUserSign.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewUserSign.setFont(new Font("Tahoma", Font.BOLD, 20));
	lblNewUserSign.setBounds(61, 11, 492, 25);
	contentPane.add(lblNewUserSign);
	
	JLabel lblEnterUserName = new JLabel("Enter User Name: ");
	lblEnterUserName.setForeground(Color.BLUE);
	lblEnterUserName.setBackground(Color.LIGHT_GRAY);
	lblEnterUserName.setFont(new Font("Times New Roman", Font.BOLD, 16));
	lblEnterUserName.setBounds(24, 56, 184, 47);
	contentPane.add(lblEnterUserName);
	
	JLabel PassEntryLBL = new JLabel("Enter Password: ");
	PassEntryLBL.setForeground(Color.BLUE);
	PassEntryLBL.setFont(new Font("Times New Roman", Font.BOLD, 16));
	PassEntryLBL.setBackground(Color.LIGHT_GRAY);
	PassEntryLBL.setBounds(24, 114, 184, 47);
	contentPane.add(PassEntryLBL);
	
	newUserName = new JTextField();
	newUserName.setBounds(157, 56, 428, 35);
	contentPane.add(newUserName);
	newUserName.setColumns(10);
	
	newUserPass = new JTextField();
	newUserPass.setFont(new Font("Bookshelf Symbol 7", Font.BOLD, 14));
	newUserPass.setColumns(10);
	newUserPass.setBounds(157, 122, 428, 35);
	contentPane.add(newUserPass);
	
	
	
	//Make Account button
	JButton makeAccountBTTN = new JButton("Make Account");
	makeAccountBTTN.addActionListener(new ActionListener() {
		
		
public void actionPerformed(ActionEvent e) {
			
	
//Path address is in C drive:
	
String newUser = newUserName.getText();
String newPass = newUserPass.getText();
String SstartVal = textField.getText();
double startVal = Double.parseDouble(SstartVal);
new File("/C:/MoneyManager").mkdirs();
new File("/C:/MoneyManager/"+ newUser).mkdirs();			


PrintWriter writer = null;
try {
	writer = new PrintWriter("/C:/MoneyManager/"+newUser+"/pass.txt", "UTF-8");
} catch (FileNotFoundException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
} catch (UnsupportedEncodingException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
writer.println(newUser);
writer.println(newPass);
writer.println(startVal);
writer.close();
Component popup = null;
JOptionPane.showMessageDialog(popup, "ACCOUNT MADE SUCCESSFULLY");


	}});
	makeAccountBTTN.setFont(new Font("Tahoma", Font.BOLD, 14));
	makeAccountBTTN.setBounds(460, 238, 184, 44);
	contentPane.add(makeAccountBTTN);
	
	JLabel lblEnterStartingBalance = new JLabel("Enter starting balance before activating account   $");
	lblEnterStartingBalance.setFont(new Font("Tahoma", Font.BOLD, 12));
	lblEnterStartingBalance.setForeground(Color.BLACK);
	lblEnterStartingBalance.setBackground(Color.LIGHT_GRAY);
	lblEnterStartingBalance.setBounds(89, 160, 318, 64);
	contentPane.add(lblEnterStartingBalance);
	
	textField = new JTextField();
	textField.setBounds(406, 176, 179, 35);
	contentPane.add(textField);
	textField.setColumns(10);
	
	JSeparator separator = new JSeparator();
	separator.setForeground(Color.BLUE);
	separator.setBounds(0, 39, 654, 10);
	contentPane.add(separator);
	
	JButton btnLoginPage = new JButton("Login Page");
	btnLoginPage.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			Login login = new Login();
			login.setVisible(true);
			setVisible(false);
			
			
		}
	});
	btnLoginPage.setFont(new Font("Tahoma", Font.PLAIN, 23));
	btnLoginPage.setBounds(26, 241, 171, 41);
	contentPane.add(btnLoginPage);
}
}


