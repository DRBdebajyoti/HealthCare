package Screenshot;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Browser.browser;   // your existing Browser class

public class capture extends browser {

    public static void takeScreenshot(String name) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);

            String timestamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss"));

            String path = System.getProperty("user.dir")
                    + File.separator + "target"
                    + File.separator + "screenshots"
                    + File.separator + name + "_" + timestamp + ".png";

            File destination = new File(path);
            FileUtils.copyFile(source, destination);

            System.out.println("Screenshot captured: " + path);

        } catch (Exception e) {
            System.out.println("Unable to capture screenshot");
            e.printStackTrace();
        }
    }
}