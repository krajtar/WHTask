package Glues;

import Pages.commonPage;
import Utils.BaseTest;
import cucumber.api.java.en.When;

public class commonGlues extends BaseTest{

    @When("^user goes to (.*)$")
    public void userGoes(String site){

        if(!site.startsWith("http://"))
            site = "http://" + site;
        driver.navigate().to(site);
        getSiteVer();

    }

    public void getSiteVer(){
        commonPage pageObj = new commonPage();
        prettyLog("\n" +  pageObj.getTime() + ": Site version is : " + pageObj.getSiteVersion() + "\n");
        pageObj.getStackCookie();
    }


}
