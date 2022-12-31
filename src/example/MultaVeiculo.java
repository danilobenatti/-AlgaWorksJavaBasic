package example;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class MultaVeiculo {
	
	public static void main(String[] args) {
		
		Logger logger = Logger.getLogger("");
		
		try (Scanner scanner = new Scanner(System.in)) {
			Character vehicle = 0;
			float instantSpeed = 0;
			float maxSpeedAlert = 0;
			float maxSpeedAttention = 0;
			
			final Pattern textPattern = Pattern.compile("[A, B]");
			logger.info("Enter car[A] or truck[B].");
			if (scanner.hasNext(textPattern)) {
				vehicle = scanner.next().charAt(0);
			} else {
				logger.warning("Only letter 'A'[car] or 'B'[truck].");
				return;
			}
			
			final Pattern numberPattern = Pattern.compile("\\d*\\.?\\d*");
			logger.info("Enter with speed[km/h].");
			if (scanner.hasNext(numberPattern)) {
				instantSpeed = Float.parseFloat(scanner.next());
			} else {
				logger.warning("Only speed value[km/h].");
				return;
			}
			switch (vehicle) {
				case 'A': // car, max.: 10%
					maxSpeedAlert = 100;
					maxSpeedAttention = (float) (maxSpeedAlert * 1.1);
					checkSpeed(logger, instantSpeed, maxSpeedAlert,
							maxSpeedAttention);
					break;
				
				case 'B': // truck, max.: 5%
					maxSpeedAlert = 90;
					maxSpeedAttention = (float) (maxSpeedAlert * 1.05);
					checkSpeed(logger, instantSpeed, maxSpeedAlert,
							maxSpeedAttention);
					break;
				
				default:
					break;
			}
		}
	}
	
	private static void checkSpeed(Logger logger, float instantSpeed,
			float maxSpeedAlert, float maxSpeedAttention) {
		if (instantSpeed <= maxSpeedAlert) {
			String msgInfo = String.format(
					"Information![%.2f], maximum speed permitted, {0}km/h",
					instantSpeed);
			logger.log(Level.INFO, msgInfo, maxSpeedAlert);
		} else if (instantSpeed <= maxSpeedAttention) {
			String msgAlert = String.format(
					"Alert![%.2f] vehicle above the permitted speed, {0}km/h",
					instantSpeed);
			logger.log(Level.INFO, msgAlert, maxSpeedAlert);
		} else {
			String msgAttention = String.format(
					"Attention![%.2f] vehicle exceeded the speed limit, registered infraction, speed above {0}km/h",
					instantSpeed);
			logger.log(Level.INFO, msgAttention, maxSpeedAttention);
		}
	}
	
}
