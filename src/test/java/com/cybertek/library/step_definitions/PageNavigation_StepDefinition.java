package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.LandingPage;
import com.cybertek.library.pages.PageBase;
import com.cybertek.library.pages.UserManagementPage;
import com.cybertek.library.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class PageNavigation_StepDefinition {

    PageBase landingPage=new LandingPage();         // Polymorphic object
    UserManagementPage userManagementPage =new UserManagementPage();            //
    Select select;

    @When("I click on {string} link")
    public void i_click_on_link(String link) {
        BrowserUtils.waitForVisibility(landingPage.dashboardPageIcon,20);
        switch (link){
            case "dashboard":
                landingPage.dashboardPageIcon.click();
                break;
            case "Books":
                landingPage.booksPageIcon.click();
                break;
            case "Users":
                landingPage.usersPageIcon.click();
                break;
        }

    }

    @Then("show records default value should be {int}")
    public void show_records_default_value_should_be(int expected) {
        BrowserUtils.waitForVisibility(userManagementPage.showRecordsDropdown,10);
        select=new Select(userManagementPage.showRecordsDropdown);
        String actual=select.getFirstSelectedOption().getText();
        String expectedStr=String.valueOf(expected);
        Assert.assertEquals(actual,expectedStr);
    }

    @Then("show records should have following options:")
    public void show_records_should_have_following_options(List<Integer> options) {
        System.out.println("options.size() = " + options.size());

        select=new Select(userManagementPage.showRecordsDropdown);
        List<WebElement>webElements=select.getOptions();
        BrowserUtils.getElementsText(webElements);
        List<Integer> webElementsNumbers=new ArrayList<>();
        for (int i = 0; i <webElements.size() ; i++) {
            webElementsNumbers.add(Integer.parseInt(webElements.get(i).getText()));
        }
        Assert.assertEquals(webElementsNumbers,options);

    }

}