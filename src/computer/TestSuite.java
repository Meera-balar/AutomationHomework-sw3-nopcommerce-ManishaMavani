package computer;

import com.google.common.base.Verify;
import javafx.scene.control.Tab;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.Computer;
import org.openqa.selenium.By;
import utilities.Utility;

import java.awt.*;

public class TestSuite extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void verifyProductArrangeInAlphabeticalOrder(){
        //1.1 Click on Computer Menu.
        clickOnElement(By.xpath("//div[@class='header-menu']/ul[1]/li//a[text()='Computers ']"));
        //1.2 Click on Desktop
        clickOnElement(By.xpath("//div[@class='item-grid']/div[1]/div[1]/h2/a"));
        //1.3 Select Sort By position "Name: Z to A"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"), "Name: Z to A");
        //1.4 Verify the Product will arrange in Descending order.
        String expectedMessage = "Name: Z to A";
        //Actual Text
        String actualMessage = getTextFromElement(By.xpath("//select[@id='products-orderby']/option[3]"));
        //Validate actual and expected
        Assert.assertEquals(expectedMessage, actualMessage);

    }
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException{
        //2.1 Click on Computer Menu.
        clickOnElement(By.xpath("//div[@class='header-menu']/ul[1]/li//a[text()='Computers ']"));
        //2.2 Click on Desktop
        clickOnElement(By.xpath("//div[@class='item-grid']/div[1]/div[1]/h2/a"));
        //2.3 Select Sort By position "Name: A to Z"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"), "Name: A to Z");
        //2.4 Click on "Add To Cart"
        Thread.sleep(1000);
        mouseHoverToElementAndClick(By.xpath("//div[@data-productid='1']/div[2]/div[3]/div[2]/button[1]"));
        //2.5 Verify the Text "Build your own computer"
        String expectedMessage = "Build your own computer";
        //Actual Message
        String actualMessage = getTextFromElement(By.xpath("//div[@data-productid='1']/div[2]/h2/a"));
        //Validate actual and expected
        Assert.assertEquals(expectedMessage,actualMessage);
        //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        selectByVisibleTextFromDropDown(By.id("product_attribute_1"),"2.2 GHz Intel Pentium Dual-Core E2200");
        //2.7.Select "8GB [+$60.00]" using Select class.
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='product_attribute_2']"),"8GB [+$60.00]");
        //2.8 Select HDD radio "400 GB [+$100.00]"
        clickOnElement(By.xpath("//input[@id='product_attribute_3_7']"));
        //2.9 Select OS radio "Vista Premium [+$60.00]"
        clickOnElement(By.xpath("//input[@id='product_attribute_4_9']"));
        //2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        clickOnElement(By.xpath("//input[@id='product_attribute_5_12']"));
        //2.11 Verify the price "$1,475.00"
        String expectedPrice = "$1,475.00";
        //Actual Price
        String actualPrice = getTextFromElement(By.xpath("//span[text()='$1,475.00']"));
        //Validate actual and expected
        Assert.assertEquals(expectedPrice,actualPrice);
        //2.12 Click on "ADD TO CARD" Button.
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));
        //2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar After that close the bar clicking on the cross button.
        String expectedMessage1 = "The product has been added to your shopping cart";
        //Actual Message
        String actualMessage1 = getTextFromElement(By.xpath("//div[@class='bar-notification success']"));
        //Validate actual and expected message
        Assert.assertEquals(expectedMessage1,actualMessage1);
        //2.13 Close the bar clicking on the cross button.
        clickOnElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]"));
        //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        Thread.sleep(1000);
        mouseHoverToElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        clickOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));
        //2.15 Verify the message "Shopping cart"
        String expectedMessage2 = "Shopping cart";
        //Actual message
        String actualMessage2 = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        //Validate actual and expected message
        Assert.assertEquals(expectedMessage2,actualMessage2);
        //2.16 Change the Qty to "2" and Click on "Update shopping cart"
        Thread.sleep(1000);
        clickOnElement(By.xpath("//td[@class='quantity']/input"));
        driver.findElement(By.xpath("//td[@class='quantity']/input")).clear();
        sendTextToElement(By.xpath("//td[@class='quantity']/input"),"2");
       // 2.16 Click on "Update shopping cart"
        clickOnElement(By.xpath("//button[@id='updatecart']"));
        //2.17 Verify the Total"$2,950.00"
        String expectedMessage3 = "$2,950.00";
        //Actual message
        String actualMessage3 = getTextFromElement(By.xpath("//td[@class= 'subtotal']/span"));
        //Validate actual and expected message
        Assert.assertEquals(expectedMessage3,actualMessage3);
        //2.18 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        //2.19 Click on “CHECKOUT
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@id='checkout']"));
        //2.20 Verify the Text “Welcome, Please Sign In!”
        String expectedMessage4 = "Welcome, Please Sign In!";
        //Actual message
        String actualMessage4 = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        //Validate actual and expected message
        Assert.assertEquals(expectedMessage4,actualMessage4);
        //2.21 Click on “CHECKOUT AS GUEST” Tab
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));
        //************************************************2.22 Fill the all mandatory field*************************************************//
        //Enter FirstName
        sendTextToElement(By.id("BillingNewAddress_FirstName"),"MEERA");
        //Enter LastName
        sendTextToElement(By.id("BillingNewAddress_LastName"),"MAVANI");
        //Enter Email
        sendTextToElement(By.id("BillingNewAddress_Email"),"meeramavani@gmail.com");
        //Select country
        selectByVisibleTextFromDropDown(By.id("BillingNewAddress_CountryId"),"United Kingdom");
        //Enter City
        sendTextToElement(By.id("BillingNewAddress_City"),"London");
        //Enter Address 1
        sendTextToElement(By.id("BillingNewAddress_Address1"),"20, Coventry Road");
        //Enter Zip code
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"),"CV2 0LL");
        //Enter PhoneNumber
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"),"06767567634");
        //2.23 Click on “CONTINUE”
        Thread.sleep(500);
        clickOnElement(By.xpath("//div[@id='billing-buttons-container']/button[4]"));
        //2.24 Click on Radio Button “Next Day Air($0.00)”
        Thread.sleep(500);
        clickOnElement(By.xpath("//input[@id='shippingoption_1']"));
        //2.25 Click on “CONTINUE”
        Thread.sleep(500);
        clickOnElement(By.xpath("//div[@id='shipping-method-buttons-container']/button"));
        //2.26 Select Radio Button “Credit Card”
        Thread.sleep(500);
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        clickOnElement(By.xpath("//div[@id='payment-method-buttons-container']/button"));
        //2.27 Select “Master card” From Select credit card dropdown
        selectByVisibleTextFromDropDown(By.id("CreditCardType"),"Master card");
        //*********2.28 Fill all the details**************//
        //Enter CardHolder Name
        sendTextToElement(By.id("CardholderName")," MRs M D Mavani");
        //Enter card number
        sendTextToElement(By.id("CardNumber"),"5555 5555 5555 4444");
        //Select Expiry Month
        selectByVisibleTextFromDropDown(By.id("ExpireMonth"),"04");
        //Select Expiry Year
        selectByVisibleTextFromDropDown(By.id("ExpireYear"),"2026");
        //Card code
        sendTextToElement(By.id("CardCode"),"123");
        //2.29 Click on “CONTINUE”
        Thread.sleep(500);
        clickOnElement(By.xpath("//div[@id='payment-info-buttons-container']/button"));
        //2.30 Verify “Payment Method” is “Credit Card”
       String expectedMessage5 = "Payment Method: Credit Card";
        //Actual Message
        String actualMessage5 = getTextFromElement(By.xpath("//div[@class='payment-method-info']/ul/li"));
        //Validate actual and Expected message
        Assert.assertEquals(expectedMessage5,actualMessage5);
        //2.32 Verify “Shipping Method” is “Next Day Air”
        String expectedMessage6 = "Shipping Method: Next Day Air";
        //Actual Message
        String actualMessage6 = getTextFromElement(By.xpath("//div[@class='shipping-method-info']/ul/li"));
        //Validate actual and Expected message
        Assert.assertEquals(expectedMessage6,actualMessage6);
        //2.33 Verify Total is “$2,950.00”
        String expectedMessage7 = "$2,950.00";
        //Actual Message
        String actualMessage7 = getTextFromElement(By.xpath("//tr[@class ='order-total']/td[2]/span//strong[text()='$2,950.00']"));
        //Validate actual and Expected message
        Assert.assertEquals(expectedMessage7,actualMessage7);
        //2.34 Click on “CONFIRM”
        Thread.sleep(500);
        clickOnElement(By.xpath("//div[@id='confirm-order-buttons-container']//button"));
        //2.35 Verify the Text “Thank You”
        String expectedMessage8 = "Thank you";
        //Actual Message
        String actualMessage8 = getTextFromElement(By.xpath("//h1[text()='Thank you']"));
        //Validate actual and Expected message
        Assert.assertEquals(expectedMessage8,actualMessage8);
        //2.36 Verify the message “Your order has been successfully processed!”
        String expectedMessage9 = "Your order has been successfully processed!";
        //Actual Message
        String actualMessage9 = getTextFromElement(By.xpath("//strong[text()='Your order has been successfully processed!']"));
        //Validate actual and Expected message
        Assert.assertEquals(expectedMessage9,actualMessage9);
        //2.37 Click on “CONTINUE”
        Thread.sleep(500);
        clickOnElement(By.xpath("//button[@class='button-1 order-completed-continue-button']"));
        //2.37 Verify the text “Welcome to our store”
        String expectedMessage10 = "Welcome to our store";
        //Actual Message
        String actualMessage10 = getTextFromElement(By.xpath("//h2[text()='Welcome to our store']"));
        //Validate actual and Expected message
        Assert.assertEquals(expectedMessage10,actualMessage10);

    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}
