package logining;

import java.io.File;
import java.util.Scanner;

public class Login {
	private String path = "D:\\Coding\\JAVA\\PayGet\\src\\data\\accounts.txt";
	
	private int accountIndex;
	private int balance;
	private int credit;
	
	
	public boolean login(String username, String pass) {
		File file = new File(path);
		this.accountIndex = 0;
		
		try {
			Scanner scanner = new Scanner(file);
			while(scanner.hasNextLine()) {
				this.accountIndex++;
				String[] data = scanner.nextLine().split(" ");
				if(data[0].equals(username) && data[1].equals(pass)) {
					this.balance = Integer.parseInt(data[3]);
					this.credit = Integer.parseInt(data[4]);
					return true;
				}
			}
		}
		catch(Exception e) {
			System.out.println("Ошибка в методе login");
		}
		return false;
	}
	
	
	public int getAccountIndex() {
		return this.accountIndex;
	}
	
	public int getBalance() {
		return this.balance;
	}
	
	public int getCredit() {
		return this.credit;
	}
}
