package StepDefinition;

import Pages.LoginPage;
import Pages.AppointmentPage;
import Browser.browser;
import Screenshot.capture;
import io.cucumber.java.en.*;

public class AppointmentSteps {

   LoginPage loginPage;
    AppointmentPage appointmentPage;

	@Given("user launches the browser")
	public void user_launches_the_browser() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		browser.openBrowser();
	}
	@And("user navigates to CURA Healthcare site")
	public void user_navigates_to_cura_healthcare_site() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		 browser.navigate("CURA Healthcare Service");
	        loginPage = new LoginPage();
	        appointmentPage = new AppointmentPage();
	}
	@When("user logs in with valid credentials")
	public void user_logs_in_with_valid_credentials() {
	    // Write code here that turns the phrase above into concrete actions
		 loginPage.clickMakeAppointment();
	        loginPage.login("John Doe", "ThisIsNotAPassword");
	}
	@And("user books an appointment")
	public void user_books_an_appointment() {
	    // Write code here that turns the phrase above into concrete actions
		appointmentPage.fillAppointmentDetails();
	}
	@Then("appointment should be booked successfully")
	public void appointment_should_be_booked_successfully() {
	    // Write code here that turns the phrase above into concrete actions
		String confirmation =
                appointmentPage.getConfirmationText();
        System.out.println("Appointment Confirmed: " + confirmation);
        capture.takeScreenshot("Appointment_Confirmation");

        // optional wait so you can SEE the page
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        browser.driver.quit();
	}
}