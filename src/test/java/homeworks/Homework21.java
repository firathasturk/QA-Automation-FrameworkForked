package homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;

@Test
public class Homework21 extends BaseTest {

    String playlistName = "Firat's updated Playlist";

    public void renamePlaylist() {

        logIn();
        selectPlaylist();
        contextClickSelectedPlaylist();
        enterPlaylistName();
        Assert.assertTrue(doesPlaylistExist());

    }

    public void selectPlaylist() {

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".playlist:nth-child(4)"))).click();
    }

    public void contextClickSelectedPlaylist() {

        Actions actions;
        actions = new Actions(driver);

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".playlist:nth-child(4)"))).click();
        WebElement playlistElement = driver.findElement(By.cssSelector(".playlist:nth-child(4)"));

        actions.contextClick(playlistElement).perform();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[data-testid='playlist-context-menu-edit']"))).click();

    }

    public void enterPlaylistName() {

        WebElement playListInputField = driver.findElement(By.cssSelector("input[name='name']"));
        playListInputField.sendKeys((Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE)));
        playListInputField.sendKeys(playlistName);
        playListInputField.sendKeys(Keys.ENTER);

    }

    public boolean doesPlaylistExist() {
        WebElement playlistElement = driver.findElement(By.xpath("//a[text()='"+playlistName+"']"));
        return playlistElement.isDisplayed();

    }
}


