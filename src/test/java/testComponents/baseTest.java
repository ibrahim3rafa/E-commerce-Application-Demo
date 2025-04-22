package testComponents;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageObjects.landingPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class baseTest {
    public WebDriver driver;
    public landingPage lp;


    public WebDriver initializeDriver() throws IOException {

        //properties class
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src//main//resources//globalData.properties");
        prop.load(fis);
        String browserName =  System.getProperty("browser") != null? System.getProperty("browser"):prop.getProperty("browser");
      //  String browserName = prop.getProperty("browser");

        if (browserName.contains("chrome")) {
            ChromeOptions options = new ChromeOptions();
            if (browserName.contains("headless")) {
                options.addArguments("headless");
            }
            driver = new ChromeDriver(options);
            driver.manage().window().setSize(new Dimension(1440,990));
        } else if (browserName.equalsIgnoreCase("firefox")) {
            //firefox
          //  WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            //edge
            driver = new EdgeDriver();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return driver;
    }

    @BeforeMethod(alwaysRun = true)
    public void launchApplication() throws IOException {

        driver = initializeDriver();
        if (driver != null) {
            lp = new landingPage(driver);
            lp.getURL();
        }

    }


    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.close();
    }



    public List<HashMap<String, String>> getJsonDataToMap(File filePath) throws IOException {
        String jsonContent=  FileUtils.readFileToString(filePath);

        //String to HashMap -- Jackson databind
        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String,String>> data=  mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>() {
        });

        return data;

    }


    public String takeScreenShot(String tcName ,WebDriver driver) throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) driver ;
        File sourceFile =screenshot.getScreenshotAs(OutputType.FILE);
        File desfile = new File(System.getProperty("user.dir")+"//src//test//java//testData//"+tcName+".png");
        FileUtils.copyFile(sourceFile,desfile);
        return System.getProperty("user.dir")+"//src//test//java//testData//"+tcName+".png";
    }
}
