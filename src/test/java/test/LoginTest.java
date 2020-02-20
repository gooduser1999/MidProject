package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import page.DashboardPage;
import util.BrowserFactory;
import page.LoginPage;

public class LoginTest {

	WebDriver driver;

	@BeforeMethod
	public void launchBrowser() {
		// Starts the browser and saves the driver in the test class
		driver = BrowserFactory.startBrowser();
	}
	
	@Test
	public void loginTest() throws InterruptedException {
		driver.get("https://s1.demo.opensourcecms.com/wordpress/wp-login.php");
	//	@SuppressWarnings("unused")
		LoginPage LoginPage = PageFactory.initElements(driver, LoginPage.class);
		// Call the login method from the LoginPage Class
		LoginPage.login("opensourcecms", "opensourcecms");
		Thread.sleep(5000);
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class); // Object Reference
		dashboardPage.waitForPage();
		dashboardPage.submitDraft();
	    Thread.sleep(5000);
	}

	@AfterMethod
	public void close() {
		// close and quit
		driver.close();
		driver.quit();
	}
}

