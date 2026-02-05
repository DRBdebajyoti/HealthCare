package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import Browser.browser;
import Locators.LoginPageLocators;

public class LoginPage {

    public void clickMakeAppointment() {
        browser.driver.findElement(
                By.xpath(LoginPageLocators.Make_Appointment_Btn)).click();
    }

    public void login(String user, String pass) {

        
     	browser.wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath(LoginPageLocators.USERNAME)));

        browser.driver.findElement(
                By.xpath(LoginPageLocators.USERNAME)).sendKeys(user);

        browser.driver.findElement(
                By.xpath(LoginPageLocators.PASSWORD)).sendKeys(pass);

        browser.driver.findElement(
                By.xpath(LoginPageLocators.LOGIN_BTN)).click();

       
    }
}