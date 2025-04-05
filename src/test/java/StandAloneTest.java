import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.cartPage;
import pageObjects.landingPage;
import pageObjects.placeOrderPage;
import pageObjects.productCatalogue;

import java.time.Duration;
import java.util.List;

public class StandAloneTest {
    public static void main(String[] args) throws InterruptedException {

        String productName = "IPHONE 13 PRO";
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        landingPage lp = new landingPage(driver);
        lp.getURL();
        productCatalogue pC = lp.userLogin("ibrahimarafa611@gmail.com", "@I3rafa304852");
//        productCatalogue pC = new productCatalogue(driver);
        List<WebElement> products = pC.getProducts();
        List<WebElement> productButtons = pC.getAddToCartButton();
        cartPage cartP = pC.addToCart(products, productButtons, productName);

        Assert.assertTrue(cartP.isItemInCart(productName));
        placeOrderPage placeOrder = cartP.completeCheckout();

        placeOrder.selectionFromSuggestiveDropdown();
        placeOrder.submitOrder();
        Assert.assertEquals("thankyou for the order.", placeOrder.confirmationMessages().toLowerCase());
        driver.close();
    }

}
