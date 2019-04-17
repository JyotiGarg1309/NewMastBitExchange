package mastbit.exchange.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Mastbit_createTicket {
	public WebDriver driver;
	By createTicket = By.xpath("//*[@id=\"app-wrapper\"]/app-my-tickets//button[@class='btn btn-success']");
	By title = By.xpath("//input[@formcontrolname='title']");
	By description = By.xpath("//textarea[@formcontrolname='description']");
	By create = By.xpath("//button[@type='submit']");
	By yourTicket = By.xpath("//a[text()='Your Tickets']");
	By header = By.xpath("//*[@id=\"app-wrapper\"]/app-my-tickets-chat/section/div/div/div[1]/h3");
	By eye = By.xpath(
			"//*[@id=\"app-wrapper\"]/app-my-tickets/section/div/div/div/div[3]/div/div/div/table/tbody/tr/td[6]/i[1]");
	By toast1 = By.xpath("//span[@class='toast-message ng-star-inserted']");

	public Mastbit_createTicket(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public void getYourTicket() {
		WebElement element = driver.findElement(yourTicket);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

	}

	public WebElement getCreateTicket() {
		return driver.findElement(createTicket);
	}

	public WebElement getTitle() {
		return driver.findElement(title);
	}

	public WebElement getDescription() {
		return driver.findElement(description);
	}

	public WebElement getCreate() {
		return driver.findElement(create);
	}

	public WebElement getEye() {
		return driver.findElement(eye);
	}

	public WebElement getHeader() {
		return driver.findElement(header);
	}

	public void getToastMessage() {
		String str = driver.findElement(toast1).getAttribute("innerHTML");
		System.out.println("Notification Message :" + " " + str);

	}

}
