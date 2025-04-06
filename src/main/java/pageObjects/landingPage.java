package pageObjects;

import abstractComponents.abstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class landingPage extends abstractComponent {

    WebDriver driver;

    WebDriverWait wait;
    public landingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Initialize WebDriverWait
    }

    @FindBy(id = "userEmail")
    WebElement email;

    @FindBy(id = "userPassword")
    WebElement password;

    @FindBy(id = "login")
    WebElement submit;


    @FindBy(css = "[class*='ng-star-inserted']")
    WebElement incorrectMessage;
//ng-tns-c4-12 toast-message ng-star-inserted


    public void getURL() {
        driver.get("https://rahulshettyacademy.com/client");

    }

    public productCatalogue userLogin(String userEmail, String userPass) {
        email.sendKeys(userEmail);
        password.sendKeys(userPass);
        submit.click();
        return new productCatalogue(driver);
    }

    public String getIncorrectMessage(){
        waitWebElementsToAppear(incorrectMessage);
        return incorrectMessage.getText();
    }

}
