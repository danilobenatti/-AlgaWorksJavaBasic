package example;

import java.util.Comparator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class WhileStruct2 {
	
	public static void main(String[] args) {
		Logger logger = Logger.getLogger("");
		
		try (Scanner scanner = new Scanner(System.in)) {
			int number = 0;
			int finalNumber = 0;
			logger.info("Enter (+/-) initial number.");
			Pattern pattern = Pattern.compile("-?\\d*");
			if (scanner.hasNext(pattern)) {
				number = Integer.parseInt(scanner.next());
			} else {
				logger.log(Level.WARNING, "Only integers [0, 1, 2...]!");
				return;
			}
			logger.info("Enter (+/-) final number.");
			if (scanner.hasNext(pattern)) {
				finalNumber = Integer.parseInt(scanner.next());
				if (finalNumber < number) {
					logger.log(Level.WARNING, "Number must be > {0}", number);
					return;
				}
			} else {
				logger.log(Level.WARNING, "Only integers [3, 4, 5...]!");
				return;
			}
			logger.log(Level.INFO, "Result1: {0}",
					WhileStruct1.listNumbers(number, finalNumber));
			logger.log(Level.INFO, "Result2: {0}",
					WhileStruct1.arrayNumbers(number, finalNumber));
			
			Integer[] numbers = { 15, 4, 1, 5, 4, 3, 2, 3, 7, 9, 8, 10, 6, 0 };
			logger.log(Level.INFO, "Result3: {0}", WhileStruct1
					.hashNumbers(numbers, Comparator.naturalOrder()));
			logger.log(Level.INFO, "Result4: {0}", WhileStruct1
					.hashNumbers(numbers, Comparator.comparing(i -> i)));
			logger.log(Level.INFO, "Result5: {0}", WhileStruct1
					.hashNumbers(numbers, Comparator.reverseOrder()));
		}
		
	}
	
}
