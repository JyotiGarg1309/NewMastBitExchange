package mastbit.exchange.POM;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import mastbit.exchange.common.BaseBrowser;
import mastbit.exchange.common.WaitStatement;

public class Mastbit_login {

	public WebDriver driver;

	By home1 = By.xpath("/html/body/ngb-modal-window/div/div/div[2]/div[2]/a");
	By loginclick = By.xpath("//a[contains(text(),'Log in')]");
	By email = By.xpath("//input[@name='email']");
	By password = By.xpath("//input[@name='password']");
	By login = By.xpath("//button[@type='submit']");
	By menu = By.xpath("//*[@id=\"app-wrapper\"]/app-dashboard-header/nav/div[4]");
	By logout = By.xpath("//*[@id=\"app-wrapper\"]/app-dashboard-header/nav/div[5]/div/ul/li[12]/a");

	By forgotPasswordClick = By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[5]/a[1]");

	public Mastbit_login(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public void getForgotPasswordClick() {
		driver.findElement(forgotPasswordClick).click();

	}

	public void getHomeClickNew() throws InterruptedException {
		Set<String> winHandles = driver.getWindowHandles();

		// Loop through all handles
		for (String handle : winHandles) {
			if (!handle.equals(BaseBrowser.parentWinHandle)) {

				driver.switchTo().window(handle);
				// WaitStatement.waitForLoad(driver);

				System.out.println("Title of the new window: " + driver.getTitle());

				WaitStatement.sleep(5000);
				driver.findElement(home1).click();

			}
		}

	}

	public WebElement getLoginClick() {
		List<WebElement> all = driver.findElements(loginclick);
		WebElement dr = all.get(0);
		return dr;

	}

	public WebElement getEmail() {
		List<WebElement> all = driver.findElements(email);
		WebElement dr = all.get(1);
		return dr;

	}

	public WebElement getPassword() {
		return driver.findElement(password);
	}

	public WebElement getLogin() {
		List<WebElement> all = driver.findElements(login);
		WebElement dr = all.get(1);
		return dr;

	}

	public WebElement getMenu() {

		return driver.findElement(menu);
	}

	public WebElement getLogout() {
		return driver.findElement(logout);
	}
}
