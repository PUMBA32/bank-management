package program;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import mainWindow.WelcomeWindowGUI;
import settings.Settings;


public class ProgramGUI implements ActionListener {
	
	private String username;
	private String pass;
	private int balance;
	private int credit;
	
	JFrame frame;
	
	private JLabel usernameLabel, balanceLabel;
	
	private JButton sendButton, getButton, updateButton, exitButton, profileButton;
	
	private Font font = new Font("Somic Sans", Font.BOLD, 18);
	
	
	public ProgramGUI(String username, String pass, int balance, int credit) {
		this.pass = pass;
		this.username = username;
		this.balance = balance;
		this.credit = credit;
		
		// main window settings
		frame = new JFrame();
		frame.setTitle(Settings.TITLE);
		frame.setSize(Settings.PROGRAM_WINDOW_WIDTH, Settings.PROGRAM_WINDOW_HEIGHT);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// user name label settings
		usernameLabel = new JLabel();
		usernameLabel.setText("USERNAME:  " + username);
		usernameLabel.setBounds(25, 30, 400, 25);
		usernameLabel.setFont(font);
		
		// user name label settings
		balanceLabel = new JLabel();
		balanceLabel.setText("BALANCE:     " + balance + "$");
		balanceLabel.setBounds(25, 50, 300, 30);
		balanceLabel.setFont(font);
		
		// send button settings
		sendButton = new JButton("Send");
		sendButton.setFont(font);
		sendButton.addActionListener(this);
		sendButton.setBounds(25, 110, 190, 40);
		sendButton.setFocusable(false);
		
		// send button settings
		getButton = new JButton("Get Credit");
		getButton.setFont(font);
		getButton.addActionListener(this);
		getButton.setBounds(220, 110, 190, 40);
		getButton.setFocusable(false);
		
		// send button settings
		updateButton = new JButton("Update (Not works)");
		updateButton.setFont(font);
		updateButton.addActionListener(this);
		updateButton.setBounds(25, 160, 385, 40);
		updateButton.setFocusable(false);
		
		// send button settings
		profileButton = new JButton("Profile");
		profileButton.setFont(font);
		profileButton.addActionListener(this);
		profileButton.setBounds(25, 210, 385, 40);
		profileButton.setFocusable(false);
		
		// send button settings
		exitButton = new JButton("Back to manu");
		exitButton.setFont(font);
		exitButton.addActionListener(this);
		exitButton.setBounds(25, 260, 385, 40);
		exitButton.setFocusable(false);
		
		
		frame.add(exitButton);
		frame.add(profileButton);
		frame.add(updateButton);
		frame.add(getButton);
		frame.add(sendButton);
		frame.add(balanceLabel);
		frame.add(usernameLabel);
		frame.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == sendButton) {
			Send sendMoney = new Send(username, balance);
		}
		
		if(e.getSource() == exitButton) {
			WelcomeWindowGUI welcomwWindow = new WelcomeWindowGUI(); 
			frame.setVisible(false);
			frame = null;
		}
		
		if(e.getSource() == profileButton) {
			Profile profile = new Profile(username, pass, balance, credit);
		}
		
		if(e.getSource() == getButton) {
			Get get = new Get(username, balance);
		}
		
		if(e.getSource() == updateButton) {
			
		}
	}
}
