package example;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class IpvaVeiculo {
	
	public static void main(String[] args) {
		Logger logger = Logger.getLogger("");
		
		try (Scanner scanner = new Scanner(System.in)) {
			char number = 0;
			Pattern pattern = Pattern.compile("\\d");
			logger.info("Enter final number[0-9].");
			if (scanner.hasNext(pattern)) {
				number = scanner.next().charAt(number);
			} else {
				logger.warning("Only positive number[0-9].");
				return;
			}
			String year = new SimpleDateFormat("yyyy").format(new Date());
			String info = switch (number) {
				case '1', '2' -> String.format("Final date 13/02/%s", year);
				case '3', '4' -> String.format("Final date 14/02/%s", year);
				case '5', '6' -> String.format("Final date 15/02/%s", year);
				case '7', '8' -> String.format("Final date 16/02/%s", year);
				case '9', '0' -> String.format("Final date 17/02/%s", year);
				default -> null;
			};
			String msg = info != null ? info : "-- ? --";
			logger.info(msg);
		}
		
	}
	
}
