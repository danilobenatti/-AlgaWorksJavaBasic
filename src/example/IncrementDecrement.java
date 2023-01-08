package example;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IncrementDecrement {
	
	public static void main(String[] args) {
		
		Logger logger = Logger.getLogger("");
		
		int age = 10;
		
		age = age + 1;
		logger.log(Level.INFO, "1) Age = {0}", age); // 11
		
		age += 1;
		logger.log(Level.INFO, "2) Age = {0}", age); // 12
		
		age += 3;
		logger.log(Level.INFO, "3) Age = {0}", age); // 15
		
		age -= 5;
		logger.log(Level.INFO, "4) Age = {0}", age); // 10
		
		age++;
		logger.log(Level.INFO, "5) Age = {0}", age); // 11
		logger.log(Level.INFO, "6) Age = {0}", ++age); // 12
		
		int newAge = ++age;
		
		logger.log(Level.INFO, "7) newAge = {0}", newAge); // 13
		logger.log(Level.INFO, "8) Age = {0}", --age); // 12
		
		int oldAge = age--;
		logger.log(Level.INFO, "9) oldAge = {0}", oldAge); // 12
		logger.log(Level.INFO, "10) Age = {0}", age); // 11
		
		int var1 = 5;
		int var2 = 5;
		logger.log(Level.INFO, "var1: {0}", var1++);
		logger.log(Level.INFO, "var2: {0}", ++var2);
		logger.log(Level.INFO, "var1: {0}", var1);
		
		int operand = 0;
		int number = 0;
		
		List<Integer> listSum = new ArrayList<>();
		List<Integer> listSub = new ArrayList<>();
		
		operand = 1;
		++operand; // operand = 2
		number = ++operand; // operand = 3, number = 3
		listSum.add(operand);
		listSum.add(number);
		logger.log(Level.INFO, "Test1: {0}", listSum);
		
		operand = 1;
		operand++; // operand = 2
		number = operand++; // operand = 3, number = 2
		listSum.add(operand);
		listSum.add(number);
		logger.log(Level.INFO, "Test2: {0}", listSum);
		listSum.clear();
		
		operand = 2;
		--operand; // operand = 1
		number = --operand; // operand = 0, number = 0
		listSub.add(operand);
		listSub.add(number);
		logger.log(Level.INFO, "Test3: {0}", listSub);
		
		operand = 2;
		operand--; // operand = 1
		number = operand--; // operand = 0, number = 1
		listSub.add(operand);
		listSub.add(number);
		logger.log(Level.INFO, "Test4: {0}", listSub);
		listSub.clear();
		
	}
	
}
