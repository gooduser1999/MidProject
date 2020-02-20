package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {


		WebDriver driver;

		public LoginPage(WebDriver driver) {
			this.driver = driver;
		}

		// Element Library
		@FindBy(how = How.ID, using = "user_login")
		WebElement UserName;
		@FindBy(how = How.ID, using = "user_pass")
		WebElement Password;
		@FindBy(how = How.NAME, using = "wp-submit")
		WebElement LogInButton;
		// Methods to interact with the elements
		public void login(String userName, String password) {
			UserName.sendKeys(userName);
			Password.sendKeys(password);
			LogInButton.click();
		}

		public String getPageTitle() {
			return driver.getTitle();
		}
}
