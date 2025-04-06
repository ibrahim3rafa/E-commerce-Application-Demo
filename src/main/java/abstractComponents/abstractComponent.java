package abstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.landingPage;

import java.time.Duration;

public class abstractComponent {


    WebDriver driver;
    public abstractComponent(WebDriver driver) {
    this.driver = driver;
    }




    public void waitElementsToAppear(By findBy){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }

    public void waitElementsToDisappear(By findBy) throws InterruptedException {

        Thread.sleep(1000);
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
    }

}
