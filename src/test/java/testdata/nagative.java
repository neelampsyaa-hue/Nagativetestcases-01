package testdata;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class nagative {

	public static void main(String[] args) {
		
	WebDriver driver = new  ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://pro.smlsaarthi.com/dashboard");

	String Expectedreuslt = driver.getTitle();
	System.out.println(Expectedreuslt);
	        String  AchualResult  =  "SML SAARTHI";
	        
	     Assert.assertEquals(Expectedreuslt, AchualResult);
	     driver.close();
	}
}
