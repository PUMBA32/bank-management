package logining;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import mainWindow.WelcomeWindowGUI;
import program.ProgramGUI;
import settings.Settings;


public class LoginGUI implements ActionListener {
	
	private JFrame frame;
	
	private JTextField usernameField, passField;
	
	private JLabel infoLabel;
	
	private JButton submitButton, backButton;
		
	private Font font = new Font("Comic Sans", Font.BOLD, 15);
	
	Login login = new Login();
	
	
	public LoginGUI() {
		
		// main window settings
		frame = new JFrame();
		frame.setTitle(Settings.TITLE);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setSize(Settings.LOGIN_WINDOW_WIDTH, Settings.LOGIN_WINDOW_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// user name text label settings
		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setBounds(30, 30, 80, 30);
		usernameLabel.setFont(font);
		
		// user name text field settings
		usernameField = new JTextField();
		usernameField.setBounds(120, 30, 280, 30);
		usernameField.setFont(font);
		
		// pass name text label settings
		JLabel passLabel = new JLabel("Pass");
		passLabel.setBounds(30, 70, 80, 30);
		passLabel.setFont(font);
		
		// pass text field settings
		passField = new JTextField();
		passField.setBounds(120, 70, 280, 30);
		passField.setFont(font);
		
		// submit button settings
		submitButton = new JButton();
		submitButton.setText("submit");
		submitButton.setFont(font);
		submitButton.setBounds(30, 140, 370, 30);
		submitButton.setFocusable(false);
		submitButton.addActionListener(this);
		
		// back button settings
		backButton = new JButton();
		backButton.setText("back");
		backButton.setFont(font);
		backButton.setBounds(30, 180, 370, 30);
		backButton.setFocusable(false);
		backButton.addActionListener(this);
		
		// info message label settings
		infoLabel = new JLabel();
		infoLabel.setBounds(140, 105, 240, 30);
		infoLabel.setFont(font);
		infoLabel.setForeground(Color.RED);
		
		
		frame.add(infoLabel);
		
		frame.add(backButton);
		frame.add(submitButton);
				
		frame.add(passField);
		frame.add(passLabel);
		
		frame.add(usernameField);
		frame.add(usernameLabel);
		
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == backButton) {
			WelcomeWindowGUI welcomwWindow = new WelcomeWindowGUI(); 
			frame.setVisible(false);
			frame.setVisible(false);
			frame = null;
		}
		
		if(e.getSource() == submitButton) {
			String username = usernameField.getText();
			String pass = passField.getText();
			
			if(usernameField.getText().length() > 0 && passField.getText().length() > 0) {
				if(!login.login(username, pass)) {
					infoLabel.setText("There is no such account!");
				}
				else {
					ProgramGUI programGUI = new ProgramGUI(username, pass, login.getBalance(), login.getCredit());
					frame.setVisible(false);
					frame = null;
				}
			}
			else {
				infoLabel.setText("there is empty field!");
			}
		}
	}
}
