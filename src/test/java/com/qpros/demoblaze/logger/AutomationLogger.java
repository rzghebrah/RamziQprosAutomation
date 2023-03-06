package com.qpros.demoblaze.logger;

import org.testng.Reporter;

import java.util.logging.Logger;

public class AutomationLogger {
    public final static Logger logger = Logger.getLogger(AutomationLogger.class.getName());

    public static void Logger(String message) {
        logger.info("\n" + message);
        Reporter.log("\n" + message);
    }
}
