package com.example.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

@Component
public class LogViewer {
    private static final Logger logger =
            LoggerFactory.getLogger(LogViewer.class);
    private static final String LOG_FILE_PATH =
            System.getProperty("user.dir") + "/logs/student-crud.log";

    public String readLogFile() {
        try {
            Path logDir = Paths.get(System.getProperty("user.dir") +
                    "/logs");
            logger.debug("Attempting to create log directory: {}",
                    logDir);
            Files.createDirectories(logDir);
            Path logFile = Paths.get(LOG_FILE_PATH);
            logger.debug("Reading log file from: {}", logFile);
            if (Files.exists(logFile)) {
                return
                        Files.lines(logFile).collect(Collectors.joining("\n"));
            } else {
                logger.warn("Log file does not exist: {}", logFile);
                return "Log file not found at: " + LOG_FILE_PATH;
            }
        } catch (Exception e) {
            logger.error("Error reading log file at {}: {}",
                    LOG_FILE_PATH, e.getMessage(), e);
            return "Unable to read logs: " + LOG_FILE_PATH + " - " +
                    e.getMessage();
        }
    }
}