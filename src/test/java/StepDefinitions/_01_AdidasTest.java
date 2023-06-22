package StepDefinitions;

import Pages.DialogContent;
import Pages.Parent;
import Utilities.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class _01_AdidasTest {

    DialogContent dc = new DialogContent();

    @Given("Nagivgate to blaze.com")
    public void nagivgateToBlazeCom() {

        GWD.getDriver().get("https://www.demoblaze.com/index.html");
        GWD.getDriver().manage().window().maximize();

    }

    @When("Navigate to \"Laptop\"")
    public void navigateTo() {

        dc.findAndClick("laptops");

    }

    @Then("\"Sony vaio i5\" and click on Add to cart")
    public void andClickOnAddToCart() {

        dc.findAndClick("sony");
        dc.findAndClick("addToCart");

    }

    @And("Accept pop up confirmation")
    public void acceptPopUpConfirmation() {

        Parent.waitUntilAlert();
        GWD.getDriver().switchTo().alert().accept();

        GWD.getDriver().navigate().back();
        GWD.getDriver().navigate().back();

    }

    @Then("\"Dell i7 8gb\" and click on Add to cart")
    public void dellIGbAndClickOnAddToCart() {

        dc.findAndClick("dell");
        dc.findAndClick("addToCart");

    }

    @When("Navigate to \"Cart\"")
    public void navigateToCart() {

        dc.findAndClick("cart");

    }

    @Then("Delete \"Dell i7 8gb\" from cart")
    public void deleteFromCart() {

        dc.findAndClick("deleteProduct");
        Parent.waitInvisibilityOf("success",1);

    }

    String productPrice;

    @And("Click on \"Place order\"")
    public void clickOn() {

        productPrice = dc.findAndGetText("productPrice");

        dc.findAndClick("placerOrder");

    }

    @Then("Fill in all web form fields")
    public void fillInAllWebFormFields() {

        dc.findAndSend("name","Alex");
        dc.findAndSend("country","Brazil");
        dc.findAndSend("city","Rio");
        dc.findAndSend("card","1234-1245-2578-2356");
        dc.findAndSend("month","12");
        dc.findAndSend("year","2025");

    }

    @And("Click on \"Purchase\"")
    public void clickOnPurchase() {

        dc.findAndClick("purchase");

    }

    @Then("Capture and log purchase Id and Amount")
    public void captureAndLogPurchaseIdAndAmount() {
        String value= dc.findAndGetText("idAmount");
        int ss=value.indexOf("Id:")+2;
        int tt=value.indexOf("Amount:");
        String id=value.substring(ss+2,tt);
        System.out.print("id="+id);

        int amountIndex=value.indexOf("Amount:")+8;
        int card=value.indexOf("Card");
        String amount=value.substring(amountIndex,card);
        System.out.print("amount="+amount);


    }

    @And("Assert purchase amount equals expected")
    public void assertPurchaseAmountEqualsExpected() {

        String value= dc.findAndGetText("idAmount");
        int amountIndex=value.indexOf("Amount:")+8;
        int card=value.indexOf("Card");
        String amount=value.substring(amountIndex,card-5);

        Assert.assertEquals(productPrice,amount);

    }

    @And("Click on \"Ok\"")
    public void clickOnOk() {

        dc.findAndClick("ok");

    }
}
