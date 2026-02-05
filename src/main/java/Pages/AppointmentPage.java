package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Browser.browser;
import Locators.AppointmentPageLocators;

public class AppointmentPage {
	private void waitForAppointmentPageReady() {
	    browser.wait.until(ExpectedConditions.visibilityOfElementLocated(
	        By.id("combo_facility")
	    ));
	}
	
	
    //  Handle Change Password Popup automatically
    public void handleChangePasswordPopup() {
        try {
            // Wait until OK button is clickable and click it
            browser.wait.until(
                ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[text()='OK']"))
            ).click();

            // Wait until the popup disappears fully
            browser.wait.until(
                ExpectedConditions.invisibilityOfElementLocated(
                    By.xpath("//button[text()='OK']"))
            );
            
        } catch (Exception e) {
            // Popup may not appear every time
            System.out.println("Change password popup not displayed");
        }
    }

    // Fill Appointment Details fully automatically
    public void fillAppointmentDetails() {

        // Handle popup first
    	
       handleChangePasswordPopup();
       waitForAppointmentPageReady();
       /* WebDriverWait fastWait = new WebDriverWait(browser.driver, Duration.ofSeconds(1));
        fastWait.pollingEvery(Duration.ofMillis(100)); // check every 100ms for faster reaction */

        //  Interact with elements using the same wait

        // Facility dropdown
       /*fastWait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(AppointmentPageLocators.FACILITY)
        ));*/

        // Wait until Facility dropdown is clickable
     /*   browser.wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(AppointmentPageLocators.FACILITY)
        ));*/

        // Select Facility
        Select select = new Select(
                browser.driver.findElement(
                        By.xpath(AppointmentPageLocators.FACILITY)
                )
        );
        select.selectByVisibleText("Hongkong CURA Healthcare Center");

        // Check Readmission
        browser.driver.findElement(
                By.xpath(AppointmentPageLocators.READMISSION)
        ).click();

        // Choose Medicaid
        browser.driver.findElement(
                By.xpath(AppointmentPageLocators.MEDICAID)
        ).click();

        // Small wait for safety
        browser.wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(AppointmentPageLocators.MEDICAID)
        ));

        // Click Medicaid
        browser.driver.findElement(
                By.xpath(AppointmentPageLocators.MEDICAID)
        ).click();
        // Click calendar icon
        browser.wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(AppointmentPageLocators.VISIT_DATE_ICON)
        )).click();

        // Click date 25
        browser.wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(AppointmentPageLocators.DATE_25)
        )).click();

        // Enter Comment
        browser.driver.findElement(
                By.xpath(AppointmentPageLocators.COMMENT)
        ).sendKeys("Routine checkup");

        // Click Book Appointment
        browser.driver.findElement(
                By.xpath(AppointmentPageLocators.BOOK_BTN)
        ).click();
    }

    //  Get Confirmation Text
    public String getConfirmationText() {
        return browser.driver.findElement(
                By.xpath(AppointmentPageLocators.CONFIRMATION)
        ).getText();
    }
}