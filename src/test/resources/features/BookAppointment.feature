Feature: Book Appointment

  Scenario: Successful appointment booking
    Given user launches the browser
    And user navigates to CURA Healthcare site
    When user logs in with valid credentials
    And user books an appointment
    Then appointment should be booked successfully