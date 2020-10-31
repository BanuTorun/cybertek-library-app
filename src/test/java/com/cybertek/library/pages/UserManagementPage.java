package com.cybertek.library.pages;

import com.cybertek.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UserManagementPage {

    public UserManagementPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }


    @FindBy(id="user_groups")
    public WebElement userGroup;

    @FindBy(id="user_status")
    public WebElement status;

    @FindBy(name="tbl_users_length")
    public WebElement showRecordsDropdown;

    @FindBy(xpath="//a[@href='tpl/add-user.html']")
    public WebElement addUserIcon;

    @FindBy(xpath="//input[@type='search']")
    public WebElement searchBox;

    @FindBy(xpath = "//table[@id='tbl_users']//tr/td")
    public List<WebElement> userManagementTable;

    @FindBy(xpath = "//table[@id='tbl_users']//tr/td")
    public WebElement editUserBtn;

}
