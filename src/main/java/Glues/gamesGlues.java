package Glues;

import Pages.gamePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;


public class gamesGlues {
    @And("^user displays A-Z list$")
    public void userDisplaysAZList(){

        gamePage gameObj = new gamePage();
        gameObj.goToListAZ();

    }

    @Then("^user can count number of games$")
    public void userCanCountNumberOfGames(){

        gamePage gameObj = new gamePage();
        gameObj.countGames();
        gameObj.listGames();

    }
}
