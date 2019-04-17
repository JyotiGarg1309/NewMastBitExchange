package mastbit.exchange.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Mastbit_walletTransaction {

	public WebDriver driver;
	By walletTransaction=By.xpath("//a[text()='Wallet Transactions ']");
	
	
	
	
	public Mastbit_walletTransaction(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}



	public void getWalletTransaction()
	{
		WebElement element = driver.findElement(walletTransaction);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
	}
}
