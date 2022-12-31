package example;

import java.util.logging.Level;
import java.util.logging.Logger;

public class VariablesJavaII {
	
	public static void main(String[] args) {
		
		double height = 100.9;
		int size = (int) height;
		
		Double weight = 83.6;
		long longValue = weight.longValue();
		short shortValue = weight.shortValue();
		double sum0 = Double.sum(longValue, shortValue);
		double sum1 = Double.sum(longValue, weight);
		double sum2 = Double.sum(weight, shortValue);
		
		Logger logger = Logger.getLogger("");
		logger.log(Level.INFO, "{0}", size);
		logger.log(Level.INFO, "{0}", longValue);
		logger.log(Level.INFO, "{0}", shortValue);
		logger.log(Level.INFO, "{0}", sum0);
		logger.log(Level.INFO, "{0}", sum1);
		logger.log(Level.INFO, "{0}", sum2);
		
	}
	
}
