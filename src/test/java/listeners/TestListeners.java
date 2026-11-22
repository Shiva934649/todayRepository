
package listeners;

import java.lang.reflect.Field;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import profitUtilspackage.ScreenshotsUtil;

public class TestListeners implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {

        System.out.println("Test Started: " + result.getName());

    }

    @Override
    public void onTestSuccess(ITestResult result) {

        System.out.println("Test Passed: " + result.getName());

    }

    @Override
    public void onTestFailure(ITestResult result) {

        System.out.println("Test Failed: " + result.getName());

        try {

            Object testClass = result.getInstance();

            Class<?> currentClass = testClass.getClass();

            Field driverField = null;

            // Search driver in class and its parent classes
            while (currentClass != null) {

                try {

                    driverField = currentClass.getDeclaredField("driver");
                    break;

                } catch (NoSuchFieldException e) {

                    currentClass = currentClass.getSuperclass();

                }
            }

            if (driverField == null) {

                throw new RuntimeException("Driver field not found!");

            }

            driverField.setAccessible(true);

            WebDriver driver = (WebDriver) driverField.get(testClass);

            if (driver == null) {

                System.out.println("Driver is NULL!");

                return;
            }

            ScreenshotsUtil.captureScreenshot(driver, result.getName());

        } catch (Exception e) {

            System.out.println("Listener screenshot error!");

            e.printStackTrace();

        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        System.out.println("Test Skipped: " + result.getName());

    }
}
