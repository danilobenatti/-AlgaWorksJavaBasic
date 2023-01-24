package example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DoWhileStruct {
	
	public static void main(String[] args) {
		Logger logger = Logger.getLogger("");
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));
		Integer sum = 0;
		int i = 0;
		try {
			int number = 0;
			do {
				i++;
				logger.info("Info number[press '0' for finish!]:");
				number = Integer.parseInt(reader.readLine());
				sum += number;
			} while (number != 0);
		} catch (NumberFormatException | IOException ex) {
			ex.printStackTrace();
		}
		float average = sum.floatValue() / (i - 1);
		
		logger.info(sum::toString);
		logger.log(Level.INFO, "{0}", average);
		
		try (Scanner scanner = new Scanner(System.in)) {
			boolean doIt = true;
			List<Object> object = new ArrayList<>();
			do {
				logger.info("Inform something[press '0' for finish!]:");
				if (!scanner.hasNext("[0]")) {
					object.add(scanner.next());
				} else {
					doIt = false;
				}
			} while (doIt);
			logger.log(Level.INFO, "{0}", object);
		}
		
	}
	
}
