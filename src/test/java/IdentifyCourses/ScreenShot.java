package IdentifyCourses;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShot {
    WebDriver driver;

    public ScreenShot(WebDriver driver) {
        this.driver = driver;
    }

    public void takeScreenshot(String screenshotName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File destination = new File(System.getProperty("user.dir") + "\\HackathonScreenShots\\" + screenshotName + ".png");

        try {
            FileHandler.copy(source, destination);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error in taking screenshot");
        }
    }
}
