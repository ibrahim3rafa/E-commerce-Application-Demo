package abstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.cartPage;
import pageObjects.orderPage;

import java.time.Duration;

public class abstractComponent {


    @FindBy (css = "[routerlink*='cart']")
            WebElement cartButton;


    @FindBy (css = "[routerlink*='myorders']")
    WebElement orderButton;

    WebDriver driver;
    public abstractComponent(WebDriver driver) {
    this.driver = driver;
    }




    public cartPage goToCart(){
        cartButton.click();
        return new cartPage(driver);
    }

    public void waitWebElementsToAppear(WebElement findBy){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(findBy));
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


    public orderPage goToOrderPage(){
        orderButton.click();
        return new orderPage(driver);
    }

}
