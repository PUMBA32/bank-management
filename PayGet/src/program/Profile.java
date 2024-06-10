package program;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import settings.Settings;


public class Profile {
	
	private Font font = new Font("Comic Sans", Font.BOLD, 15);
	
	
	public Profile(String username, String pass, int balance, int credit) {

		JFrame frame = new JFrame();
		frame.setTitle(Settings.TITLE);
		frame.setSize(Settings.PROFILE_WINDOW_WIDTH, Settings.PROFILE_WINDOW_HEIGHT);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel nameLabel = new JLabel("Name: " + username);
		nameLabel.setFont(font);
		nameLabel.setBounds(20, 30, 270, 20);
		
		JLabel balanceLabel = new JLabel("Balance: " + balance + "$");
		balanceLabel.setFont(font);
		balanceLabel.setBounds(20, 50, 270, 20);
		
		JLabel passLabel = new JLabel("Pass: " + pass);
		passLabel.setFont(font);
		passLabel.setBounds(20, 70, 270, 20);
		
		JLabel creditLabel = new JLabel("Credit: " + credit);
		creditLabel.setFont(font);
		creditLabel.setBounds(20, 90, 270, 20);
		
		
		frame.add(creditLabel);
		frame.add(passLabel);
		frame.add(balanceLabel);
		frame.add(nameLabel);
		frame.setVisible(true);
		 
	}
}
