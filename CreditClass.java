import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreditClass extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void NewScreen2() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreditClass frame = new CreditClass();
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
	public CreditClass() throws FileNotFoundException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Login lg = new Login();
		File fi2 = new File(lg.currentdirectory+"/test");
		Scanner sc = new Scanner(fi2);
		
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
		btnNewButton.setBounds(310, 0, 119, 23);
		contentPane.add(btnNewButton);
		
		JTextPane txtpnTest = new JTextPane();
		txtpnTest.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtpnTest.setText("List that displays the profit added with the date it was added to the system.");
		txtpnTest.setBounds(35, 47, 124, 154);
		contentPane.add(txtpnTest);
		
		TextArea textArea = new TextArea();
		textArea.setEditable(false);
		textArea.setBounds(165, 25, 235, 209);
		contentPane.add(textArea);
		//String temp = String.valueOf(temp1).format("%.2f", temp1);
		//System.out.println(temp);
		while(sc.hasNext()) {
			double temp1 = sc.nextDouble();
			double temp2 = sc.nextDouble();
			double temp3 = sc.nextDouble();
			String value1 = String.valueOf(temp1).format("%.2f", temp1);
			String value2 = String.valueOf(temp2).format("%.2f", temp2);
			String value3 = String.valueOf(temp3).format("%.2f", temp3);
			sc.nextDouble();
			textArea.setText(textArea.getText() + "$"+ value1 + "   $" + value2 + "   $" + value3 + " "  + " - " + sc.next() + "\n");
			
		}
		sc.close();
	}
}
