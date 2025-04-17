package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import static Actions.Action.*;
import static Util.HighlightElement.highlightElement;
import static Util.WaitUntil.waitUntil;

public class Login extends AbstractStepDef {
    @Given("user insert username")
    public void UserInsertUsername() throws InterruptedException {
        navigate(loginPageUrl, driver);
       waitUntil(2);
        sendKey(loginPage.getUsernameField(), "Admin");

    }

    @And("user insert password")
    public void UserInsertPassword() throws InterruptedException {
        sendKey(loginPage.getPasswordField(), "admin123");

    }

    @When("user clicks on login button")
    public void UserClicksOnLoginButton() {
        click(loginPage.getSubmitButton(), 2);

    }

    @Then("user is redirect to homepage")
    public void UserIsRedirectToHomepage() throws InterruptedException {
        waitUntil(3);
       highlightElement(homePage.getDashboardSign());
        Assert.assertEquals("Dashboard", homePage.getDashboardSign().getText());
    }

    @And("user clicks on LogOut button")
    public void userClicksOnLogOutButton(){
        click(homePage.getUserMeniu(),1);
        highlightElement(homePage.getLogout());
        waitUntil(5);
        click(homePage.getLogout(),1);
    }
}
