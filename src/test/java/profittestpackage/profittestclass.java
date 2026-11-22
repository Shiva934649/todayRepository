package profittestpackage;

import java.time.Duration;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import listeners.TestListeners;
import profitbaseclasspackage.profitbaseclass;
import profitpompackage.profitpomclass;
@Listeners(TestListeners.class)

public class profittestclass extends profitbaseclass {
@Test (priority=1,groups= {"smoke"})
public void VerifyLoginFunctionality() {
Reporter.log("========== Login Screen Launched Successfully ==========");
profitpomclass login = new profitpomclass(driver);
login.clickloginoption();
Reporter.log("Login Button clicked Successfully");
login.enterpassword("Shiva@12345");
Reporter.log("Password Entered Successfully");
login.enteremail("arepatiranga@gmail.com");
Reporter.log("Email entered Successfully");
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
login.loginwithpass();
Reporter.log("Login with password clicked Successfully");
login.loginwithpass();
Reporter.log("Login with password cliked successfully");
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
boolean actualresult = login.isstartbuttonisvisible();
Reporter.log("startbuttonvisibility:"+actualresult,true);
Assert.assertTrue(actualresult,"Start button is not visible Login Failed");

}
}
