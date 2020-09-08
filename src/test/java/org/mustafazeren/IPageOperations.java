package org.mustafazeren;

import org.openqa.selenium.WebDriver;

public interface IPageOperations {

     void Open(WebDriver driver);

     void Login(WebDriver driver) throws InterruptedException;

     void ChangeComputer(WebDriver driver) throws InterruptedException;

     void AddProductMore(WebDriver driver) throws InterruptedException;

     void Delete(WebDriver driver) throws InterruptedException;
}
