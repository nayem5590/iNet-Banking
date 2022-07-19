package testCases;

import groovy.console.ui.Console;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import utilities.ReadConfig;

import java.util.logging.Logger;

public class BaseClass {

    ReadConfig readConfig = new ReadConfig();

    public String baseURL= readConfig.getApplicationURL();
    public String username= readConfig.getUsername();
    public String password= readConfig.getPassword();
    public static WebDriver driver;

    public static Logger Logger;

    @Parameters("browser")
    @BeforeClass
    public void setup( String br)
    {
        Logger = Logger.getLogger("eBanking");
        PropertyConfigurator.configure("Log4j.properties");

        if(br.equals("chrome"))
        {System.setProperty("webdriver.chrome.driver",readConfig.getChromepath());
        driver= new ChromeDriver();
        }
        else if (br.equals("ed")){
            System.setProperty("webdriver.edge.driver",readConfig.getedpath());
            driver= new EdgeDriver();

        }
        else if(br.equals("firefox"))
        {
            System.setProperty("webdriver.gecko.driver",readConfig.getFirefoxpath());
            driver= new FirefoxDriver();
        }

        driver.get(baseURL);

    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }


}
