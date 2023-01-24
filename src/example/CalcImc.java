package example;

import java.text.NumberFormat;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class CalcImc {
	
	public static void main(String[] args) {
		Logger logger = Logger.getLogger("");
		Scanner scanner = new Scanner(System.in);
		
		char sex;
		Pattern textPattern = Pattern.compile("[mM, fF]");
		logger.info("Enter male[M] or female[F].");
		if (scanner.hasNext(textPattern)) {
			sex = scanner.next().charAt(0);
		} else {
			logger.warning("Only letter 'M'[male] or 'F'[female].");
			scanner.close();
			return;
		}
		
		float weight = 0;
		float height = 0;
		Pattern numberPattern = Pattern.compile("\\d*\\.?\\d*");
		logger.info("Enter weight[Kilograms], ex.: 68.2");
		if (scanner.hasNext(numberPattern)) {
			weight = Float.parseFloat(scanner.next());
		} else {
			logger.warning("Only weight value[numeric].");
			scanner.close();
			return;
		}
		logger.info("Enter height[meters], ex.: 1.78");
		if (scanner.hasNext(numberPattern)) {
			height = Float.parseFloat(scanner.next());
		} else {
			logger.warning("Only height value[numeric].");
			scanner.close();
			return;
		}
		
		double imc = 0;
		if (weight > 0 && height > 0) {
			imc = weight / Math.pow(height, 2);
		} else {
			imc = 0;
		}
		
		String result = switch (sex) {
			case 'm', 'M' -> maleImc(imc);
			case 'f', 'F' -> femaleImc(imc);
			default -> "-- ? --";
		};
		
		String msg = String.format("IMC[{0}]: %s", result);
		NumberFormat nf = NumberFormat.getNumberInstance();
		nf.setMaximumFractionDigits(2);
		logger.log(Level.INFO, msg, nf.format(imc));
		scanner.close();
	}
	
	private static String femaleImc(double imc) {
		String info = null;
		if (imc < 19.1) {
			info = "under weight.";
		} else if (imc > 19.2 && imc < 25.8) {
			info = "at ideal weight.";
		} else if (imc > 25.9 && imc < 27.3) {
			info = "a little overweight.";
		} else if (imc > 27.4 && imc < 32.3) {
			info = "over ideal weight.";
		} else {
			info = "obesity.";
		}
		return info;
	}
	
	public static String maleImc(double imc) {
		String info = null;
		if (imc < 20.7) {
			info = "under weight.";
		} else if (imc > 20.8 && imc < 26.4) {
			info = "at ideal weight.";
		} else if (imc > 26.5 && imc < 27.8) {
			info = "a little overweight.";
		} else if (imc > 27.9 && imc < 31.1) {
			info = "over ideal weight.";
		} else {
			info = "obesity.";
		}
		return info;
	}
	
}
