package example;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class VariablesJavaI {
	
	public static void main(String[] args) {
		
		String name = "Peter";
		char gener = 'M';
		int age = 10;
		float height = 1.82f;
		double weight = 83.5;
		age += 2 * (5 + 5) * 2.2;
		Year birthYear = Year.now().minusYears(age);
		boolean isAlive = true;
		
		List<Object> person = new ArrayList<>();
		person.add(name);
		person.add(gener);
		person.add(age);
		person.add(height);
		person.add(weight);
		person.add(birthYear);
		person.add(isAlive);
		
		Logger logger = Logger.getLogger("");
		logger.info(person::toString);
		
	}
	
}
