package Pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class logInPage extends commonPage{
    public logInPage(){
        super();
    }

    @FindBy(xpath = "//a[@data-ng-href='#!/action/login']")
    private WebElement logInButton;

    @FindBy(name = "username")
    private WebElement username;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submit;

    @FindBy(css = "a.wf-main-balance__button")
    private WebElement deposit;

    public void logIn(){

        logInButton.click();
        wait(2);
        username.click();
        username.sendKeys(System.getProperty("login"));
        password.click();
        password.sendKeys(System.getProperty("password"));
        submit.click();
        try{
            Assert.assertTrue(deposit.isDisplayed());
        }catch(Exception e){
            prettyLog("\n" + getTime() + ": Log in failed, aborting the test" + "\n");
            Assert.assertTrue(false);
        }
    }
}
