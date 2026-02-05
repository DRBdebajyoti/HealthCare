package Hooks;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Utils.ExtentManager;
import io.cucumber.java.*;

public class Hooks {

    public static ExtentReports extent;
    public static ExtentTest scenarioTest;

    @BeforeAll
    public static void startReport() {
        extent = ExtentManager.getExtent();
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        scenarioTest = extent.createTest(scenario.getName());
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        if (scenario.isFailed()) {
            scenarioTest.fail("Step failed");
        } else {
            scenarioTest.pass("Step passed");
        }
    }

    @AfterAll
    public static void endReport() {
        extent.flush();
    }
}