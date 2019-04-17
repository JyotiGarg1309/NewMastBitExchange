package mastbit.exchange.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Mastbit_order {

	public WebDriver driver;
	By limitclick=By.xpath(".//*[@id='ap_email']");
	By marketclick=By.xpath(".//*[@id='ap_email']");
	By amount=By.xpath(".//*[@id='ap_email']");
	By limitval=By.xpath(".//*[@id='user_password']");
	By buy=By.xpath(".//*[@id='user_password']");
	By sell=By.xpath(".//*[@id='user_password']");
	By register=By.xpath(".//*[@id='new_user']/div[3]/input");
	
	
	
	public Mastbit_order(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}



	public WebElement getLimitclick()
	{
	return driver.findElement(limitclick);
	}
	public WebElement getMarketclick()
	{
	return driver.findElement(marketclick);
	}
	public WebElement getAmount()
	{
	return driver.findElement(amount);
	}
	public WebElement getLimitval()
	{
	return driver.findElement(limitval);
	}
	public WebElement getBuy()
	{
	return driver.findElement(buy);
	}
	public WebElement getSell()
	{
	return driver.findElement(sell);
	}

}
