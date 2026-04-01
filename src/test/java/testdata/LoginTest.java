package testdata;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseTest.setup;
import PageClass.LoginPage;
import utils.DataProviderClass;

public class LoginTest extends setup {

	   @Test(dataProvider = "loginData", dataProviderClass = DataProviderClass.class)
	    public void loginTest(String u, String p, boolean isValid) throws InterruptedException {

		   LoginPage    page = new LoginPage(driver); 
     
	        page.login(u, p);
	        Thread.sleep(5000);
	        if (isValid) {
	            Assert.assertTrue(page.isDashboardVisible(), "Login should succeed");
	        } else {
	            Assert.assertFalse(page.isDashboardVisible(), "Login should fail");
	        }
	    }
	    
	   

	    @Test
	    public void forgotPasswordTest() {
	
			LoginPage page = new LoginPage(driver);
	        page.forgotPasswordFlow();
	    }

	    @Test
	    public void forgotUsernameTest() {
	        LoginPage page = new LoginPage(driver);
	        page.forgotUsernameFlow();
	    }
	}
