package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DialogContent extends Parent {

    public DialogContent() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(linkText = "Laptops")
    private WebElement laptops;

    @FindBy(linkText = "Sony vaio i5")
    private WebElement sony;

    @FindBy(linkText = "Add to cart")
    private WebElement addToCart;

    @FindBy(linkText = "Dell i7 8gb")
    private WebElement dell;

    @FindBy(linkText = "Cart")
    private WebElement cart;

    @FindBy(xpath = "(//a[text()='Delete'])[1]")
    private WebElement deleteProduct;

    @FindBy(css = "div.panel-info+button")
    private WebElement placerOrder;

    @FindBy(id = "name")
    private WebElement name;

    @FindBy(id = "country")
    private WebElement country;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "card")
    private WebElement card;

    @FindBy(id = "month")
    private WebElement month;

    @FindBy(id = "year")
    private WebElement year;

    @FindBy(xpath = "//button[text()='Purchase']")
    private WebElement purchase;

    @FindBy(xpath = "//p[@class='lead text-muted ']")
    private WebElement idAmount;

    @FindBy(xpath = "//td[text()='790']")
    private WebElement productPrice;

    @FindBy(xpath = "//button[@class='confirm btn btn-lg btn-primary']")
    private WebElement ok;

    WebElement myElement;

    public void findAndSend(String strElement, String value) {
        switch (strElement) {
            case "name": myElement = name; break;
            case "country": myElement = country; break;
            case "city": myElement = city; break;
            case "card": myElement = card; break;
            case "month": myElement = month; break;
            case "year": myElement = year; break;
        }

        sendKeysFunction(myElement, value);
    }

    public void findAndClick(String strElement) {

        switch (strElement) {
            case "laptops": myElement = laptops; break;
            case "sony" : myElement = sony; break;
            case "addToCart" : myElement = addToCart; break;
            case "dell" : myElement = dell; break;
            case "cart" : myElement = cart; break;
            case "deleteProduct" : myElement = deleteProduct; break;
            case "placerOrder" : myElement = placerOrder; break;
            case "purchase" : myElement = purchase; break;
            case "ok" : myElement = ok; break;
        }

        clickFunction(myElement);
    }

    public void findAndContainsText(String strElement, String text) {
        switch (strElement) {
            //case "dellText" : myElement =dellText; break;
        }

        verifyContainsText(myElement, text);
    }

    public String  findAndGetText(String strElement) {
        switch (strElement) {
            case "idAmount" : myElement =idAmount; break;
            case "productPrice" : myElement =productPrice; break;
        }

        return verifyContainsText(myElement);
    }

    public void findAndClear(String strElement) {
        switch (strElement) {
            //case "searchInput": myElement = searchInput; break;
        }

        clear(myElement);
    }

}
