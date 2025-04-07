package pageObjects;

import abstractComponents.abstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class orderPage extends abstractComponent {

    WebDriver driver;
    public orderPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }



    @FindBy(css="tr td:nth-child(3)")
    List<WebElement> orderElements;

    By orderElementsBy = By.cssSelector("tr td:nth-child(3)");


    public boolean isItemInOrders(String itemName){
        goToOrderPage();
        waitElementsToAppear(orderElementsBy);
        return orderElements.stream().anyMatch(item -> item.getText().contains(itemName));
    }

}
