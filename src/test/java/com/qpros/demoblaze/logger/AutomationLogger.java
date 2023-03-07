package com.qpros.demoblaze.logger;


import java.util.logging.Logger;

public class AutomationLogger {
    public final static Logger logger = Logger.getLogger(AutomationLogger.class.getName());

    public static void Logger(String message) {
        logger.info("\n" + message);
    }
}
