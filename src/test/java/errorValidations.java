import org.testng.Assert;
import org.testng.annotations.Test;
import testComponents.baseTest;

import java.io.IOException;

public class errorValidations extends baseTest {


    @Test
    public void submitOrder() throws InterruptedException, IOException {
        lp.userLogin("ibrahiarafa611@gmail.com", "@I3rafa304852");
        Assert.assertEquals(lp.getIncorrectMessage(), "Incorrect email or password.");
        System.out.println(lp.getIncorrectMessage());
    }

}
