package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.LandingPage;
import com.cybertek.library.pages.LoginPage;
import com.cybertek.library.utilities.ConfigurationReader;
import com.cybertek.library.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_StepDefinitions {
    LoginPage loginPage=new LoginPage();
    LandingPage landingPage =new LandingPage();
    WebDriverWait wait=new WebDriverWait(Driver.getDriver(),20);

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        String url= ConfigurationReader.getProperty("qa2url");
        Driver.getDriver().get(url);
    }

    @When("I login as a librarian")
    public void i_login_as_a_librarian() {
        String username= ConfigurationReader.getProperty("lib47_username");
        String password=ConfigurationReader.getProperty("lib47_password");
        loginPage.usernameBox.sendKeys(username);
        loginPage.passwordBox.sendKeys(password);
        loginPage.submitBox.click();
    }

    @Then("dashboard should be displayed")
    public void dashboard_should_be_displayed() {
        String expected="dashboard";
        wait.until(ExpectedConditions.urlContains(expected));
        String actual=Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actual.contains(expected));
        Driver.closeDriver();
    }

    @When("I login as a student")
    public void i_login_as_a_student() {
        String username=ConfigurationReader.getProperty("stud95_username");
        String password=ConfigurationReader.getProperty("stud95_password");
        loginPage.usernameBox.sendKeys(username);
        loginPage.passwordBox.sendKeys(password);
        loginPage.submitBox.click();
    }


    @Then("books should be displayed")
    public void books_should_be_displayed() {
        String expected="books";
        wait.until(ExpectedConditions.urlContains(expected));
        String actual=Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actual.contains(expected));

    }

    @When("I enter username {string}")
    public void i_enter_username(String string) {
        loginPage.sendUserName(string);
    }


    @When("I enter password {string}")
    public void i_enter_password(String string) {
        loginPage.sendPassword(string);
    }

    @When("click the sign in button")
    public void click_the_sign_in_button() {
        loginPage.submitBox.click();
    }

    @Then("there should be {int} users")
    public void there_should_be_users(Integer int1) {
        int expectedEndUserNumber=int1;
        wait.until(ExpectedConditions.elementToBeClickable(landingPage.userCount));
        //String expected=String.valueOf(expectedEndUserNumber);
        //String actual=landingPage.userCount.getText();
        int actual=Integer.parseInt(landingPage.userCount.getText());
        Assert.assertEquals("Actual user number is not as much as expected",expectedEndUserNumber,actual);
    }


    @When("I enter  {string} and  {string}")
    public void i_enter_username_and_password(String username, String password) {
        loginPage.usernameBox.sendKeys(username);
        loginPage.passwordBox.sendKeys(password);
        loginPage.submitBox.click();
    }


}
