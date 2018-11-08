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
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class Homepage extends JFrame {
	
	Calendar cal = Calendar.getInstance();
	int currentMonth = cal.get(Calendar.MONTH);
	int currentDay = cal.get(Calendar.DATE);
	int currentYear = cal.get(Calendar.YEAR);		
	String currentDate = Integer.toString(currentMonth) + "/" +  Integer.toString(currentDay) + "/" + Integer.toString(currentYear);
	double homeBal;
	double homeGoal;
	
	public void showGoals() {
		
	}
	
	public void showNotifications() {
		
	}
	
	public void showTransitions() {
		
	}

	private JPanel homepagePane;
	private JTextField homepageBalance;
	private JTextField homepageTodayReturn;
	private JTextField homepageCurrentDate;
	private JTextField homepageGoalDate;
	private JTextField homepageProgressText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	 */
	public Homepage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 370);
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
				
			}
		});
		btnInputTransactions.setBounds(163, 291, 140, 23);
		homepagePane.add(btnInputTransactions);
		
		JLabel lblNotifications = new JLabel("Notifications");
		lblNotifications.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNotifications.setHorizontalAlignment(SwingConstants.CENTER);
		lblNotifications.setBounds(411, 50, 78, 14);
		homepagePane.add(lblNotifications);
		
		JScrollPane notificationsScrollPane = new JScrollPane();
		notificationsScrollPane.setBounds(355, 75, 196, 245);
		homepagePane.add(notificationsScrollPane);
		
		JButton btnSetGoals = new JButton("Set Goal");
		btnSetGoals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showGoals();
			}
		});
		btnSetGoals.setBounds(10, 291, 140, 23);
		homepagePane.add(btnSetGoals);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(33, 220, 283, 37);
		homepagePane.add(progressBar);
		
		JLabel lblCurrentDate = new JLabel("Current Date:");
		lblCurrentDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCurrentDate.setBounds(45, 135, 78, 14);
		homepagePane.add(lblCurrentDate);
		
		JLabel lblGoalDate = new JLabel("Goal Date:");
		lblGoalDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGoalDate.setBounds(34, 160, 89, 14);
		homepagePane.add(lblGoalDate);
		
		JLabel lblProgress = new JLabel("Progress:");
		lblProgress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblProgress.setBounds(23, 185, 100, 14);
		homepagePane.add(lblProgress);
		
		JLabel lblHomepageBalance = new JLabel("Balance:");
		lblHomepageBalance.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHomepageBalance.setBounds(10, 75, 113, 14);
		homepagePane.add(lblHomepageBalance);
		
		JLabel lblTodays = new JLabel("Today's Return:");
		lblTodays.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTodays.setBounds(10, 100, 113, 14);
		homepagePane.add(lblTodays);
		
		homepageBalance = new JTextField();
		homepageBalance.setEditable(false);
		homepageBalance.setBounds(153, 72, 164, 20);
		homepagePane.add(homepageBalance);
		homepageBalance.setColumns(10);
		
		homepageTodayReturn = new JTextField();
		homepageTodayReturn.setEditable(false);
		homepageTodayReturn.setBounds(153, 97, 164, 20);
		homepagePane.add(homepageTodayReturn);
		homepageTodayReturn.setColumns(10);
		
		homepageCurrentDate = new JTextField(currentDate);
		homepageCurrentDate.setEditable(false);
		homepageCurrentDate.setBounds(153, 132, 164, 20);
		homepagePane.add(homepageCurrentDate);
		homepageCurrentDate.setColumns(10);
		
		homepageGoalDate = new JTextField();
		homepageGoalDate.setEditable(false);
		homepageGoalDate.setBounds(153, 157, 164, 20);
		homepagePane.add(homepageGoalDate);
		homepageGoalDate.setColumns(10);
		
		homepageProgressText = new JTextField();
		homepageProgressText.setEditable(false);
		homepageProgressText.setBounds(153, 182, 164, 20);
		homepagePane.add(homepageProgressText);
		homepageProgressText.setColumns(10);
	}
}
