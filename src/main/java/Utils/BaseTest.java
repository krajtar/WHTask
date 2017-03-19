package Utils;


import Pages.commonPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

abstract public class BaseTest {
    static private DesiredCapabilities caps;
    static public WebDriver driver;
    static private String summary = "\n\n";

    static public void setUp(){
            verifyGecko();
            setCapabilities();
            setDriver();
        }

    static public void setCapabilities(){ //We can specify any needed or desired capabilities that will later be used by the driver
        caps = new DesiredCapabilities();
        caps.setCapability("marionette", "true");
    }

    static public void setDriver(){ //Method to start the WebDriver with already defined capabilities
        driver = new FirefoxDriver(caps);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //Setting implicit wait for the entire driver to try to perform actions for up to 10s
        prettyLog("\n" + commonPage.getTime() + ": The driver has been set, beginning the test \n");
    }

    static public void tearDown(){ //After finishing the test, destroying the driver
        driver.quit();
        System.out.println(summary + "\n" + commonPage.getTime() + ": The driver has been quit. Test Finished !");
    }

    static public void verifyGecko(){ //With selenium 3, geckodriver is needed for Mozilla browsers, checking if the system already has a env path for it, if not setting one. Works only for Win64
        if(System.getenv("ProgramFiles(x86)")!=null){
            if(System.getProperty("webdriver.gecko.driver")==null)
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\geckoDriver\\geckodriver.exe");
        }else {
            prettyLog("\n" + commonPage.getTime() + ": That is not a Windwos 64 bit OS, given driver works only under that version\n");
            System.exit(0);
        }
    }

    static public void prettyLog(String log){
        System.out.println(log);
        summary += log;
    }
}
