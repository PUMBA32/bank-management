package program;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import settings.Settings;


public class Send implements ActionListener{
	private int money;
	private int balance;
	private String username;
	private String username2;
	
	private String path = "D:\\Coding\\JAVA\\PayGet\\src\\data\\accounts.txt";
	
	private String[] banks = {"Тинькофф Банк", "PayPal", "СБЕР", "ЮMoney", "Qiwi", "Альфа-Банк"};
	
	private Font font = new Font("Comic Sans", Font.BOLD, 13);
	
	private JButton sendMoneyButton, button_10, button_100, button_1000, button_clr;
	private JTextField howMuchMoney;
	private JTextField usernameField;
	private JLabel text, errorText;
	
	
	public Send(String username, int balance) {
		this.username = username;
		this.balance = balance;
		
		JFrame frame = new JFrame();
		frame.setTitle(Settings.TITLE);
		frame.setSize(Settings.SEND_WINDOW_WIDTH, Settings.SEND_WINDOW_HEIGHT);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		howMuchMoney = new JTextField("0");
		howMuchMoney.setFont(font);
		howMuchMoney.setBounds(20, 20, 300, 30);
		howMuchMoney.setEditable(false);
		
		usernameField = new JTextField("");
		usernameField.setFont(font);
		usernameField.setBounds(20, 170, 300, 30);
		
		JComboBox box = new JComboBox(banks);
		box.setBounds(20, 90, 300, 30);
		
		sendMoneyButton = new JButton("Send money");
		sendMoneyButton.addActionListener(this);
		sendMoneyButton.setFocusable(false);
		sendMoneyButton.setFont(font);
		sendMoneyButton.setBounds(20, 230, 300, 30);
		
		text = new JLabel("Enter name of user");
		text.setFont(font);
		text.setBounds(20, 140, 300, 30);
		
		errorText = new JLabel("");
		errorText.setFont(font);
		errorText.setForeground(Color.RED);
		errorText.setBounds(20, 200, 300, 30);
		
		button_10 = new JButton("+10");
		button_10.addActionListener(this);
		button_10.setFocusable(false);
		button_10.setFont(font);
		button_10.setBounds(20, 50, 75, 30);
		
		button_100 = new JButton("+100");
		button_100.addActionListener(this);
		button_100.setFocusable(false);
		button_100.setFont(font);
		button_100.setBounds(95, 50, 75, 30);
		
		button_1000 = new JButton("+1000");
		button_1000.addActionListener(this);
		button_1000.setFocusable(false);
		button_1000.setFont(font);
		button_1000.setBounds(170, 50, 75, 30);
		
		button_clr = new JButton("clr");
		button_clr.addActionListener(this);
		button_clr.setFocusable(false);
		button_clr.setFont(font);
		button_clr.setBounds(245, 50, 75, 30);
		
		
		frame.add(errorText);
		frame.add(text);
		frame.add(usernameField);
		frame.add(button_clr);
		frame.add(button_10);
		frame.add(button_100);
		frame.add(button_1000);
		frame.add(box);
		frame.add(sendMoneyButton);
		frame.add(howMuchMoney);
		frame.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == sendMoneyButton) {
			this.username2 = usernameField.getText();
			this.money = Integer.parseInt(howMuchMoney.getText());
			
			if(isThereUsername()) {
				if(!username.equals(username2) && balance >= money) {
					sendMoney();
					errorText.setForeground(Color.GREEN);
					errorText.setText("Money were sent successfully!");
				} else {
					errorText.setText("");
				}
				
			} else {
				errorText.setText("There is no such user!");
			}
		}
		
		if(e.getSource() == button_clr) {
			howMuchMoney.setText("0");
		}
		
		if(e.getSource() == button_10) {
			String text = howMuchMoney.getText();
			this.money = (!text.equals("")) ? Integer.parseInt(text) + 10 : 0;
			howMuchMoney.setText(money+"");
		}
		
		if(e.getSource() == button_100) {
			String text = howMuchMoney.getText();
			this.money = (!text.equals("")) ? Integer.parseInt(text) + 100 : 0;
			howMuchMoney.setText(money+"");
		}
		
		if(e.getSource() == button_1000) {
			String text = howMuchMoney.getText();
			this.money = (!text.equals("")) ? Integer.parseInt(text) + 1000 : 0;
			howMuchMoney.setText(money+"");
		}	
	}
	
	
	private void sendMoney() {
		File file = new File(path);
		
		try {
			// reading file content
			BufferedReader reader = new BufferedReader(new FileReader(path));
			StringBuilder fileContent = new StringBuilder();
			String line;
			while((line = reader.readLine()) != null) {
				fileContent.append(line).append("\n");
			}
			reader.close();
			
			
			// changing strokes
			String[] lines = fileContent.toString().split("\n");
			int k = 0;
			for(int i = 0; i < lines.length; i++) {
				String[] cur_line = lines[i].split(" ");
				
				if(cur_line[0].equals(username)) {
					int cur_money = Integer.parseInt(cur_line[3]) - money;
					cur_line[3] = cur_money+"";
					lines[i] = String.join(" ", cur_line);
					if(k == 2) break;
					k++;
				} 
				
				if(cur_line[0].equals(username2)) {
					int cur_money = Integer.parseInt(cur_line[3]) + money;
					cur_line[3] = cur_money+"";
					lines[i] = String.join(" ", cur_line);
					if(k == 2) break;
					k++;
				}
			} 
			
			// rewriting file
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            for(String updateLine : lines) {
            	writer.write(updateLine);
            	writer.newLine();
            }
            writer.close();
		}
		catch(Exception e) {
			System.out.println("Ошибка в методе sendMoney!");
		}
	}
	
	private boolean isThereUsername() {
		File file = new File(path);
		try {
			Scanner scanner = new Scanner(file);
			while(scanner.hasNextLine()) {
				String[] data = scanner.nextLine().split(" ");
				if(data[0].equals(username2)) {
					return true;
				}
			}
		}
		catch(Exception e) {
			System.out.println("Ошибка в методе isThereUsername в классе Send");
		}
		return false;
	}
}
