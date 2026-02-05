package Locators;

public class AppointmentPageLocators {

    public static  String FACILITY = "//select[@id='combo_facility']";
   // public static final String READMISSION = "//input[@id='chk_hospital_readmission']";
    public static  String READMISSION ="//*[@id=\"appointment\"]/div/div/form/div[2]/div/label";
    public static  String MEDICAID = "//input[@id='radio_program_medicaid']";

    public static  String VISIT_DATE_ICON =
            "//span[@class='glyphicon glyphicon-calendar']";

    public static  String DATE_25 =
            "//td[text()='25' and not(contains(@class,'old'))]";

    public static  String COMMENT = "//textarea[@id='txt_comment']";
    public static  String BOOK_BTN = "//button[@id='btn-book-appointment']";
    public static  String CONFIRMATION = "//h2[text()='Appointment Confirmation']";
}