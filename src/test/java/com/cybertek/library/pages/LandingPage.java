package com.cybertek.library.pages;

import com.cybertek.library.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage extends PageBase {

    public LandingPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    WebDriverWait wait=new WebDriverWait(Driver.getDriver(),40);

    @FindBy(id="user_count")
    public WebElement userCount;

    @FindBy(id="book_count")
    public WebElement bookCount;

    @FindBy(id="borrowed_books")
    public WebElement borrowedBooks;


    public void isDashboardDisplayed(){
        String expected="dashboard";
        wait.until(ExpectedConditions.urlContains(expected));
        String actual=Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actual.contains(expected));

    }



}
