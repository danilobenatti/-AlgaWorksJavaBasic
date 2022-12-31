package example;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InputData {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));
		Logger logger = Logger.getLogger("");
		String name = null;
		int age = 0;
		short weight = 0;
		char[] password;
		
		name = reader.readLine();
		age = Integer.parseInt(reader.readLine());
		weight = Short.parseShort(reader.readLine());
		
		logger.log(Level.INFO, "Name1: {0}", name);
		logger.log(Level.INFO, "Age1: {0}", age);
		logger.log(Level.INFO, "Weight1: {0}", weight);
		
		Scanner scanner = new Scanner(System.in);
		name = scanner.nextLine();
		age = scanner.nextInt();
		weight = scanner.nextShort();
		logger.log(Level.INFO, "Name2: {0}", name);
		logger.log(Level.INFO, "Age2: {0}", age);
		logger.log(Level.INFO, "Weight2: {0}", weight);
		scanner.close();
		
		Console console = System.console();
		if (console != null) {
			PrintWriter writer = console.writer();
			writer.print(name);
			name = console.readLine("Enter your name: ");
			password = console.readPassword("Enter your password: ");
			logger.log(Level.INFO, "Name3: {0}", name);
			logger.log(Level.INFO, "Pass3: {0}", password);
			console.printf(name + " is Username");
			console.printf(Arrays.toString(password) + " is Password");
			doTheThing();
			console.flush();
		} else {
			logger.log(Level.WARNING, "No console available");
		}
	}
	
	private static Object doTheThing() {
		return null;
	}
	
}
