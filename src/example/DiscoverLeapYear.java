package example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DiscoverLeapYear {
	
	public static void main(String[] args) {
		Logger logger = Logger.getLogger("");
		
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("y");
		try {
			logger.info("Inform a year:");
			istLeapYear(Year.parse(reader.readLine(), formatter), logger);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		istLeapYear(Year.parse("2012"), logger);
		istLeapYear(Year.now(), logger);
		
		try (Scanner scan = new Scanner(System.in)) {
			logger.info("Inform a year:");
			logger.log(Level.INFO, () -> isLeapYear(Year.parse(scan.next())));
		}
		logger.log(Level.INFO, () -> isLeapYear(Year.parse("2012")));
		logger.log(Level.INFO, () -> isLeapYear(Year.now()));
	}
	
	public static void istLeapYear(Year year, Logger logger) {
		boolean test1 = year.getValue() % 400 == 0;
		boolean test2 = year.getValue() % 4 == 0 && year.getValue() % 100 != 0;
		if (test1 ^ test2) {
			if (test1) {
				logger.log(Level.INFO, "[Test1] {0} is a leap year.", year);
			}
			if (test2) {
				logger.log(Level.INFO, "[Test2] {0} is a leap year.", year);
			}
		} else {
			logger.log(Level.INFO, "{0} is not leap year.", year);
		}
	}
	
	public static String isLeapYear(Year year) {
		boolean test1 = year.getValue() % 400 == 0;
		boolean test2 = year.getValue() % 4 == 0 && year.getValue() % 100 != 0;
		String txt1 = String.format("%s is a leap year.", year.toString());
		String txt2 = String.format("%s is not leap year.", year.toString());
		return (test1 ^ test2) ? txt1 : txt2;
	}
	
}
