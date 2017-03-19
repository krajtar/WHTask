package Pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    public void logIn(){

        logInButton.click();
        wait(2);
        username.click();
        username.sendKeys(System.getProperty("login"));
        password.click();
        password.sendKeys(System.getProperty("password"));
        submit.click();
    }
}
