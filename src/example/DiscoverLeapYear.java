package example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DiscoverLeapYear {
	
	public static void main(String[] args) throws IOException {
		Logger logger = Logger.getLogger("");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("y");
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));
		
		testLeapYear(Year.parse(reader.readLine(), formatter), logger);
		testLeapYear(Year.parse("2012"), logger);
		testLeapYear(Year.now(), logger);
		
	}
	
	public static void testLeapYear(Year year, Logger logger) {
		boolean test1 = year.getValue() % 400 == 0;
		boolean test2 = year.getValue() % 4 == 0 && year.getValue() % 100 != 0;
		if (test1 || test2) {
			logger.log(Level.INFO, "Year {0} is a leap year!", year);
		} else {
			logger.log(Level.INFO, "Year {0} not is a leap year!", year);
		}
	}
	
}
