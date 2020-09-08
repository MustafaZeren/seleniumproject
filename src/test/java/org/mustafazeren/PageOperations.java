package org.mustafazeren;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import java.security.Key;
import java.sql.Driver;
import java.util.List;
import java.util.Random;

public class PageOperations implements IPageOperations{

    public void Open(WebDriver driver){ open(driver); }

    public void Login(WebDriver driver) throws InterruptedException {
        login(driver);
    }

    public void ChangeComputer(WebDriver driver) throws InterruptedException { changeComputer(driver); }

    public void AddProductMore(WebDriver driver)throws InterruptedException { addProductMore(driver);}

    public void Delete(WebDriver driver) throws InterruptedException {
        delete(driver);
    }

    private void open(WebDriver driver){
        driver.get(Statics.URL);
        driver.findElement(By.xpath(Statics.MAN_CHOICE)).click();

        if (driver.getTitle().contains(Statics.EXPECTED_TITLE)) {
            System.out.println("Web page opened");
        }
        System.out.println(driver.getTitle());
    }

    private void login(WebDriver driver) throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/div[3]/div/div/ul/li[1]/div[2]/span[1]/span")).click();
        WebElement eMailText = driver.findElement(By.name("email"));
        WebElement passwordText=driver.findElement(By.name("password"));
        eMailText.sendKeys(Statics.MAIL);
        passwordText.sendKeys(Statics.PASSWORD);
        Thread.sleep(2000);
        eMailText.sendKeys(Keys.ENTER);

    }

    private void changeComputer(WebDriver driver) throws InterruptedException {

        Thread.sleep(4000);
        driver.findElement(By.xpath(Statics.SEARCH_BOX)).sendKeys("Bilgisayar");
        Thread.sleep(500);
        driver.findElement(By.xpath(Statics.SEARCH_BOX)).sendKeys(Keys.ENTER);

        Random random=new Random();
        int index= random.nextInt(5);

        List<WebElement> productPriceList=driver.findElements(By.className("prc-box-dscntd"));
        String productPriceInSearchPage=productPriceList.get(index).getText();
        productPriceList.get(index).click();
        System.out.println("Random product price in search page: "+productPriceInSearchPage);
    }

    private void addProductMore(WebDriver driver) throws InterruptedException {

        WebElement countBox=driver.findElement(By.xpath("//*[@id=\"partial-basket\"]/div/div[2]/div[2]/div[3]/div[1]/div/input"));
        Thread.sleep(2000);
        countBox.sendKeys(Keys.BACK_SPACE);
        Thread.sleep(2000);
        countBox.sendKeys("2");
        Thread.sleep(2000);
    }

    private void delete(WebDriver driver) throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"partial-basket\"]/div/div[2]/div[2]/div[3]/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"ngdialog1\"]/div[2]/form/div/div[2]/div/div[1]/button[2]")).click();
        Thread.sleep(2000);

    }

}