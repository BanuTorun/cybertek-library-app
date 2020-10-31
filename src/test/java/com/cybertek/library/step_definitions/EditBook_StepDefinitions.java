package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.BookManagementPage;
import com.cybertek.library.pages.EditBookInfoPage;
import com.cybertek.library.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

public class EditBook_StepDefinitions {

    BookManagementPage bookMPage=new BookManagementPage();
    EditBookInfoPage editBIPage=new EditBookInfoPage();

    WebDriverWait wait=new WebDriverWait(Driver.getDriver(),20);

    Select select=new Select(editBIPage.bookCategory);





    @When("I click Edit Book link")
    public void i_click_link() {
        wait.until(ExpectedConditions.visibilityOf(bookMPage.editBook));
        bookMPage.editBook.click();

        wait.until(ExpectedConditions.elementToBeClickable(editBIPage.bookName));
    }


    @Then("I should be able to edit the book information")
    public void i_should_be_able_to_edit_the_book_information(Map<String,String> dataTable) {

        String bookName=dataTable.get("Book Name");
        String isbn=dataTable.get("ISBN");
        String year=dataTable.get("Year");
        String author=dataTable.get("Author");
        //String bookCategory=dataTable.get("Book Category");
        String description=dataTable.get("Description");
        editBIPage.bookName.sendKeys(bookName);
        editBIPage.ISBN.sendKeys(isbn);
        editBIPage.year.sendKeys(year);
        editBIPage.author.sendKeys(author);
        editBIPage.bookCategory.click();
        select.selectByVisibleText("Story");
        editBIPage.description.sendKeys(description);

    }

    @Then("I should be able to save changes")
    public void i_should_be_able_to_save_changes() {
        editBIPage.saveTheChanges.click();

    }

    @Then("I should be able to close")
    public void i_should_be_able_to_close() {
        editBIPage.close.click();

    }

}
