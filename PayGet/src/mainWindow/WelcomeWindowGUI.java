package mainWindow;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import logining.LoginGUI;
import logining.RegistrationGUI;
import settings.Settings;

public class WelcomeWindowGUI implements ActionListener {
	
	private JFrame frame;
	
	private Font font = new Font("Comic Sans", Font.BOLD, 20);
		
	private JButton loginButton, registrationButton;
	
	
	public WelcomeWindowGUI() {
		frame = new JFrame();
		frame.setTitle(Settings.TITLE);
		frame.setSize(Settings.WELCOME_WINDOW_WIDTH, Settings.WELCOME_WINDOW_HEIGHT);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		
		JLabel label = new JLabel("Welcome to the PayGet!");
		label.setFont(font);
		label.setBounds(30, 40, 270, 30);
		
		JLabel littleText = new JLabel("Made by Sanchez");
		littleText.setFont(new Font("Comic Sans", Font.BOLD, 12));
		littleText.setBounds(93, 270, 270, 30);
		
		loginButton = new JButton();
		loginButton.setText("Login");
		loginButton.setFocusable(false);
		loginButton.addActionListener(this);
		loginButton.setBounds(40, 110, 200, 40);
		loginButton.setFont(font);
		
		registrationButton = new JButton();
		registrationButton.setText("Registration");
		registrationButton.setFocusable(false);
		registrationButton.addActionListener(this);
		registrationButton.setBounds(40, 155, 200, 40);
		registrationButton.setFont(font);
		
		frame.add(registrationButton);
		frame.add(loginButton);
		frame.add(label);
		frame.add(littleText);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == registrationButton) {
			RegistrationGUI registration = new RegistrationGUI();
			frame.setVisible(false);
			frame = null;
		}
		
		if(e.getSource() == loginButton) {
			LoginGUI login = new LoginGUI();
			frame.setVisible(false);
			frame = null;
		}
	}
	
}
