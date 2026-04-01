package PageClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	    WebDriver driver;
	    WebDriverWait wait;
	    @FindBy(xpath = "//input[@placeholder='Username']")
	    WebElement username;

	    @FindBy(xpath = "//input[@placeholder='Password']")
	    WebElement password;

	    @FindBy(xpath = ("//input[@class='PrivateSwitchBase-input css-1m9pwf3']"))
	    WebElement  checkbox;	
	    @FindBy(xpath = "//button[text()='Sign In']")
	    WebElement loginBtn;

	    @FindBy(xpath = "//h4[text()='Dashboard']")
	    WebElement dashboard;

	    @FindBy(xpath = "//div[text()='Forgot Password?']")
	    WebElement forgotPassword;

	    @FindBy(id = "outlined-size-small")
	    WebElement mobileInput;

	    @FindBy(xpath = "//button[text()='Send OTP']")
	    WebElement sendOtp;

	    @FindBy(xpath = "//div[text()='Back to Login']")
	    WebElement backToLogin;

	    @FindBy(xpath = "//div[text()='Forgot Username?']")
	    WebElement forgotUsername;

	    @FindBy(xpath = "//input[@placeholder='Chassis Number']")
	    WebElement chassisNumber;

	    
	    public LoginPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	    }
	    public void login(String u, String p) {
	    	
	    	 wait.until(ExpectedConditions.visibilityOf(username)).sendKeys(u);

	    	    wait.until(ExpectedConditions.visibilityOf(password)).sendKeys(p);
	    	    wait.until(ExpectedConditions.elementToBeClickable(checkbox)).click();
	               
	    	    wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
	    }

	    public boolean isDashboardVisible() {
	    	try {
	            return wait.until(ExpectedConditions.visibilityOf(dashboard)).isDisplayed();
	        } catch (Exception e) {
	            return false;
	        }
	    }

	    public void forgotPasswordFlow() {
	    	 wait.until(ExpectedConditions.elementToBeClickable(forgotPassword)).click();

	    	    wait.until(ExpectedConditions.visibilityOf(mobileInput))
	    	        .sendKeys("65765786889");

	    	    wait.until(ExpectedConditions.elementToBeClickable(sendOtp)).click();

	    	    wait.until(ExpectedConditions.elementToBeClickable(backToLogin)).click();
	    }

	    public void forgotUsernameFlow() {

	        wait.until(ExpectedConditions.elementToBeClickable(forgotUsername)).click();

	        wait.until(ExpectedConditions.visibilityOf(chassisNumber))
	            .sendKeys("MBUZT54AHL0318141");
	    }
	}

