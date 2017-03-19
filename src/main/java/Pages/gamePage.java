package Pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class gamePage extends commonPage {
    public gamePage(){
        super();
    }

    @FindBy(css = "div.game-tile.ng-scope.ng-isolate-scope.wf-game-tile img.main-image")
    private List<WebElement> games;

    @FindBy(xpath = "//a[@class = 'ng-scope'][@title='A-Z']")
    private WebElement azList;

    public void goToListAZ(){
        wait(2);
        azList.click();
    }

    public int countGames(){
        int numOfGames;
        do{
            numOfGames = games.size();
            wait(2);
        }while(games.size()!=numOfGames); //Since the number of games is changing until all of them are loaded, I check every 2 seconds whether the total number changed

        prettyLog("\n" + getTime() + ": Number of games is : " + games.size() + "\n");
        return numOfGames;
    }

    public void listGames(){ //List all the names of the games
        System.out.println("\n " + getTime() + ": List of games : \n");
        for(WebElement we : games){
            System.out.println("\n" + we.getAttribute("alt"));
        }
    }
}
