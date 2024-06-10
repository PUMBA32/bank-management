package logining;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Registration {
	private String path = "D:\\Coding\\JAVA\\PayGet\\src\\data\\accounts.txt";
	
	private int accountIndex;
	
	// Запись данных
	public boolean registration(String username, String pass) {
		if(isThereSuchAccount(username, pass)) {  // Если такой аккаунт уже есть
			return false;
		}
		else {
			this.accountIndex++;
			
			try {
				String text = username + " " + pass + " " + accountIndex + " " + 0 + " " + 0 + "\n";
				FileWriter writer = new FileWriter(path, true);
				BufferedWriter bWriter = new BufferedWriter(writer);
				bWriter.write(text);
				bWriter.close();
			}
			catch(Exception e) { return false; }
			return true;
		}
	}
	
	// Проверка на наличие такого аккаунта
	private boolean isThereSuchAccount(String username, String pass) {
		File file = new File(path);
		this.accountIndex = 0;
		
		try {
			Scanner scanner = new Scanner(file);
			while(scanner.hasNextLine()) {
				this.accountIndex++;
				
				String[] data = scanner.nextLine().split(" ");
				
				if(data[0] == username) {
					return true;
				}
			}
		}
		catch(Exception e) {
			System.out.println("Ошибка в методе isThereSuchAccount!");
		}
		return false;
	}
	
	public int getAccountIndex() {
		return this.accountIndex;
	}
}
