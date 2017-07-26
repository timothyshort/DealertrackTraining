package com.dealertrack.testframeworks;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.Test;

public class LoggingwithLog4j {

	@Test
	public void logTest() {
		System.out.println("This class will implement the log");
		
		// 1. Create Logger Object
		Logger log = Logger.getLogger(getClass());
		
		
		// 2. Configure the Logger Object
		DOMConfigurator.configure("log4j.xml");
		
		
		// 3. Write to the Log File
		log.info("I'm writing to the log file now");
		log.warn("Here's a warning message");
		log.error("This is an error message");
		log.fatal("This is a FATAL message");
		
		
		
	}

}
