package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;
import java.util.Scanner;

public class TopMenuTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    //1.1 method created as per requirement to select menu
    public void selectMenu(String menu) {
        //Lis of my account list
        List<WebElement> menuList = driver.findElements(By.xpath("//div[@class = 'header-menu']/ul/li"));
        try {
            //for loop for find right options
            for (WebElement options : menuList) {
                //if condtion will check passed parameter
                if (options.getText().equals(menu) ) {
                    //click on passed parameter
                    options.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            menuList = driver.findElements(By.xpath("//div[@class = 'header-menu']/ul/li"));
        }

    }
    @Test
    public void verifyPageNavigation(){
        //1.2 Method call and pass the parameter to navigate to Books menu
        selectMenu("Books");
        //1.3 verifying Home text is displayed on all navigated page for different tab
        String expectedMessage = "Home";
        //Actual message
        String actualMessage = getTextFromElement(By.xpath("//a[contains(text(),'Home')]"));
        //Validate actual and expected message
        Assert.assertEquals(expectedMessage,actualMessage);
    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}
