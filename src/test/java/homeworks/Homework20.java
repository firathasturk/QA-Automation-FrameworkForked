package homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework20 extends BaseTest{

    @Test
    public void DeletePlaylist() throws InterruptedException {

        logIn();
        selectPlaylist();
        pressDeletePlaylist();
        Assert.assertEquals(getConfirmationPopupText(),"Deleted Playlist");
    }

    public void selectPlaylist() throws InterruptedException {

        WebElement myPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='playlists']")));
        myPlaylist.click();
    }

    private void pressDeletePlaylist() throws InterruptedException {
        WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='del btn-delete-playlist']")));
        deleteButton.click();
    }

    private String getConfirmationPopupText(){
        return driver.findElement(By.cssSelector("div.success.show")).getText();
    }



}
