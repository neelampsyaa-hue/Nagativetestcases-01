package BaseTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class setup {

	 protected WebDriver driver;
	 @BeforeMethod
	    public void setup() {
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://dev-pro.smlsaarthi.com/");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	    }

	    @AfterMethod
	    public void teardown() {
	        if (driver != null) {
	            driver.quit();   // ✅ important
	        }
	    }
}
