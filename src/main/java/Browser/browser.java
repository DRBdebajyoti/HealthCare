package Browser;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class browser {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Actions action;

    // Open browser
    public static void openBrowser() throws Exception {

        String choice = utility.properties("browser");

        if (choice == null) {
            throw new RuntimeException("Browser name is NULL in Configure.properties");
        }

        if (choice.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (choice.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else if (choice.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else {
            throw new RuntimeException("Invalid browser name: " + choice);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    // Navigate to application
    public static void navigate(String title) throws Exception {

        if (driver == null) {
            throw new RuntimeException("Driver is NULL. openBrowser() not called.");
        }

        driver.get(utility.properties("url"));
        driver.manage().window().maximize();

        action = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.titleContains(title));
    }

    // Close browser
    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}


/* package Browser;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class browser {
	public static WebDriver driver; // Declared object globally
	public static WebDriverWait wait;
	public static Actions action;
	public static Select select;

	
	public static void openBrowser() throws Exception {
		try {
			String choice = utility.properties("browser"); // Chrome
			if (choice.equalsIgnoreCase("Chrome"))
				driver = new ChromeDriver();
			else if (choice.equalsIgnoreCase("Edge"))
				driver = new EdgeDriver();
			else if (choice.equalsIgnoreCase("Firefox"))
				driver = new FirefoxDriver();
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("Browser - openBrowser");
		}
	}

	
	public static void navigate(String title) throws Exception {
		try {
			driver.get(utility.properties("url")); // https://www.rediff.com
			driver.manage().window().maximize();
			action = new Actions(driver);
			wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.titleIs(title));
		} catch (Exception e) {
			System.out.println("Browser - navigate" + e);
		}
	}
	
	public static void closeBrowser() {
		try {
			driver.quit();
		} catch (Exception e) {
			System.out.println("Browser - closeBrowser");
		}
	}
}*/