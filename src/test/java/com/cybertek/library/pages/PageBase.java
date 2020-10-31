package com.cybertek.library.pages;

import com.cybertek.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class PageBase {
    public PageBase(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(linkText = "Users")
    public WebElement usersPageIcon;

    @FindBy(linkText = "Books")
    public WebElement booksPageIcon;

    @FindBy(linkText = "Dashboard")
    public WebElement dashboardPageIcon;

    @FindBy(xpath = "//a[@id='navbarDropdown']/img")
    public WebElement signOut;
}
