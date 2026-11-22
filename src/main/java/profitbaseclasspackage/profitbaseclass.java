package profitbaseclasspackage;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class profitbaseclass {

	
	protected AndroidDriver driver;
	@BeforeMethod
	public void setup() throws MalformedURLException {
	UiAutomator2Options options = new UiAutomator2Options();
	options.setPlatformName("Android");
	options.setAutomationName("UiAutomator2");
	options.setDeviceName("Android Device");
	options.setAppPackage("com.grafterr.grafterr_pos");
	options.setAppActivity(".MainActivity");
	options.setNoReset(false);
    driver= new AndroidDriver (new URL("http://127.0.0.1:4723"),options);
    options.setNoReset(false);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    System.out.println("Application launched Successfully");
	}
	@AfterMethod
	public void teardown() {
	if(driver!=null) {
	driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	}

}
