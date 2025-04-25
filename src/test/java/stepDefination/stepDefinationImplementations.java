package stepDefination;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pageObjects.cartPage;
import pageObjects.productCatalogue;
import pageObjects.submitPage;
import testComponents.baseTest;

import java.io.IOException;
import java.util.List;

public class stepDefinationImplementations extends baseTest {

    public productCatalogue pC;
    public cartPage cartP;
    public submitPage placeOrder;

    @Given("I landed on ECommerce website")
    public void i_Landed_on_ecommerce_website() throws IOException {
        launchApplication();
    }


    @Given("^I loggen with (.+) and (.+)$")
    public void I_login_with_userName_PASS(String userName, String Password) {
        pC = lp.userLogin(userName, Password);
    }


    @When("^I add product to Cart (.+)$")
    public void I_Add_Product_To_Cart(String productName) throws InterruptedException {
        List<WebElement> products = pC.getProducts();
        List<WebElement> productButtons = pC.getAddToCartButton();
        cartP = pC.addToCart(products, productButtons, productName);
        Assert.assertTrue(cartP.isItemInCart(productName));

    }

    @And("Complete checkout and submit the order")
    public void Complete_Checkout_And_Submit() {
        placeOrder = cartP.completeCheckout();
        placeOrder.selectionFromSuggestiveDropdown();
        placeOrder.submitOrder();
    }


    @Then("Verify {string} message appears")
    public void Verify_Message(String string) {
        Assert.assertEquals(string, placeOrder.confirmationMessages().toLowerCase());
        driver.close();
    }

}
