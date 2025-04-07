package pageObjects;

import abstractComponents.abstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class cartPage extends abstractComponent {

    WebDriver driver;

    public cartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //cart Button
    @FindBy(css = "[routerlink*='cart']")
    WebElement cartButton;

    By cartButtonBy = By.cssSelector("[routerlink*='cart']");


    //cart items
    @FindBy(css = ".cartSection h3")
    List<WebElement> cartItems;

    By cartItemsBy = By.cssSelector(".cartSection h3");


    //checkout
    @FindBy(css = ".subtotal.cf.ng-star-inserted button")
    WebElement checkout;


    public boolean isItemInCart(String itemName) {
        cartButton.click();
        waitElementsToAppear(cartItemsBy);
        return cartItems.stream().anyMatch(item -> item.getText().contains(itemName));
    }

    public placeOrderPage completeCheckout() {
        checkout.click();
        return new placeOrderPage(driver);
    }

}
