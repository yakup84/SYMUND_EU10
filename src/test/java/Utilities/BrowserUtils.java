package Utilities;

import Pages.LoginPage;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class BrowserUtils {
    static LoginPage loginPage = new LoginPage();

    public static void verifyTitle(String expectedTitle) {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 15);
        wait.until(ExpectedConditions.titleIs(expectedTitle));
        Assert.assertTrue(Driver.getDriver().getTitle().equals(expectedTitle));

    }

    public static void loginMethod() {
        loginPage.inputUsername.sendKeys(ConfigurationReader.getProperty("username"));
        loginPage.inputPassword.sendKeys(ConfigurationReader.getProperty("password"));
        loginPage.loginButton.click();

    }

    public void clickFonction(WebElement clickElement) {

        clickElement.click();
    }

    public void sendKeysFonction(WebElement sendKeysElement, String value) {


        sendKeysElement.sendKeys(value);

    }

    public void selectElementFromDropdownFonction(WebElement dropdown, String element) {
        Select slc = new Select(dropdown);
        slc.selectByVisibleText(element);

    }

    public void assertTrueFonction(boolean condition) {
        Assert.assertTrue(condition);
    }

    public void assertEqualFonction(String actual, String expected) {
        Assert.assertEquals(actual, expected);
    }

    public void verifyTitleFonction(String expected) {
        Assert.assertEquals(expected, Driver.getDriver().getTitle());

    }

    /**
     * This method will take dropdown element and return options list text of options
     *
     * @param element
     * @return
     */
    public List<String> listGetTextFonction(WebElement element) {
        Select select = new Select(element);
        List<String> actualList = new ArrayList<>();
        for (WebElement option : select.getOptions()) {
            actualList.add(option.getText());
        }


        return actualList;
    }

    /**
     * This method will click radio button  that have spesific value( find with getAtribute() method)
     *
     * @param radioButton
     * @param attributeValue
     */
    public void clickRadioButtonFonction(List<WebElement> radioButton, String attributeValue) {

        for (WebElement element : radioButton) {
            if (element.getAttribute("value").equalsIgnoreCase(attributeValue)) {
                element.click();
            }
        }

    }
}