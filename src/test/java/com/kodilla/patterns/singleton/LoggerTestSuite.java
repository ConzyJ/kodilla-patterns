package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LoggerTestSuite {

    @Test
    void testLog() {

        Logger logger = Logger.INSTANCE;
        logger.log("First log message");


        String lastLog = logger.getLastLog();


        assertEquals("First log message", lastLog);
    }

    @Test
    void testMultipleLogs() {

        Logger logger = Logger.INSTANCE;
        logger.log("Log entry 1");
        logger.log("Log entry 2");


        String lastLog = logger.getLastLog();


        assertEquals("Log entry 2", lastLog);
    }
}
