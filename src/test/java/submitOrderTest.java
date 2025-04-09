import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.*;
import testComponents.baseTest;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class submitOrderTest extends baseTest {

    String productName = "IPHONE 13 PRO";
    @Test(dataProvider = "getData", groups = "purchase")

    public void submitOrder(HashMap<String,String> input) throws InterruptedException, IOException {

        this.productName = input.get("productName");
//         landingPage lp = launchApplication();
        productCatalogue pC = lp.userLogin(input.get("mail"), input.get("pass"));
        List<WebElement> products = pC.getProducts();
        List<WebElement> productButtons = pC.getAddToCartButton();
        cartPage cartP = pC.addToCart(products, productButtons, productName);
        Assert.assertTrue(cartP.isItemInCart(productName));
        submitPage placeOrder = cartP.completeCheckout();
        placeOrder.selectionFromSuggestiveDropdown();
        placeOrder.submitOrder();
        Assert.assertEquals("thankyou for the order.", placeOrder.confirmationMessages().toLowerCase());
    }

    @Test(dependsOnMethods= {"submitOrder"})
    public void OrderHistoryTest(String productName)
    {
        productCatalogue pC = lp.userLogin("ibrahimarafa611@gmail.com", "@I3rafa304852");
        orderPage orderpage = pC.goToOrderPage();
        Assert.assertTrue(orderpage.isItemInOrders(productName));

    }

    @DataProvider
    public Object[][] getData() throws IOException {

        List<HashMap<String,String>> data = getJsonDataToMap(new File(System.getProperty("user.dir") + "//src//test//java//testData//purchaseOrder.json"));

        return new Object[][] {{data.get(0)},{data.get(1)}};

    }


}
