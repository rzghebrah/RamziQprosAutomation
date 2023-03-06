package com.qpros.demoblaze.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import static com.qpros.demoblaze.logger.AutomationLogger.Logger;

public class AutomationUtil {

    public String generateRandomValue() {
        String randomValue = String.valueOf(System.currentTimeMillis());
        return randomValue;
    }

    public void takeScreenshot(WebDriver driver) throws IOException {
        TakesScreenshot screenshot = ((TakesScreenshot) driver);
        try {
            File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
            File destFile = new File(System.getProperty("user.dir") + File.separator + "target" + File.separator + "screenshots" + File.separator + "FailedScreenshot_" + LocalDateTime.now() + ".png");
            FileUtils.copyFile(srcFile, destFile);
            Logger("Screenshot Reference: \n" + destFile.getAbsolutePath());
        } catch (UnhandledAlertException alertException) {
            Logger(String.valueOf(alertException.getAlert()));
        }
    }

}
