package org.mustafazeren;

import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

public class TestSelenium {

    WebDriver driver;
    PageOperations pageOperations;

    @Before
    public void setUp() {
        ChromeOptions options= new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", Statics.DRIVER_PATH);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(60,TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

    @Test
    public void testOperations() throws InterruptedException {
        pageOperations=new PageOperations();
        pageOperations.Open(driver);
        pageOperations.Login(driver);
        pageOperations.ChangeComputer(driver);
        Thread.sleep(2000);
        driver.get(Statics.CART_ADDRESS_URL);
        pageOperations.AddProductMore(driver);
        Thread.sleep(2000);
        pageOperations.Delete(driver);
    }


    /*
    @After
    public void tearDown() {
        driver.quit();
    }
    */
}
