package example;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SwitchExample {
	
	public static void main(String[] args) {
		Logger logger = Logger.getLogger("");
		logger.log(Level.INFO, "{0}", formatter(1));
		logger.log(Level.INFO, "{0}", formatter(18L));
		logger.log(Level.INFO, "{0}", formatter(1.8f));
		logger.log(Level.INFO, "{0}", formatter(1.8));
		logger.log(Level.INFO, "{0}", formatter("1.8"));
		logger.log(Level.INFO, "{0}", formatter('A'));
		logger.log(Level.INFO, "{0}", formatter(true));
		
		logger.log(Level.INFO, "{0}", formatterPatternSwitch(1));
		logger.log(Level.INFO, "{0}", formatterPatternSwitch(18L));
		logger.log(Level.INFO, "{0}", formatterPatternSwitch(1.8F));
		logger.log(Level.INFO, "{0}", formatterPatternSwitch(1.8));
		logger.log(Level.INFO, "{0}", formatterPatternSwitch("1.8"));
		logger.log(Level.INFO, "{0}", formatterPatternSwitch('A'));
		logger.log(Level.INFO, "{0}", formatterPatternSwitch(true));
		
		logger.log(Level.INFO, "{0}", switchMonth(Month.JULY));
		logger.log(Level.INFO, "{0}", switchMonth(Month.FEBRUARY));
		logger.log(Level.INFO, "{0}", switchMonth(Month.AUGUST));
		logger.log(Level.INFO, "{0}", switchDayOfWeek());
		
		logger.log(Level.INFO, "{0}", newSwitch(1));
		logger.log(Level.INFO, "{0}", newSwitch(18L));
		logger.log(Level.INFO, "{0}", newSwitch(1.8f));
		logger.log(Level.INFO, "{0}", newSwitch(1.8));
		logger.log(Level.INFO, "{0}", newSwitch("1.8"));
		logger.log(Level.INFO, "{0}", newSwitch('A'));
		logger.log(Level.INFO, "{0}", newSwitch(true));
		logger.log(Level.INFO, "{0}", newSwitch(null));
	}
	
	static String formatter(Object object) {
		String formatted = "unknow";
		if (object instanceof Integer i) {
			formatted = String.format("int %d", i);
		} else if (object instanceof Long l) {
			formatted = String.format("long %d", l);
		} else if (object instanceof Float f) {
			formatted = String.format("float %f", f);
		} else if (object instanceof Double d) {
			formatted = String.format("double %f", d);
		} else if (object instanceof String s) {
			formatted = String.format("string %s", s);
		} else if (object instanceof Character s) {
			formatted = String.format("char %s", s);
		} else if (object instanceof Boolean s) {
			formatted = String.format("boolean %s", s);
		}
		return formatted;
	}
	
	static String formatterPatternSwitch(Object object) {
		String simpleName = object.getClass().getSimpleName();
		return switch (simpleName) {
			case "Integer" -> String.format("%s", simpleName);
			case "Long" -> String.format("%s", simpleName);
			case "Float" -> String.format("%s", simpleName);
			case "Double" -> String.format("%s", simpleName);
			case "String" -> String.format("%s", simpleName);
			case "Character" -> String.format("%s", simpleName);
			case "Boolean" -> String.format("%s", simpleName);
			default -> null;
		};
	}
	
	static int switchMonth(Month month) {
		return switch (month) {
			case JANUARY, JUNE, JULY -> 3;
			case FEBRUARY, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER -> 1;
			case MARCH, MAY, APRIL, AUGUST -> {
				int monthLength = month.toString().length();
				yield monthLength * 4;
			}
			default -> 0;
		};
	}
	
	static String switchDayOfWeek() {
		LocalDate now = LocalDate.now();
		DayOfWeek dayOfWeek = DayOfWeek.from(now);
		return switch (dayOfWeek) {
			case SUNDAY, SATURDAY -> "Weekend";
			case FRIDAY, THURSDAY, WEDNESDAY, TUESDAY, MONDAY -> "Weekday";
		};
	}
	
	@SuppressWarnings("preview")
	static String newSwitch(Object object) {
		return switch (object) {
			case Integer i -> String.format("It is an integer %d", i);
			case Long l -> String.format("It is an long %d", l);
			case Float f -> String.format("It is an float %f", f);
			case Double d -> String.format("It is an double %f", d);
			case String s -> String.format("It is a string %s", s);
			case Character c -> String.format("It is a char %s", c);
			case Boolean b -> String.format("It is a boolean %s", b);
			case null -> "It is a null object";
			default -> object.toString();
		};
	}
}
