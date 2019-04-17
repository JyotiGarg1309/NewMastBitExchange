package mastbit.exchange.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Mastbit_YourOrderHistory {
	public WebDriver driver;
	By yourOrderhistory=By.xpath("//a[text()='Your order History']");

	By openOrder=By.id("order");
	By tradeHistory=By.id("trade");
	
	
	public Mastbit_YourOrderHistory(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}



	public void getYourOrderHistory()
	{

		WebElement element = driver.findElement(yourOrderhistory);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
	
	}
	public void getOpenOrderClick() {
		driver.findElement(openOrder).click();

	}
	public void getTradeHistoryClick() {
		driver.findElement(tradeHistory).click();

	}
	

}
