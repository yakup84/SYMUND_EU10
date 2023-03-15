package Pages;

import Utilities.Driver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "user")
    public WebElement inputUsername;

    @FindBy(id = "password")
    public WebElement inputPassword;

    @FindBy(id = "submit-form")
    public WebElement loginButton;

    @FindBy(css = "p[class^='warning']")
    public WebElement wrongUsernamePasswordMessage;
    @FindBy(id = "password")
    public WebElement passwordText;
    @FindBy(xpath = "//input[@required='required']")
    public WebElement popupMessage;
    @FindBy(xpath = "//a[@class='toggle-password']")
    public WebElement eyeButton;
    @FindBy(id = "lost-password")
    public WebElement forgetPasswordLink;
    @FindBy(xpath = "//input[@id='reset-password-submit']")
    public WebElement resetPasswordLink;



}
