package program;

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


public class Get implements ActionListener {
	
	private int balance;  // текущее кол-во монет
	private int money;  // кол-во монет к добавлению
	private String username;  // ник пользователя
	
	private String path = "D:\\Coding\\JAVA\\PayGet\\src\\data\\accounts.txt";  
	private String[] banks = {"Тинькофф Банк", "PayPal", "СБЕР", "ЮMoney", "Qiwi", "Альфа-Банк"};
	
	private Font font = new Font("Comic Sans", Font.BOLD, 13);
	
	private JButton getMoneyButton, button_10, button_100, button_1000, button_clr;
	private JTextField howMuchMoney;
	
	
	public Get(String username, int balance) {
		this.username = username;
		this.balance = balance;
		
		JFrame frame = new JFrame();
		frame.setTitle(Settings.TITLE);
		frame.setSize(Settings.GET_WINDOW_WIDTH, Settings.GET_WINDOW_HEIGHT);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		howMuchMoney = new JTextField("");
		howMuchMoney.setFont(font);
		howMuchMoney.setBounds(20, 20, 300, 30);
		howMuchMoney.setEditable(false);
		
		JComboBox box = new JComboBox(banks);
		box.setBounds(20, 90, 300, 30);
		
		getMoneyButton = new JButton("Get money");
		getMoneyButton.addActionListener(this);
		getMoneyButton.setFocusable(false);
		getMoneyButton.setFont(font);
		getMoneyButton.setBounds(20, 165, 300, 30);
		
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
		
		
		frame.add(button_clr);
		frame.add(button_10);
		frame.add(button_100);
		frame.add(button_1000);
		frame.add(box);
		frame.add(getMoneyButton);
		frame.add(howMuchMoney);
		frame.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == getMoneyButton && money > 0) {
			getBalance();
		}
		
		if(e.getSource() == button_clr) {
			howMuchMoney.setText("");
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


	private void getBalance() {
		try {
			// reading file content
			BufferedReader reader = new BufferedReader(new FileReader(path));
			StringBuilder fileContent = new StringBuilder();
			String line;
			while((line = reader.readLine()) != null) {
				fileContent.append(line).append("\n");
			}
			reader.close();

			
			// changing stroke
			String[] lines = fileContent.toString().split("\n");
			for(int i = 0; i < lines.length; i++) {
				String[] cur_line = lines[i].split(" ");
				
				if(cur_line[0].equals(username)) {
					int curr_money = Integer.parseInt(cur_line[3]) + money; 
					cur_line[3] = curr_money+"";
					lines[i] = String.join(" ", cur_line);
					break;
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
			System.out.println("Ошибка в методе updateBalance(), в классе Get!");
		}
	}
}
