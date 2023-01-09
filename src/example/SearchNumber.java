package example;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SearchNumber {
	
	public static void main(String[] args) {
		Logger logger = Logger.getLogger("");
		try (Scanner scanner = new Scanner(System.in)) {
			int number = Integer.parseInt(scanner.next());
			for (int i = 100; i <= 120; i++) {
				if (i % number == 0) {
					continue;
				}
				logger.log(Level.INFO, "{0}", i);
			}
		}
		logger.info("End!");
	}
	
}
