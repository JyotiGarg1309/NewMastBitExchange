package mastbit.exchange.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Mastbit_yourBrokerage {

	public WebDriver driver;
	By yourbrokerage=By.xpath("//a[text()='Your Brokerage']");

	
	
	
	public Mastbit_yourBrokerage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}



	public void getYourbrokerage()
	{

		WebElement element = driver.findElement(yourbrokerage);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
	
	}
	
}
