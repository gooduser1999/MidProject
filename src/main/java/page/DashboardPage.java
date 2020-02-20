package page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
public class DashboardPage extends BasePage {
	WebDriver driver; // Global

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Element Library
	@FindBy(how = How.XPATH, using = "//h1[contains(text(),'Dashboard')]")
	WebElement PageTitle;

	public void waitForPage() {
		waitForElement(PageTitle, driver);
	}
	
//	public boolean isDashboardDisplayed() {
//		try {
//			waitForPage();
//			return true;
//		} catch (Exception e) {
//
//		}
//		return false;
//	}
	public void submitDraft() throws InterruptedException {
		driver.findElement(By.id("title")).sendKeys("test");	
		driver.findElement(By.id("content")).sendKeys("This is a test draft. ;)");
		driver.findElement(By.id("save-post")).click();
		Thread.sleep(7000);
		Actions action= new Actions(driver);
	    action.moveToElement(driver.findElement(By.linkText("Posts"))).build().perform();
	   
	    action.moveToElement(driver.findElement(By.linkText("All Posts"))).build().perform();
	    //waitForElement(driver, 15, By.linkText("All Posts"));
	    driver.findElement(By.linkText("All Posts")).click();
	    Thread.sleep(5000);
	}

	private void waitForElement(WebElement pageTitle2, WebDriver driver2) {
		// TODO Auto-generated method stub
		
	}
}
