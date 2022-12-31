package example;

import java.util.logging.Logger;

public class HelloWorld {
	
	public static void main(String[] args) {
		/**
		 * Bloco de comentário!
		 */
		System.out.println("Hello world!");
		/**
		 * Mensage by logger
		 */
		Logger logger = Logger.getLogger(HelloWorld.class.getName());
		logger.info("\"Hello world!\"\nIs beautiful day!");
	}
	
}
