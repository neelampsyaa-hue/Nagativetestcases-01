package testdata;


import java.lang.reflect.Field;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
@Test(enabled = false)
public class nagative {
	
	public static  WebDriver driver;

	@BeforeMethod
	public static void setup() {

        driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://dev-pro.smlsaarthi.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		String Expectedreuslt = driver.getTitle();
		System.out.println(Expectedreuslt);
		String AchualResult = "SML SAARTHI";
		Assert.assertEquals(Expectedreuslt, AchualResult);
		
	}

	@Test(priority = 2, dataProvider = "LoginPage")
	public void LoginPage(String u, String p) {
		WebElement username = driver.findElement(By.xpath("//input[@placeholder=\"Username\"]"));
		username.sendKeys(u);
		WebElement password = driver.findElement(By.xpath("//input[@placeholder=\"Password\"]"));
		password.sendKeys(p);
		WebElement checkbox = driver.findElement(By.xpath("span[class^=\"MuiButtonBase-root MuiCheckbox-root\"]"));
		checkbox.click();
		boolean select = checkbox.isSelected();
		System.out.println("the check is select");
		WebElement signbtn = driver.findElement(By.xpath("//button[text()=\"Sign In\"]"));
		signbtn.click();
		String Expectedresult ="Dashboard";
	WebElement deshboad = driver.findElement(By.xpath("//h4[text()=\"Dashboard\"]"));
		Assert.assertEquals(Expectedresult, deshboad);

	}

	@DataProvider(name = "LoginPage")
	public Object[][] getdata() {
		return new Object[][] {
			
				{ " ", "8296574063" }, // Null username
				{ "8296574063", " " }, // Null password
				{ "verylongusername1234567890", "8296574063" }, // Length test
				{ "admin' OR '1'='1", "pass" }, // SQL Injection
				{ "829657406", "82965740631" },//boundry value anyasis
				{ "8296574063", "8296574063" }, // Both empty
		};
	}

	//@Test
	public void loginviaOtp() {

	}

	@Test(priority = 2)
	public void forgotPassword() {
       driver.findElement(By.xpath("//div[text()=\"Forgot Password?\"]"));
      WebElement EnterMobile = driver.findElement(By.cssSelector("#outlined-size-small"));
      EnterMobile.sendKeys("65765786889");
   WebElement optclick = driver.findElement(By.xpath("//button[text()=\"Send OTP\"]"));
   optclick.click();
                         
   WebElement backtobtn=  driver.findElement(By.xpath("//div[text()=\"Back to Login\"]"));
   backtobtn.click();
 
      
	}

	
@Test(priority = 1)
public void  forgotusername() {
	 WebElement clciklink = driver.findElement(By.xpath("//div[text()=\"Forgot Username?\"]"));

	   String  expectedResult = "Please enter the chassis number for any vehicle linked to your account.";
	   WebElement AuchalResult = driver.findElement(By.xpath("//div[text()=\"Please enter the chassis number for any vehicle linked to your account.\"]"));
	   Assert.assertEquals(expectedResult, AuchalResult);
	 
	WebElement vehiclechassisnumber = driver.findElement(By.xpath("//input[@placeholder=\"Chassis Number\"]"));
	vehiclechassisnumber.sendKeys("MBUZT54AHL0318141");  
	WebElement sumbit = driver.findElement(By.xpath("//button[text()=\"Submit\"]"));
    WebElement Backtologinbtn = driver.findElement(By.xpath("//div[text()=\"Back to Login\"]"));
	 
} 
	@Test(priority = 4)
	public void logout() {
   WebElement logoutbtn = driver.findElement(By.xpath("//span[text()=\"Log Out\"]"));
   logoutbtn.click();
	}
	
	@AfterMethod
	public void teardwon() {
    if(driver!=null) {
	  driver.close();
  }
	}
}
