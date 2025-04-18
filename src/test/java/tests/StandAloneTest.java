package tests;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pageObjects.cartPage;
import pageObjects.productCatalogue;
import pageObjects.submitPage;
import testComponents.baseTest;

import java.io.IOException;
import java.util.List;

public class StandAloneTest extends baseTest {


    @Test
    public void submitOrder() throws InterruptedException, IOException {
        String productName = "IPHONE 13 PRO";
        productCatalogue pC = lp.userLogin("ibrahimarafa611@gmail.com", "@I3rafa304852");
        List<WebElement> products = pC.getProducts();
        List<WebElement> productButtons = pC.getAddToCartButton();
        cartPage cartP = pC.addToCart(products, productButtons, productName);
        Assert.assertTrue(cartP.isItemInCart(productName));
        submitPage placeOrder = cartP.completeCheckout();
        placeOrder.selectionFromSuggestiveDropdown();
        placeOrder.submitOrder();
        Assert.assertEquals("thankyou for the order.", placeOrder.confirmationMessages().toLowerCase());
    }

}
