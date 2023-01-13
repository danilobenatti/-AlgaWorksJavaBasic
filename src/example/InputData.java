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
	
	public static void main(String[] args) {
		Logger logger = Logger.getLogger("");
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));
		String name = null;
		int age = 0;
		float weight = 0;
		char[] password;
		
		try {
			name = reader.readLine().trim();
			age = Integer.parseInt(reader.readLine().trim());
			weight = Float.parseFloat(reader.readLine().trim());
			logger.log(Level.INFO, "Name1: {0}", name);
			logger.log(Level.INFO, "Age1: {0}", age);
			logger.log(Level.INFO, "Weight1: {0}", weight);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		try (Scanner scanner = new Scanner(System.in)) {
			name = scanner.nextLine();
			age = scanner.nextInt();
			weight = Float.parseFloat(scanner.next().trim());
			logger.log(Level.INFO, "Name2: {0}", name);
			logger.log(Level.INFO, "Age2: {0}", age);
			logger.log(Level.INFO, "Weight2: {0}", weight);
		}
		
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
