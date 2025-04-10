package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.cartPage;
import pageObjects.productCatalogue;
import testComponents.baseTest;
import testData.retry;

import java.io.IOException;
import java.util.List;

public class errorValidationsTest extends baseTest {


    @Test(groups = {"errorHandling"},retryAnalyzer = retry.class)
    public void loginErrorValidation() throws InterruptedException ,IOException {



      lp.userLogin("ibrahiarafa611@gmail.com", "@I3rafa304852");
        Assert.assertEquals(lp.getIncorrectMessage(), "Incorrect email password.");
        System.out.println(lp.getIncorrectMessage());
    }

    @Test
    public void productValidationError() throws InterruptedException {
        String productName = "IPHONE 13 PRO";
        productCatalogue pC = lp.userLogin("ibrahimarafa611@gmail.com", "@I3rafa304852");
        List<WebElement> products = pC.getProducts();
        List<WebElement> productButtons = pC.getAddToCartButton();
        cartPage cartP = pC.addToCart(products, productButtons, productName);
        org.junit.Assert.assertTrue(cartP.isItemInCart(productName));
        Assert.assertFalse(cartP.isItemInCart("\"IPHONE 133 PRO2\""));
    }


}
