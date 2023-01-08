package example;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ForExample {
	
	public static void main(String[] args) {
		Logger logger = Logger.getLogger("");
		NumberFormat numberFormat = NumberFormat.getInstance();
		
		double[] numbers = { 7.7, 6, 1.7, 3, 4, 9.1, 5, 2, 8.8 };
		ArrayList<Double> arrayList = new ArrayList<>();
		for (double value : numbers) {
			arrayList.add(value);
		}
		double sum = 0;
		for (double number : arrayList) {
			sum += number;
		}
		Double average = (sum / arrayList.size());
		logger.log(Level.INFO, average::toString);
		logger.log(Level.INFO, () -> numberFormat.format(average));
	}
	
}
