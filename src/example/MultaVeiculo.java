package example;

import java.text.NumberFormat;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class MultaVeiculo {
	
	public static void main(String[] args) {
		Logger logger = Logger.getLogger("");
		
		try (Scanner scanner = new Scanner(System.in)) {
			
			Character vehicle;
			Pattern textPattern = Pattern.compile("[aA, bB]");
			logger.info("Enter car[A] or truck[B]?");
			if (scanner.hasNext(textPattern)) {
				vehicle = scanner.next().charAt(0);
			} else {
				logger.warning("Only letter 'A'[car] or 'B'[truck]!");
				return;
			}
			
			float speed;
			Pattern numberPattern = Pattern.compile("\\d*\\.?\\d*");
			logger.info("Enter with speed[km/h]?");
			if (scanner.hasNext(numberPattern)) {
				speed = Float.parseFloat(scanner.next());
			} else {
				logger.warning("Only speed value[numeric, ex.: 95.6]!");
				return;
			}
			
			String result;
			float maxSpeed = 0;
			switch (vehicle) {
				case 'a', 'A': // car, tolerance max.: 10%
					maxSpeed = 110;
					result = check(speed, maxSpeed, (float) (maxSpeed * 1.1));
					break;
				case 'b', 'B': // truck, tolerance max.: 5%
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
	
	private static String check(float speed, float maxSpeed, float tolSpeed) {
		NumberFormat nf = NumberFormat.getPercentInstance();
		nf.setMaximumFractionDigits(2);
		String info = null;
		if (speed <= maxSpeed) {
			info = String.format(
					"Information![%.1f] max speed allowed is {0}km/h", speed);
		} else if (speed <= tolSpeed) {
			info = String.format(
					"Alert![%.1f] %s above the speed allowed, {0}km/h", speed,
					nf.format((speed / maxSpeed) - 1));
		} else {
			info = String.format(
					"Infraction[%.1f] %s speed limit exceeded, {0}km/h", speed,
					nf.format((speed / maxSpeed) - 1));
		}
		return info;
	}
	
}
