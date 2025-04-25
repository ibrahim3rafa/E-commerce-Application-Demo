package tests;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.cartPage;
import pageObjects.orderPage;
import pageObjects.productCatalogue;
import pageObjects.submitPage;
import testComponents.baseTest;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class submitOrderTest extends baseTest {

   String productName = "IPHONE 13 PRO";


    @Test(dataProvider="getData" , groups = {"purchase"})
    public void submitOrder(HashMap<String,String> input ) throws InterruptedException, IOException {

        this.productName = input.get("productName");
//     landingPage lp = launchApplication();
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


    @Test(dependsOnMethods = {"submitOrder"})
    public void verifyOrders() {
        productCatalogue pC = lp.userLogin("ibrahimarafa611@gmail.com", "@I3rafa304852");
        orderPage orderPageObject = pC.goToOrderPage();
        boolean match = orderPageObject.isItemInOrders(productName);
       Assert.assertTrue(match);
    }


//    @DataProvider
//    public Object[][] getData(){
//        return new Object[][] {{"ibrahimarafa611@gmail.com","@I3rafa304852","IPHONE 13 PRO"},{"ibrahimarafa611@gmail.com","@I3rafa304852","ADIDAS ORIGINAL"}};
//    }
//HashMap<String,String> map = new HashMap<String,String>();
//        map.put("mail","ibrahimarafa611@gmail.com");
//        map.put("pass","@I3rafa304852");
//            map.put("productName","IPHONE 13 PRO");
//
//    HashMap<String,String> map1 = new HashMap<String,String>();
//        map1.put("mail","ibrahimarafa611@gmail.com");
//        map1.put("pass","@I3rafa304852");
//        map1.put("productName","ADIDAS ORIGINAL");
//



    @DataProvider
    public Object[][] getData() throws IOException {

        List<HashMap<String, String>> data = getJsonDataToMap(new File(System.getProperty("user.dir")+"//src//test//java//testData//purchaseOrder.json"));

        return new Object[][] {{data.get(0)},{data.get(1)}};
    }


}
