package homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {

    WebDriver driver;
    String url;

    @BeforeSuite
    public static void chromeConfigs() {
        // This is for Windows users
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        }
    }

    @BeforeMethod
    @Parameters({"baseURL"})
    public void launchBrowser(String baseURL){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        url = "https://bbb.testpro.io/";
        driver.get(url);
    }

    public void provideEmail(String email){
        WebElement emailField = driver.findElement(By.cssSelector("[type='submit']"));
        emailField.click();
        emailField.sendKeys("frathasturk@gmail.com");
    }

    public void providePassword(String password){
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.click();
        passwordField.sendKeys("Testpro12345!");
    }

    public void clickSubmitBtn() {
        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();
    }

    public void deletePlaylist(){

        WebElement openPlaylist = driver.findElement(By.xpath("//a[@href='playlists']"));
        openPlaylist.click();

        WebElement deleteButton = driver.findElement(By.xpath("//*[@class='del btn-delete-playlist']"));
        deleteButton.click();
    }

    public void logIn(){
        provideEmail("frathasturk@gmail.com");
        providePassword("Testpro12345!");
        clickSubmitBtn();
    }





    @AfterMethod
    public void tearDownBrowser(){
        driver.quit();

    }

}
