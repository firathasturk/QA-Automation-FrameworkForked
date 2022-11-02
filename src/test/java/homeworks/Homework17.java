package homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.internal.BaseTestMethod;

import java.time.Duration;

@Test(description = "addSongToPlaylist")
public class Homework17 extends BaseTest {

    @Test(priority = 0)
    public void LoginValidEmailValidPasswordTest () {

        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.click();
        emailField.sendKeys("frathasturk@gmail.com");

        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.click();
        passwordField.sendKeys("Testpro12345!");

        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();

    }

    @Test(priority = 1)
    public void CreateNewPlaylist() throws InterruptedException {

        WebElement createNewPlaylist = driver.findElement(By.xpath("//i[@title='Create a new playlist']"));
        Thread.sleep(2000);
        createNewPlaylist.click();

        WebElement newPlaylist  = driver.findElement(By.xpath("//*[contains(text(),'New Playlist']"));
        newPlaylist.click();

        WebElement newPlaylistNameField = driver.findElement(By.xpath("//*[contains(@placeholder, 'to save')]"));
        newPlaylistNameField.sendKeys("NewPlaylist1");
        newPlaylistNameField.click();

    }

    @Test(priority = 2)
    public void addSongToPlaylist(){

        WebElement AllSongs = driver.findElement(By.xpath("//*[contains(@href, '#!/songs')]"));
        AllSongs.click();

        driver.findElement(By.xpath(""))

                //Could you please help me how I can locate the song?
        
    }


}
