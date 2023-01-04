package example;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class IpvaVeiculo {
	
	public static void main(String[] args) {
		
		Logger logger = Logger.getLogger("");
		String info = "";
		char number = 0;
		
		try (Scanner scanner = new Scanner(System.in)) {
			
			Pattern pattern = Pattern.compile("\\d");
			logger.info("Enter final number[0-9].");
			if (scanner.hasNext(pattern)) {
				number = scanner.next().charAt(number);
			} else {
				logger.warning("Only number[0-9].");
				return;
			}
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
			String year = dateFormat.format(new Date());
			
			switch (number) {
			case '1':
			case '2':
				info = String.format("Final date 13/02/%s", year);
				break;
			case '3':
			case '4':
				info = String.format("Final date 14/02/%s", year);
				break;
			case '5':
			case '6':
				info = String.format("Final date 15/02/%s", year);
				break;
			case '7':
			case '8':
				info = String.format("Final date 16/02/%s", year);
				break;
			case '9':
			case '0':
				info = String.format("Final date 17/02/%s", year);
				break;
			default:
				info = "-- ? --";
				break;
			}
			logger.log(Level.INFO, info);
		}
		
	}
	
}
