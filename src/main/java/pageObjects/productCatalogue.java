package pageObjects;

import abstractComponents.abstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class productCatalogue extends abstractComponent {
    WebDriver driver;

    public productCatalogue(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //all products
    @FindBy(css = ".col-lg-4.col-md-6.col-sm-10.offset-md-0.offset-sm-1.mb-3.ng-star-inserted")
    List<WebElement> products;

    By prod = By.cssSelector(".col-lg-4.col-md-6.col-sm-10.offset-md-0.offset-sm-1.mb-3.ng-star-inserted");


    //allproduct add to cart button
    @FindBy(xpath = "//button[@class='btn w-10 rounded'][normalize-space()='Add To Cart']")
    List<WebElement> prodButtons;

    By prodButt = By.xpath("//button[@class='btn w-10 rounded'][normalize-space()='Add To Cart']");

    //add to cart message
    @FindBy(id = "toast-container")
    WebElement message;

    By messageBy = By.id("toast-container");


    //add to cart message disappearing
    @FindBy(css = ".ng-animating")
    WebElement messageDisappear;

    By messageDisappearBy = By.cssSelector(".ng-animating");


    //method to get all products in the page
    public List<WebElement> getProducts() {
        waitElementsToAppear(prod);
        return products;
    }

    //method to get add to cart buttons at the page
    public List<WebElement> getAddToCartButton() {
        waitElementsToAppear(prodButt);
        return prodButtons;
    }


    //method to add specific item to cart and wait message to disappear
    public cartPage addToCart(List<WebElement> products, List<WebElement> productsButtons, String itemName) throws InterruptedException {

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getText().contains(itemName)) {
                productsButtons.get(i).click();
            }
        }

        waitElementsToAppear(messageBy);
        waitElementsToDisappear(messageDisappearBy);

        return new cartPage(driver);
    }



}
