package mastbit.exchange.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Mastbit_Api {

	public WebDriver driver;
	By apikey = By.xpath("//*[@id=\"app-wrapper\"]/app-dashboard-header/nav/div[5]/div/ul/li[11]/a");
	By generateapi = By.xpath("//*[@id=\"app-wrapper\"]/app-api/section/div/div/div[2]/div[1]/div/button");
	By regenerateapi = By.xpath(
			"//*[@id=\"app-wrapper\"]/app-api/section/div/div/div[2]/div[2]/div/div/table/tbody/tr/td[2]/span[1]");
	By deleteapi = By.xpath(
			"//*[@id=\"app-wrapper\"]/app-api/section/div/div/div[2]/div[2]/div/div/table/tbody/tr/td[2]/span[2]");
	By toast1 = By.xpath("//span[@class='toast-message ng-star-inserted']");
	By toast = By.id("toast-container");

	public Mastbit_Api(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public void getApikey() {
		WebElement element = driver.findElement(apikey);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

	}

	public WebElement getGenerateApi() {
		return driver.findElement(generateapi);
	}

	public WebElement getRegenerateApi() {
		return driver.findElement(regenerateapi);
	}

	public WebElement getDeleteApi() {
		return driver.findElement(deleteapi);
	}

	public void getToastMessage() {
		String str = driver.findElement(toast1).getAttribute("innerHTML");
		System.out.println("Notification Message :" + " " + str);

	}

}
