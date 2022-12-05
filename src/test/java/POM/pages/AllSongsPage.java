package POM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class AllSongsPage extends BasePage{

    //locators
    By shuffleBtnLocator = By.cssSelector(".btn-shuffle-all");
    By firstSongSelector = By.cssSelector(".play");

    public AllSongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public void shuffle(){
        driver.findElement(shuffleBtnLocator).click();

    }

    public void DoubleClickFirstSong(){
        actions.doubleClick(driver.findElement(firstSongSelector));
    }
}
