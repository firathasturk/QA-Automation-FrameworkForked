package homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{

    @Test
    public void DeletePlaylist() throws InterruptedException {

        logIn();
        selectPlaylist();
        pressDeletePlaylist();
        Assert.assertEquals(getConfirmationPopupText(),"Deleted Playlist");
    }

    public void selectPlaylist() throws InterruptedException {

        WebElement myPlaylist = driver.findElement(By.xpath("//a[@href='playlists']"));
        myPlaylist.click();
        Thread.sleep(5000);
    }

    private void pressDeletePlaylist() throws InterruptedException {
        WebElement deleteButton = driver.findElement(By.xpath("//*[@class='del btn-delete-playlist']"));
        deleteButton.click();
        Thread.sleep(4000);
    }

    private String getConfirmationPopupText(){
        return driver.findElement(By.cssSelector("div.success.show")).getText();
    }



}
