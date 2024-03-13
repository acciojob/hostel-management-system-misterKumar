package com.driver;

import java.util.logging.Level;
import java.util.logging.Logger;

public class HostelLogger {
    private static final Logger LOGGER = Logger.getLogger(HostelLogger.class.getName());

    public static void logInfo(String message) {
    	//your code goes here
        LOGGER.log(Level.INFO, message);
    }

    public static void logWarning(String message) {
    	//your code goes here
        LOGGER.log(Level.WARNING, message);
    }

    public static void logError(String message, Throwable throwable) {
    	//your code goes here
        LOGGER.log(Level.SEVERE, message, throwable);
    }
}
