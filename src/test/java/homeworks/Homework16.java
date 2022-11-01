package homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework16 {

    @Test
    public void createNewPlaylist() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        driver.get(url);

        WebElement emailField = driver.findElement(By.cssSelector("[type = 'email']"));
        emailField.click();
        emailField.sendKeys("frathasturk@gmail.com");

        WebElement passwordField = driver.findElement(By.cssSelector("[type = 'password']"));
        passwordField.click();
        passwordField.sendKeys("Testpro12345!");

        WebElement submitButton = driver.findElement(By.cssSelector("[type = 'submit']"));
        submitButton.click();

        WebElement createNewPlaylist = driver.findElement(By.xpath("//i[@title='Create a new playlist']"));
        Thread.sleep(2000);
        createNewPlaylist.click();

       WebElement newPlaylist  = driver.findElement(By.xpath("//*[contains(text(),'New Playlist']"));
        newPlaylist.click();

        WebElement newPlaylistNameField = driver.findElement(By.xpath("//*[contains(@placeholder, 'to save')]"));
        newPlaylistNameField.sendKeys("firathasturk");
        newPlaylistNameField.click();

        WebElement newPlaylist1= driver.findElement(By.xpath("//*[contains(@href, '#!/playlist/26085')]"));
        Thread.sleep(2000);
        Assert.assertTrue(newPlaylist1.isDisplayed());
        driver.quit();


        





    }
}
