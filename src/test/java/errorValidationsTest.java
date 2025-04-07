import org.testng.Assert;
import org.testng.annotations.Test;
import testComponents.baseTest;

import java.io.IOException;

public class errorValidationsTest extends baseTest {


    @Test
    public void errorValidationsTest() throws InterruptedException, IOException {
        lp.userLogin("ibrahiarafa611@gmail.com", "@I3rafa304852");
        Assert.assertEquals(lp.getIncorrectMessage(), "Incorrect email or password.");
        System.out.println(lp.getIncorrectMessage());
    }

}
