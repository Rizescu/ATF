package stepDefinition;

import Util.DataKeys;
import Util.WaitUntil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;


import static Actions.Action.*;
import static Util.DataKeys.PASSWORD;
import static Util.DataKeys.USERNAME;
import static Util.HighlightElement.highlightElement;
import static Util.ScenarioContext.getData;
import static Util.ScenarioContext.saveData;
import static Util.WaitUntil.waitUntil;

public class Login extends AbstractStepDef {
    @Given("user insert username")
    public void UserInsertUsername() {
        navigate(loginPageUrl, driver);
        waitUntil(3);
        sendKey(loginPage.getUsernameField(), "Admin");
        saveData(USERNAME, "Admin");
    }

    @And("user insert password")
    public void UserInsertPassword() {
        sendKey(loginPage.getPasswordField(), "admin123");
        saveData(PASSWORD, "admin123");

    }

    @When("user clicks on login button")
    public void UserClicksOnLoginButton() {
        click(loginPage.getSubmitButton(), 3);

    }

    @Then("user is redirect to homepage")
    public void UserIsRedirectToHomepage() {
        waitUntil(3);
        highlightElement(homePage.getDashboardSign());
        Assert.assertEquals("Dashboard", homePage.getDashboardSign().getText());
    }

    @And("user clicks on LogOut button")
    public void userClicksOnLogOutButton() {
        click(homePage.getUserMeniu(), 3);
        highlightElement(homePage.getLogout());
        waitUntil(5);
        click(homePage.getLogout(), 3);

    }

    @And("insert username")
    public void insertUsername() {
        waitUntil(3);
        sendKey(loginPage.getUsernameField(), getData(USERNAME).toString());
    }

    @And("insert password")
    public void insertPassword() {
        waitUntil(3);
        sendKey(loginPage.getPasswordField(), getData(PASSWORD).toString());

    }
}
