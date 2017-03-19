package Utils;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@CucumberOptions(features = "src/main/resources/features",
                glue = "Glues",
                format = {"pretty"})
public class cucumberRunner extends AbstractTestNGCucumberTests {


    @BeforeClass
    public void initiateWebDriver(){
        BaseTest.setUp();
    }

    @AfterClass
    public void tearDownWebDriver(){
        BaseTest.tearDown();
    }
}
