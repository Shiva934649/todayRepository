
package profitUtilspackage;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotsUtil {

    public static String captureScreenshot(WebDriver driver, String testName) {

        try {

            if (driver == null) {
                System.out.println("Driver is NULL. Screenshot cannot be captured.");
                return null;
            }

            TakesScreenshot ts = (TakesScreenshot) driver;

            File source = ts.getScreenshotAs(OutputType.FILE);

            String destination = System.getProperty("user.dir")
                    + "/src/test/resources/Screenshots/"
                    + testName + "_" + System.currentTimeMillis() + ".png";

            File destFile = new File(destination);

            // Create folder automatically
            destFile.getParentFile().mkdirs();

            // Copy screenshot
            FileUtils.copyFile(source, destFile);

            System.out.println("Screenshot saved successfully: " + destination);

            return destination;

        } catch (Exception e) {

            System.out.println("Screenshot capture failed!");
            e.printStackTrace();

            return null;
        }
    }
}
