package pageObjects;

import abstractComponents.abstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class landingPage extends abstractComponent {

    WebDriver driver;

    public landingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "userEmail")
    WebElement email;

    @FindBy(id = "userPassword")
    WebElement password;

    @FindBy(id = "login")
    WebElement submit;


    public void getURL() {
        driver.get("https://rahulshettyacademy.com/client");

    }

    public productCatalogue userLogin(String userEmail, String userPass) {
        email.sendKeys(userEmail);
        password.sendKeys(userPass);
        submit.click();
        return new productCatalogue(driver);
    }

}
