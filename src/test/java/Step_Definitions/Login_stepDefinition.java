package Step_Definitions;

import Pages.LoginPage;
import Utilities.BrowserUtils;
import Utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.bytebuddy.asm.Advice;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class Login_stepDefinition extends BrowserUtils {
    LoginPage loginPage = new LoginPage();

    @When("user enter a valid {string} into user field")
    public void user_enter_a_valid_into_user_field(String string) {
        sendKeysFonction(loginPage.inputUsername, string);
    }

    @When("user enter a valid {string} into password field")
    public void user_enter_a_valid_into_password_field(String string) {
        sendKeysFonction(loginPage.inputPassword, string);
    }

    @When("user click Login button")
    public void user_click_login_button() {
        clickFonction(loginPage.loginButton);
    }

    @Then("user should land on the home page")
    public void user_land_on_the_home_page() {
        verifyTitleFonction(
                "Dashboard - Symund - QA");
    }

    @Given("user opens a browser and goes to login page")
    public void userOpensABrowserAndGoesToLoginPage() {
        Driver.getDriver().get("https://qa.symund.com/");
    }


    @And("user enter a valid {string} into password field and click enter")
    public void userEnterAValidIntoPasswordFieldAndClickEnter(String arg0) {
        sendKeysFonction(loginPage.inputPassword, arg0 + Keys.ENTER);
    }

    @When("user enter invalid {string} or{string} into user and password field")
    public void userEnterInvalidOrIntoUserAndPasswordField(String arg0, String arg1) {
        sendKeysFonction(loginPage.inputUsername, arg0);
        sendKeysFonction(loginPage.inputPassword, arg1);
    }

    @Then("should be displayed {string} message")
    public void shouldBeDisplayedMessage(String arg0) {
        Assert.assertTrue(loginPage.wrongUsernamePasswordMessage.isDisplayed());
        Assert.assertEquals(arg0, loginPage.wrongUsernamePasswordMessage.getText().trim());
    }

    @When("user enter blank {string} or{string} into user and password field")
    public void userEnterBlankOrIntoUserAndPasswordField(String arg0, String arg1) {
        sendKeysFonction(loginPage.inputUsername, arg0);
        sendKeysFonction(loginPage.inputPassword, arg1);
    }

    @When("user enter  {string} into password field")
    public void userEnterIntoPasswordField(String arg0) {
        sendKeysFonction(loginPage.inputPassword, arg0);
    }

    @Then("user should see the password in a form of dots")
    public void userShouldSeeThePasswordInAFormOfDots() {
        Assert.assertTrue(loginPage.passwordText.getAttribute("type").equals("password"));
    }

    @And("user click eye button near password")
    public void userClickEyeButtonNearPassword() {
        clickFonction(loginPage.eyeButton);

    }

    @Then("user should see the password explicitly")
    public void userShouldSeeThePasswordExplicitly() {
        Assert.assertTrue(loginPage.passwordText.getAttribute("type").equals("text"));
    }

    @Then("user should see the Forgot password? link")
    public void userShouldSeeTheLink() {
        Assert.assertTrue(loginPage.forgetPasswordLink.isDisplayed());
        Assert.assertEquals("Forgot password?", loginPage.forgetPasswordLink.getText().trim());
    }

    @When("User click Forgot password? link")
    public void userClickForgotPasswordLink() {
        clickFonction(loginPage.forgetPasswordLink);
    }


    @Then("User should see Reset Password link")
    public void userShouldSeeResetPasswordLink() {
        Assert.assertTrue(loginPage.resetPasswordLink.isDisplayed());
        Assert.assertEquals("Reset password", loginPage.resetPasswordLink.getAttribute("value"));
    }

    @Then("user should be displayed {string} message")
    public void userShouldBeDisplayedMessage(String message) {


    }

    @Then("user should be displayed {string} message when {string} or{string} is blank")
    public void userShouldBeDisplayedMessageWhenOrIsBlank(String message, String username, String password) {
        if (username.isEmpty()) {
            Assert.assertEquals(message, loginPage.inputUsername.getAttribute("validationMessage"));

        } else if (password.isEmpty()) {
            Assert.assertEquals(message, (loginPage.inputPassword.getAttribute("validationMessage")));
        }


    }

    @Then("user can see valid placeholders on Username and Password fields")
    public void userCanSeeValidPlaceholdersOnUsernameAndPasswordFields() {
        Assert.assertTrue(loginPage.inputUsername.isDisplayed());

        Assert.assertTrue(loginPage.inputPassword.isDisplayed());

    }
}
