package mastbit.exchange.main;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import mastbit.exchange.POM.Mastbit_YourOrderHistory;
import mastbit.exchange.common.ScreenShot;

public class YourOrderHistory {

	public WebDriver driver;

	public YourOrderHistory(WebDriver driver) {
		this.driver = driver;
	}

	public void yourOrderhistoryNavigation() throws InterruptedException, IOException {
		Thread.sleep(2000);
		Mastbit_YourOrderHistory oh = new Mastbit_YourOrderHistory(driver);
		oh.getYourOrderHistory();
		Thread.sleep(3000);
		ScreenShot.take_screenshot(driver, "YourOrderHistory");
		oh.getOpenOrderClick();
		Thread.sleep(3000);
		ScreenShot.take_screenshot(driver, "Open Orders");
		oh.getTradeHistoryClick();
		Thread.sleep(3000);
		ScreenShot.take_screenshot(driver, "Trade History");
	}

}
