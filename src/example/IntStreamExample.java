package example;

import java.util.OptionalDouble;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;

public class IntStreamExample {
	
	public static void main(String[] args) {
		Logger logger = Logger.getLogger("");
		IntStream intStream = IntStream.of(15, 13, 45, 18, 89, 70, 76, 56);
		OptionalDouble optionalDouble = intStream.average();
		if (optionalDouble.isPresent()) {
			logger.log(Level.INFO, "Average of the elements...{0}",
					optionalDouble.getAsDouble());
		} else {
			logger.info("Nothing!");
		}
	}
	
}
