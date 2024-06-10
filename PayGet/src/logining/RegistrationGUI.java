package logining;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import mainWindow.WelcomeWindowGUI;
import program.ProgramGUI;
import settings.Settings;


public class RegistrationGUI implements ActionListener {
	
	private JFrame frame;
	
	private JTextField usernameField, passField;
	
	private JLabel infoLabel;
	
	private JButton submitButton, backButton;
	
	private JCheckBox checkbox;
	
	private Font font = new Font("Comic Sans", Font.BOLD, 15);
	
	Registration registration = new Registration();
	
	
	public RegistrationGUI() {
		
		// main window settings
		frame = new JFrame();
		frame.setTitle(Settings.TITLE);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setSize(Settings.REGISTRATION_WINDOW_WIDTH, Settings.REGISTRATION_WINDOW_HEIGHT);
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
	
		// I am not a robot check box settings
		checkbox = new JCheckBox();
		checkbox.setText("I'm not a robot");
		checkbox.setBounds(30, 150, 150, 30);
		checkbox.setFont(font);
		checkbox.setFocusable(false);
		
		// submit button settings
		submitButton = new JButton();
		submitButton.setText("submit");
		submitButton.setFont(font);
		submitButton.setBounds(30, 190, 370, 30);
		submitButton.setFocusable(false);
		submitButton.addActionListener(this);
		
		// back button settings
		backButton = new JButton();
		backButton.setText("back");
		backButton.setFont(font);
		backButton.setBounds(30, 230, 370, 30);
		backButton.setFocusable(false);
		backButton.addActionListener(this);
		
		// info message label settings
		infoLabel = new JLabel();
		infoLabel.setBounds(30, 270, 240, 30);
		infoLabel.setFont(font);
		infoLabel.setForeground(Color.RED);
				
				
		frame.add(infoLabel);
		
		frame.add(backButton);
		frame.add(submitButton);
		
		frame.add(checkbox);
		
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
			frame = null;
		}
		
		if(e.getSource() == submitButton) {
			int u_len = usernameField.getText().length();
			int p_len = passField.getText().length();
			
			if(u_len > 0 && p_len > 0 && checkbox.isSelected()) {
				String username = usernameField.getText();
				String pass = passField.getText();
				
				if(!registration.registration(username, pass)) {
					infoLabel.setText("Already is there such account");
				} else {
					ProgramGUI programGUI = new ProgramGUI(username, pass, 0, 0);
					frame.setVisible(false);
					frame = null;
				}
			}
			else {
				if(!checkbox.isSelected()) infoLabel.setText("confirm that you are not a robot!");
				else infoLabel.setText("there is empty field!");
			}
		}
	}
}
