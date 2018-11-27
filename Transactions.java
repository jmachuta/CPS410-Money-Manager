import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class Transactions extends JFrame {

	private JPanel contentPane;
	private JPanel contentPane2;
	private JTextField stocktxt;
	private JTextField additionaltxt;
	private JTextField debittxt;
	private JTextField wagetxt;
	

	/**
	 * Launch the application.
	 */
	public static void newscreen3() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Transactions frame = new Transactions();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws FileNotFoundException 
	 */
	public Transactions() throws FileNotFoundException {
		File fi = new File("data.txt");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 537, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Homepage hp = new Homepage();
					hp.homepageScreen();
					setVisible(false);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
			}
			}});
		btnNewButton.setBounds(402, 0, 119, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("WAGE (+)");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(53, 94, 79, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("STOCK (+)");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(217, 96, 79, 18);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ADDITIONAL (+)");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(33, 184, 126, 30);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("DEBIT (-)");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(217, 187, 68, 30);
		contentPane.add(lblNewLabel_3);
		
		wagetxt = new JTextField();
		wagetxt.setBounds(33, 120, 126, 37);
		contentPane.add(wagetxt);
		wagetxt.setColumns(10);
		
		stocktxt = new JTextField();
		stocktxt.setBounds(192, 120, 136, 37);
		contentPane.add(stocktxt);
		stocktxt.setColumns(10);
		
		additionaltxt = new JTextField();
		additionaltxt.setBounds(33, 225, 126, 37);
		contentPane.add(additionaltxt);
		additionaltxt.setColumns(10);
		
		debittxt = new JTextField();
		debittxt.setBounds(189, 225, 139, 37);
		contentPane.add(debittxt);
		debittxt.setColumns(10);
		
		JButton btnDebit = new JButton("DEBIT");
		btnDebit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					DebitClass db = new DebitClass();
					db.NewScreen1();
					setVisible(false);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnDebit.setBounds(0, 322, 100, 37);
		contentPane.add(btnDebit);
		
		JButton btnCredit = new JButton("CREDIT");
		btnCredit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					CreditClass cd = new CreditClass();
					cd.NewScreen2();
					setVisible(false);
				}
				catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnCredit.setBounds(421, 322, 100, 37);
		contentPane.add(btnCredit);
		
		//Enter button to load all the information in text boxes to file
		JButton btnWage = new JButton("ENTER");
		btnWage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				label: try {
				//final static String DOUBLE_PATTERN = "[0-9]+(\.){0,1}[0-9]*";
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");  
				LocalDateTime now = LocalDateTime.now();
				Login lg = new Login();
				PrintWriter pw = new PrintWriter(new FileOutputStream(new File(lg.currentdirectory+"/test"), true /* append = true */));
				DecimalFormat df = new DecimalFormat("#0.00");
				double dWage = 0;
				double dStock = 0;
				double dAdditional = 0;
				double dDebit = 0;
				Boolean test = true;
				String wage = "";	
				String stock = "";
				String additional = "";
				String debit = "";
				wage = wagetxt.getText();
				stock = stocktxt.getText();
				additional = additionaltxt.getText();
				debit = debittxt.getText();
				//if statements to check if boxes are empty. If they are sets the value to zero. 
				//Double.parseDouble is to convert the String to double because they are read in as a string
				if(wage.equals("")) {
					dWage = 0.00;
					if(isDouble(wage)) {
						//System.out.println("YES");
					}
					else {
						
					}
				}
				else
				{
					if(isDouble(wage)) {
						dWage = Double.parseDouble(wage);
					}
					else {
						JOptionPane.showMessageDialog(null, "ERROR: Invalid Number", "Transaction: " + "Invalid Number", JOptionPane.INFORMATION_MESSAGE);
						break label;
					}
				}
				
				if(stock.equals("")) {
					dStock = 0.00;
					if(isDouble(stock)) {
						//System.out.println("YES");
					}
					else {
						
					}
				}
				else
				{
					if(isDouble(stock)) {
						dStock = Double.parseDouble(stock);
					}
					else {
						JOptionPane.showMessageDialog(null, "ERROR: Invalid Number", "Transaction: " + "Invalid Number", JOptionPane.INFORMATION_MESSAGE);
						break label;
				}
				}
				
				if(additional.equals("")) {
					dAdditional = 0.00;
					if(isDouble(additional)) {
						//System.out.println("YES");
					}
					else {
						
					}
				}
				else
				{
					if(isDouble(additional)) {
						dAdditional = Double.parseDouble(additional);
					}
					else {
						JOptionPane.showMessageDialog(null, "ERROR: Invalid Number", "Transaction: " + "Invalid Number", JOptionPane.INFORMATION_MESSAGE);
						break label;
				}
				}
				
				if(debit.equals("")) {
					dDebit = 0.00;
					if(isDouble(debit)) {
						//System.out.println("YES");
					}
					else {
						
					}
				}
				else
				{
					if(isDouble(debit)) {
						dDebit = Double.parseDouble(debit);
					}
					else {
						JOptionPane.showMessageDialog(null, "ERROR: Invalid Number", "Transaction: " + "Invalid Number", JOptionPane.INFORMATION_MESSAGE);
						break label;
				}
				}
				
		
				//prints information to file
				pw.println(df.format(dWage) + " " + df.format(dStock) + " " + df.format(dAdditional) + " " + df.format(dDebit) + " " + dtf.format(now));
				pw.close();
				 JOptionPane.showMessageDialog(null, "Money Added to file", "Transaction: " + "Complete", JOptionPane.INFORMATION_MESSAGE);
				}catch(FileNotFoundException e1){
					e1.printStackTrace();
				}
				
			}
		});
		btnWage.setBounds(338, 163, 100, 54);
		contentPane.add(btnWage);
		
	}
	
	public boolean isDouble(String temp) {
		try{
            double num = Double.parseDouble( temp );
            return true;
        }
        catch( Exception e ){
            return false;
        }
	}
	
}