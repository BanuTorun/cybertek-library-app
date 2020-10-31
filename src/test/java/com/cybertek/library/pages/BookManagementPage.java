package com.cybertek.library.pages;

import com.cybertek.library.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookManagementPage {

    public BookManagementPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    WebDriverWait wait=new WebDriverWait(Driver.getDriver(),20);


    @FindBy(id="book_categories")
    public WebElement bookCategories;

    @FindBy(xpath = "//a[@href='tpl/add-book.html']")
    public WebElement addBook;

    @FindBy(xpath = "//select[@name='tbl_books_length']")
    public WebElement showRecords;

    @FindBy(xpath="//input[@type='search']")
    public WebElement searchBox;


    @FindBy(linkText = " Edit Book")
    public WebElement editBook;


    public void isBooksDisplayed(){
        String expected="books";
        wait.until(ExpectedConditions.urlContains(expected));
        String actual= Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actual.contains(expected));

    }

}