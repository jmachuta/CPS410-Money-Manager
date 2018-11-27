import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JEditorPane;

public class Homepage extends JFrame {
	
	Calendar cal = Calendar.getInstance();
	int currentMonth = cal.get(Calendar.MONTH);
	int currentDay = cal.get(Calendar.DATE);
	int currentYear = cal.get(Calendar.YEAR);		
	String currentDate = Integer.toString(currentMonth) + "/" +  Integer.toString(currentDay) + "/" + Integer.toString(currentYear);
	Login lg = new Login();
	PrintWriter pw = new PrintWriter(new FileOutputStream(new File(lg.currentdirectory+"/test"), true /* append = true */));
	String goalDate = "";
	String username = "test";
	//Login lg = new Login();
	//File trans = new File (lg.currentdirectory+"/Transactions.txt");
	File ps = new File(lg.currentdirectory+"/pass.txt");
	Scanner sc = new Scanner(ps);
	String name = sc.next();
	String pass = sc.next();
	public double progGoal = sc.nextDouble();
	public double homeGoal = 0;
	File bal = new File (lg.currentdirectory+"/test");
	//double homeBal = balScnr.nextDouble();
	private JPanel homepagePane;
	private JTextField homepageBalance;
	//private JTextField homepageTodayReturn;
	private JTextField homepageGoalAmt;
	private JTextField homepageProgressText;

	/**
	 * Launch the application.
	 * @throws FileNotFoundException 
	 */
	public static void homepageScreen(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Homepage frame = new Homepage();
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
	public Homepage() throws FileNotFoundException {
		
		Scanner balScnr = new Scanner(bal);
		double temp5 = 0 + progGoal;
		//double homeBal = 0;
		while(balScnr.hasNextDouble()) {
			double temp = balScnr.nextDouble();
			double temp2 = balScnr.nextDouble();
			double temp3 = balScnr.nextDouble();
			double temp4 = balScnr.nextDouble();
			temp5 = temp5+ temp + temp2 + temp3 - temp4;
			balScnr.next();
			//editorPane.setText((temp + " " + temp2 + " " + temp3 + " " + temp4 + " " + temp5));
		}
		//balScnr.close();
		double temp = temp5;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 322);
		homepagePane = new JPanel();
		homepagePane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(homepagePane);
		homepagePane.setLayout(null);
		
		JLabel lblHomepageMoneyManager = new JLabel("Money Manager");
		lblHomepageMoneyManager.setBounds(71, 11, 424, 22);
		lblHomepageMoneyManager.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblHomepageMoneyManager.setHorizontalAlignment(SwingConstants.CENTER);
		homepagePane.add(lblHomepageMoneyManager);
		
		JButton btnInputTransactions = new JButton("Input Transactions");
		btnInputTransactions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					showTransactions();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnInputTransactions.setBounds(10, 256, 164, 23);
		homepagePane.add(btnInputTransactions);
		
		JLabel lblNotifications = new JLabel("Notifications");
		lblNotifications.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNotifications.setHorizontalAlignment(SwingConstants.CENTER);
		lblNotifications.setBounds(411, 50, 78, 14);
		homepagePane.add(lblNotifications);
		
		JScrollPane notificationsScrollPane = new JScrollPane();
		notificationsScrollPane.setBounds(355, 75, 270, 200);
		homepagePane.add(notificationsScrollPane);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setEditable(false);
		//PrintWriter pw2 = new PrintWriter(new FileOutputStream(new File(lg.currentdirectory+"/test"), true /* append = true */));
		Scanner sc2 = new Scanner(bal);
		String nme = "";
		while(sc2.hasNext()) {
			double temp6 = sc2.nextDouble();
			double temp7 = sc2.nextDouble();
			double temp8 = sc2.nextDouble();
			double temp9 = sc2.nextDouble();
			String temp10 = sc2.next();
			//System.out.println(temp6 + " " + temp7 + " " + temp8 + " " + temp9 + " " + temp10);
			//String nme = "";
			nme = nme + "$" +temp6 + " $" + temp7 + " $" + temp8 + " $" + temp9 + " - " + temp10 + "\n";
			editorPane.setText(nme);
		}
		notificationsScrollPane.setViewportView(editorPane);
		
		//JScrollBar scrollBar = new JScrollBar();
		//notificationsScrollPane.setRowHeaderView(scrollBar);
		//Scanner transScnr = new Scanner(trans);

		JButton btnSetGoals = new JButton("Set Goal");
		btnSetGoals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//setGoals(temp);
				String goal = homepageGoalAmt.getText();
				if(goal.isEmpty()) {
					
				}
				else {
					//String goal = homepageGoalAmt.getText();
					homeGoal = Double.parseDouble(goal);
					homepageProgressText.setText("$" + temp + " / $" + homeGoal);
				}
				//homeGoal = goal;
				homepageProgressText.setText("$" + temp + " / $" + homeGoal);
			}
			
		});
		btnSetGoals.setBounds(10, 213, 164, 23);
		homepagePane.add(btnSetGoals);
		
		JLabel lblGoalAmt = new JLabel("Goal Amount:");
		lblGoalAmt.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGoalAmt.setBounds(10, 100, 113, 14);
		homepagePane.add(lblGoalAmt);
		
		JLabel lblProgress = new JLabel("Progress:");
		lblProgress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblProgress.setBounds(10, 125, 113, 14);
		homepagePane.add(lblProgress);
		
		JLabel lblHomepageBalance = new JLabel("Balance:");
		lblHomepageBalance.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHomepageBalance.setBounds(10, 75, 113, 14);
		homepagePane.add(lblHomepageBalance);
		
//		JLabel lblTodays = new JLabel("Today's Return:");
//		lblTodays.setHorizontalAlignment(SwingConstants.RIGHT);
//		lblTodays.setBounds(10, 100, 113, 14);
//		homepagePane.add(lblTodays);
		
		homepageBalance = new JTextField();
		homepageBalance.setEditable(false);
		homepageBalance.setBounds(153, 72, 164, 20);
		homepagePane.add(homepageBalance);
		homepageBalance.setColumns(10);
		homepageBalance.setText("$" + temp5+ "");
		
//		homepageTodayReturn = new JTextField();
//		homepageTodayReturn.setEditable(false);
//		homepageTodayReturn.setBounds(153, 97, 164, 20);
//		homepagePane.add(homepageTodayReturn);
//		homepageTodayReturn.setColumns(10);
		
		homepageGoalAmt = new JTextField();
		homepageGoalAmt.setBounds(153, 97, 164, 20);
		homepagePane.add(homepageGoalAmt);
		homepageGoalAmt.setColumns(10);
		
		homepageProgressText = new JTextField();
		homepageProgressText.setEditable(false);
		homepageProgressText.setBounds(153, 120, 164, 20);
		homepagePane.add(homepageProgressText);
		homepageProgressText.setColumns(10);
		
		JButton btnRefreshNotifications = new JButton("Refresh Notifications");
		btnRefreshNotifications.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				while(transScnr.hasNext()) {
//					editorPane.setText(transScnr.nextDouble() + "\n");
//				}
			}
		});
		btnRefreshNotifications.setBounds(10, 234, 164, 23);
		homepagePane.add(btnRefreshNotifications);
		pw.close();
	}
	
//	public void setGoals(double balIn) {
//		String goal = homepageGoalAmt.getText();
//		if(goal.isEmpty()) {
//			goal = "0";
//		}
//		homeGoal = Double.parseDouble(goal);
//		homepageProgressText.setText("$" + balIn + " / $" + homeGoal);
//	}
	
	public void showTransactions() throws FileNotFoundException {
		Transactions transactions = new Transactions();
		transactions.newscreen3();
		setVisible(false);
	}
}
