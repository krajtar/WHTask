package Glues;


import Pages.logInPage;
import cucumber.api.java.en.And;

public class loginGlues {


    @And("^user logs into the portal$")
    public void userLogs() throws Throwable {
        logInPage logObj = new logInPage();
        logObj.logIn();
    }
}
