package TestCase;

import Browser.browser;
import Browser.utility;
import Pages.LoginPage;
import Pages.AppointmentPage;

public class Demo {

    public static void main(String[] args) {

        try {
            // Step 1: Open Browser
            browser.openBrowser();

            // Step 2: Navigate to CURA Application
            browser.navigate("CURA Healthcare Service");

           // Step 3: Create Page Objects
            LoginPage loginPage = new LoginPage();
            AppointmentPage appointmentPage = new AppointmentPage();

            // Step 4: Click Make Appointment
            loginPage.clickMakeAppointment();

           // Step 5: Login
            loginPage.login(
                    utility.properties("username"),
                    utility.properties("password")
            );
             appointmentPage.handleChangePasswordPopup();
            // Step 6: Fill Appointment Details
            appointmentPage.fillAppointmentDetails();

            // Step 7: Verify Appointment Confirmation
            String confirmationText = appointmentPage.getConfirmationText();

            if (confirmationText.equals("Appointment Confirmation")) {
                System.out.println("Appointment booked successfully");
            } else {
                System.out.println("Appointment booking failed");
            }

            // Step 8: Close Browser
         //   browser.closeBrowser();

        } catch (Exception e) {
            System.out.println("Error in execution: " + e);
            //browser.closeBrowser();
        }
    }
}