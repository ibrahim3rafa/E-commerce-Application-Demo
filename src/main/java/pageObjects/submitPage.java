package pageObjects;

import abstractComponents.abstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class submitPage extends abstractComponent {

    WebDriver driver;
    public submitPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    String inputText = "eg";
    String optionToSelected = "Egypt";
    //input field
    @FindBy(css="input[placeholder='Select Country']")
    WebElement inputField;


    //suggestedCountries
    @FindBy(css=".ta-results.list-group.ng-star-inserted")
    WebElement suggestedCountries;

   By suggestedCountriesBy =By.cssSelector(".ta-results.list-group.ng-star-inserted");


   //suggestedCountryList
   @FindBy(css=".ta-results.list-group.ng-star-inserted button")
   List<WebElement> suggestedCountryList;



   //submit order
   @FindBy(css=".action__submit")
   WebElement submitOrder;


   //order placed
   @FindBy(css=".toast-success")
   WebElement orderPlaced;

    //confirm
    @FindBy(css=".hero-primary")
    WebElement confirmText;



    //method to select country
    public void selectionFromSuggestiveDropdown(){
        inputField.sendKeys(inputText);
        waitElementsToAppear(suggestedCountriesBy);
        for (WebElement suggestion : suggestedCountryList) {
            if (suggestion.getText().contains(optionToSelected)) {
                suggestion.click();
                break;
            }
        }

    }


    //method to submit order
    public void submitOrder(){
        submitOrder.click();
    }



    //method of confirmation
    public String confirmationMessages()
    {
        System.out.println(orderPlaced.getText());
        System.out.println(confirmText.getText());
        return confirmText.getText();
    }

}
