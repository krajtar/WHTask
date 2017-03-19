package Pages;


import Utils.BaseTest;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.sql.Timestamp;
import java.util.Date;


public class commonPage extends BaseTest{
    public commonPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//link[@rel='stylesheet']")
    private WebElement versionElement;

    public String getSiteVersion(){
        String href = versionElement.getAttribute("href"); //Obtaining attribute that has the version number and splitting it into pieces
        String parts[] = href.split("/");

        for(String s : parts){ //Checks every part of the 'href' attribute to find one that contains site version
            if(s.equals("")) //if there's an empty string skip verification
                continue;
            s = s.replaceAll("[^0-9.]", "!"); //Filters string to search only for numbers and ., otherwise changes string to !
            if(!s.contains("!")) //If there are no ! (only numbers and . found in string) then return the string and finish
                return s;
        }
        return null;
    }

    public void wait(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void getStackCookie(){
        for(Cookie c : driver.manage().getCookies()){
            System.out.print("\n" + c.getName());
        }
    }

    static public String getTime(){ //Returns a string with current time
        Date date = new Date();
        return (new Timestamp(date.getTime()).toString());
    }
}
