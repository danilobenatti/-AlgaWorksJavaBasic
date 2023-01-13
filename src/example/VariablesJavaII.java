package example;

import java.util.logging.Level;
import java.util.logging.Logger;

public class VariablesJavaII {
	
	public static void main(String[] args) {
		
		double height = 100.937;
		int size = (int) height;
		
		Double weight = 83.6;
		long longValue = weight.longValue();
		short shortValue = weight.shortValue();
		
		Logger logger = Logger.getLogger("");
		logger.log(Level.INFO, "double value -> {0}", height);
		logger.log(Level.INFO, "int value -> {0}", size);
		logger.log(Level.INFO, "Double value -> {0}", weight);
		logger.log(Level.INFO, "long value -> {0}", longValue);
		logger.log(Level.INFO, "short value -> {0}", shortValue);
		logger.log(Level.INFO, "{0}", Double.sum(longValue, shortValue));
		logger.log(Level.INFO, "{0}", Double.sum(longValue, weight));
		logger.log(Level.INFO, "{0}", Double.sum(height, shortValue));
		
	}
	
}
