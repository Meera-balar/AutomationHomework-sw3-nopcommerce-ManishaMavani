package electronics;

import com.google.common.base.Verify;
import javafx.scene.control.Tab;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class ElectronicsTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {
        //1.1 Mouse Hover on “Electronics” Tab
        mouseHoverToElement(By.xpath("//div[@class='header-menu']/ul[1]/li[2]/a"));
        //1.2 Mouse Hover on “Cell phones” and click
        mouseHoverToElementAndClick(By.xpath("//div[@class='header-menu']/ul[1]/li[2]/ul/li[2]/a[1]"));
        //1.3 Verify the text “Cell phones”
        String expectedMessage = "Cell phones";
        //Actual message
        String actualMessage = getTextFromElement(By.xpath("//h1[text()='Cell phones']"));
        //Validate actual and expected
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully () throws InterruptedException {
        //2.1 Mouse Hover on “Electronics” Tab
        mouseHoverToElement(By.xpath("//div[@class='header-menu']/ul[1]/li[2]/a"));
        //2.2 Mouse Hover on “Cell phones” and click
        mouseHoverToElementAndClick(By.xpath("//div[@class='header-menu']/ul[1]/li[2]/ul/li[2]/a[1]"));
        //2.3 Verify the text “Cell phones”
        String expectedMessage = "Cell phones";
        //Actual message
        String actualMessage = getTextFromElement(By.xpath("//h1[text()='Cell phones']"));
        //Validate actual and expected
        Assert.assertEquals(expectedMessage, actualMessage);
        //2.4 Click on List View Tab
        clickOnElement(By.xpath("//a[text()='List']"));
        //2.5 Click on product name “Nokia Lumia 1020” link
        Thread.sleep(2000);
        clickOnElement(By.linkText("Nokia Lumia 1020"));

        String expectedMessage1 = "Nokia Lumia 1020";
        //Actual message
        String actualMessage1 = getTextFromElement(By.xpath("//h1[text()='Nokia Lumia 1020']"));
        //Validate actual and expected
        Assert.assertEquals(expectedMessage1, actualMessage1);
        //2.7 Verify the price “$349.00”
        String expectedMessage2 = "$349.00";
        //Actual message
        String actualMessage2 = getTextFromElement(By.xpath("//div[@class='product-price']//span[text()=' $349.00 ']"));
        //Validate actual and expected
        Assert.assertEquals(expectedMessage2, actualMessage2);
        //2.8 Change quantity to 2
        Thread.sleep(500);
        clickOnElement(By.id("product_enteredQuantity_20"));
        driver.findElement(By.id("product_enteredQuantity_20")).clear();
        sendTextToElement(By.id("product_enteredQuantity_20"), "2");
        //2.9 Click on “ADD TO CART” tab
        Thread.sleep(1500);
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-20']"));
        //2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        String expectedMessage3 = "The product has been added to your shopping cart";
        //Actual message
        String actualMessage3 = getTextFromElement(By.xpath("//body/div[@id='bar-notification']/div[1]"));
        //Validate actual and expected
        Assert.assertEquals(expectedMessage3, actualMessage3);
        // 2.10 After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]"));
        //2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverToElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        clickOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));
        //2.12 Verify the message "Shopping cart"
        String expectedMessage4 = "Shopping cart";
        //Actual message
        String actualMessage4 = getTextFromElement(By.xpath("//h1[text()='Shopping cart']"));
        //Validate actual and expected
        Assert.assertEquals(expectedMessage4, actualMessage4);
        //2.13 Verify the quantity is 2
        WebElement text = driver.findElement(By.xpath("//input[@class='qty-input']"));
        String expectedMessage5 = "2";
        //Actual message
        String actualMessage5 = text.getAttribute("value");
        Assert.assertEquals(expectedMessage5, actualMessage5);
        //2.14 Verify the Total $698.00
        String expectedMessage6 = "$698.00";
        //Actual message
        String actualMessage6 = getTextFromElement(By.xpath("//td[@class='subtotal']//span[text()='$698.00']"));
        //Validate actual and expected
        Assert.assertEquals(expectedMessage6, actualMessage6);
        //2.15 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        //2.16 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));
        //2.17 Verify the Text “Welcome, Please Sign In!”
        String expectedMessage7 = "Welcome, Please Sign In!";
        //Actual message
        String actualMessage7 = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        //Validate actual and expected
        Assert.assertEquals(expectedMessage7, actualMessage7);
        //2.18 Click on “REGISTER” tab
        clickOnElement(By.xpath("//button[contains(text(),'Register')]"));
        //2.19 Verify the text “Register”
        String expectedMessage8 = "Register";
        //Actual message
        String actualMessage8 = getTextFromElement(By.xpath("//h1[text()='Register']"));
        //Validate actual and expected
        Assert.assertEquals(expectedMessage8, actualMessage8);
        //*************************************************************2.20 Fill the mandatory fields*************************************//
        //Enter First Name
        sendTextToElement(By.id("FirstName"),"Darsh");
        //Enter Last Name
        sendTextToElement(By.id("LastName"),"Mavani");
        //Enter Date
        selectByVisibleTextFromDropDown(By.name("DateOfBirthDay"),"15");
        //Enter Month
        selectByVisibleTextFromDropDown(By.name("DateOfBirthMonth"),"July");
        //Enter Year
        selectByVisibleTextFromDropDown(By.name("DateOfBirthYear"),"1998");
        //Enter Email
        sendTextToElement(By.id("Email"),"Darshanmavani401@gmail.com");
        //Enter Password
        sendTextToElement(By.id("Password"),"Darsh123");
        //Enter Confirm password
        sendTextToElement(By.id("ConfirmPassword"),"Darsh123");
        //2.21 Click on “REGISTER” Button
        clickOnElement(By.id("register-button"));
        //2.22 Verify the message “Your registration completed”
        String expectedMessage9 = "Your registration completed";
        //Actual message
        String actualMessage9 = getTextFromElement(By.xpath("//div[contains(text(),'Your registration completed')]"));
        //Validate actual and expected
        Assert.assertEquals(expectedMessage9, actualMessage9);
        //2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
        //2.24 Verify the text “Shopping cart”
        String expectedMessage10 = "Shopping cart";
        //Actual message
        String actualMessage10 = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        //Validate actual and expected
        Assert.assertEquals(expectedMessage10, actualMessage10);
        //2.25 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        //2.26 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));
        //**************************************************************2.27 Fill the Mandatory fields********************************************//
        //Select country
        selectByVisibleTextFromDropDown(By.id("BillingNewAddress_CountryId"),"United States");
        //Select state
        selectByVisibleTextFromDropDown(By.id("BillingNewAddress_StateProvinceId"),"California");
        //Enter City
        sendTextToElement(By.id("BillingNewAddress_City"),"London");
        //Enter Address 1
        sendTextToElement(By.id("BillingNewAddress_Address1"),"20, Coventry Road");
        //Enter Zip code
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"),"CV2 0LL");
        //Enter PhoneNumber
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"),"06767567634");
        //2.23 Click on “CONTINUE”
        clickOnElement(By.xpath("//div[@id='billing-buttons-container']/button[4]"));
        //2.28 Click on “CONTINUE”
        clickOnElement(By.xpath("//div[@id='billing-buttons-container']/button[4]"));
        //2.29 Click on Radio Button “2nd Day Air ($0.00)”
        clickOnElement(By.id("shippingoption_2"));
        //2.30 Click on “CONTINUE”
        clickOnElement(By.xpath("//div[@id='shipping-method-buttons-container']/button"));
        //2.31 Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        clickOnElement(By.xpath("//div[@id='payment-method-buttons-container']/button"));
        //2.32 Select “Visa” From Select credit card dropdown
        selectByVisibleTextFromDropDown(By.id("CreditCardType"),"Visa");
        //**************************************************************2.33 Fill all the details**********************************************//
        //Enter CardHolder Name
        sendTextToElement(By.id("CardholderName")," MR M D Mavani");
        //Enter card number
        sendTextToElement(By.id("CardNumber"),"4111111111111111");
        //Select Expiry Month
        selectByVisibleTextFromDropDown(By.id("ExpireMonth"),"04");
        //Select Expiry Year
        selectByVisibleTextFromDropDown(By.id("ExpireYear"),"2026");
        //Card code
        sendTextToElement(By.id("CardCode"),"123");
        //2.34 Click on “CONTINUE”
        clickOnElement(By.xpath("//div[@id='payment-info-buttons-container']/button"));
        //2.35 Verify “Payment Method” is “Credit Card”
        String expectedMessage11 = "Payment Method: Credit Card";
        //Actual message
        String actualMessage11 = getTextFromElement(By.xpath("//div[@class='payment-method-info']/ul/li"));
        //Validate actual and expected
        Assert.assertEquals(expectedMessage11, actualMessage11);
        //2.36 Verify “Shipping Method” is “2nd Day Air”
        String expectedMessage12 = "Shipping Method: 2nd Day Air";
        //Actual message
        String actualMessage12 = getTextFromElement(By.xpath("//div[@class='shipping-method-info']/ul/li"));
        //Validate actual and expected
        Assert.assertEquals(expectedMessage12, actualMessage12);
        //2.37 Verify Total is “$698.00”
        String expectedMessage13 = "$698.00";
        //Actual message
        String actualMessage13 = getTextFromElement(By.xpath("//tr[@class ='order-total']/td[2]/span//strong[text()='$698.00']"));
        //Validate actual and expected
        Assert.assertEquals(expectedMessage13, actualMessage13);
        //2.38 Click on “CONFIRM”
        clickOnElement(By.xpath("//div[@id='confirm-order-buttons-container']//button"));
        //2.39 Verify the Text “Thank You”
        String expectedMessage14 = "Thank you";
        //Actual Message
        String actualMessage14 = getTextFromElement(By.xpath("//h1[text()='Thank you']"));
        //Validate actual and Expected message
        Assert.assertEquals(expectedMessage14,actualMessage14);
        //2.40 Verify the message “Your order has been successfully processed!”
        String expectedMessage15 = "Your order has been successfully processed!";
        //Actual Message
        String actualMessage15 = getTextFromElement(By.xpath("//strong[text()='Your order has been successfully processed!']"));
        //Validate actual and Expected message
        Assert.assertEquals(expectedMessage15,actualMessage15);
        //2.41 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 order-completed-continue-button']"));
        //2.42 Verify the text “Welcome to our store”
        String expectedMessage16 = "Welcome to our store";
        //Actual Message
        String actualMessage16 = getTextFromElement(By.xpath("//h2[text()='Welcome to our store']"));
        //Validate actual and Expected message
        Assert.assertEquals(expectedMessage16,actualMessage16);
        //2.43 Click on “Logout” link
        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));
        //2.44 Verify the URL is “https://demo.nopcommerce.com/”
        String expectedMessage17 = "https://demo.nopcommerce.com/";
        //Actual Message
        String actualMessage17 = driver.getCurrentUrl();
        //Validate actual and Expected message
        Assert.assertEquals(expectedMessage17,actualMessage17);
    }


    @After
    public void tearDown() {
        closeBrowser();
    }

}
