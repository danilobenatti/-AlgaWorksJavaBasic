package example;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class MultaVeiculo {
	
	public static void main(String[] args) {
		Logger logger = Logger.getLogger("");
		Character vehicle = 0;
		float speed = 0;
		float maxSpeed = 0;
		
		try (Scanner scanner = new Scanner(System.in)) {
			
			Pattern textPattern = Pattern.compile("[aA, bB]");
			logger.info("Enter car[A] or truck[B]?");
			if (scanner.hasNext(textPattern)) {
				vehicle = scanner.next().charAt(0);
			} else {
				logger.warning("Only letter 'A'[car] or 'B'[truck]!");
				return;
			}
			
			Pattern numberPattern = Pattern.compile("\\d*\\.?\\d*");
			logger.info("Enter with speed[km/h]?");
			if (scanner.hasNext(numberPattern)) {
				speed = Float.parseFloat(scanner.next());
			} else {
				logger.warning("Only speed value[numeric, ex.: 95.6]!");
				return;
			}
			
			String result;
			switch (vehicle) {
				case 'A': // car, tolerance max.: 10%
					maxSpeed = 100;
					result = check(speed, maxSpeed, (float) (maxSpeed * 1.1));
					break;
				case 'B': // truck, tolerance max.: 5%
					maxSpeed = 90;
					result = check(speed, maxSpeed, (float) (maxSpeed * 1.05));
					break;
				default:
					result = "-- ? --";
					break;
			}
			
			logger.log(Level.INFO, result, maxSpeed);
		}
	}
	
	private static String check(float speed, float maxSpeed, float tolerance) {
		String info = null;
		if (speed <= maxSpeed) {
			info = String.format(
					"Information![%.1f], max speed permitted, {0}km/h", speed);
		} else if (speed <= tolerance) {
			info = String.format(
					"Alert![%.1f] above the permitted speed, {0}km/h", speed);
		} else {
			info = String.format(
					"Infraction[%.1f] speed limit exceeded, {0}km/h", speed);
		}
		return info;
	}
	
}
