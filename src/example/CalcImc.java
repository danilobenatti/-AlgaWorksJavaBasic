package example;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class CalcImc {
	
	static String result = null;
	
	public static void main(String[] args) {
		Logger logger = Logger.getLogger("");
		Scanner scanner = new Scanner(System.in);
		String sex = null;
		float weight = 0;
		float height = 0;
		double imc = 0;
		
		final Pattern textPattern = Pattern.compile("[m, f]");
		logger.info("Enter male[m] or female[f].");
		if (scanner.hasNext(textPattern)) {
			sex = scanner.next();
		} else {
			logger.warning("Only letter 'm'[male] or 'f'[female].");
			scanner.close();
			return;
		}
		
		final Pattern numberPattern = Pattern.compile("\\d*\\.?\\d*");
		logger.info("Enter weight[Kilograms], ex.: 68.2");
		if (scanner.hasNext(numberPattern)) {
			weight = Float.parseFloat(scanner.next());
		} else {
			logger.warning("Only weight value[Kilogram].");
			scanner.close();
			return;
		}
		logger.info("Enter height[meters], ex.: 1.78");
		if (scanner.hasNext(numberPattern)) {
			height = Float.parseFloat(scanner.next());
		} else {
			logger.warning("Only height value[meter].");
			scanner.close();
			return;
		}
		
		if (weight > 0 && height > 0) {
			imc = weight / Math.pow(height, 2);
		} else {
			imc = 0;
		}
		
		switch (sex) {
			case "m":
				CalcImc.result = maleImc(imc);
				break;
			case "f":
				CalcImc.result = femaleImc(imc);
				break;
			default:
				CalcImc.result = null;
				break;
		}
		
		String msg = String.format("IMC [{0}]: %s", result);
		logger.log(Level.INFO, msg, imc);
		scanner.close();
		
	}
	
	private static String femaleImc(double imc) {
		String text = null;
		if (imc < 19.1) {
			text = "under weight.";
		} else if (imc > 19.2 && imc < 25.8) {
			text = "at ideal weight.";
		} else if (imc > 25.9 && imc < 27.3) {
			text = "a little overweight.";
		} else if (imc > 27.4 && imc < 32.3) {
			text = "over ideal weight.";
		} else {
			text = "obesity.";
		}
		return text;
	}
	
	public static String maleImc(double imc) {
		String text = null;
		if (imc < 20.7) {
			text = "under weight.";
		} else if (imc > 20.8 && imc < 26.4) {
			text = "at ideal weight.";
		} else if (imc > 26.5 && imc < 27.8) {
			text = "a little overweight.";
		} else if (imc > 27.9 && imc < 31.1) {
			text = "over ideal weight.";
		} else {
			text = "obesity.";
		}
		return text;
	}
	
}
