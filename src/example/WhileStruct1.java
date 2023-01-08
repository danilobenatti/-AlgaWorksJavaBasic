package example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class WhileStruct1 {
	
	public static void main(String[] args) {
		Logger logger = Logger.getLogger("");
		
		int number = 0;
		int finalNumber = 0;
		
		try (Scanner scanner = new Scanner(System.in)) {
			logger.info("Enter positive initial number.");
			Pattern pattern = Pattern.compile("\\d*");
			if (scanner.hasNext(pattern)) {
				number = Integer.parseUnsignedInt(scanner.next());
			} else {
				logger.log(Level.WARNING, "Only (+)integers [0, 1, 2...]!");
				return;
			}
			logger.info("Enter positive final number.");
			if (scanner.hasNext(pattern)) {
				finalNumber = Integer.parseUnsignedInt(scanner.next());
				if (finalNumber < number) {
					logger.log(Level.WARNING, "Number must be > {0}", number);
					return;
				}
			} else {
				logger.log(Level.WARNING, "Only (+)integers [3, 4, 5...]!");
				return;
			}
			logger.log(Level.INFO, "Result: {0}",
					listNumbers(number, finalNumber));
		}
	}
	
	protected static List<Integer> listNumbers(int number, int finalNumber) {
		List<Integer> list = new ArrayList<>();
		while (number <= finalNumber) {
			list.add(number);
			number++;
		}
		return list;
	}
	
	static ArrayList<Integer> arrayNumbers(int number, int finalNumber) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i <= finalNumber - number; i++) {
			list.add(number + i);
			if (number + i == 0)
				break;
		}
		return list;
	}
}
