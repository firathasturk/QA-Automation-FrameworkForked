package homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {

    @Test
    public void playSong() throws InterruptedException {
        
        provideEmail("frathasturk@gmail.com");
        providePassword("Testpro12345!");
        clickSubmitBtn();
        playASong();

        WebElement visualizer = driver.findElement(By.xpath("//button[@title='Click for a marvelous visualizer!']"));
        Assert.assertTrue(visualizer.isDisplayed());


    }


    private void playASong() throws InterruptedException {

        WebElement nextBtn = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
        nextBtn.click();
    }

}
