import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.Label;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class DebitClass extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void NewScreen1() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DebitClass frame = new DebitClass();
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
	public DebitClass() throws FileNotFoundException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Login lg = new Login();
		File fi = new File(lg.currentdirectory+"/test");
		Scanner sc = new Scanner(fi);
		
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
		
		TextArea textArea = new TextArea();
		textArea.setEditable(false);
		textArea.setBounds(177, 28, 247, 209);
		contentPane.add(textArea);
		
		JTextPane txtpnListThatDisplays = new JTextPane();
		txtpnListThatDisplays.setBackground(SystemColor.scrollbar);
		txtpnListThatDisplays.setEditable(false);
		txtpnListThatDisplays.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtpnListThatDisplays.setText("List that displays the money spent/paid with the date it was added to the system.");
		txtpnListThatDisplays.setBounds(10, 80, 151, 106);
		contentPane.add(txtpnListThatDisplays);
		while(sc.hasNext()) {
			sc.nextDouble();
			sc.nextDouble();
			//sc.nextDouble();
			String temp = String.valueOf(sc.nextDouble()).format("%.2f", sc.nextDouble());
			//String.format("%.2f", temp);
			textArea.setText(textArea.getText() + "$ "+ temp + " - " + sc.next() + "\n");
			
		}
		sc.close();
	}
}
