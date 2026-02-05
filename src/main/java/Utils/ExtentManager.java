package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getExtent() {
        if (extent == null) {

            String reportPath = System.getProperty("user.dir")
                    + "/target/extent-report/ExtentReport.html";

            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
            spark.config().setReportName("Healthcare Automation Report");
            spark.config().setDocumentTitle("CURA Test Results");

            extent = new ExtentReports();
            extent.attachReporter(spark);
            extent.setSystemInfo("Project", "Healthcare");
            extent.setSystemInfo("Framework", "Cucumber TestNG");
            extent.setSystemInfo("Tester", "You");
        }
        return extent;
    }
}

