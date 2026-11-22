
package profitpompackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class profitpomclass {

        private  AndroidDriver driver;
        WebDriverWait wait;
        public profitpomclass(AndroidDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        }
        private By clickloginoption      = AppiumBy.androidUIAutomator("new UiSelector().description(\"Log in\")");
        private By loginwithpassword     = AppiumBy.androidUIAutomator("new UiSelector().description(\"Login with password\")");
        private By clickenteremail       = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(0)");
        private By enterpassword         = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(1)");
        private By startbuttonvisibility = AppiumBy.androidUIAutomator("new UiSelector().description(\"Start\").instance(0)");
        
        public void clickloginoption() {
        wait.until(ExpectedConditions.elementToBeClickable(clickloginoption)).click();
        }
        public void enteremail(String email) {
        WebElement EmailField =wait.until(ExpectedConditions.visibilityOfElementLocated(clickenteremail));
        EmailField.click();
        EmailField.clear();
        EmailField.sendKeys(email);
        }
        public void enterpassword(String pass) {
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(enterpassword));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(pass);
        }
        public void loginwithpass() {
        wait.until(ExpectedConditions.elementToBeClickable(loginwithpassword)).click();
        }
        public boolean isstartbuttonisvisible() {
        try {
        wait.until(ExpectedConditions.visibilityOfElementLocated(startbuttonvisibility));
        return true;
        }catch(Exception e){
        return false;
        
        }
        }
        
        
        
        
    }


