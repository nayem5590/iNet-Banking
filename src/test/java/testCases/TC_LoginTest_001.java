package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass
{
    @Test
    public void loginTest()
    {

        Logger.info("URL is Opened");

        LoginPage lp = new LoginPage(driver);
        lp.setUserName(username);
        Logger.info("Entered username");

        lp.setPassword(password);
        Logger.info("Entered Password");
        lp.clickSubmit();


        if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
        {
            Assert.assertTrue(true);
            Logger.info("Login Test Passed");
        }
        else
        {
            Assert.assertTrue(false);
            Logger.info("Login Test Failed");
        }

    }
}
